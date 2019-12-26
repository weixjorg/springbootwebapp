package com.root.utils;



	import cn.hutool.poi.excel.ExcelReader;
	import cn.hutool.poi.excel.ExcelUtil;
//	import org.apache.commons.lang.ArrayUtils;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.InputStream;
	import java.util.List;
	import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

	/**
	 * @Author jchw
	 * @CreateTime 2019/6/21 17:57
	 * @Version 1.0
	 * @Descr
	 **/

	public class ImportExcelUtils {

	    /**
	     * 读取excel表格内容返回List<Map>
	     * @param inputStream  excel文件流
	     * @param head         表头数组
	     * @param headerAlias  表头别名数组
	     * @return
	     */
	    public static List<Map<String,Object>> importExcel(InputStream inputStream, String[] head, String[] headerAlias){
	        ExcelReader reader = ExcelUtil.getReader(inputStream);
	        List<Object> header=reader.readRow(1);
	        //替换表头关键字
	        if(ArrayUtils.isEmpty(head)||ArrayUtils.isEmpty(headerAlias)||head.length!=headerAlias.length){
	            return null;
	        }else{
	            for(int i=0;i<head.length;i++){
	                if(head[i].equals(header.get(i))){
	                    reader.addHeaderAlias(head[i],headerAlias[i]);
	                }else{
	                    return null;
	                }

	            }
	        }
	        //读取指点行开始的表数据（以下介绍的三个参数也可以使用动态传入，根据个人业务情况修改）
	        //1：表头所在行数  2：数据开始读取位置   Integer.MAX_VALUE:数据读取结束行位置 
	        List<Map<String,Object>> read = reader.read(1,2,Integer.MAX_VALUE);
	        return read;
	    }
	    /**
	     * 读取excel表格内容返回List<Bean>
	     * @param inputStream  excel文件流
	     * @param head         表头数组
	     * @param headerAlias  表头别名数组
	     * @return
	     */
	    public static <T>List<T> importExcel(InputStream inputStream, String[] head, String[] headerAlias,Class<T> bean){
	        ExcelReader reader = ExcelUtil.getReader(inputStream);
	        List<Object> header=reader.readRow(1);
	        //替换表头关键字
	        if(ArrayUtils.isEmpty(head)||ArrayUtils.isEmpty(headerAlias)||head.length!=headerAlias.length){
	            return null;
	        }else{
	            for(int i=0;i<head.length;i++){
	                if(head[i].equals(header.get(i))){
	                    reader.addHeaderAlias(head[i],headerAlias[i]);
	                }else{
	                    return null;
	                }

	            }
	        }
	        //读取指点行开始的表数据（从0开始）
	        List<T> read = reader.read(1,2,bean);
	        return read;
	    }


	    
	public static void main(String[] args) {

	    try {
	        InputStream inputStream=new FileInputStream(new File("C:\\Users\\jchw\\Desktop\\用户数据导入模板_old.xlsx"));
	        String[] excelHead={"*用户账号","*用户姓名","部门代码","*部门名称","标签代码","*标签名称"};
	        String[] excelHeadAlias={"username","realName","deptCode","deptName","labelCode","labelName"};
	        List<Map<String,Object>> result=ImportExcelUtils.importExcel(inputStream,excelHead,excelHeadAlias);
	        System.out.println(result);
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	}

}