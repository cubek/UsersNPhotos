package sk.cubi.usersnphotos.facade;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.cubi.usersnphotos.gen.user.model.PostUserDto;
import sk.cubi.usersnphotos.gen.user.model.UserDto;
import sk.cubi.usersnphotos.persistence.entity.User;
import sk.cubi.usersnphotos.service.FacebookService;
import sk.cubi.usersnphotos.service.UserService;

import java.util.Optional;

@Service
public class DefaultUserFacade implements UserFacade {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserService userService;

	@Autowired
	private FacebookService facebookService;

	@Override
	public Optional<UserDto> findById(Long id) {
		return userService.findById(id).map(x -> modelMapper.map(x, UserDto.class));
	}

	@Override
	public void loadUser(PostUserDto postData) {
		User user = facebookService.getUser(postData);
		userService.save(modelMapper.map(user, User.class));
	}

	@Override
	public void deleteById(Long id) {
		userService.deleteById(id);
	}

}
