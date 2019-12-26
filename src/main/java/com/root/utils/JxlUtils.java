package com.root.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class JxlUtils {
	
	
	public static void exportToExcel() throws RowsExceededException, WriteException, IOException {
		//创建文件，设置文件名。文件默认保存在当前位置
		WritableWorkbook book = Workbook.createWorkbook(new File("测试.xls"));
		 
		//生成名为“first”的工作表，参数0表示这是第一页
		WritableSheet sheet = book.createSheet("第一页" ,0);
		 
		//在Label对象的构造子中指名单元格位置是第一列第一行(0,0) 以及单元格内容为test
		Label label = new Label(0,0,"test");
		 
		//将定义好的单元格添加到工作表中
		sheet.addCell(label);
		 
		//生成一个保存数字的单元格，值为789.123，类型为jxl.write.Number
		jxl.write.Number number = new jxl.write.Number(1,0,789.123);
		sheet.addCell(number);
		 
		//写进文件，关闭文件
		try {
			book.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void readExcel(MultipartFile file) throws BiffException, IOException {
	    //创建一个workbook，在里面执行读取操作
	    //我用的是spring框架，从前端传来的文件格式是MultipartFile file，我用file.getInputStream()将file从MultipartFile转到file格式，从而使用jxl读取
	    Workbook book = Workbook.getWorkbook(file.getInputStream());	 
	    //获得第一个工作表对象，0表示第一个
	    Sheet sheet = book.getSheet(0);	 
	    //得到所有的列数
	    int clos = sheet.getColumns();	 
	    //得到所有的行数
	    int rows = sheet.getRows();	 
	    //Cell cell = sheet.getCell(j,i);cell是这个表里第j+1列第i+1行的单元格 
	    //第3列第2行
	    Cell cell = sheet.getCell(2,1); 
	    //得到该单元格里的内容
	    String result = cell.getContents();	 
	    //关闭
	    book.close();
	}
	
	public static void writeExcel() {
	      File xlsFile = new File("jxl.xls");
	      // 创建一个工作簿
	      WritableWorkbook workbook = null;
		try {
			workbook = Workbook.createWorkbook(xlsFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      // 创建一个工作表
	      WritableSheet sheet = workbook.createSheet("sheet1", 0);
	      for (int row = 0; row < 10; row++)
	      {
	         for (int col = 0; col < 10; col++)
	         {
	            // 向工作表中添加数据
	            try {
					sheet.addCell(new Label(col, row, "data" + row + col));
				} catch (RowsExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         }
	      }
	      try {
			workbook.write();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      try {
			workbook.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
     public static void readFromExcel() {
         File xlsFile = new File("jxl.xls");
         // 获得工作簿对象
         Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(xlsFile);
		} catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         // 获得所有工作表
         Sheet[] sheets = workbook.getSheets();
         // 遍历工作表
         if (sheets != null)
         {
            for (Sheet sheet : sheets)
            {
               // 获得行数
               int rows = sheet.getRows();
               // 获得列数
               int cols = sheet.getColumns();
               // 读取数据
               for (int row = 0; row < rows; row++)
               {
                  for (int col = 0; col < cols; col++)
                  {
                     System.out.printf("%10s", sheet.getCell(col, row).getContents());
                  }
                  System.out.println();
               }
            }
         }
         workbook.close();
		
	}
	
}
