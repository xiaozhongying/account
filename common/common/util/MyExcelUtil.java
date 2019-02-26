package common.util;

import java.text.DecimalFormat;
import org.apache.poi.ss.usermodel.Cell;

public class MyExcelUtil
{
	private static DecimalFormat df = new DecimalFormat("0.000");

	@SuppressWarnings("deprecation")
	public static String getCellValue(Cell cell)
	{
		String s = "";
		if(cell != null)
		{
			switch(cell.getCellType())
			{
				case Cell.CELL_TYPE_NUMERIC:// 0数值型
					s = df.format(cell.getNumericCellValue()).trim();
					break;
				case Cell.CELL_TYPE_STRING:// 1字符串型
					s = cell.toString().trim();
					break;
				case Cell.CELL_TYPE_FORMULA:// 2公式型
				case Cell.CELL_TYPE_BLANK:// 3空值
				case Cell.CELL_TYPE_BOOLEAN:// 4布尔型
				case Cell.CELL_TYPE_ERROR:// 5错误
				default:
					break;
			}
		}
		return s;
	}
	public static void main(String[] args)
	{
		//float a =26011201f;
		String a="26011201";
		
		System.out.println(Float.parseFloat(a));
		
	}
}
