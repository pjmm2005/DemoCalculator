package com.calculator.demo.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.calculator.demo.DemoCalculatorApplication;
import com.calculator.demo.exceptions.RestOperationNotFoundException;
import java.net.URI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.util.UriComponentsBuilder;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoCalculatorApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @LocalServerPort
  private int port;

  private static final String INITIAL_URL = "http://localhost:";

  @Test
  public void test_calculate_if_all_parameters_are_correct_then_return_correct_value() {
    HttpHeaders headers = new HttpHeaders();

    UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(getfullUrl("/calculator/calculate"))
        .queryParam("operation", "sum")
        .queryParam("operand01", "5")
        .queryParam("operand02", "2");

    HttpEntity<?> entity = new HttpEntity<>(headers);

    ResponseEntity<Double> response = restTemplate.exchange(new RequestEntity<Void>(headers, HttpMethod.GET, URI.create(uriBuilder.toUriString())), Double.class);

    assertNotNull(response);
    assertNotNull(response.getBody());
    assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();

    Double res = response.getBody();
    assertThat(res).isEqualTo(7.0);

  }

  @Test
  public void test_calculate_if_parameter_operation_doesnt_exist_then_an_restOperationNotFoundException_is_throw() {
    HttpHeaders headers = new HttpHeaders();

    UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(getfullUrl("/calculator/calculate"))
        .queryParam("operation", "not_exist")
        .queryParam("operator01", "5")
        .queryParam("operator02", "2");

    HttpEntity<?> entity = new HttpEntity<>(headers);

    ResponseEntity<RestOperationNotFoundException> response = restTemplate.exchange(new RequestEntity<Void>(headers, HttpMethod.GET, URI.create(uriBuilder.toUriString())), RestOperationNotFoundException.class);

    assertThat(response.getStatusCode().is4xxClientError()).isTrue();

  }

  @Test
  public void test_calculate_if_operation_is_blank_then_an_restOperationNotFoundException_is_throw() {
    HttpHeaders headers = new HttpHeaders();

    UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(getfullUrl("/calculator/calculate"))
        .queryParam("operation", "")
        .queryParam("operator01", "5")
        .queryParam("operator02", "2");

    HttpEntity<?> entity = new HttpEntity<>(headers);

    ResponseEntity<RestOperationNotFoundException> response = restTemplate.exchange(new RequestEntity<Void>(headers, HttpMethod.GET, URI.create(uriBuilder.toUriString())), RestOperationNotFoundException.class);

    assertThat(response.getStatusCode().is4xxClientError()).isTrue();

  }

  @Test
  public void test_availableOps() {
    HttpHeaders headers = new HttpHeaders();

    UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(getfullUrl("/calculator/availableOps"));

    HttpEntity<?> entity = new HttpEntity<>(headers);

    ResponseEntity<String> response = restTemplate.exchange(new RequestEntity<Void>(headers, HttpMethod.GET, URI.create(uriBuilder.toUriString())), String.class);

    assertNotNull(response);
    assertNotNull(response.getBody());
    assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();

    String res = response.getBody();
    assertTrue(!res.isEmpty());

  }

  private String getfullUrl(String partialUrl){
    return INITIAL_URL + port + partialUrl;
  }

}
