package sk.cubi.usersnphotos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.cubi.usersnphotos.persistence.entity.User;
import sk.cubi.usersnphotos.persistence.repository.UserDao;

import java.util.Optional;

@Service
public class DefaultUserService implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public Optional<User> findById(Long id) {
		return userDao.findById(id);
	}

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public void deleteById(Long id) {
		userDao.deleteById(id);
	}

}
