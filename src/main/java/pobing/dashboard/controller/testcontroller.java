package pobing.dashboard.controller;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pobing.dashboard.dao.UserSupport;
import pobing.dashboard.model.User;

@Controller
public class testcontroller extends BaseController {

	@RequestMapping(value="/index")
	public String TestController(){
		SqlSession session=sqlSessionFactory.openSession();
		try{
			UserSupport userSupport=session.getMapper(UserSupport.class);
			User user=userSupport.selectUserByID(1);
			System.out.println(user.toString());
			log.warn("成功!");
		}catch(Exception e){
			e.printStackTrace();
			log.error("发生错误！");
		}
		return "index";
	}
}