package pobing.dashboard.controller;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

/**
 * 日志、数据库链接
 * @author mark
 *
 */

public class BaseController {
	public Logger log=Logger.getLogger(this.getClass());
	public SqlSessionFactory sqlSessionFactory;
    private Reader reader; 
    
    BaseController(){
    	try{
            reader    = Resources.getResourceAsReader("conf/spring-mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
