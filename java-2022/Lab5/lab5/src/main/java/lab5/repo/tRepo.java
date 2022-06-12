package lab5.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import lab5.phones.Phone;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface tRepo extends JpaRepository<Phone, Integer>{

}