package com.calculator.demo.controllers;

import com.calculator.demo.exceptions.OperationNotFoundException;
import com.calculator.demo.exceptions.RestOperationNotFoundException;
import com.calculator.demo.services.CalculatorService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@OpenAPIDefinition(
    info = @Info(
        title = "Calculator implementation demo API",
        version = "1.0",
        description = "API with the operations available for the calculator implementation"
    )
)
@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {

  @Autowired
  CalculatorService calculatorService;

  @Operation(summary = "Endpoint that allows the calculation through one operation and two operands.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successful response."),
      @ApiResponse(responseCode = "400", description = "Not Found."),
      @ApiResponse(responseCode = "500", description = "Internal server error.")
  })
  @GetMapping(path = "/calculate", produces = "application/json")
  public ResponseEntity<Double> calculate(@RequestParam String operation, @RequestParam Double operand01, @RequestParam Double operand02){
    Double res = 0.0;

    try {
      res = calculatorService.calculate(operation, operand01, operand02);
    }catch (OperationNotFoundException onfe){
      throw new RestOperationNotFoundException();
    }

    return ResponseEntity.ok(res);

  }

  @Operation(summary = "Endpoint that returns all available operations for a calculator implementation.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successful response."),
      @ApiResponse(responseCode = "500", description = "Internal server error.")
  })
  @GetMapping(path = "/availableOps", produces = "application/json")
  public ResponseEntity<String> getAvailableOps(){

    return ResponseEntity.ok(calculatorService.getAvailableOps());

  }

}
