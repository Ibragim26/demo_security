package ru.looktook.demo_security.repo;

import org.springframework.data.repository.CrudRepository;
import ru.looktook.demo_security.domain.User;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String name);
}
