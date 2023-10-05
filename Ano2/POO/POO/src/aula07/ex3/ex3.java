package aula07.ex3;
import java.util.Scanner;

public class ex3 {
    
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String menu = "Menu:"+
                       "\n1: Adicionar Alojamento."+
                       "\n2: Adicionar Viatura"+
                       "\n3: Imprimir lista de alojamentos"+
                       "\n4: Imprimir lista de veiculos"+
                       "\n5: Alojamentos disponíveis"+
                       "\n6: Veiculos disponíveis"+
                       "\n7: Realizar check-in de um alojamento"+
                       "\n8: Realizar check-out de um alojamento"+
                       "\n9: Levantar uma viatura: "+
                       "\n10: Entregar uma viatura"+
                       "\n0: Exit";
    
    
        int op;
        Agencia ag = new Agencia("Agencia de alojamentos/carros", "Algures em Portugal, nº678");
    do{
        System.out.println(menu);
        op = sc.nextInt();

        switch (op) {
            case 1:
            addHousing(ag);
            break;

            case 2:
            addVehicle(ag);
            break;

            case 3:
            housingList(ag);
            break;

            case 4:
            VehicleList(ag);
            break;

            case 5:
            availableHousing(ag);
            break;

            case 6:
            availableVehicles(ag);
            break;

            case 7:
            checkIn(ag);
            break;

            case 8:
            checkOut(ag);
            break;

            case 9:
            takeVehicle(ag);
            break;

            case 10:
            returnVehicle(ag);
            break;

            default:
        }

    }while(op < 11 && op >0);
    sc.close();
   } 

   public static Agencia addHousing(Agencia ag){
       Apartamento ap1 = new Apartamento("ap1", "Xpto", "Lisboa", 56, 4, true, 3);
       Quarto q1 = new Quarto("q1", "quarto", "Aveiro", 40, 3.5, true, "single");
       Quarto q2 = new Quarto("q2", "quarto", "Aveiro", 50, 4.5, false, "twin");
       Quarto q3 = new Quarto("q3", "quarto", "Aveiro", 30, 2.5, true, "double");
       ag.addHousing(ap1);
       ag.addHousing(q1);
       ag.addHousing(q2);
       ag.addHousing(q3);

        return ag;

   }


   public static Agencia addVehicle(Agencia ag){
       Viatura v1 = new Viatura('A', "diesel");
       Viatura v2 = new Viatura('B', "gasolina");
       Viatura v3 = new Viatura('C', "hibrido");
       Viatura v4 = new Viatura('D', "eletrico");
       v2.takeCar();
       ag.addCar(v1);
       ag.addCar(v2);
       ag.addCar(v3);
       ag.addCar(v4);
       return ag;

   }

   public static void housingList(Agencia ag){
       ag.listHousing();
   }

   public static void VehicleList(Agencia ag){
       ag.listVehicles();
   }

   public static void availableHousing(Agencia ag){
    ag.listHousingavailable();
}

public static void availableVehicles(Agencia ag){
    ag.listVehiclesAvailable();
}

public static void checkIn(Agencia ag){
    for (Alojamento a : ag.housing()){
        if(a.getAvailable() == true){
            a.checkIn();
            break;
        }
    }

}

public static void checkOut(Agencia ag){
    for (Alojamento a : ag.housing()){
        if(a.getAvailable() == false){
            a.checkOut();
            break;
        }
    }

}

public static void takeVehicle(Agencia ag){
    for (Viatura v : ag.viaturas()){
        if(v.getCarTakenState() == false){
            v.takeCar();
            break;
        }
    }
}

public static void returnVehicle(Agencia ag) throws Exception{
    for (Viatura v : ag.viaturas()){
        if(v.getCarTakenState() == true){
            v.returnCar();
            break;
        }
    }
}

}
