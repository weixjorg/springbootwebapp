package com.root.interfaces;

import java.util.List;
import java.util.Map;


public interface IServiceCommand<T> {
	  //查询所有的数据
		public List<T> getAllData();
		//新增数据
		 public boolean insertData(T t);
		 //修改数据
		 public boolean update(T t); 
		 //删除数据
		 public boolean delete(int id);
		 //查询一条数据通过ID
		 public T getDataById(int id);
		 
		 public List<T> getAll();
		 
		 public List<T> getByCondition(Map<String, Object> map);
		 
		 /**
		  * Map用法
		  * Map<String,Object> map=new HashMap<String, Object>();
			map.put("requireno",productlist.getRequireno());
			map.put("requirename",productlist.getRequirename());
			map.put("uatstarttime",productlist.getUatstarttime());
			map.put("uatendtime",productlist.getUatendtime());
			
		  * <select id="getByCondition" parameterType="map" resultType="cn.temptation.domain.Productlist">
			select * from table   
				<!--
					test 判断表达式(OGNL) C:if test OGNL参照ppt或者官方文档 c:if test 从参数中取值进行判断
					遇见特殊符号应该去写转义字符
					CONCAT(CONCAT('%','${templateName}'),'%')
				-->
		<where >
	        <if test="requireid!=null and requireid!=''">
					and requireid=#{requireid} 
	        </if>
			<if test="requirename!=null and requirename!=''">
					and requirename LIKE '%'#{requirename}'%' 
	        </if>
			<if test="uatstarttime !=null">
					and uatstarttime &gt; #{uatstarttime} 
	        </if>
	        <if test="uatendtime !=null">
					and uatendtime &lt; #{uatendtime} 
	        </if>
	     </where>  
	       order by  requireid
				<!-- ognl 会进行字符串和数字的转换   "0"==0 
				<if test="gender==0  or  gender==1">
					and gender=#{gender}
	            </if>
	              -->
	       </select>
		  */
		 
		 /**
			 * <select id="getAll"  resultType="cn.temptation.domain.WorkList">
		         select * from worklist  where 1=1
		       </select>
		  *  
		 */ 
		 
}
