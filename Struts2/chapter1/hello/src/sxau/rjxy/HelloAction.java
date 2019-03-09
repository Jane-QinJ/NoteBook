package sxau.rjxy;

public class HelloAction {
	/**
	 * 方法->public
	 * 不能有参数
	 * 名字默认为execute()
	 * @return String
	 */
	//一个action
	public String execute() {
		System.out.println("HelloAction.execute()");
		return "success";
	}
}
