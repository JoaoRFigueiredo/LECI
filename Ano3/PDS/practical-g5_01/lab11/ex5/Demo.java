package lab11.ex5;

import java.util.concurrent.atomic.AtomicLong;

public class Demo {

    public static void main(String[] args) {
        AtomicLong addedSize = null;

        if (args.length <= 0) { errorMsg(); }
        if (args.length == 1) {
            DirectorySizeCalculator calc = new DirectorySizeCalculator();
            addedSize = calc.Walker(args[1], false);

        }
        else if (args.length == 2) {
            if (args[0].equals("-r")) {
                DirectorySizeCalculator calc = new DirectorySizeCalculator();
                addedSize = calc.Walker(args[1], true);
            }
            else { errorMsg(); }
        }
        else { errorMsg(); }
        System.out.println("Total: " +  addedSize + " kB");
    }

    private static void errorMsg() {
        System.out.println("Error! \n" +
                        "Usage:\tjava Demo [-option] [path]\n");
        System.exit(0);
    }

}