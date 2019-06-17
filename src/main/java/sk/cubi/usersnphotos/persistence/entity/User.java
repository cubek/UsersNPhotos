package sk.cubi.usersnphotos.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Table(name = "user")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@NotNull
	@Size(max = 255)
	private String name;

	@NotNull
	private String gender;

	private URL profilePicture;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Photo> photos;

	public User setPhotos(Collection<Photo> photos) {
		this.photos = new ArrayList<>(photos);
		return this;
	}

}
