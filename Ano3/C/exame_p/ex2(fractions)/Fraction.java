public class Fraction {
    private int den;
    private int num;
    private boolean flag = false;

    public Fraction(int num, int den){
        this.num = num;
        this.den = den;
    }

    public Fraction(int num){
        this.num = num;
        this.den = 1;
    }

    public Fraction(String frac){
        String[] arr = frac.split("/");
        switch (arr.length){
            case 1:
            this.num = Integer.parseInt(arr[0]);
            this.den = 1;
            break;

            case 2:
            this.num = Integer.parseInt(arr[0]);
            this.den = Integer.parseInt(arr[1]);
            break;
        }

        if (!(den > 0 && num >= 0)){
            flag = true;
        }
    }

    public int num(){
        return num;
    }

    public int den(){
        return den;
    }

    public Fraction add(Fraction f){
        int numer = num * f.den() + f.num() * den;
        int denom = den * f.den;
        return new Fraction(numer, denom);
    }

    public Fraction sub(Fraction f) {
        int numer = num * f.den() - f.num() * den;
        int denom = den * f.den;
        return new Fraction(numer, denom);
    }

    public Fraction mul(Fraction f) {
        int numer = num * f.num();
        int denom = den * f.den();
        return new Fraction(numer, denom);
    }

    public Fraction div(Fraction f) {
        int numer = num * f.den();
        int denom = den * f.num();
        return new Fraction(numer, denom);
    }

    public boolean flag(){
        return flag;
    }

    public Fraction negate(){
        return new Fraction(num*(-1), den);
    }


    public int mdc(int a, int b){
        if (b == 0) return a;
        return mdc(b, a % b);
    }

    public Fraction reduce() {
        int divider = mdc(num, den);
        return new Fraction(num/divider, den/divider);               
    }

    public String toString(){
        return den > 1 ? (num + "/"+den) : num+"";
    }




    
}
