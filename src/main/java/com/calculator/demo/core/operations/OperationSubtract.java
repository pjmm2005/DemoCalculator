package com.calculator.demo.core.operations;

import java.util.function.BiFunction;

public class OperationSubtract extends Operation{

  private static final BiFunction<Double, Double, Double> FUNCTION = (a, b) -> a - b;

  public OperationSubtract() {
    super(FUNCTION);
  }

}
