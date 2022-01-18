package com.calculator.demo.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.calculator.demo.core.calculator.CalculatorSanitasImpl;
import com.calculator.demo.core.operations.OperationMultiply;
import com.calculator.demo.core.operations.OperationSubtract;
import com.calculator.demo.core.operations.OperationSum;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class CalculatorImplTest {

  private static final String OPERATION_SUM = "sum";
  private static final String OPERATION_SUBTRACT = "subtract";
  private static final String OPERATION_MULTIPLY = "multiply";

  private CalculatorSanitasImpl calculatorSanitas = new CalculatorSanitasImpl(new HashMap<>() {{
    put(OPERATION_SUM, new OperationSum());
    put(OPERATION_SUBTRACT, new OperationSubtract());
  }});

  @Test
  public void test_makeCalculation_if_operation_and_operands_are_correct_then_return_value(){

    Double res = calculatorSanitas.makeCalculation(OPERATION_SUM,Double.valueOf(3),Double.valueOf(2));

    assertThat(res).isEqualTo(5.0);
  }

  @Test
  public void test_makeCalculation_if_operands_are_negative_then_return_correct_value(){

    Double res = calculatorSanitas.makeCalculation(OPERATION_SUM,Double.valueOf(-3),Double.valueOf(-2));

    assertThat(res).isEqualTo(-5.0);
  }

  @Test
  public void test_makeCalculation_if_operation_doesnt_exist_then_return_zero(){

    Double res = calculatorSanitas.makeCalculation("not_exist",Double.valueOf(3),Double.valueOf(2));

    assertThat(res).isEqualTo(0.0);
  }

  @Test
  public void test_setToOperationMap_if_operation_is_add_then_the_new_value_is_added_to_map(){

    int number_of_operations = sizeOfOperations(calculatorSanitas.getOperationsAvailable());
    assertFalse(calculatorSanitas.existOperation(OPERATION_MULTIPLY));

    calculatorSanitas.setToOperationMap(OPERATION_MULTIPLY, new OperationMultiply());

    assertThat(sizeOfOperations(calculatorSanitas.getOperationsAvailable())).isEqualTo(number_of_operations + 1);
    assertTrue(calculatorSanitas.existOperation(OPERATION_MULTIPLY));
  }

  private int sizeOfOperations(String operations){
    String [] listOfOperations = operations.split(",");
    return listOfOperations.length;
  }

}
