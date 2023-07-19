package come.home.prec0719.model;

//DTO : Data Transfer Object
//로직을 작성하기 위함이 아닌, 단순히 1건의 레코드만을 담기위한 더미
public class Member2 {
	private int member2_idx;
	private String id;
	private String pass;
	private String name;
	private String email;
	
	
	public int getMember2_idx() {
		return member2_idx;
	}
	public void setMember2_idx(int member2_idx) {
		this.member2_idx = member2_idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
