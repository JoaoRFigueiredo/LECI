public class ComplexNumber {
    private double real;
    private int imaginary;

    public ComplexNumber(double real, int imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

public ComplexNumber(String value) {
    String[] parts = value.split("[+-]");
    if (parts.length == 2) {
        this.real = Double.parseDouble(parts[0]);
        String imaginaryPart = parts[1].replace("i", "");
        if (imaginaryPart.isEmpty()) {
            this.imaginary = -1;
        } else {
            this.imaginary = Integer.parseInt(imaginaryPart);
            if (value.indexOf('-') > value.indexOf('+')) {
                this.imaginary = -this.imaginary;
            }
        }
    } else if (parts.length == 1 && value.contains("i")) {
        String imaginaryPart = value.replace("i", "");
        this.imaginary = Integer.parseInt(imaginaryPart);
    } else {
        throw new IllegalArgumentException("Invalid complex number: " + value);
    }
}
    public int getImaginary(){
        return imaginary;
    }

    public double getReal(){
        return real;
    }

    public ComplexNumber negate(){
        return new ComplexNumber(real*(-1), imaginary*(-1));
    }

    public ComplexNumber add(ComplexNumber n2){
        return new ComplexNumber(real+n2.getReal(), imaginary+n2.getImaginary());

    }

    public ComplexNumber sub(ComplexNumber n2){
        return new ComplexNumber(real-n2.getReal(), imaginary-n2.getImaginary());

    }

    public ComplexNumber mul(ComplexNumber n2){
        double newReal = real*n2.getReal() - imaginary*n2.getImaginary();
        int newim = ((int)real)*n2.getImaginary() + imaginary*((int)n2.getReal());
        return new ComplexNumber(newReal, newim);
        
    }

    public ComplexNumber div(ComplexNumber n2){
        double r = (real*n2.getReal() + imaginary*n2.getImaginary())/(n2.getReal()*n2.getReal() + n2.getImaginary()*n2.getImaginary());
        int im =   (imaginary*((int)n2.getReal()) + ((int)real * n2.getImaginary()))/(int)(n2.getReal()*n2.getReal() + n2.getImaginary()*n2.getImaginary());

        return new ComplexNumber(r, im);
    }

    public ComplexNumber conjugado(){
        
        return new ComplexNumber(real, imaginary*(-1));
    }

    public Double mod(){

        Double result = Math.sqrt(real*real + imaginary*imaginary);
        return result;
    }

public String toString() {
    String res = "";

    if (real != 0){
        String temp = Double.toString(real);
        if (!temp.contains(".0")){
            res += real;
        } else {
            res += (int)real;
        }
    }

    if (imaginary != 0){
        if (imaginary == 1){
            if (real == 0){
                res += "i";
            }
            else if (real != 0){
                res += "+i";
            }
        }
        else if (imaginary > 1){
            if (real == 0){
                res += imaginary+"i";
            }
            else if (real != 0){
                res += "+"+imaginary+"i";
            }
        }

        else if (imaginary == -1){
            res += "-i";
        }
        else if (imaginary < -1){
            res += imaginary+"i";
        }
    }

    if (res.isEmpty()){
        res = "0";
    }

    return res;
}

}
