package sk.cubi.usersnphotos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.cubi.usersnphotos.facade.PhotoFacade;
import sk.cubi.usersnphotos.facade.UserFacade;
import sk.cubi.usersnphotos.gen.user.api.UsersApi;
import sk.cubi.usersnphotos.gen.user.model.PhotoDto;
import sk.cubi.usersnphotos.gen.user.model.PostUserDto;
import sk.cubi.usersnphotos.gen.user.model.UserDto;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(ControllerUtil.API_PATH)
public class UserController implements UsersApi {

	@Autowired
	private UserFacade userFacade;

	@Autowired
	private PhotoFacade photoFacade;

	public ResponseEntity<Void> deleteUserById(BigDecimal userId) {
		userFacade.deleteById(userId.longValue());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<List<PhotoDto>> getPhotosByUserId(BigDecimal userId) {
		return ResponseEntity.ok(photoFacade.findByUserId(userId.longValue()));
	}

	public ResponseEntity<UserDto> getUserById(BigDecimal userId) {
		return ResponseEntity.of(userFacade.findById(userId.longValue()));
	}

	public ResponseEntity<Void> loadUser(PostUserDto postUserRequest) {
		userFacade.loadUser(postUserRequest);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
