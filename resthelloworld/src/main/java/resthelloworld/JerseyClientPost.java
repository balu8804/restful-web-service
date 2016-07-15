package resthelloworld;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientPost {

	public static void main(String[] args) {
		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8081/jerseyws/services/studentdetails/data/lastname");

			String input = "{\"id\":\"1\",\"lastname\":\"lanka\",\"firstname\":\"Balasubramanyam\",\""
					+ "dateofbirth\":\"1988-01-04\",\"program\":\"MSXS\",\"admit\":\"Spring\"}";

			ClientResponse response = webResource.type("application/json")
					.header("Content-Type", "application/json")
					.header("Accept", "application/json")
					.post(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}
		// TODO Auto-generated method stub

	}

}
