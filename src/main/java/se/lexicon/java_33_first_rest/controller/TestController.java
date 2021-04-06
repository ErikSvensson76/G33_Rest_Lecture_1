package se.lexicon.java_33_first_rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/v1/test")
    public ResponseEntity<String> helloWebService(@RequestParam(required = false, name = "message") String message){
        if(message != null){
            return ResponseEntity.ok(message);
        }
        return ResponseEntity.ok("Hello World!");
    }

}
