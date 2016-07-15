package resthelloworldtestcases;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import resthelloworld.Student;
import resthelloworld.StudentDAO;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestApiTestCases {
	// JsonReader jsonReader = Json.createReader(new
	// StringReader(Student.class));

	@Test
	public void createStudentDetails() throws SQLException, IOException,
			JSONException {
		Client client = Client.create();
		Student student = new Student();
		WebResource webResource = client
				.resource("http://localhost:8081/jerseyws/services/student/createStudent");

		ClientResponse response = webResource.accept("application/json").get(
				ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Request Failed "+response.getStatus());
		}
		String output = response.getEntity(String.class);

		JSONObject object = new JSONObject(output);
		// JSONObject accumulate = object.accumulate(student.getLastname(),"lank
		// a");

		Assert.assertEquals("suresh",student.getFirstname());

	}

	@Test
	public void getStudentDetails() {

	}

	public static String restConsume(String webResource2, String input) {
		String output = null;
		System.out.println(webResource2);
		System.out.println(input);
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(webResource2);
			ClientResponse response = webResource.header("Content-Type",
					"application/json").post(ClientResponse.class, input);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return output;
	}

}
