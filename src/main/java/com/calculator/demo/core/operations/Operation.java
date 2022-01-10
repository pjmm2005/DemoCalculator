package com.calculator.demo.core.operations;

import java.util.function.BiFunction;

public abstract class Operation implements ICalculate {

  private BiFunction<Double, Double, Double> function;

  public Operation(BiFunction<Double, Double, Double> function) {
    this.function = function;
  }

  @Override
  public double calculate(double operator01, double operator02) {
    return this.function.apply(operator01,operator02);
  }
}
