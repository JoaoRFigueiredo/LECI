public class Pork implements Portion{

    @Override
    public Temperature getTemperature() {
        return Temperature.WARM;
    }

    @Override
    public State getState() {
        return State.Solid;
    }

    @Override
    public String toString(){
        return "Pork: Temperature " + getTemperature().toString() + ", State " + getState().toString();
    }
}
