package com.example.Location;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationWebService {

	

    private List<Car> cars = new ArrayList<>();
	private Map<String, Dates> rentalDates = new HashMap<>();

	    public LocationWebService() {
        cars.add(new Car("AA11BB", "Ferrari", 100));
        cars.add(new Car("BB22CC", "BMW", 80));
        cars.add(new Car("CC33DD", "Audi", 70));
    }


	@GetMapping("/cars")
	public List<Car> listOfCars() {
		List<Car> availableCars = new ArrayList<>();

    for (Car car : cars) {
        if (!car.isRented()) {
            availableCars.add(car);
        }
    }

    return availableCars;
	}

	@GetMapping("/cars/{plateNumber}")
	public Car aCar(@PathVariable("plateNumber") String plateNumber) {
		 for (Car car : cars) {
        	if (car.getPlateNumber().equals(plateNumber)) {
            return car;
        	}
    }

    return null;
	}

	@PutMapping("/cars/{plateNumber}")
public void rentOrGetBack(
        @PathVariable("plateNumber") String plateNumber,
        @RequestParam("rent") boolean rent,
        @RequestBody(required = false) Dates dates) {

    for (Car car : cars) {

        if (car.getPlateNumber().equals(plateNumber)) {

            if (rent && dates == null) {
                throw new IllegalArgumentException("Rental dates are required");
            }

            car.setRented(rent);

            if (rent) {
                rentalDates.put(plateNumber, dates);
            } else {
                rentalDates.remove(plateNumber);
            }

            return;
        }
    }
}

	@GetMapping("/")
	public String hello() {
		return "hello";
	}
}
