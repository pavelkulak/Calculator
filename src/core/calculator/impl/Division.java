package core.calculator.impl;

import core.calculator.ComlexNumber;
import core.calculator.Compute;

public class Division implements Compute {
    @Override
    public ComlexNumber getResult(ComlexNumber a, ComlexNumber b) {
        double real = (a.getReal() * b.getReal() + a.getImaginary() * b.getImaginary())/
                (b.getReal() * b.getReal() + b.getImaginary() * b.getImaginary());

        double imaginary = (a.getImaginary() * b.getReal() - a.getReal() * b.getImaginary())/
                (b.getReal() * b.getReal() + b.getImaginary() * b.getImaginary());

        return new ComlexNumber(real, imaginary);
    }

}
