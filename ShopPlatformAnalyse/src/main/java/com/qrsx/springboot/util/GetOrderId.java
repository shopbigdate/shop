/**  
* <p>Title: Get.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.qst.com</p>  
* @author llx  
* @date 2019年12月11日  
* @version 1.0  
*/  
package com.qrsx.springboot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**  
* <p>Title: Get</p>  
* <p>Description: </p>  
* @author llx  
* @date 2019年12月11日  
*/
public class GetOrderId {
	public String getId(SimpleDateFormat sdf,Date d,Integer user_id) {
		return sdf.format(d)+"-"+user_id;
	}
}
