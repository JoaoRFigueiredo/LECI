<<<<<<< HEAD
// package Ex2;
=======
//package Ex2;
>>>>>>> 0031b8c6947045583c7ba859f34c76b0a7aca4bd

public class Ex2 {

    public static void main(String[] args)  {
        UserInterface ui;
        if (args.length == 0) {
            ui= new UserInterface("H", args);
            ui.interact();
        } else {
            System.out.println("Argumentos: " + args[0]);
            ui = new UserInterface(args[0], args);
            ui.interact();
        }

    }
    
}