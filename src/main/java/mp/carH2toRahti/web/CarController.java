package mp.carH2toRahti.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import mp.carH2toRahti.domain.CarRepository;
import mp.carH2toRahti.domain.OwnerRepository;
import mp.carH2toRahti.service.InitDB;

@Controller
public class CarController {

    private static final Logger log = LoggerFactory.getLogger(CarController.class);

    // https://docs.spring.io/spring-boot/reference/using/spring-beans-and-dependency-injection.html
    private final CarRepository carRepository;
    private final InitDB initDB;
    private OwnerRepository ownerRepository;

    public CarController(CarRepository carRepository, OwnerRepository ownerRepository, InitDB initDB) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
        this.initDB = initDB;
    }

    @GetMapping(value = { "/", "main" })
    public String showMainPage() {
        log.info("open main page");
        return "main";
    }

    @GetMapping("/carlist")
    @CrossOrigin(origins = "*")
    public String showCars(Model model) {
        log.info("Read cars from database..");
        model.addAttribute("cars", carRepository.findAll());
        return "carlist";
    }

}
