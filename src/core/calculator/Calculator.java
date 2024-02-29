package core.calculator;

import core.calculator.impl.Division;
import core.calculator.impl.Multiplication;
import core.calculator.impl.Subtraction;
import core.calculator.impl.Sum;
import core.util.Operators;

import java.util.HashMap;

public class Calculator {
    HashMap<String,Compute> computer;
    public Calculator() {
        computer = new HashMap<String,Compute>();
        computer.put(Operators.PLUS.operator(),new Sum());
        computer.put(Operators.MINUS.operator(), new Subtraction());
        computer.put(Operators.MULTI.operator(), new Multiplication());
        computer.put(Operators.DIVIDE.operator(), new Division());
    }
    public ComlexNumber calculate(String action,ComlexNumber a, ComlexNumber b) {
        return computer.get(action).getResult(a,b);
    }

}
