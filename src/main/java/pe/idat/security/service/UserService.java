package pe.idat.security.service;

import pe.idat.security.model.User;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(Integer id);
    Optional<User> findByUsername(String username);
    User save(User user);
    void deleteById(Integer id);
    Boolean existsByUsername(String username);
}
