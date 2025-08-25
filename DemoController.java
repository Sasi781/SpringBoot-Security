package com.example.api.Controller;
import com.example.api.model.Users;
import com.example.api.service.DemoService;
import com.example.api.service.MyUserDetailsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@SecurityRequirement(name = "basicAuth")
public class DemoController {
    @Autowired
    private DemoService demoService;

    List<Integer> list = new ArrayList<>();
    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @PostMapping("/create")
    public List<Integer> create(@RequestParam int a){
        list.add(a);
        return list;
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return demoService.verify(user);
    }
}
