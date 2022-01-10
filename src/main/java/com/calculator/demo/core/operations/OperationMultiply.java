package com.calculator.demo.core.operations;

import java.util.function.BiFunction;

public class OperationMultiply extends Operation{

  private static final BiFunction<Double, Double, Double> FUNCTION = (a, b) -> a * b;

  public OperationMultiply() {
    super(FUNCTION);
  }

}
