package common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlToken;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;

public class WriteDocUtil
{
	public static XWPFDocument writeWordFile(String templatepath, Map<String, Object> map)
	{
		try
		{
			String pojectPath = templatepath.split("tempdoc")[0];
			// System.err.println(pojectPath);
			InputStream is = new FileInputStream(templatepath);
			// 替换段落里面的变量
			XWPFDocument docx = new XWPFDocument(is);
			replaceInPara(docx, map);
			// 替换表格里面的变量
			replaceInTable(docx, map, pojectPath);
			if(is != null)
			{
				is.close();
			}
			return docx;
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 替换段落里面的变量
	 * @param doc 要替换的文档
	 * @param params 参数
	 */
	private static void replaceInPara(XWPFDocument docx, Map<String, Object> params)
	{
		Iterator<XWPFParagraph> iterator = docx.getParagraphsIterator();
		XWPFParagraph para;
		while(iterator.hasNext())
		{
			para = iterator.next();
			replaceInPara(para, params, null, null);
		}
	}

	/**
	 * 替换表格里面的变量
	 * @param doc 要替换的文档
	 * @param params 参数
	 */
	private static void replaceInTable(XWPFDocument doc, Map<String, Object> params, String pojectPath)
	{
		Iterator<XWPFTable> iterator = doc.getTablesIterator();
		XWPFTable table;
		List<XWPFTableRow> rows;
		List<XWPFTableCell> cells;
		List<XWPFParagraph> paras;
		while(iterator.hasNext())
		{
			table = iterator.next();
			rows = table.getRows();
			for(XWPFTableRow row : rows)
			{
				cells = row.getTableCells();
				for(XWPFTableCell cell : cells)
				{
					paras = cell.getParagraphs();
					for(XWPFParagraph para : paras)
					{
						replaceInPara(para, params, doc, pojectPath);
					}
				}
			}
		}
	}

	/**
	 * 替换段落里面的变量
	 * @param para 要替换的段落
	 * @param params 参数
	 */
	private static void replaceInPara(XWPFParagraph para, Map<String, Object> params, XWPFDocument docx, String pojectPath)
	{
		List<XWPFRun> runs;
		Matcher matcher;
		boolean falg = matcher(para.getParagraphText()).find();
		if(falg)
		{
			//该参数涉及到你的模板编写的时候保存顺序来切割的 如${name}在前面加入english的时候会切分成english,name两个，必须删掉name然后直接输入englishname才不会被切割
			runs = para.getRuns();
			String str = "";
			for(int i = 0; i < runs.size(); i++)
			{
				str = str + runs.get(i);
				String fontFamily = runs.get(i).getFontFamily();
				int fontSize = runs.get(i).getFontSize();
				if(fontSize < 0)
				{
					fontSize = 16;
				}
				if(fontFamily == null && fontSize == 22)
				{
					fontFamily = "宋体";
				}
				if(str.lastIndexOf("$") != 0)
				{
					para.removeRun(i);
					//para.insertNewRun(i).setText(str);
					XWPFRun newRun = para.insertNewRun(i);
					newRun.setFontFamily(fontFamily);
					newRun.setFontSize(fontSize);
					newRun.setText(str);
					str = "";
					continue;
				}
				String runText = str.toString();
				matcher = matcher(runText);
				if(matcher.find())
				{
					System.err.println(runText);
					while((matcher = matcher(runText)).find())
					{
						if(runText.equals("${photo}"))
						{
							try
							{
								File pic = new File(pojectPath + "\\temp\\" + params.get("photo").toString());
								// if(!pic.exists()){
								// pic = new File(pojectPath+"\\temp\\"+params.get("photo").toString());
								// }
								FileInputStream is = new FileInputStream(pic);
								String ind = docx.addPictureData(is, Document.PICTURE_TYPE_BMP);
								createPicture(ind, docx.getNextPicNameNumber(Document.PICTURE_TYPE_BMP), 106, 145, para);
								runText = "";
								break;
							}
							catch(Exception e)
							{
								e.printStackTrace();
								System.out.println("网络出现了问题.");
								break;
							}
						}
						else
						{
							runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
							str = "";
						}
					}
					para.removeRun(i);
//					para.insertNewRun(i).setText(runText);
					XWPFRun newRun = para.insertNewRun(i);
					newRun.setFontFamily(fontFamily);
					newRun.setFontSize(fontSize);
					newRun.setText(runText);
					//break;
				}
				else
				{
					para.removeRun(i);
					para.insertNewRun(i).setText("");
				}
			}
		}
	}

	/**
	 * 正则匹配字符串
	 * @param str
	 * @return
	 */
	private static Matcher matcher(String str)
	{
		Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		return matcher;
	}

	/**
	 * 创建一张新的图片
	 * @param id
	 * @param width 宽
	 * @param height 高
	 * @param paragraph 段落
	 */
	public static void createPicture(String blipId, int id, int width, int height, XWPFParagraph paragraph)
	{
		final int EMU = 9525;
		width *= EMU;
		height *= EMU;
		// String blipId = getAllPictures().get(id).getPackageRelationship()
		// .getId();
		CTInline inline = paragraph.createRun().getCTR().addNewDrawing().addNewInline();
		// CTInline inline=createParagraph().createRun().getCTR().addNewDrawing().addNewInline();
		String picXml = "" +
                "<a:graphic xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\">" +
                "   <a:graphicData uri=\"http://schemas.openxmlformats.org/drawingml/2006/picture\">" +
                "      <pic:pic xmlns:pic=\"http://schemas.openxmlformats.org/drawingml/2006/picture\">" +
                "         <pic:nvPicPr>" +
                "            <pic:cNvPr id=\"" + id + "\" name=\"Generated\"/>" +
                "            <pic:cNvPicPr/>" +
                "         </pic:nvPicPr>" +
                "         <pic:blipFill>" +
                "            <a:blip r:embed=\"" + blipId + "\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\"/>" +
                "            <a:stretch>" +
                "               <a:fillRect/>" +
                "            </a:stretch>" +
                "         </pic:blipFill>" +
                "         <pic:spPr>" +
                "            <a:xfrm>" +
                "               <a:off x=\"0\" y=\"0\"/>" +
                "               <a:ext cx=\"" + width + "\" cy=\"" + height + "\"/>" +
                "            </a:xfrm>" +
                "            <a:prstGeom prst=\"rect\">" +
                "               <a:avLst/>" +
                "            </a:prstGeom>" +
                "         </pic:spPr>" +
                "      </pic:pic>" +
                "   </a:graphicData>" +
                "</a:graphic>";
		// CTGraphicalObjectData graphicData =
		inline.addNewGraphic().addNewGraphicData();
		XmlToken xmlToken = null;
		try
		{
			xmlToken = XmlToken.Factory.parse(picXml);
		}
		catch(XmlException xe)
		{
			xe.printStackTrace();
		}
		inline.set(xmlToken);
		// graphicData.set(xmlToken);
		inline.setDistT(0);
		inline.setDistB(0);
		inline.setDistL(0);
		inline.setDistR(0);
		CTPositiveSize2D extent = inline.addNewExtent();
		extent.setCx(width);
		extent.setCy(height);
		CTNonVisualDrawingProps docPr = inline.addNewDocPr();
		docPr.setId(id);
		docPr.setName("图片" + id);
		docPr.setDescr("导游照片");
	}
}
