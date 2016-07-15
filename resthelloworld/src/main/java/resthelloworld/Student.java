package resthelloworld;


public class Student {
	public static int id;
	public static String lastname;
	public static String firstname;
	public static String dateofbirth;
	public static  String program;
	public static  String admit;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		Student.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		Student.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		Student.firstname = firstname;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		Student.dateofbirth = dateofbirth;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		Student.program = program;
	}

	public String getAdmit() {
		return admit;
	}

	public void setAdmit(String admit) {
		Student.admit = admit;
	}

}
