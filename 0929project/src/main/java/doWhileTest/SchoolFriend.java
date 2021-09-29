package doWhileTest;

public class SchoolFriend extends Friend {
	private String school;

	public SchoolFriend(String name, String phone, String school) {
		this.name =name;
		this.phone=phone;
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	@Override
	public String toString() {
		return "SchoolFriend [name=" + super.getName() + ", phone=" + super.getPhone() + ", school=" + school + "]";
	}
	

}
