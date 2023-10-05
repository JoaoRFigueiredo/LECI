package lab09.ex2;

public abstract class Chef {
    
    protected String name;
    protected Chef nextChef;

    public Chef(String name){
        this.name  = name;
    }


    public void setNextChef(Chef chef){
        this.nextChef = chef;
    }

    public void cook(String dish) {
        if (canCook(dish)) {
            System.out.println(name + ": Starting to cook " + dish.replace("Can I please get a ", "") + ". Out in " + cookingTime(dish) + " minutes!\n");
        } else if (nextChef != null) {
            System.out.println(name+": I can't cook that.");
            nextChef.cook(dish);
        } else {
            System.out.println("We're sorry but that request can't be satisfied by our service!");
        }
    }

    protected abstract boolean canCook(String dish);

    protected abstract int cookingTime(String dish);
}
