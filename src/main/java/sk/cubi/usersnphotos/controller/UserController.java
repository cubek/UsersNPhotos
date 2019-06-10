package sk.cubi.usersnphotos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.cubi.usersnphotos.gen.user.api.UsersApi;
import sk.cubi.usersnphotos.gen.user.model.Photo;
import sk.cubi.usersnphotos.gen.user.model.PostUserRequest;
import sk.cubi.usersnphotos.gen.user.model.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(ControllerUtil.APIT_PATH)
public class UserController implements UsersApi {

	public ResponseEntity<Void> deleteUserById(BigDecimal userId) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<List<Photo>> getPhotosByUserId(BigDecimal userId) {
		return ResponseEntity.ok(new ArrayList<>());
	}

	public ResponseEntity<User> getUserById(BigDecimal userId) {
		return ResponseEntity.ok(new User().name("Eric Draven").id(userId));
	}

	public ResponseEntity<Void> loadUser(PostUserRequest postUserRequest) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
