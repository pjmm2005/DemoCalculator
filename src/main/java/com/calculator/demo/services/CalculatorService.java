package com.calculator.demo.services;

import com.calculator.demo.core.calculator.Calculator;
import com.calculator.demo.core.calculator.CalculatorSanitasImpl;
import com.calculator.demo.exceptions.OperationNotFoundException;
import com.calculator.demo.log.Logger;
import com.calculator.demo.log.LoggerImpl;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

  Calculator calculator;
  Logger logger;

  public CalculatorService(CalculatorSanitasImpl calculator, LoggerImpl logger) {
    this.calculator = calculator;
    this.logger = logger;
  }

  public Double calculate(String operation, Double operand01, Double operand02) throws OperationNotFoundException {
    logger.log("Calculate with operation " + operation + " and operand01: " + operand01 + " and operand02: " + operand02);
    if(calculator.existOperation(operation)){
      double res = calculator.makeCalculation(operation, operand01, operand02);
      logger.log("Result of calculation: " + res);
      return res;
    }else{
      logger.log("Operation not found: " + operation);
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
