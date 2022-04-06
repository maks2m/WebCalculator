package ru.elkin.neostudytest.models;

import org.springframework.stereotype.Component;

@Component
public class ArithmeticOperation {

    private int firstOperand;
    private  int secondOperand;
    private String typeOperation;

    public String getResultOperation(){
        String error = "";
        double result;
        switch (typeOperation){
            case "addition":
                result = firstOperand + secondOperand;
                break;
            case "subtraction":
                result = firstOperand - secondOperand;
                break;
            case "multiplication":
                result = firstOperand * secondOperand;
                break;
            case "division":
                if (secondOperand != 0) {
                    result = firstOperand / (double) secondOperand;
                    break;
                } else {
                    error = "Деление на ноль";
                    result = 0;
                    break;
                }
            default:
                result = 0;
                error = "Неверно задан математический оператор";
        }
        if (error == ""){
            return String.valueOf(result);
        } else {
            return error;
        }
    }

    public void setFirstOperand(int firstOperand) {
        this.firstOperand = firstOperand;
    }

    public void setSecondOperand(int secondOperand) {
        this.secondOperand = secondOperand;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

}
