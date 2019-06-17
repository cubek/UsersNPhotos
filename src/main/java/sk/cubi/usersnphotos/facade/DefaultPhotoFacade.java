package sk.cubi.usersnphotos.facade;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.cubi.usersnphotos.gen.user.model.PhotoDto;
import sk.cubi.usersnphotos.service.PhotoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultPhotoFacade implements PhotoFacade {

	@Autowired
	private PhotoService photoService;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<PhotoDto> findByUserId(Long userId) {
		return photoService.findByUserId(userId)
			.stream().map(x -> modelMapper.map(x, PhotoDto.class))
			.collect(Collectors.toList());
	}

}
