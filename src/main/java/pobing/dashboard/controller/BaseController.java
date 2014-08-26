package pobing.dashboard.controller;

import java.io.Reader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pobing.dashboard.util.CSRFTokenManager;

/**
 * 日志、数据库链接
 * @author mark
 *
 */
@Controller
public class BaseController {
	HttpSession session=null;
	public Logger logger=Logger.getLogger(this.getClass());
	public SqlSessionFactory sqlSessionFactory;
    private Reader reader; 
    
    BaseController(){
    	//session.setAttribute(CSRFTokenManager.CSRF_TOKEN_FOR_SESSION_ATTR_NAME, UUID.randomUUID().toString());
    	try{
            reader    = Resources.getResourceAsReader("conf/spring-mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
