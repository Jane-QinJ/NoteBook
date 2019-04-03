package domain;
//一道试题
public class Question {
	private Integer id;
	private String ask;
	private String optiona;
	private String optionb;
	private String optionc;
	private String optiond;
	private String correct_ans;
	private String stu_ans;
	
	private String stu_score;
	private String score;
	private String flag;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAsk() {
		return ask;
	}
	public void setAsk(String ask) {
		this.ask = ask;
	}
	public String getOptiona() {
		return optiona;
	}
	public void setOptiona(String optiona) {
		this.optiona = optiona;
	}
	public String getOptionb() {
		return optionb;
	}
	public void setOptionb(String optionb) {
		this.optionb = optionb;
	}
	public String getOptionc() {
		return optionc;
	}
	public void setOptionc(String optionc) {
		this.optionc = optionc;
	}
	public String getOptiond() {
		return optiond;
	}
	public void setOptiond(String optiond) {
		this.optiond = optiond;
	}
	public String getCorrect_ans() {
		return correct_ans;
	}
	public void setCorrect_ans(String correct_ans) {
		this.correct_ans = correct_ans;
	}
	public String getStu_ans() {
		return stu_ans;
	}
	public void setStu_ans(String stu_ans) {
		this.stu_ans = stu_ans;
	}
	public String getStu_score() {
		return stu_score;
	}
	public void setStu_score(String stu_score) {
		this.stu_score = stu_score;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}
