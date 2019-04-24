package sturs_typeconverter;

import com.opensymphony.xwork2.ActionSupport;

import domain.Point;

public class PointAction extends ActionSupport{
	private Point point;

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	//获取页面提交的坐标点
	public String execute() throws Exception {
		System.out.println(point);
		return SUCCESS;
	}
	public String login() {
		return INPUT;
	}
	
}
