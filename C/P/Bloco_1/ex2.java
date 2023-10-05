import java.util.HashMap;
import java.util.Scanner;



public class ex2 {

    private static HashMap<String, Double> mapa = new HashMap<>();


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
          
        while(sc.hasNextLine()){
                Scanner sc2 = new Scanner(System.in);
                processLine(sc2);
                sc2.close();


        }

        sc.close();


    }


    public static void processLine(Scanner sc){
        double op1;
        String var1,var2;

        if(sc.hasNextDouble()){                 // First element NUM

            op1 = sc.nextDouble();
            System.out.println(solveExpressions(sc,op1));

        } else if(sc.hasNext()){
            var1 = sc.next();
            if(!validateVar(var1)){             //First element isn't NUM or VAR
            System.out.println("First element should be a number or a variable");

            } else {                            //First element is VAR
                if(sc.hasNext("=")){            //Atribution of value to VAR
                    sc.next();          //skip equals
                    if(sc.hasNextDouble()){
                        op1 = sc.nextDouble();
                        double val = solveExpressions(sc,op1);
                        mapa.put(var1, val);
                    } else if(sc.hasNext()){
                        var2 = sc.next();
                        if(!mapa.containsKey(var2)){
                            System.err.println("Variable isn't defined");
                        }
                        double val = solveExpressions(sc,mapa.get(var2));
                        mapa.put(var1, val);
                    } else {
                        System.err.println("Variable needs value after =");
                    }

                } else {                        //Normal expression with VAR
                    if(!mapa.containsKey(var1)){
                        System.err.println("Variable isn't defined");
                    }
                    System.out.println(solveExpressions(sc, mapa.get(var1)));
                }
            }
        }
    }


    public static boolean validateVar(String var){
        if(!Character.isLetter(var.charAt(0))){
            return false;
        }

        for(int i = 1; i<var.length(); i++){
            if(!Character.isDigit(var.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean validateOpr(String opr){
        return (opr.equals("+") || opr.equals("-") || opr.equals("*") || opr.equals("/"));
    }


    public static double solveExpressions(Scanner sc, double op1){
        double op2 = 0;
        String op, var1;
        if (!sc.hasNext()){
            return op1;
        }

        op = sc.next();

        if (!validateOpr(op)){
            System.err.println("Invalid operator was used!");
            System.exit(0);
        }

        if (sc.hasNextDouble()){
            op2 = sc.nextDouble();
        }
        else if(sc.hasNext()){
            var1 = sc.next();
            if(!mapa.containsKey(var1)){
                System.err.println("Variable wasn't defined!");
                System.exit(0);
            }
            op2 = mapa.get(var1);   
        }
        else{
            System.err.println("Operand is missing!");
            System.exit(0);

        }

        switch(op){
            case "+":
            return (op1 + op2);

            case "-":
            return (op1 - op2);

            case "/":
            return (op1 / op2);

            case "*":
            return (op1 * op2);

        }

        return op1;




    }

    
    
}
