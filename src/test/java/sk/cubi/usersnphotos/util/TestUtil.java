package sk.cubi.usersnphotos.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import sk.cubi.usersnphotos.controller.ControllerUtil;

import java.io.IOException;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class TestUtil {

	public static final MediaType APPLICATION_JSON = MediaType.APPLICATION_JSON;

	/**
	 * Returns path to Users endpoint with given path suffix
	 *
	 * @param pathSuffix suffix to be appended to url, for example url parameter
	 * @return concatenated base api path with Users endpoint and given suffix
	 */
	public static String getUsersPath(String pathSuffix) {
		return ControllerUtil.APIT_PATH.concat("/users/").concat(pathSuffix);
	}

	/**
	 * Maps MvcResult obtained from service to specified type
	 *
	 * @param mvcResult   result received from rest controller
	 * @param objectClass class of result
	 * @param <T>         class of result
	 * @return mapped entity from mvcResult's content
	 * @throws Exception Mapping exceptions in case of failure
	 */
	public static <T> T mapResponseToObject(MvcResult mvcResult, Class<T> objectClass) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		return mapper.readValue(mvcResult.getResponse().getContentAsByteArray(), objectClass);
	}

	/**
	 * Maps entity into JSON
	 *
	 * @param entity entity to be converted into JSON
	 * @param <T>    class of entity parameter
	 * @return entity converted into JSON string
	 * @throws JsonProcessingException Error occurred when processing JSON content
	 */
	public static <T> String convertToJson(final T entity) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		return mapper.writeValueAsString(entity);
	}

	/**
	 * Maps MvcResult obtained from service to List of specified type
	 *
	 * @param mvcResult   result received from rest controller
	 * @param objectClass class of result
	 * @param <T>         class of result
	 * @return mapped list of entity from mvcResult's content
	 * @throws IOException Mapping exceptions in case of failure
	 */
	public static <T> List<T> mapResponseToList(MvcResult mvcResult, Class<T> objectClass) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		final byte[] responseBody = mvcResult.getResponse().getContentAsByteArray();
		return mapper.readValue(responseBody, mapper.getTypeFactory().constructCollectionType(List.class, objectClass));
	}

	/**
	 * Creates post request to specified address
	 *
	 * @param objectToPost object to be posted
	 * @param path         api endpoint path for post
	 * @param <T>          class of objectToPost
	 * @return request with specified parameters
	 * @throws JsonProcessingException Error occurred when processing JSON content
	 */
	public static <T> MockHttpServletRequestBuilder createPostRequest(T objectToPost, String path) throws JsonProcessingException {
		return post(path)
			.contentType(APPLICATION_JSON)
			.content(convertToJson(objectToPost));
	}

}
