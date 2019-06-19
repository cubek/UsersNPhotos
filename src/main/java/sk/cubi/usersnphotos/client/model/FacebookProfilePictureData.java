package sk.cubi.usersnphotos.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.net.URL;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class FacebookProfilePictureData {

	private URL url;

}
