package mp.carH2toRahti.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    List<Owner> findByLastName(String lastName);

}
