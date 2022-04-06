package ru.elkin.neostudytest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.elkin.neostudytest.models.ArithmeticOperation;

@Controller
public class CalcController {

    private ArithmeticOperation arithmeticOperation;

    @Autowired
    public CalcController(ArithmeticOperation arithmeticOperation) {
        this.arithmeticOperation = arithmeticOperation;
    }

    @GetMapping("/calculate")
    public String calculate(
            @RequestParam(value = "first_operand", required=false) int firstOperand,
            @RequestParam(value = "second_operand", required=false) int secondOperand,
            @RequestParam(value = "type_operation", required=false) String typeOperation,
                         Model model){
        arithmeticOperation.setFirstOperand (firstOperand);
        arithmeticOperation.setSecondOperand(secondOperand);
        arithmeticOperation.setTypeOperation(typeOperation);
        model.addAttribute("result_operation", arithmeticOperation.getResultOperation());
        return "calculate";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

}