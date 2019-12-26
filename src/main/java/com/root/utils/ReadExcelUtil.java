package com.root.utils;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.root.entity.ShopVO;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;


@Log
public class ReadExcelUtil {

	
	//读取excel文件
	public static ExcelReader readData(String path) throws IOException {
			File file = FileUtil.file(path);
			InputStream is = new FileInputStream(file);
			return ExcelUtil.getReader(is, 0);
	}
	
	
	@Test
	public void initTest() throws Exception {
	   ExcelReader excelReader = ReadExcelUtil.readData("E:/log/ud_shop.xlsx");
	   Sheet sheet = excelReader.getSheet();
	//  遍历每一行
	for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
	    Row row = sheet.getRow(rowIndex);
	   if (row == null) {
	       continue;
	     }
        //  遍历每一行的每一列
       ShopVO shop = new ShopVO();
	    String userId = "1";
		shop.setUserId(userId);
	    for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
	        Cell cell = row.getCell(cellIndex);
	     if (cellIndex == 0) {
	        shop.setName((String) excelReader.readCellValue(cellIndex,rowIndex));
	     }else if (cellIndex == 1) {
	        shop.setCoverUrl((String) excelReader.readCellValue(cellIndex,rowIndex));
	     }else if (cellIndex == 2) {
	         shop.setLogoUrl((String) excelReader.readCellValue(cellIndex,rowIndex));
	     }else if (cellIndex == 3) {
	          shop.setBrief((String) excelReader.readCellValue(cellIndex,rowIndex));
	      }else {
	          shop.setAddr((String) excelReader.readCellValue(cellIndex,rowIndex));
	      }
	    }
	  }
	}
	   //    log.info("shop={}"+shop);
	// shopProvider.insert(shop);

	 
	//生成验证码
	@GetMapping("/code")
	public void writeCode(HttpServletRequest request, HttpServletResponse response) {
	//生成验证码图片
	LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(250, 100,6,200);
	try {
	request.getSession().setAttribute("CAPTCHA_KEY", lineCaptcha.getCode());
	response.setContentType("image/png");//告诉浏览器输出内容为图片
	response.setHeader("Pragma", "No-cache");//禁止浏览器缓存
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expire", 0);
	lineCaptcha.write(response.getOutputStream());
	//log.info("code={}",lineCaptcha.getCode());
	} catch (IOException e) {
	e.printStackTrace();
	}
	}
	 
	//生成二维码
	@GetMapping("/qrCode")
	public void generateQrCode(HttpServletResponse response) {
	QrConfig config = new QrConfig(300, 300);
	// 高纠错级别
	config.setErrorCorrection(ErrorCorrectionLevel.H);
	// 设置边距，既二维码和背景之间的边距
	config.setMargin(3);
      // 设置前景色，既二维码颜色
	config.setForeColor(Color.WHITE.getRGB());
	// 设置背景色
	config.setBackColor(Color.BLACK.getRGB());
	// 生成二维码到文件，写入流
	try {
	      QrCodeUtil.generate("http://g5zdsc.natappfree.cc/hello/code", config, "jpg",response.getOutputStream());
	} catch (IOException e) {
	// TODO Auto-generated catch block
	    e.printStackTrace();
	   }
	}

	
	
	
}
