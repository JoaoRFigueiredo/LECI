import java.util.ArrayList;
import java.util.List;

public class Vector extends Value {
    private List<Double> arr = new ArrayList<>();

    public Vector(List<Double> values){
        this.arr = values;
        setVector(true);
    }

    public Vector(String values){
        setVector(true);
        values = values.replace("[", "");
        values = values.replace("]", "");
        String[] numbers = values.split(",");
        for (String num : numbers){
            this.arr.add(Double.parseDouble(num));
        }
    }

    @Override
    public Value symmetric() {
        List<Double> lst = new ArrayList<>();
        for (Double d : arr) {
            lst.add(d*(-1));
        }
        return new Vector(lst);
    }

    @Override
    public Value add(Value f) {
        Vector nf = (Vector)f;
        List<Double> lst = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            lst.add(arr.get(i) + nf.getValues().get(i));
        }
        return new Vector(lst);
    }

    @Override
    public Value sub(Value f) {
        Vector nf = (Vector) f;
        List<Double> lst = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            lst.add(arr.get(i) - nf.getValues().get(i));
        }
        //System.out.println(new Vector(lst));
        return new Vector(lst);
    }

    @Override
    public Value mul(Value f) {
        Scalar nf = (Scalar) f;
        List<Double> lst = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            lst.add(arr.get(i) * nf.getValue());
        }
        return new Vector(lst);
    }

    public Value intProd(Value nf) {
        Vector f = (Vector) nf;
        double v1 = 1.0, v2 = 1.0;
        for (int i = 0; i < arr.size(); i++) {
            v1 *= arr.get(i);
        }
        List<Double> flst = f.getValues();
        for (int i = 0;i < flst.size(); i++){
            v2 *= flst.get(i);
        }
        
        return new Scalar(v1 + v2);
    }

    public String toString(){
        return ""+arr;
    }

    public List<Double> getValues(){
        return arr;
    }

    
}