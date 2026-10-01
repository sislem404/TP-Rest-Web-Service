package com.example.Location;

import org.springframework.web.bind.annotation.*;

@RestController
public class LocationWebService {

	@GetMapping("/")
	public String hello() {
		return "hello";
	}
}
