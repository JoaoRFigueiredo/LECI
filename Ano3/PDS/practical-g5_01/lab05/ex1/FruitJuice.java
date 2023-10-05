public class FruitJuice implements Portion{

    public FruitName getFruit(){
        return FruitName.Orange;
    }

    @Override
    public Temperature getTemperature() {
        return Temperature.COLD;
    }

    @Override
    public State getState() {
        return State.Liquid;
    }

    @Override
    public String toString(){
        return "FruitJuice: " + getFruit().toString() + ", Temperature " + getTemperature().toString() + ", State " + getState().toString();
    }
}
