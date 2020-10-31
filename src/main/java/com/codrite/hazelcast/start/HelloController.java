package com.codrite.hazelcast.start;

import datadog.trace.api.Trace;
import io.opentracing.util.GlobalTracer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Trace(operationName = "hello")
    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String hello(){
        GlobalTracer.get().activeSpan().setTag("Controller", "/hello");
        return "{\"message\": \"hello\"}";
    }

}
