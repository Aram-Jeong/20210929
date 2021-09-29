package doWhileTest;

public class CompFriend extends Friend {
	private String company;
	public CompFriend() {
		
	}

	public CompFriend(String name, String phone, String company) {
		this.name =name;
		this.phone=phone;
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
	
	@Override
	public String toString() {
		return "CompFriend [name=" + super.getName() + ", phone=" + super.getPhone() +", company=" + company + "]";
	}
}
