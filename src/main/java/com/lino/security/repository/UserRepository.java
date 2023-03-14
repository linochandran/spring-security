package com.lino.security.repository;

import com.lino.security.entity.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
