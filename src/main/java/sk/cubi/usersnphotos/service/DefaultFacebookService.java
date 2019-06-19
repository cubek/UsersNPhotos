package sk.cubi.usersnphotos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.cubi.usersnphotos.client.FacebookClient;
import sk.cubi.usersnphotos.client.model.FacebookPhoto;
import sk.cubi.usersnphotos.client.model.FacebookPhotoWrapper;
import sk.cubi.usersnphotos.client.model.FacebookUser;
import sk.cubi.usersnphotos.gen.user.model.PostUserDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultFacebookService implements FacebookService {

	@Autowired
	private FacebookClient facebookClient;

	@Override
	public FacebookUser getUser(PostUserDto postData) {
		FacebookUser user = facebookClient.getUser(postData.getId().longValue(), postData.getAccessToken(), FacebookUser.USER_FIELDS);
		List<FacebookPhoto> photos = new ArrayList<>();
		FacebookPhotoWrapper loadedPhotos;
		String afterCursor = "";
		do {
			loadedPhotos = facebookClient.getUserPhotos(postData.getId().longValue(), postData.getAccessToken(), FacebookPhoto.PHOTO_FIELDS, afterCursor);
			photos.addAll(loadedPhotos.getData());
			afterCursor = loadedPhotos.getPaging().getCursors().getAfter();
		} while (loadedPhotos != null && loadedPhotos.getPaging().getNext() != null);
		user.setPhotos(photos);
		return user;
	}

}
