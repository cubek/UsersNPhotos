package sk.cubi.usersnphotos.service;

import org.springframework.stereotype.Service;
import sk.cubi.usersnphotos.gen.user.model.PostUserDto;
import sk.cubi.usersnphotos.persistence.entity.Photo;
import sk.cubi.usersnphotos.persistence.entity.User;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

@Service
public class DefaultFacebookService implements FacebookService {

	@Override
	public User getUser(PostUserDto postData) {
		// mock functionality
		try {
			User user = new User().setId(postData.getId().longValue()).setName("Eric Draven").setGender("Male")
				.setProfilePicture(new URL("https://www.photo.com"));
			Photo photo = new Photo().setId(1L).setAlbum("album").setFacebookUrl(new URL("https://www.fb.com"))
				.setImageUrl(new URL("https://www.img.com")).setUser(user);
			user.setPhotos(Arrays.asList(photo));
			return user;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
