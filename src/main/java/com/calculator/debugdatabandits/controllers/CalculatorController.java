package com.calculator.debugdatabandits.controllers;

import com.calculator.debugdatabandits.service.CalculateSimple;
import com.calculator.debugdatabandits.model.OperationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {

    OperationModel operationModel = new OperationModel();

    @Autowired
    private CalculateSimple calculateSimple;

    @RequestMapping("/calculator")
    public String getCalculatorPage(Model model){
        model.addAttribute("operationModel", operationModel);
        model.addAttribute("operationModel",  calculateSimple.initialize(operationModel));
        model.addAttribute("result", calculateSimple.gcd(operationModel));
        return "index";
    }

    @RequestMapping(value="/calculator", params="add", method = RequestMethod.POST)
    public String add(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.add(operationModel));
        return "index";
    }

    @RequestMapping(value="/calculator", params="subtract", method = RequestMethod.POST)
    public String subtract(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.subtract(operationModel));
        return "index";
    }

    @RequestMapping(value="/calculator", params="multiply", method = RequestMethod.POST)
    public String multiply(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.multiply(operationModel));
        return "index";
    }
    
    @RequestMapping(value="/calculator", params="gcd", method = RequestMethod.POST)
    public String gcd(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.gcd(operationModel)[0]);
        model.addAttribute("time", calculateSimple.gcd(operationModel)[1]);
        return "index";
    }

    @RequestMapping(value="/calculator", params="divide", method = RequestMethod.POST)
    public String divide(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.divide(operationModel));
        return "index";
    }

    @RequestMapping(value="/calculator", params="fibonacci", method = RequestMethod.POST)
    public String fibonacci(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.fibonacci(operationModel));
        return "index";
    }

    @RequestMapping(value="/calculator", params="sqrt", method = RequestMethod.POST)
    public String sqrt(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.sqrt(operationModel));
        return "index";
    }

    @RequestMapping(value="/calculator", params="power", method = RequestMethod.POST)
    public String power(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.power(operationModel));
        return "index";
    }

    @RequestMapping(value="/calculator", params="factorial", method = RequestMethod.POST)
    public String factorial(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.factorial(operationModel));
        return "index";
    }

    @RequestMapping(value="/calculator", params="clearSimple", method = RequestMethod.POST)
    public String clearSimple(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("operationModel",  calculateSimple.clearSimple(operationModel));
        model.addAttribute("result", 0);
        return "index";
    }

    @RequestMapping(value="/calculator", params="clearAdvanced", method = RequestMethod.POST)
    public String clearAdvanced(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("operationModel",  calculateSimple.clearAdvanced(operationModel));
        model.addAttribute("result", 0);
        return "index";
    }
}
