package core.calculator.impl;

import core.calculator.ComlexNumber;
import core.calculator.Compute;

public class Multiplication implements Compute {
    @Override
    public ComlexNumber getResult(ComlexNumber a, ComlexNumber b) {
        return new ComlexNumber(a.getReal()*b.getReal()-a.getImaginary()*b.getImaginary(),
                a.getReal()* b.getImaginary()+b.getReal()*a.getImaginary() );
    }
}
