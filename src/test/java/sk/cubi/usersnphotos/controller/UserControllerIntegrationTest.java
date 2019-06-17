package sk.cubi.usersnphotos.controller;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;
import sk.cubi.usersnphotos.AbstractUsersNPhotosIntegrationTest;
import sk.cubi.usersnphotos.gen.user.model.PhotoDto;
import sk.cubi.usersnphotos.gen.user.model.PostUserDto;
import sk.cubi.usersnphotos.gen.user.model.UserDto;
import sk.cubi.usersnphotos.util.TestUtil;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerIntegrationTest extends AbstractUsersNPhotosIntegrationTest {

	@Test
	public void deleteUserById() throws Exception {
		mockMvc.perform(delete(TestUtil.getUsersPath("123456")))
			.andExpect(status().isNoContent());
	}

	@Test
	public void getPhotosByUserId() throws Exception {
		MvcResult result = mockMvc.perform(get(TestUtil.getUsersPath("123456/photos")))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtil.APPLICATION_JSON))
			.andReturn();
		List<PhotoDto> photos = TestUtil.mapResponseToList(result, PhotoDto.class);
		assertThat(photos).isEmpty();
	}

	@Test
	public void getUserById() throws Exception {
		MvcResult result = mockMvc.perform(get(TestUtil.getUsersPath("123456")))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtil.APPLICATION_JSON))
			.andReturn();
		UserDto user = TestUtil.mapResponseToObject(result, UserDto.class);
		assertThat(user).isEqualTo(new UserDto().id(new BigDecimal(123456)).name("Eric Draven"));
	}

	@Test
	public void loadUser() throws Exception {
		PostUserDto userRequest = new PostUserDto().accessToken("mock access token").id(new BigDecimal(123456));
		mockMvc.perform(TestUtil.createPostRequest(userRequest, TestUtil.getUsersPath("")))
			.andExpect(status().isNoContent());
	}

}
