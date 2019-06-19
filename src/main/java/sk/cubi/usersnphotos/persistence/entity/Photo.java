package sk.cubi.usersnphotos.persistence.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.net.URL;

@Table(name = "photo")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Photo {

	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@NotNull
	private URL facebookUrl;

	@NotNull
	private URL imageUrl;

	@Size(max = 255)
	private String album;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@ToString.Exclude
	private User user;

}
