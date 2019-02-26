package common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateUtil {
	
	public String dateUtli(){
		//得到long类型当前时间
		long l = System.currentTimeMillis();
		//new日期对象
		Date date = new Date(l);
		//转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);	
	}
}
