package mp.carH2toRahti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;

import mp.carH2toRahti.domain.AppUser;
import mp.carH2toRahti.domain.AppUserRepository;
import mp.carH2toRahti.domain.Car;
import mp.carH2toRahti.domain.CarRepository;
import mp.carH2toRahti.domain.Owner;
import mp.carH2toRahti.domain.OwnerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class CarH2ToRahtiApplication {

	private static final Logger log = LoggerFactory.getLogger(CarH2ToRahtiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarH2ToRahtiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(CarRepository carRepository,
			OwnerRepository ownerRepository, AppUserRepository appUserRepository) {
		return (args) -> {

			log.info("save owners");
			ownerRepository.save(new Owner("Kia", "Watson", 1978));
			ownerRepository.save(new Owner("Aku", "Ankka", 1940));
			ownerRepository.save(new Owner("Iines", "Ankka", 1941));
			ownerRepository.save(new Owner("-", "-"));

			log.info("print owners");
			for (Owner owner : ownerRepository.findAll()) {
				log.info(owner.toString());
			}

			log.info("save some cars");

			carRepository.save(new Car("Ford", "Mustang", ownerRepository.findByLastName("Watson").get(0)));
			carRepository.save(new Car("Nissan", "Leaf", ownerRepository.findByLastName("Watson").get(0)));
			carRepository.save(new Car("Toyota", "Prius", ownerRepository.findByLastName("Ankka").get(0)));
			carRepository.save(new Car("Toyota", "Prius"));
			carRepository.save(new Car("IlmanOwneria", "Testing"));

			log.info("create application users");
			appUserRepository
					.save(new AppUser("user", "$2a$10$6Ehacq06EduOQsntdjKXteXkvuTHKhAWVyuIoHUyBevq5TUhv4nhG", "USER"));
			appUserRepository.save(
					new AppUser("admin", "$2a$10$kjjhzAwU3c4wap0cH0HLM.BUrLfBT6QbDw1YGzpwfmVkJ7RfoG/he", "ADMIN"));

			log.info("print car information");
			for (Car car : carRepository.findAll()) {
				log.info(car.toString());
			}

		};

	};
}
