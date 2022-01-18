package com.calculator.demo.core.calculator;

import com.calculator.demo.core.operations.Operation;
import java.util.Map;

public class CalculatorSanitasImpl extends Calculator{

  public CalculatorSanitasImpl(Map<String, Operation> operations) {
    super(operations);
  }

}
