package com.calculator.demo.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.calculator.demo.core.calculator.CalculatorSanitasImpl;
import com.calculator.demo.exceptions.OperationNotFoundException;
import com.calculator.demo.log.LoggerImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

  @InjectMocks
  private CalculatorService calculatorService;

  @Mock
  private CalculatorSanitasImpl calculatorSanitas;

  @Mock
  private LoggerImpl logger;

  private static final String OPERATION = "sum";

  @Test
  public void test_calculate_if_operation_and_operands_are_correct_then_return_value(){

    when(calculatorService.existOperation(OPERATION)).thenReturn(true);

    when(calculatorSanitas.makeCalculation(OPERATION,Double.valueOf(3),Double.valueOf(2))).thenReturn(5.0);

    Double res = 0.0;

    try {
      res = calculatorService.calculate(OPERATION,Double.valueOf(3),Double.valueOf(2));
    } catch (OperationNotFoundException e) {
      e.printStackTrace();
    }

    assertThat(res).isEqualTo(5.0);
  }

  @Test
  public void test_calculate_if_operation_doesnt_exist_then_exception_is_throw(){

    when(calculatorService.existOperation(OPERATION)).thenReturn(false);

    OperationNotFoundException thrown = assertThrows(
        OperationNotFoundException.class,
        () -> calculatorService.calculate(OPERATION,Double.valueOf(3),Double.valueOf(2)),
        "Expected calculate() throw OperationNotFoundException, but it didn't"
    );

    assertTrue(thrown.getMessage().contains("Operation not found"));
  }

  @Test
  public void test_calculate_if_operation_is_blank_then_exception_is_throw(){

    when(calculatorService.existOperation("")).thenReturn(false);

    OperationNotFoundException thrown = assertThrows(
        OperationNotFoundException.class,
        () -> calculatorService.calculate("",Double.valueOf(3),Double.valueOf(2)),
        "Expected calculate() throw OperationNotFoundException, but it didn't"
    );

    assertTrue(thrown.getMessage().contains("Operation not found"));
  }

}
