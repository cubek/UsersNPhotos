package sk.cubi.usersnphotos.facade;

import sk.cubi.usersnphotos.gen.user.model.PhotoDto;

import java.util.List;

public interface PhotoFacade {

	List<PhotoDto> findByUserId(Long userId);

}
