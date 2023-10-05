public abstract class Container {
    public static Container create(Portion p){
        if(p.getState() == State.Liquid && p.getTemperature() == Temperature.COLD){
            return new PlasticBottle(p);
        }

        if(p.getState() == State.Liquid && p.getTemperature() == Temperature.COLD || p.getTemperature() == Temperature.WARM){
            return new TermicBottle(p);
        }

        if(p.getState() == State.Solid && p.getTemperature() == Temperature.COLD || p.getTemperature() == Temperature.WARM){
            return new Tupperware(p);
        }

        if(p.getState() == State.Solid && p.getTemperature() == Temperature.COLD){
            return new PlasticBag(p);
        }

        return null;
    }
}
