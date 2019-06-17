package sk.cubi.usersnphotos.service;

import sk.cubi.usersnphotos.persistence.entity.Photo;
import sk.cubi.usersnphotos.persistence.entity.User;

import java.util.List;

public interface PhotoService {

	List<Photo> findByUserId(Long userId);

}
