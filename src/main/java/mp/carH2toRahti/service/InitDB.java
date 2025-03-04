package mp.carH2toRahti.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import mp.carH2toRahti.domain.Car;
import mp.carH2toRahti.domain.CarRepository;

@Service
public class InitDB {

    private static final Logger log = LoggerFactory.getLogger(InitDB.class);

    private final CarRepository carRepository;

    public InitDB(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public String saveManyCars() {
        carRepository.save(new Car("Ford", "Mustang"));
        carRepository.save(new Car("Nissan", "Leaf"));
        carRepository.save(new Car("Toyota", "Prius"));
        return "Cars saved";
    }

}