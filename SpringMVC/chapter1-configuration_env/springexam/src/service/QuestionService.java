package service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import domain.Question;

@Service
public class QuestionService {
	//使用静态集合变量users模拟数据库
	private static ArrayList<Question> juanzi = new ArrayList<Question>();
	public String SpectialTurn(String tmp) {
		//对于<>，换成HTML转义字符 &lt; &gt;
		
				tmp = tmp.replace("<", "&lt;");  //先将tmp的<改变
				return 	tmp.replace(">", "&gt;");
				
	}
	public boolean addUser(Question u) {
		// TODO Auto-generated method stub
	
		u.setOptiona(SpectialTurn(u.getOptiona()));
		u.setOptionb(SpectialTurn(u.getOptionb()));
		u.setOptionc(SpectialTurn(u.getOptionc()));
		u.setOptiond(SpectialTurn(u.getOptiond()));
		
		juanzi.add(u);
		return true;
		
	}
		
	
	public ArrayList<Question> getPaper() {
		// TODO Auto-generated method stub
		return juanzi;
	}
	
	
	
	
}
