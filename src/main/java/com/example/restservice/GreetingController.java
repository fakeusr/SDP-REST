package com.example.restservice;

import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World")String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


    // Approach 1
    @PostMapping("/concat")
    public Map<String, Object> processConcat(@RequestBody HashMap<String, Object> values) {
        Map<String, Object> responseValues = new HashMap<>();
        responseValues.put("resultString",
                String.valueOf(values.get("str1")) + " " + String.valueOf(values.get("str2")));
        responseValues.put("time", LocalTime.now());
        return responseValues;
    }

    // Approach 2
    @PostMapping("/concat2")
    public ConcatResponse processConcat2(@RequestBody ConcatObj obj) {
        return new ConcatResponse(obj.getStr1() + " " + obj.getStr2());
    }


}
