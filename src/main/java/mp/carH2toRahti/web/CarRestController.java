package mp.carH2toRahti.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mp.carH2toRahti.domain.Car;
import mp.carH2toRahti.domain.CarRepository;

@RestController
public class CarRestController {

    private static final Logger log = LoggerFactory.getLogger(CarRestController.class);

    private final CarRepository carRepository;

    public CarRestController(CarRepository carRepository) {
        this.carRepository = carRepository;

    }

    // return list of cars
    @GetMapping("/cars")
    public Iterable<Car> getCars() {
        log.info("//fetch and return cars");
        return carRepository.findAll();
    }

}
