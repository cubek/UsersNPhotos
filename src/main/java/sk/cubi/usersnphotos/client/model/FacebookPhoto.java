package sk.cubi.usersnphotos.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.net.URL;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class FacebookPhoto {

	public static String PHOTO_FIELDS = "id,picture,link,album";

	private Long id;

	private URL picture;

	private URL link;

	private FacebookAlbum album;

}
