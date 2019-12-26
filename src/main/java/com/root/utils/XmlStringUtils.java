package com.root.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

import net.sf.json.JSONObject;




public class XmlStringUtils {
	
	  public final static Logger	log	= Logger.getLogger(XmlStringUtils.class);

	// 生成随机数
		public static int tails(final int min, final int max) {
			Random r1 = new Random();
			int tmp = Math.abs(r1.nextInt());
			return tmp % (max - min + 1) + min;
		}
	  
	  static int[] phoneHead = {186, 131, 185, 177,138,139,156,185,152,150, 151 };
		// 当前时间，精确到毫秒
		static String now = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date());
		// 保留两位小数
		static DecimalFormat df = new DecimalFormat("#.00");
		// thirdSeq
		static String thirdSeq = now + tails(1000, 9999);  
		// serNo
		static String serno = now + tails(100000, 999999);		
		//<ec>0004</ec><em>系统日期与自然日日期不一致，暂不处理业务！</em>
		// tradeDate TODO
		static String nowdDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		// tradeTime
//		static String tradeTime = tradeDate + " " + now.substring(8, 10) + ":"+ now.substring(10, 12) + ":" + now.substring(12, 14);
		// applSeqPC
		static String applSeq = "1002" + now.substring(0, 8)+ now.substring(10, 14) + now.substring(14, 16) + tails(0, 9);
		// apptSeq
		static String apptSeq = "1002" + now.substring(0, 8)+ now.substring(10, 14)+ (Integer.parseInt(now.substring(14, 16)) + 1) + tails(0, 9);	
		// applyAmt TODO
		// static String applyAmt = df.format((double)(tails(1000,20000)));
		static String applyAmt = df.format((double) (10000));// 贷款申请金额
		static String apprvAmt = df.format((double) (10000));// 贷款审批金额		
		// indivMobile 手机号
		static String indivMobile = phoneHead[(int) (Math.random() * 9)] + ""
				+ tails(10000000, 99999999);
		// regMobile 注册手机
		static String regMobile = phoneHead[(int) (Math.random() * 9)] + ""
				+ tails(10000000, 99999999);
		// relMobile 联系人手机
		static String relMobile = phoneHead[(int) (Math.random() * 9)] + ""+ tails(10000000, 99999999);
		// applAcNo
		static String applAcNo = "6214320102" + tails(100000, 999999);
		// applAcSeq1
		static String applAcSeq1 = "1002" + now.substring(0, 8)+ now.substring(10, 14) + now.substring(14, 15) + tails(10, 99);
		// applAcSeq2
		static String applAcSeq2 = "1002" + now.substring(0, 8)+ now.substring(10, 11) + tails(10, 99) + tails(0, 9) + tails(0, 9)+ tails(10, 99);
	 
	/**
	 *    处理主方法
	 * @param file   全路径字符串传入,如： /home/filename.xml
	 * @param map   参数设置如右 
	 * Map<String, String> map=new HashMap<>();
	 * map.put(key,value);
	 * @throws IllegalArgumentException
	 * @throws Exception
	 * 返回值为更新字段后明文字符串
	 */
		
	   public static String getPostXmlString(String file,Map<String, String> map) throws IllegalArgumentException, Exception {
		  String objectStr=null;
		  String keytemp=null;
		  String keyvalue=null;
		  objectStr=replaceBlank(getXmlString(file));
		 System.out.println("获取原始报文字符串"+objectStr);
		 String[] keygrouptemp=getMapKeyToStrgroup(map);
		 List<String> objectKeylist = new ArrayList<String>();
		 objectKeylist=StrIsEquals(keygrouptemp, objectStr);
		 System.out.println("==========objectKeylist:"+objectKeylist+"==========");
          /**
           *    Map用法之输出Key值
		 for (String key : map.keySet()) {System.out.println(key);System.out.println("=============");}
		 */
		for(int k=0;k<objectKeylist.size();k++) {
			  keytemp=objectKeylist.get(k);
			  keyvalue=map.get(keytemp);
			  System.out.println("keytemp:"+keytemp+"     keyvalue:"+keyvalue);			  
			  objectStr=matcherAndReplace(objectStr, keytemp,keyvalue); 
		}
		System.out.println("修改后请求报文字符串如下：");
        System.out.println(objectStr);
        return objectStr;
	 }
	  
	   /**
	    * 	 
	    * @param file  填写文件全路径及文件名称
	    * @return
	    */
	 public static String getXmlString(String file) {
	   		 String xmlString;
	   		 byte[] strBuffer = null;
	   		 int flen = 0;
	   		 File xmlfile = new File(file);
	   		 try {
	   		@SuppressWarnings("resource")
	   		InputStream in = new FileInputStream(xmlfile);
	   		 flen = (int)xmlfile.length();
	   		 strBuffer = new byte[flen];
	   		 in.read(strBuffer, 0, flen);
	   		 } catch (FileNotFoundException e) {
	   		 // TODO Auto-generated catch block
	   		 e.printStackTrace();
	   		 } catch (IOException e) {
	   		 // TODO Auto-generated catch block
	   		 e.printStackTrace();
	   		 }
	   		 xmlString = new String(strBuffer); //构建String时，可用byte[]类型，
	   		 return xmlString;
	  }  
	 
	private static String replaceBlank(String str) {
		        StringBuffer sb=new StringBuffer();
		        for(String s:str.split("\n")) {
		        	sb.append(s.trim());
		        }
		        return sb.toString();
		    }
         
		 
		 private static String matcher(String xml,String label) {
			 String context = "";		 
			 //正则表达式
			 String rgex = "<"+label+">(.*?)</"+label+">";
		     Pattern pattern = Pattern.compile(rgex);// 匹配的模式    
			  Matcher m = pattern.matcher(xml);
//			  System.out.println("0=============进入匹配字符串方法====================0");
		     while(m.find()) {	    	 
//		    	 System.out.println(m.group(1));
//		    	 System.out.println("1===========匹配并获取字符串成功==================1");
		    	 context= m.group(1);
		     }
			   return context;
			 }
		 
		 /**
		  * 
		  * @param xml
		  * @param labelValue
		  * @param replacedStr
		  * @return   返回变更后的整个字符串
		  */
		 public static String replace(String xml,String labelValue,String replacedStr) {
			 String context = "";
			 String value="${"+labelValue+"}";
//			 log.info("value:"+value);
             if(xml.contains(value)) {
            	 context= xml.replace(value, replacedStr);
             }else {
            	 context=xml;
             }
			 return context;
    }
	
		 
		 
		 private static String matcherAndReplace(String xml,String label,String replacedStr) {
					 String context = "";		 
					 //正则表达式
					 String rgex = "<"+label+">(.*?)</"+label+">";
				     Pattern pattern = Pattern.compile(rgex);// 匹配的模式    
					  Matcher m = pattern.matcher(xml);
				     while(m.find()) {	    	 
		//		    	 System.out.println(m.group(1));
		//		    	 System.out.println("1===========匹配并获取字符串成功==================1");
				    	 context= m.group(1);
				     }
				     context=xml.replace(matcher(xml,label),replacedStr);
					 return context;
		    }
		 
		 /**
		   * 
		   * @param str   传入键数据
		   * @param objectStr   检测的目标字符串
		   * @return  返回目标中存在的键组；
		   */
		private static List<String> StrIsEquals(String[] str,String objectStr) {
			ArrayList<String> list = new ArrayList<String>();
			for(int i=0;i<str.length;i++) {
				if(objectStr.contains(str[i])) {
					list.add(str[i]);
				}
			}
			System.out.println(list);
			return list;	
		}	
		
		//Map与数组
   private static String[] getMapKeyToStrgroup(Map<String, String> map) {
				   //键
//				  Set<String> keySet = map.keySet();
				//视图
				 Set<Entry<String, String>> entrySet = map.entrySet();
				  //key-->String[]
			   	 String[] array = entrySet.stream().map(Entry::getKey).toArray(String[]::new);
//				  System.out.println(Arrays.toString(array));		  
				   return array;	  
	   }
   

	  public static String mapToJson(Map<String,Object> map) {
//			Map<String,Object> map = new HashMap<String,Object>();
//			map.put(key,value);
			JSONObject jsonObject = JSONObject.fromObject(map);
			String jsonstr=jsonObject.toString();
			return jsonstr;
	  }
	  
	/*  
	public static void main(String[] args) throws IllegalArgumentException, Exception {
		Map<String, String> map =new HashMap<String, String>();
		map.put("idNo", "500227198908285217");
		map.put("custName", "魏小军");
		String[] file= {"CF004064.xml","CF001016.xml","CF004063.xml","CF004043.xml"};
		Channel channel1=ChannelService.getChannelByChannelid("7128");
		String filepath =channel1.getFilepath();     //获取服务器文件路径 ，可在这个路径下创建你上传的文件，与工程XML文件名中保持一致/home/upload/thirdChannel/
        String filename=filepath+file[0];
		String xml=XmlStringUtils.getPostXmlString(filename, map);
		System.out.println("字符串内容为："+xml);
	}
   */
}
