package lab09.ex2;

public class PizzaChef extends Chef{

    public PizzaChef(String name){
        super(name);
    }

    // public void cook(String dish){
    //     if (dish.toLowerCase().contains("pizza")){
    //         System.out.println(name+": Starting to cook "+dish+". Out in 7 minutes!");
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
        if (dish.toLowerCase().contains("pizza")){
            return true;
        }
        return false;
    }
    @Override
    protected  int cookingTime(String dish){
        return 7;
    }
    
}
