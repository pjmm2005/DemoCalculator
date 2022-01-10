package com.calculator.demo.core.operations;

import java.util.function.BiFunction;

public class OperationSum extends Operation{

  private static final BiFunction<Double, Double, Double> FUNCTION = (a, b) -> a + b;

  public OperationSum() {
    super(FUNCTION);
  }

}
