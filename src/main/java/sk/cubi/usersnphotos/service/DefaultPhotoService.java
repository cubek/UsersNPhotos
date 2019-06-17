package sk.cubi.usersnphotos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.cubi.usersnphotos.persistence.entity.Photo;
import sk.cubi.usersnphotos.persistence.repository.PhotoDao;

import java.util.List;

@Service
public class DefaultPhotoService implements PhotoService {

	@Autowired
	private PhotoDao photoDao;

	@Override
	public List<Photo> findByUserId(Long userId) {
		return photoDao.findByUserId(userId);
	}

}
