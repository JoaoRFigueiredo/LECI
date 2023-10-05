public class Fraction{
    private int num;
    private int den;
    private boolean flag = false;

    public Fraction(int num, int den){
        this.num = num;
        this.den = den;
        if (den <0){
            this.den = den*-1;
            this.num = num *-1;
        }
        if (den == 0){
            flag = true;
        }
    }

    public Fraction(int num){
        this.num = num;
        this.den = 1;
    }


    public Fraction(String value){
        
        String[] arr = value.split("/");
        if (arr.length == 1 ){
            num = Integer.parseInt(arr[0]);
            den = 1;
        }
        else if (arr.length == 2){
        
        num = Integer.parseInt(arr[0]);
        den = Integer.parseInt(arr[1]);
        if (den <0){
            this.den = den*-1;
            this.num = num *-1;
        }
        if (den == 0){
            flag = true;
        }
        }
    }


    public Fraction negate(){
        return new Fraction(num*(-1), den);
    }

    public Fraction add(Fraction f){
        return new Fraction(num*f.getDen() + den*f.getNum(), den*f.getDen());
    }

    public Fraction sub(Fraction f){
        return new Fraction(num*f.getDen() - den*f.getNum(), den*f.getDen());
    }

    public Fraction mul(Fraction f){
        return new Fraction(num*f.getNum(), den*f.getDen());
    }   

    public Fraction div(Fraction f){
        return this.mul(f.invert());
    }

    public Fraction invert(){
        return new Fraction(den, num);
    }

    public Fraction reduce(){
        int divider = mdc(num, den);
        return new Fraction(num/divider, den/divider);
    }

    private int mdc(int a, int b){
        if (b == 0){
            return a;
        }
        else{
            return mdc(b, a%b);
        }
    }



    public int getNum(){
        return num;
    }

    public int getDen(){
        return den;
    }

    public boolean getFlag(){   //verificar se a fração é válida
        return flag;
    }


    public String toString(){
        return num+( (den != 1) ? ("/"+den) : "");
    }
}