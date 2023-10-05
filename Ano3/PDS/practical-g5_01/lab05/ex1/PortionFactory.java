public class PortionFactory {

    public static Portion create(String tipo, Temperature t){
        if(tipo.equalsIgnoreCase("Beverage") && t == Temperature.WARM){
            return new Milk();
        }
        if(tipo.equalsIgnoreCase("Beverage") && t == Temperature.COLD){
            return new FruitJuice();
        }
        if(tipo.equalsIgnoreCase("Meat") && t == Temperature.WARM){
            return new Pork();
        }
        if(tipo.equalsIgnoreCase("Meat") && t == Temperature.COLD){
            return new Tuna();
        }
        return null;
    }
}
