package com.calculator.demo.configuration;

import com.calculator.demo.core.calculator.CalculatorSanitasImpl;
import com.calculator.demo.core.operations.OperationSubtract;
import com.calculator.demo.core.operations.OperationSum;
import java.util.HashMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorSanitasConfig {

  @Bean
  public CalculatorSanitasImpl getCalculatorImplBean(){
    return new CalculatorSanitasImpl(new HashMap<>() {{
      put("sum", new OperationSum());
      put("subtract", new OperationSubtract());
    }});
  }

}
