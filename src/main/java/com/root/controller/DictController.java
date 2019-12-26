package com.root.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.root.dao.ConfigInfoMapper;
import com.root.entity.ConfigInfo;
import com.root.entity.RepDict;


@Controller
@RequestMapping("/dict")
public class DictController {
	private Logger log = Logger.getLogger(DictController.class);
	String success="查询数据成功！！！";
	
	@Resource
	private ConfigInfoMapper configdao;
	
	@RequestMapping("/index.do")
	public ModelAndView index() {
		log.info("====================2================/dict/index.do  username:");
		ModelAndView model=new ModelAndView();
		model.setViewName("dictlist");
		Map<String,Object> map=new HashMap<String, Object>();					
		List<ConfigInfo> configlist=(List<ConfigInfo>) configdao.getAll();   
		 model.addObject("dbList", configlist);
		 model.addObject("message", success);	
		return model;	
	}
	
	@RequestMapping(value="/select.do")
	public ModelAndView select(ConfigInfo config) {
		log.info("====================2================/dict/select.do  id:"+config.getId());
		ModelAndView model=new ModelAndView();
		model.setViewName("dictedit");
		Map<String,Object> map=new HashMap<String, Object>();					
		List<ConfigInfo> configlist=(List<ConfigInfo>) configdao.getAll();   
		 model.addObject("dbList", configlist);
		 model.addObject("message", success+"edit");	
		return model;	
	}
	
	public RepDict getDict() {	
		return null;	
	}
}
