public class ex2 {
    public static void main(String[] args) {
        CakeMaster cakeMaster = new CakeMaster();

        CakeBuilder chocolate = new ChocolateCakeBuilder();
        cakeMaster.setCakeBuilder(chocolate);
        cakeMaster.createCake("Congratulations");
        Cake cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        CakeBuilder sponge = new SpongeCakeBuilder();
        cakeMaster.setCakeBuilder(sponge);
        cakeMaster.createCake(Shape.Square, 2, "Well done");
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        CakeBuilder yogurt = new YogurtCakeBuilder();
        cakeMaster.setCakeBuilder(yogurt);
        cakeMaster.createCake(3, "The best");
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        CakeBuilder lactose = new YogurtCakeBuilder();
        cakeMaster.setCakeBuilder(lactose);
        cakeMaster.createCake(Shape.Rectangle, 4, "Tolerate Milk");
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        CakeBuilder icecream = new IcecreamCakeBuilder();
        cakeMaster.setCakeBuilder(icecream);
        cakeMaster.createCake(2, "Happy Birthday");
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);
    }
}
