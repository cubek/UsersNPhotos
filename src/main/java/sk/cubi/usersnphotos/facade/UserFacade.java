package sk.cubi.usersnphotos.facade;

import sk.cubi.usersnphotos.gen.user.model.PostUserDto;
import sk.cubi.usersnphotos.gen.user.model.UserDto;

import java.util.Optional;

public interface UserFacade {

	Optional<UserDto> findById(Long id);

	void loadUser(PostUserDto user);

	void deleteById(Long id);

}
