package sk.cubi.usersnphotos.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.cubi.usersnphotos.persistence.entity.Photo;

import java.util.List;

public interface PhotoDao extends JpaRepository<Photo, Long> {

	List<Photo> findByUserId(Long id);

}
