package com.springcloudcontract.consumer.example.controller;

import com.springcloudcontract.consumer.example.service.BackendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ExampleController {

    private final BackendService backendService;

    @GetMapping(value = "/backend", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> backend() {
        log.debug("Request received");
        return backendService.backendCall();
    }
}
