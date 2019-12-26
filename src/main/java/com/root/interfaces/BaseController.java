package com.root.interfaces;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;



/**
 * 在普通Controller中public class XXController extends BaseController{
               在方法中调用即可：HashMap<String,Object> parameters=getRequestMapSingle(request);
   }
 * @author weixiaojun
 *
 */
public abstract class BaseController {

	protected HashMap<String,Object> getReuestMapSingle(HttpServletRequest request){
		HashMap<String,Object> conditions=new HashMap<String,Object>();
		Map<?, ?> map=request.getParameterMap();
		for(Object o:map.keySet()) {
			String key=(String) o;
			conditions.put(key, ((String[]) map.get(key))[0]);
		}
		return conditions;
	}

	
	public <T> ModelAndView add(Class<T> T,ModelAndView model) {
		return model;
	}

	public <T> ModelAndView modify(Class<T> T,ModelAndView model) {
		return model;
	}

	
	public <T> ModelAndView update(Class<T> T,ModelAndView model) {
		return model;
	}
	
	
	public <T> ModelAndView delete(Class<T> T,ModelAndView model) {
		return model;
	}
}
