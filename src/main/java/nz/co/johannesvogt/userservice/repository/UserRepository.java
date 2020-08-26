package nz.co.johannesvogt.userservice.repository;

import nz.co.johannesvogt.userservice.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    List<User> findBySurnameContainingIgnoreCase(String surname);

}