package core.view;

import core.calculator.Calculator;
import core.calculator.ComlexNumber;
import core.logger.Logger;
import core.util.Operators;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;



public class View {
    private Calculator calculator = new Calculator();
    private Logger logger;
    private final List<String> validOperators;

    public View(Logger logger) {

        this.logger = logger;
        this.validOperators = Arrays.stream(Operators.values())
                .map(Operators::operator)
                .collect(Collectors.toList());
    }

    public void run() {
        while (true) {
            doAction();
            String action = prompt();
            if (!action.equalsIgnoreCase("y")) {
                System.exit(0);
            }
        }
    }

    public void doAction() {
        double ar = promptDouble("Введите действительную часть первого числа : ");
        double ai = promptDouble("Введите мнимую часть первого числа: ");
        ComlexNumber a = new ComlexNumber(ar,ai);
        String operator = getOperator();
        double br = promptDouble("Введите действительную часть второго числа : ");
        double bi = promptDouble("Введите мнимую часть второго числа: ");
        ComlexNumber b = new ComlexNumber(br,bi);
        String message = getMessage(operator, a, b);
        System.out.println(message);
        Date date = new Date();
        logger.log(date + ": " + message);

    }
    private String prompt() {
        Scanner in = new Scanner(System.in);
        System.err.println("Continue?... (y/n)");
        return in.nextLine();
    }
    public String getMessage(String action, ComlexNumber a, ComlexNumber b) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(a.toString());
        sb.append(") ");
        sb.append(action);
        sb.append(" (");
        sb.append(b.toString());
        sb.append(") ");
        sb.append("=");
        sb.append(" ");
        sb.append(calculator.calculate(action, a, b).toString());
        return sb.toString();
    }
    private boolean isInvalidOperator(String operator) {
        return !validOperators.contains(operator);
    }

    private  double promptDouble(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        double result = -1;
        try {
            result = Double.parseDouble(in.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Введено не число. Пожалуйста введите число");
            promptDouble(message);
        }
        return result;
    }
    private String getOperator() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите одно из действий (*, +, /, -) : ");
        String operator = in.nextLine();
        while (true) {
            if (isInvalidOperator(operator)) {
                System.err.println("Введено не правильное действие. " + "Введите правильное из (*, +, /, -) : ");
                operator = in.nextLine();
            } else return operator;
        }
    }


}
