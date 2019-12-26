package com.root.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.root.dao.EasyExcelDao;
import com.root.entity.Person;
import com.root.entity.UploadEasyExcelData;
import com.root.entity.UserModel;

/**
 * 测试控制器
 *
 * @author: @我没有三颗心脏
 * @create: 2018-05-08-下午 16:46
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    
	@Resource
	EasyExcelDao   userdao;
	
    @RequestMapping("/hello")
    public ModelAndView hello() {
    	System.out.println("8888888888888888888800000000001111111111111");
    	ModelAndView model=new ModelAndView();
    	model.setViewName("index");
    	model.addObject("message","Hello Spring Boot!");
        return model;
    }
    
    @RequestMapping("/get")
    public ModelAndView getdo() {
    	System.out.println("222222222222222222");
    	ModelAndView model=new ModelAndView();
    	model.setViewName("index");
    	model.addObject("message","Hello Spring Boot!");
        return model;
    }
    
    
    @RequestMapping("/exportExcel")
    public void  export(HttpServletResponse response) throws IOException {
        List<UploadEasyExcelData> list = userdao.selectAll();
        ServletOutputStream out = response.getOutputStream();
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        String fileName = "测试exportExcel";
  //      Sheet sheet = new Sheet(1, 0,Users.class);  //原方法
        Sheet sheet = new Sheet(1, 0);
        //设置自适应宽度
        sheet.setAutoWidth(Boolean.TRUE);
        // 第一个 sheet 名称
        sheet.setSheetName("第一个sheet");
        writer.write(list, sheet);
        //通知浏览器以附件的形式下载处理，设置返回头要注意文件名有中文
        response.setHeader("Content-disposition", "attachment;filename=" + new String( fileName.getBytes("gb2312"), "ISO8859-1" ) + ".xlsx");
        writer.finish();
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        out.flush();
    }
}
