package pobing.dashboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pobing.dashboard.dao.UserSupport;
import pobing.dashboard.model.User;
import pobing.dashboard.service.UserService;
import pobing.dashboard.util.CSRFTokenManager;
import pobing.dashboard.util.DoubleSubmitSession;

@Controller
public class testcontroller extends BaseController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/index")
	public String TestController(Model model) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserSupport userSupport = session.getMapper(UserSupport.class);
			User user = userSupport.selectUserByID(1);
			System.out.println(user.toString());
			model.addAttribute("user", user);
			logger.warn("成功!");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("发生错误！");
		}
		return "index";
	}

	@RequestMapping(value = "/form")
	@DoubleSubmitSession(needSaveToken=true)
	public String Form(Model model,HttpSession session) {
		model.addAttribute("csrf", CSRFTokenManager.getTokenForSession(session));
		return "form";
	}

	@RequestMapping(value = "/csrfAction")
	@DoubleSubmitSession(needRemoveToken=true)
	public String FormAction(HttpServletRequest request,HttpSession session) {
		String param=request.getParameter("param");
		System.out.println("param:"+param);
		return "redirect:/index";
	}
	
	
	
	
	
	@RequestMapping(value="/test")
	public String GetUser(){
		User user=userService.selectUserByID(1);
		logger.debug(user.toString());
		return null;
	}
}
