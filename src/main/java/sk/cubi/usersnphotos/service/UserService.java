package sk.cubi.usersnphotos.service;

import sk.cubi.usersnphotos.persistence.entity.User;

import java.util.Optional;

public interface UserService {

	Optional<User> findById(Long id);

	void save(User user);

	void deleteById(Long id);

}
