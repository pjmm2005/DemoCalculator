package com.calculator.demo.core.operations;

import java.util.function.BiFunction;

public abstract class Operation implements ICalculate {

  private BiFunction<Double, Double, Double> function;

  public Operation(BiFunction<Double, Double, Double> function) {
    this.function = function;
  }

  @Override
  public double calculate(double operand01, double operand02) {
    return this.function.apply(operand01,operand02);
  }
}
