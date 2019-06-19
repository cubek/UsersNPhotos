package sk.cubi.usersnphotos.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class FacebookProfilePicture {

	private FacebookProfilePictureData data;

}
