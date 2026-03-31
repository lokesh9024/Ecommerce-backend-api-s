package com.example.Backend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
@GetMapping("/test")
public String testapi()
{
	return "jwt is working properly";
}

}
