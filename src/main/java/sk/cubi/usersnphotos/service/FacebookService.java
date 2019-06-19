package sk.cubi.usersnphotos.service;

import sk.cubi.usersnphotos.client.model.FacebookUser;
import sk.cubi.usersnphotos.gen.user.model.PostUserDto;
import sk.cubi.usersnphotos.persistence.entity.User;

public interface FacebookService {

	FacebookUser getUser(PostUserDto postData);

}
