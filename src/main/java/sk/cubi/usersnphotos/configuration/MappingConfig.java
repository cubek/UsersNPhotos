package sk.cubi.usersnphotos.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.cubi.usersnphotos.client.model.FacebookPhoto;
import sk.cubi.usersnphotos.client.model.FacebookUser;
import sk.cubi.usersnphotos.persistence.entity.Photo;
import sk.cubi.usersnphotos.persistence.entity.User;

@Configuration
public class MappingConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		TypeMap<FacebookUser, User> fbUserMap = modelMapper.typeMap(FacebookUser.class, User.class);
		fbUserMap.addMapping(src -> src.getPicture().getData().getUrl(), User::setProfilePicture);

		TypeMap<FacebookPhoto, Photo> fbPhotoMap = modelMapper.typeMap(FacebookPhoto.class, Photo.class);
		fbPhotoMap.addMapping(src -> src.getAlbum().getName(), Photo::setAlbum);
		fbPhotoMap.addMapping(FacebookPhoto::getLink, Photo::setFacebookUrl);
		fbPhotoMap.addMapping(FacebookPhoto::getPicture, Photo::setImageUrl);
		return modelMapper;
	}

}
