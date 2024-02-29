package core.calculator;

public class ComlexNumber {
    private double real;
    private double imaginary;
    public ComlexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    public double getReal() {
        return real;
    }
    public double getImaginary() {
        return imaginary;
    }
    public void setReal(double real) {
        this.real = real;
    }
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(real!=0 || imaginary == 0){
            sb.append(real);
        }
        if(imaginary!=0){
            if(imaginary > 0 && real != 0) {
                sb.append(" + ");
            }
            sb.append(imaginary).append("i");
        }

        return sb.toString();
    }
}
