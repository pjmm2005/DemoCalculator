package com.calculator.demo.core.calculator;

import com.calculator.demo.core.operations.Operation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Calculator {

  private Map<String, Operation> operationMap = new HashMap<>();

  public Calculator(Map<String, Operation> operationMap) {
    this.operationMap = operationMap;
  }

  public double makeCalculation(String operation, Double operator01, Double operator02){
    if(this.operationMap.containsKey(operation)){
      return operationMap.get(operation).calculate(operator01,operator02);
    }else{
      return 0;
    }
  }

  public void setToOperationMap(String nameOperation, Operation operation) {
    this.operationMap.put(nameOperation,operation);
  }

  public String getOperationsAvailable(){
    List listOfOperations = new ArrayList<>();
    this.operationMap.forEach((k, v) -> {
      listOfOperations.add(k);
    });
    return String.join(",", listOfOperations);
  }

  public boolean existOperation(String operation){
    return this.operationMap.containsKey(operation);
  }
}
