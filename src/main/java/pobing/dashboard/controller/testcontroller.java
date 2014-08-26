package pobing.dashboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pobing.dashboard.dao.UserSupport;
import pobing.dashboard.model.User;
import pobing.dashboard.util.CSRFTokenManager;

@Controller
public class testcontroller extends BaseController {

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
	public String Form(Model model,HttpSession session) {
		model.addAttribute("csrf", CSRFTokenManager.getTokenForSession(session));
		return "form";
	}

	@RequestMapping(value = "/csrfAction")
	public String FormAction(HttpServletRequest request,HttpSession session) {
		String param=request.getParameter("param");
		System.out.println("param:"+param);
		return "redirect:/index";
	}
}
