package lab09.ex2;

public class PastaChef extends Chef{

    public PastaChef(String name){
        super(name);
    }

    // public void cook(String dish){
    //     if (dish.toLowerCase().contains("pasta")){
    //         System.out.println(name+": Starting to cook "+dish+". Out in 14 minutes!");
    //     }
    //     else{
    //         if (nextChef != null){
    //             System.out.println(name+": I can't cook that.");
    //             nextChef.cook(dish);
    //         }
    //         else{
    //             System.out.println("We're sorry but that request can't be satisfied by our service!");
    //         }
    //     }
    // }

    @Override
    protected  boolean canCook(String dish){
        if (dish.toLowerCase().contains("pasta")){
            return true;
        }
        return false;
    }
    @Override
    protected  int cookingTime(String dish){
        return 14;
    }
    
}
