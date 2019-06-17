package sk.cubi.usersnphotos.service;

import sk.cubi.usersnphotos.gen.user.model.PostUserDto;
import sk.cubi.usersnphotos.persistence.entity.User;

public interface FacebookService {

	User getUser(PostUserDto postData);

}
