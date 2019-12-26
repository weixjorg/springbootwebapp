package com.root.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

public class HutoolUtils {


	public static void testHutool(File file) {
		// 1.获取上传文件输入流
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2.应用HUtool ExcelUtil获取ExcelReader指定输入流和sheet 
		ExcelReader excelReader = ExcelUtil.getReader(inputStream, "导入材料清单");
		// 可以加上表头验证
		// 3.读取第二行到最后一行数据
		List<List<Object>> read = excelReader.read(2, excelReader.getRowCount());
		for (List<Object> objects : read) {
//		 System.out.println(objects.get(0));//读取某行第一列数据
//		 System.out.println(objects.get(1));//读取某行第二列数据	
		 System.out.println(objects);
		}
	}	
	
    /**
                    <dependency>
								<groupId>cn.hutool</groupId>
								<artifactId>hutool-all</artifactId>
								<version>5.0.7</version>
						</dependency>
     *   Hutool版本使用V5.0.1
     * @param filename    读取文件路径 String类型 全路径
     * @param sheetname   读取excel的sheet名称
     * @param readindexrow  开始读取行，一般为第二行
     * @return    List<List<Object>> readdata = excelReader.read(readindexrow, excelReader.getRowCount());
     */
	public static List<List<Object>> readDataToObject(String filename,String sheetname,int readindexrow) {
		File file=new File(filename);
		// 1.获取上传文件输入流
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2.应用HUtool ExcelUtil获取ExcelReader指定输入流和sheet 
		ExcelReader excelReader = ExcelUtil.getReader(inputStream, sheetname);
		// 可以加上表头验证
		// 3.读取第二行到最后一行数据
		List<List<Object>> readdata = excelReader.read(readindexrow, excelReader.getRowCount());
		for (List<Object> objects : readdata) {
//		 System.out.println(objects.get(0));//读取某行第一列数据
//		 System.out.println(objects.get(1));//读取某行第二列数据	
		 System.out.println(objects);
		}
		
		return readdata;
	}	
	
	
}
