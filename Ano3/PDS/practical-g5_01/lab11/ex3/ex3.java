package lab11.ex3;

import java.util.ArrayList;
import java.util.Scanner;

public class ex3 {

    public static void main(String[] args) {
        Book book1 = new Book("Java Anti-Stress", "1234567890", 2021, "Omodionah");
        Book book2 = new Book("A Guerra dos Padrões", "0987654321", 2020, "Jorge Omel");
        Book book3 = new Book("A Procura da Luz", "2468135790", 2019, "Khumatkli");

        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        String menu = "*** Biblioteca ***";
        String options = ">> <livro>, <operação>:  (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela\n";

        // Read user input
        Scanner scanner = new Scanner(System.in);
        String input = "";

        do {
            try {
                // Print menu and options
                System.out.println(menu);
                for (Book b : books) {
                    System.out.println((books.indexOf(b) + 1) + " " + b.toString());
                }
                System.out.println(options);

                input = scanner.nextLine();
                String[] parts = input.split(",");
                
                if (parts.length != 2) {
                    throw new IllegalArgumentException("Invalid input format. Expected: number, number");
                }
                
                int bookId = Integer.parseInt(parts[0]);
                int operationId = Integer.parseInt(parts[1]);

                // Verify book ID and operation ID
                if (bookId < 1 || bookId > books.size()) {
                    throw new IllegalArgumentException("Invalid book ID. Please enter a valid book ID.");
                }

                if (operationId < 1 || operationId > 5) {
                    throw new IllegalArgumentException("Invalid operation ID. Please enter a valid operation ID.");
                }
                

                // Perform book operations
                Book bk = books.get(bookId - 1);
                switch (operationId) {
                    case 1:
                        bk.register();
                        break;

                    case 2:
                        bk.request();
                        break;

                    case 3:
                        bk.returnBook();
                        break;

                    case 4:
                        bk.reservation();
                        break;

                    case 5:
                        bk.cancelReservation();
                        break;

                    default:
                        break;
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter valid numbers.");
                // Handle the exception or display an error message as per your requirements
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
                // Handle the exception or display an error message as per your requirements
            }
        } while (!input.equalsIgnoreCase("exit"));
        
        scanner.close();
    }
}
