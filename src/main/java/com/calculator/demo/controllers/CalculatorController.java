package com.calculator.demo.controllers;

import com.calculator.demo.exceptions.OperationNotFoundException;
import com.calculator.demo.exceptions.RestOperationNotFoundException;
import com.calculator.demo.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {

  @Autowired
  CalculatorService calculatorService;

  @GetMapping(path = "/calculate", produces = "application/json")
  public ResponseEntity<Double> calculate(@RequestParam String operation, @RequestParam Double operand01, @RequestParam Double operand02){
    Double res = 0.0;

    try {
      res = calculatorService.calculate(operation, operand01, operand02);
    }catch (OperationNotFoundException onfe){
      throw new RestOperationNotFoundException();
    }

    return ResponseEntity.ok(res);

  }

  @GetMapping(path = "/availableOps", produces = "application/json")
  public ResponseEntity<String> getAvailableOps(){

    return ResponseEntity.ok(calculatorService.getAvailableOps());

  }

}
