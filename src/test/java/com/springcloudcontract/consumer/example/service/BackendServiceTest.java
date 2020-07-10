package com.springcloudcontract.consumer.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.CLASSPATH,
        ids = "com.springboot.example:spring-boot-example:+:stubs:8081")
public class BackendServiceTest {

    @Autowired
    private BackendService backendService;

    @Test
    void testBackendCall() {
        String response = backendService.backendCall().getBody();
        assertThat(response).isEqualTo("{\"firstName\":\"Harshad\",\"lastName\":\"Ranganathan\"}");
    }
}
