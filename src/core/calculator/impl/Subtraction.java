package core.calculator.impl;

import core.calculator.ComlexNumber;
import core.calculator.Compute;

public class Subtraction implements Compute {
    @Override
    public ComlexNumber getResult(ComlexNumber a, ComlexNumber b) {
        return new ComlexNumber(a.getReal() - b.getReal(),
                a.getImaginary()- b.getImaginary());
    }
}
