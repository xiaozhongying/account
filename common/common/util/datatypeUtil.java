package common.util;
import org.omg.CORBA.StringHolder;

import dswork.core.util.EncryptUtil;



public class datatypeUtil
{
	public static boolean validate(String type,String str,StringHolder holder) {
		switch(type)
		{
			case "Require":holder.value="必填";return RegMacher.isNull(str);////测试成功
			
			case "Chinese":holder.value="中文";return RegMacher.isChinese(str);//测试成功
			
			case "WebDate":holder.value="日期";return RegMacher.isDate(str);//日期(必填) 
			
			case "Char":holder.value="英、数、下划线"; return RegMacher.isENG_NUM_(str);//英、数、下划线(必填) 
			
			case "IdCard":holder.value="身份证号码"; return RegMacher.isIdCard(str);//身份证号码(必填) 
			
			case "Mobile":holder.value="手机号码"; return RegMacher.isMobile(str);//测试成功
			
			case "Money":holder.value="金额"; return RegMacher.isDOUBLE_NEGATIVE(str);//测试失败
			
			case "Email":holder.value="邮件格式"; return RegMacher.isEmail(str);//邮件格式(必填) 
			
			case "Number":holder.value="数值"; return RegMacher.isNumber(str);//测试成功
			
			case "NumberPlus":holder.value="正数"; return RegMacher.isNumberPlus(str);//测试成功
			
			case "NumberMinus":holder.value="负数"; return RegMacher.isNumberMinus(str);//测试成功
			
			case "Integer":holder.value="整数"; return RegMacher.isInteger(str);//测试成功
			
			case "IntegerPlus":holder.value="正整数"; return RegMacher.isIntegerPlus(str);//测试成功
			
			case "IntegerMinus":holder.value="负整数"; return RegMacher.isIntegerMinus(str);//测试成功

			
			default:return false;
		}
	}
	public static void main(String[] args)
	{
		StringHolder holder=new StringHolder();
		String a="432524199605248035";
		int b=01;
		System.out.println(a.matches("/^\\d{6}(18|19|20)?\\d{2}(0[1-9]|1[012])(0[1-9]|[12]\\d|3[01])\\d{3}(\\d|[xX])$/"));
	
	}
	/**
	 * 自定义日期格式
	 * @param type
	 * @param str
	 * @param holder
	 * @param format（yyyy-MM 或yyyy-MM-dd）
	 * @return
	 */
	public static boolean validate(String type,String str,StringHolder holder,String format) {
		switch(type)
		{
			case "Require":holder.value="必填";return RegMacher.isNull(str);//字符串(必填)  
			
			case "Chinese":holder.value="中文";return RegMacher.isChinese(str);//中文(必填) 
			
			case "WebDate":holder.value="日期(例如2018年1月格式为：2018-01)";return RegMacher.isDate(str,format);//日期(必填) 
			
			case "Char":holder.value="英、数、下划线"; return RegMacher.isENG_NUM_(str);//英、数、下划线(必填) 
			
			case "IdCard":holder.value="身份证号码"; return RegMacher.isIdCard(str);//身份证号码(必填) 
			
			case "Mobile":holder.value="手机号码"; return RegMacher.isMobile(str);//手机号码(必填) 
			
			case "Money":holder.value="金额"; return RegMacher.isDOUBLE_NEGATIVE(str);//金额(必填) 
			
			case "Email":holder.value="邮件格式"; return RegMacher.isEmail(str);//邮件格式(必填) 
			
			case "UnitCode":holder.value="纯统一社会信用代码"; return RegMacher.isJigouCode(str);//纯统一社会信用代码(必填) 
			
			case "Number":holder.value="数值"; return RegMacher.isNumber(str);//测试成功
			
			case "NumberPlus":holder.value="正数"; return RegMacher.isNumberPlus(str);//测试成功
			
			case "NumberMinus":holder.value="负数"; return RegMacher.isNumberMinus(str);//测试成功
			
			case "Integer":holder.value="整数"; return RegMacher.isInteger(str);//测试成功
			
			case "IntegerPlus":holder.value="正整数"; return RegMacher.isIntegerPlus(str);//测试成功
			
			case "IntegerMinus":holder.value="负整数"; return RegMacher.isIntegerMinus(str);//测试成功
			
			default:return false;
		}
	}
}
