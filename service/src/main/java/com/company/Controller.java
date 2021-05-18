package com.company;

import brave.Tracer;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Validated
@RequestMapping("/api/v0")
public class Controller {

    @Autowired
    private Tracer tracer;

    @GetMapping(path = "/user", produces = APPLICATION_JSON_VALUE)
    public Object get() {
        try {
            String traceId = MDC.get("X-B3-TraceId");
            System.out.println(traceId);
            System.out.println(MDC.getCopyOfContextMap());
            tracer.currentSpan().context().traceId();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.status(HttpStatus.OK);
    }

}

