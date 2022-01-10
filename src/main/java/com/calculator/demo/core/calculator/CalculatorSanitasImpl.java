package com.calculator.demo.core.calculator;

import com.calculator.demo.core.operations.Operation;
import com.calculator.demo.core.operations.OperationSubtract;
import com.calculator.demo.core.operations.OperationSum;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class CalculatorSanitasImpl extends Calculator{

  private static final Map<String, Operation> OPERATION_MAP  = new HashMap<>() {{
    put("sum", new OperationSum());
    put("subtract", new OperationSubtract());
  }};

  public CalculatorSanitasImpl() {
    super(OPERATION_MAP);
  }

}
