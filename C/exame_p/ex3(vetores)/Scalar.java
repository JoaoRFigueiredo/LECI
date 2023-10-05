import java.util.ArrayList;
import java.util.List;

public class Scalar extends Value{
    private double value;


    public Scalar(double value){
        this.value = value;
        setScalar(true);
    }


    public double getValue(){
        return value;
    }


    public String toString(){
        return ""+value;
    }


    @Override
    public Value symmetric() {
        // TODO Auto-generated method stub
        return new Scalar(value*(-1));
    }


    @Override
    public Value add(Value f) {
        // TODO Auto-generated method stub
        Scalar v = (Scalar)f;
        return new Scalar(value+v.getValue());
    }


    @Override
    public Value sub(Value f) {
        // TODO Auto-generated method stub
        Scalar v = (Scalar)f;
        return new Scalar(value-v.getValue());
    }


    @Override
    public Value mul(Value f) {
        // TODO Auto-generated method stu
        if (f instanceof Vector){
            Vector fvect = (Vector)f;
            List<Double> lst = new ArrayList<>();
            List<Double> temp = fvect.getValues();
            for (double d : temp){
                lst.add(d*value);
            }
            return new Vector(lst);
        }
        Scalar v = (Scalar)f;
        return new Scalar(value*v.getValue());
    }


    @Override
    public Value intProd(Value f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'intProd'");
    }


   
    
}
