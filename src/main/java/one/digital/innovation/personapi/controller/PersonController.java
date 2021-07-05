package one.digital.innovation.personapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("people")
public class PersonController {

    @GetMapping
    public String getBook(){
        return "API Test!";
    }
}
