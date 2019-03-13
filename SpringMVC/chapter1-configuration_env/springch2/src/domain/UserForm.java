package domain;

public class UserForm {
//	<input type="text" name="uname">
//	<input type="text" name="upwd">
//	<input type="text" name="reset_pwd">
	private String uname;
	private String upwd;
	private String reset_pwd;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getReset_pwd() {
		return reset_pwd;
	}
	public void setReset_pwd(String reset_pwd) {
		this.reset_pwd = reset_pwd;
	}

}
