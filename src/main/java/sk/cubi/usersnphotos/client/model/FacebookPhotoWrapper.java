package sk.cubi.usersnphotos.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class FacebookPhotoWrapper {

	private List<FacebookPhoto> data;

	private FacebookPaging paging;

}
