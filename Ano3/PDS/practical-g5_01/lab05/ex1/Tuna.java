public class Tuna implements Portion{
    
    @Override
    public Temperature getTemperature() {
        return Temperature.COLD;
    }

    @Override
    public State getState() {
        return State.Solid;
    }

    @Override
    public String toString(){
        return "Tuna: Temperature " + getTemperature().toString() + ", State " + getState().toString();
    }
}
