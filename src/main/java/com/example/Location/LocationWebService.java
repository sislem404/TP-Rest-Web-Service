package com.example.Location;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationWebService {

	

    private List<Car> cars = new ArrayList<>();

	    public LocationWebService() {
        cars.add(new Car("AA11BB", "Ferrari", 100));
        cars.add(new Car("BB22CC", "BMW", 80));
        cars.add(new Car("CC33DD", "Audi", 70));
    }


	@GetMapping("/cars")
	public List<Car> listOfCars() {
    return cars;
	}
	@GetMapping("/")
	public String hello() {
		return "hello";
	}
}
