<<<<<<< HEAD
// package lab03;
=======
//package lab03;
>>>>>>> 0031b8c6947045583c7ba859f34c76b0a7aca4bd
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class Ex2Main {
    public static void main(String[] args) throws FileNotFoundException {
        Agencia agencia_voos = new Agencia(); // create a new agency
        
        if (args.length == 1){
            File command_inputs = new File (args[0]);
            if (command_inputs.exists() != true) { System.out.println("Input File not found"); System.exit(0); }

            Scanner sc = new Scanner(command_inputs);
            while (sc.hasNext()){
                executeCommand(sc.nextLine(), agencia_voos);
            }
            sc.close();
        }
    
        String full_comand = ""; // full command to be executed by the program
        Scanner scan_command = new Scanner(System.in); // read next command from terminal
        
        int quit = 0;
        do { 
                System.out.println("\n--- Menu de Gestao de Voos ---");
                System.out.println("Escolha uma opcao: (H para ajuda)");
                full_comand = scan_command.nextLine();

                quit = executeCommand(full_comand,agencia_voos); 
        } while (quit == 0);
        scan_command.close();
    }
    private static int executeCommand(String full_command, Agencia agencia_voos) throws FileNotFoundException {
        String[] split_command = full_command.split(" "); // get the command to be executed
        switch(split_command[0].toUpperCase()){
            case "I":
            // Read flight info from file

                // Read the file
                File I_file = new File(split_command[1]);
                if (I_file.exists() != true) { System.out.println("I option File not found"); return 0;}

                Scanner file_reader = new Scanner(I_file);

                // Validate its format
                String[] firstLine = file_reader.nextLine().split(" ");
                if (!firstLine[0].startsWith(">")) {
                    file_reader.close();
                    System.out.println("Error: The first line does not start with '>'");
                    return 0;
                }
                
                String flight_code = firstLine[0].substring(1);

                // Create the flight
                Aviao plane = firstLine.length == 3 ? new Aviao(firstLine[1], firstLine[2]) : new Aviao(firstLine[1]);    
                Voo flight = new Voo(flight_code, plane); // create a new flight
                agencia_voos.addVoo(flight_code, flight);
                
                // Show the flight info, regarding the plane's layout seats
                System.out.println(flight.toString());

                // Try to reserve the requested seats
                while (file_reader.hasNextLine()){
                    String[] line = file_reader.nextLine().split(" ");

                    agencia_voos.reserve(flight_code, Classe.valueOf(line[0]),Integer.parseInt(line[1]));
                }
                file_reader.close();
                    
            break;

            case "M":
            // Show the flight seats info

                agencia_voos.showVoo(split_command[1]);
            break;

            case "F":
            // Add a new flight

                if (split_command.length < 3 || split_command.length > 4) {System.out.println("Incorrect number of arguments for F option"); return 0;}
                
                // Create the new flight, checking if there are any executive seats that need to be added
                String flight_code_F = split_command[1];
                Voo flight_F = split_command.length == 3 ? new Voo(flight_code_F, new Aviao(split_command[2])) : new Voo(flight_code_F, new Aviao(split_command[2],split_command[3]));
                
                // Add the flight to the agency's list
                agencia_voos.addVoo(flight_code_F, flight_F);
            break;

            case "R":
            // Reserve seats on a flight
                
                // Ask the agency to try and reserve the seats
                Reserva reserve = agencia_voos.reserve(split_command[1], Classe.valueOf(split_command[2]), Integer.parseInt(split_command[3]));
                
                // If it was possible, print the seats
                if (reserve != null) {System.out.println(reserve);}
            break;

            case "C":
            // Cancel a reservation
                
                String res_code = split_command[1];
                String flight_code_C = res_code.split(":")[0];
                
                agencia_voos.cancelReservation(flight_code_C, res_code);
                System.out.println("Reserva cancelada com sucesso.");
            break;

            case "Q": return 1;

            default:
                System.out.println("Opção inválida.");
        }
        return 0;
    }
}

