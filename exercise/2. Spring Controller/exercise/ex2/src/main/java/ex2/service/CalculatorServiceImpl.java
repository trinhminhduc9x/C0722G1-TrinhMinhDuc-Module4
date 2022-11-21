package ex2.service;

import org.springframework.stereotype.Service;


@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public double calculate(String firstOperand, String secondOperand, String operator) {
        switch (operator) {
            case "+":
                return Double.parseDouble(firstOperand) + Double.parseDouble(secondOperand);
            case "-":
                return Double.parseDouble(firstOperand) - Double.parseDouble(secondOperand);
            case "*":
                return Double.parseDouble(firstOperand) * Double.parseDouble(secondOperand);
            case "/":
                if (Integer.parseInt(secondOperand) != 0)
                    return Double.parseDouble(firstOperand) / Double.parseDouble(secondOperand);
                else
                    throw new RuntimeException("Can't divide by zero");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
