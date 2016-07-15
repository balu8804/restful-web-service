package resthelloworld;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

@Path("/student")
public class StudentDAO {
	private Connection connection;

	public StudentDAO() throws SQLException, IOException {

		connection = StudentDB.getConnection();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/createStudent")
	public Response createStudentDetails(String student) throws SQLException,
			IOException {

		Student studentObject = new ObjectMapper().readValue(student,
				Student.class);
		String status = "success";
		try {
			PreparedStatement statement = connection
					.prepareStatement("insert into studentdetails.studentslist(id,lastname,firstname,"
							+ "dateofbirth,program,admit) "
							+ "values(?,?,?,?,?,?);");

			statement.setInt(1, studentObject.getId());
			statement.setString(2, studentObject.getLastname());
			statement.setString(3, studentObject.getFirstname());
			statement.setString(4, studentObject.getDateofbirth());
			statement.setString(5, studentObject.getProgram());
			statement.setString(6, studentObject.getAdmit());
			statement.executeUpdate();

		} catch (SQLException e) {
			status = "failure";
			e.printStackTrace();
		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}
		return Response.status(200).entity(status).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getStudent")
	public List<Student> getStudentDetails() throws IOException {
		List<Student> students = new ArrayList<Student>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("select * from studentdetails.studentslist order by id;");
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setLastname(rs.getString("lastname"));
				student.setFirstname(rs.getString("firstname"));
				student.setDateofbirth(rs.getString("dateofbirth"));
				student.setProgram(rs.getString("program"));
				student.setAdmit(rs.getString("admit"));
				students.add(student);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return students;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateStudent")
	public Response updateUser(Student student) throws IOException {

		// Student studentObject = new ObjectMapper().readValue(student,
		// Student.class);
		String status = "success";
		try {
			PreparedStatement statement = connection
					.prepareStatement("update studentdetails.studentslist set lastname=?, "
							+ "firstname=?, dateofbirth=?, program=?"
							+ "where id=?;");

			statement.setString(1, student.getLastname());
			statement.setString(2, student.getFirstname());
			// statement.setString(3, studentObject.getFirstname());
			statement.setString(3, student.getDateofbirth());
			statement.setString(4, student.getProgram());
			statement.setInt(5, student.getId());
			statement.executeUpdate();

		} catch (SQLException e) {
			status = "failure";
			e.printStackTrace();
		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}
		return Response.status(200).entity(status).build();

	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deleteStudent/{id}")
	public Response deleteStudent(@PathParam("id") int id)
			throws IOException {
		String status="Success";
	
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from studentdetails.studentslist where id=?");

			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(status).build();

	}

}
