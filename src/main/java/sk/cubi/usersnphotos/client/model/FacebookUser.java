package sk.cubi.usersnphotos.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class FacebookUser {

	public static String USER_FIELDS = "gender,id,name,picture";

	private Long id;

	private String gender;

	private String name;

	private FacebookProfilePicture picture;

	private List<FacebookPhoto> photos;

}
