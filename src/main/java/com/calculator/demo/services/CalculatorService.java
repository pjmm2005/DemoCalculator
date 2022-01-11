package com.calculator.demo.services;

import com.calculator.demo.core.calculator.Calculator;
import com.calculator.demo.core.calculator.CalculatorSanitasImpl;
import com.calculator.demo.exceptions.OperationNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

  Calculator calculator;

  public CalculatorService(CalculatorSanitasImpl calculator) {
    this.calculator = calculator;
  }

  public Double calculate(String operation, Double operand01, Double operand02) throws OperationNotFoundException {
    if(calculator.existOperation(operation)){
      return calculator.makeCalculation(operation, operand01, operand02);
    }else{
      throw new OperationNotFoundException();
    }
  }

  public boolean existOperation(String operation){
    return calculator.existOperation(operation);
  }

  public String getAvailableOps() {
    return calculator.getOperationsAvailable();
  }
}
