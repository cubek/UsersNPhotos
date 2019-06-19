package sk.cubi.usersnphotos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sk.cubi.usersnphotos.client.model.FacebookPhotoWrapper;
import sk.cubi.usersnphotos.client.model.FacebookUser;

@FeignClient(value = "facebookClient", url = "https://graph.facebook.com/v3.3/")
public interface FacebookClient {

	@RequestMapping(method = RequestMethod.GET, value = "/{userId}")
	FacebookUser getUser(
		@PathVariable("userId") Long userId,
		@RequestParam("access_token") String accessToken,
		@RequestParam("fields") String fields);

	@RequestMapping(method = RequestMethod.GET, value = "/{userId}/photos")
	FacebookPhotoWrapper getUserPhotos(
		@PathVariable("userId") Long userId,
		@RequestParam("access_token") String accessToken,
		@RequestParam("fields") String fields,
		@RequestParam("after") String after);

}
