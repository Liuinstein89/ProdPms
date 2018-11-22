package com.ccb.ProdPms.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ExcelUtil {

	private XSSFSheet ExcelWSheet;
	private XSSFWorkbook ExcelWBook;
	private XSSFCell Cell;
	private XSSFRow row;
	private String filePath;

	// 设定要操作的Excel的文件路径和Excel文件中的sheet名称
	// 在读写excel的时候，均需要先调用此方法，设定要操作的excel文件路径和要操作的sheet名称
	// 构造函数初始化
	public ExcelUtil(String Path, String SheetName) throws Exception {
		FileInputStream ExcelFile;

		try {
			// 实例化excel 文件的FileInputStream 对象
			ExcelFile = new FileInputStream(Path);
			// 实例化excel 文件的XSSFWorkbook 对象
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			// 实例化ExcelWSheet 对象，指定excel 文件中的sheet 名称，后续用于sheet 中行、列和单元格的操作
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			throw (e);
		}
		filePath = Path;
	}

	// 读取指定单元格的数据。需要传入行数、列数
	public String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = "";
			if (Cell.getCellTypeEnum() == CellType.STRING) {
				CellData = Cell.getStringCellValue();
			} else if (Cell.getCellTypeEnum() == CellType.NUMERIC) {
				// 取所有整数和两位小数
				DecimalFormat df = new DecimalFormat("#.00");
				CellData = df.format(Cell.getNumericCellValue());
			}
			return CellData;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	// 读取指定单元格的数据且值为字符串。需要传入行数、列数
	public String getCellStrData_value(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			if (Cell != null) {
				String CellData = Cell.getStringCellValue();
				return CellData;
			} else {
				return "";
			}
		} catch (Exception e) {
			return "";
		}
	}

	// 读取指定单元格的数据且值为数字。需要传入行数、列数
	public String getCellNumData_value(int RowNum, int ColNum) throws Exception {
		String cellValue = "";
		// DecimalFormat df = new DecimalFormat("#");//只读整数部分
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			if (Cell != null) {
				if (Cell.getCellTypeEnum() == CellType.STRING) {
					cellValue = Cell.getStringCellValue();
				} else {
					cellValue = String.valueOf(Cell.getNumericCellValue());
					if (cellValue.endsWith(".0")) {
						cellValue = cellValue.substring(0, cellValue.length() - 2);
					}
				}
			}
			return cellValue;
		} catch (Exception e) {
			return "";
		}
	}

	// 在excel 文件的执行单元格中写入数据，此函数只支持后缀为xlsx的excel 文件写入
	public void setCellData(int RowNum, int ColNum, String Result) throws Exception {
		try {
			// 获取excel文件中的行对象
			row = ExcelWSheet.getRow(RowNum);
			// 如果单元格为空，则返回Null
			Cell = row.getCell(ColNum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

			if (Cell == null) {
				// 当单元格对象是null 的时候，则创建单元格
				// 如果单元格为空，无法直接调用单元格对象的setCellValue 方法设定单元格的值
				Cell = row.createCell(ColNum);
				// 创建单元格后可以调用单元格对象的setCellValue 方法设定单元格的值
				Cell.setCellValue(Result);
			} else {
				// 单元格中有内容，则可以直接调用单元格对象的s方法设定单元格的值etCellValue
				Cell.setCellValue(Result);
				System.out.println("执行完成");
			}
			// 实例化写入 excel 文件的文件输出流对象
			FileOutputStream fileOut = new FileOutputStream(filePath);
			// 将内容写入excel 文件中
			ExcelWBook.write(fileOut);
			// 调用flush方法强制刷新写入文件
			fileOut.flush();
			// 关闭文件输出流对象
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}

	// 从excel 文件获取测试数据的静态方法
	public static Object[][] getTestData(String execlFilePath, String sheetName) throws IOException {
		// 根据参数传入的数据文件路径和文件名称，组合出excel 数据文件的绝对路径
		// 声明一个file 文件对象
		File file = new File(execlFilePath);
		// 创建FileInputStream 对象用于读取excel 文件
		FileInputStream inputStream = new FileInputStream(file);
		// 声明Workbook 对象
		Workbook Workbook = null;
		// 获取文件名参数的后缀名，判断xlsx文件还是xls文件
		String fileExtensionName = execlFilePath.substring(execlFilePath.indexOf("."));
		// 判断文件类型如果是xlsx，则使用XSSFWorkbook 对象进行实例化
		// 判断文件类型如果是xls，则使用HSSFWorkbook 对象进行实例化
		if (fileExtensionName.equals(".xlsx")) {
			// 如果是2007的，也就是.xlsx， 让Workbook = new XSSFWorkbook(inputStream);
			Workbook = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			// 如果是2003的，也就是.xls， 让Workbook = new HSSFWorkbook(inputStream);
			Workbook = new HSSFWorkbook(inputStream);
		}
		// 通过sheetName参数，生成sheet 对象
		Sheet Sheet = Workbook.getSheet(sheetName);
		// 获取excel 数据文件中sheet1中数据的行数，getLastRowNum 方法获取数据的最后行号
		// getFirstRowNum 方法获取数据的第一行行号，相减之后算出数据的行数
		// 注意：excel 文件的行号和列号都是从0开始
		int rowCount = Sheet.getLastRowNum() - Sheet.getFirstRowNum();
		// 创建名为records 的list 对象来存储从excel数据文件读取的数据
		List<Object[]> records = new ArrayList<Object[]>();
		// 使用2个for 循环遍历excel 数据文件的所有数据（除了第一行，第一行是数据列名称）
		// 所以i 从1开始，而不是从0
		for (int i = 1; i < rowCount + 1; i++) {
			// 使用getRow 方法获取行对象
			Row row = Sheet.getRow(i);
			String fields[] = new String[row.getLastCellNum() - 1];
			if (row.getCell(row.getLastCellNum() - 1).getStringCellValue().equals("y")) {
				for (int j = 0; j < row.getLastCellNum() - 1; j++) {
					// 判断excel 的单元格字段是数字还是字符，字符串格式调用getStringCellValue 方法获取
					// 数字格式调用getNumericCellValue 方法获取
					// fields[j-1]=(String) row.getCell(j).getCellType()==;
					try {
						if (row.getCell(j).getCellTypeEnum() == CellType.STRING) {
							fields[j] = row.getCell(j).getStringCellValue();
						} else if (row.getCell(j).getCellTypeEnum() == CellType.NUMERIC) {
							DecimalFormat df = new DecimalFormat("0");
							fields[j] = df.format(row.getCell(j).getNumericCellValue());
						} else {
							System.out.println("格式错误");
						}
					} catch (Exception e) {
						fields[j] = "";
					}
				}
				// fields 的数据对象存储到records的list中
				records.add(fields);
			}
		}
		// 定义函数返回值，即Object[][]
		// 将存储测试数据的list 转换为一个Object 的二维数组
		Object[][] results = new Object[records.size()][];
		// 设置二维数组每行的值，每行是个object对象
		for (int i = 0; i < records.size(); i++) {
			results[i] = records.get(i);
		}
		// 关闭excel 文件
		return results;
	}

	public int getLastCellNum() {
		// 返回数据文件的最后一列的列号，如果有12列，则结果返回11
		return ExcelWSheet.getRow(0).getLastCellNum() - 1;
	}

	/**
	 * 方法名：importExcel 创建时间：2018/11/19
	 */
	public static List<Object[]> importExcel(String fileName, MultipartFile file) {
		/*
		 * 导入Excel常用的方法： POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("d:/test.xls")); 
		 * 如果controller传的是MultipartFile格式，这里的处理方式为：new POIFSFileSystem(file.getInputStream())
		 * HSSFWorkbook wb=new HSSFWorkbook(fs);//得到Excel工作簿对象 HSSFSheet
		 * sheet=wb.getSheetAt(0);//得到Excel工作表对象 HSSFRow
		 * row=sheet.getRow(i);//得到Excel工作表的行 HSSFCell
		 * cell=row.getCell((short)j);//得到Excel工作表指定行的单元格 
		 * cellStyle=cell.getCellStyle();//得到单元格样式
		 */
		log.info("导入解析开始，fileName:{}", fileName);
		List<Object[]> list = new ArrayList<>();
		try {
			InputStream inputStream = file.getInputStream();
			// Excel解析:将上传到的MultipartFile转为输入流，然后交给POI去解析即可
			// 创建HSSFWorkbook对象
			// Workbook workbook = WorkbookFactory.create(inputStream);
			Workbook wb = null;
			if (ExcelUtil.isExcel2003(fileName)) {
				wb = new HSSFWorkbook(inputStream);
			}
			if (ExcelUtil.isExcel2007(fileName)) {
				wb = new XSSFWorkbook(inputStream);
			}
			// 获取一共有多少sheet，然后遍历
			/*
			 * int numberOfSheets = workbook.getNumberOfSheets(); for (int i = 0; i <
			 * numberOfSheets; i++) { HSSFSheet sheet = workbook.getSheetAt(i);
			 */
			Sheet sheet = wb.getSheetAt(0);
			
			// 获取sheet中一共有多少行，遍历行（注意第一行是标题）
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
			for (int i = 0; i < physicalNumberOfRows; i++) {
				// 过滤表头行
				if (i == 0)
					continue;// 标题行
				// 获取当前行的数据
				// HSSFRow row = sheet.getRow(j);
				Row row = sheet.getRow(i);
				// 获取每一行有多少单元格，遍历单元格
				int physicalNumberOfCells = row.getPhysicalNumberOfCells();
				Object[] objects = new Object[physicalNumberOfCells];
				int index = 0;
				for (Cell cell : row) {
					if (cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
						objects[index] = String.valueOf(cell.getNumericCellValue());
					}
					if (cell.getCellTypeEnum().equals(CellType.STRING)) {
						objects[index] = cell.getStringCellValue();
					}
					if (cell.getCellTypeEnum().equals(CellType.BOOLEAN)) {
						objects[index] = cell.getBooleanCellValue();
					}
					if (cell.getCellTypeEnum().equals(CellType.ERROR)) {
						objects[index] = cell.getErrorCellValue();
					}
					index++;
				}
				list.add(objects);
			}
			log.info("导入文件解析成功！");
			//return list;
		} catch (Exception e) {
			log.info("导入文件解析失败！");
			e.printStackTrace();
		}
		return list;
	}

	public static boolean isExcel2003(String filePath) {
		return filePath.matches("^.+\\.(?i)(xls)$");
	}

	public static boolean isExcel2007(String filePath) {
		return filePath.matches("^.+\\.(?i)(xlsx)$");
	}
    /**
     * 方法名：exportExcel
     * 功能：导出Excel
     * 描述：
     * 创建人：typ
     * 创建时间：2018/10/19 16:00
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    /*public static void exportExcel(HttpServletResponse response, ExcelData data) {
        log.info("导出解析开始，fileName:{}",data.getFileName());
        try {
            //实例化HSSFWorkbook
            HSSFWorkbook workbook = new HSSFWorkbook();
            //创建一个Excel表单，参数为sheet的名字
            HSSFSheet sheet = workbook.createSheet("sheet");
            //设置表头
            setTitle(workbook, sheet, data.getHead());
            //设置单元格并赋值
            setData(sheet, data.getData());
            //设置浏览器下载
            setBrowser(response, workbook, data.getFileName());
            log.info("导出解析成功!");
        } catch (Exception e) {
            log.info("导出解析失败!");
            e.printStackTrace();
        }
    }*/
 
    /**
     * 方法名：setTitle
     * 功能：设置表头
     * 描述：
     * 创建人：typ
     * 创建时间：2018/10/19 10:20
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @SuppressWarnings("unused")
	private static void setTitle(HSSFWorkbook workbook, HSSFSheet sheet, String[] str) {
        try {
            HSSFRow row = sheet.createRow(0);
            //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
            for (int i = 0; i <= str.length; i++) {
                sheet.setColumnWidth(i, 15 * 256);
            }
            //设置为居中加粗,格式化时间格式
            HSSFCellStyle style = workbook.createCellStyle();
            HSSFFont font = workbook.createFont();
            font.setBold(true);
            style.setFont(font);
            style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
            //创建表头名称
            HSSFCell cell;
            for (int j = 0; j < str.length; j++) {
                cell = row.createCell(j);
                cell.setCellValue(str[j]);
                cell.setCellStyle(style);
            }
        } catch (Exception e) {
            log.info("导出时设置表头失败！");
            e.printStackTrace();
        }
    }
 
    /**
     * 方法名：setData
     * 功能：表格赋值
     * 描述：
     * 创建人：typ
     * 创建时间：2018/10/19 16:11
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
 /*   private static void setData(HSSFSheet sheet, List<String[]> data) {
        try{
            int rowNum = 1;
            for (int i = 0; i < data.size(); i++) {
                HSSFRow row = sheet.createRow(rowNum);
                for (int j = 0; j < data.get(i).length; j++) {
                    row.createCell(j).setCellValue(data.get(i)[j]);
                }
                rowNum++;
            }
            log.info("表格赋值成功！");
        }catch (Exception e){
            log.info("表格赋值失败！");
            e.printStackTrace();
        }
    }*/
 
    /**
     * 方法名：setBrowser
     * 功能：使用浏览器下载
     * 描述：
     * 创建人：typ
     * 创建时间：2018/10/19 16:20
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
  /*  private static void setBrowser(HttpServletResponse response, HSSFWorkbook workbook, String fileName) {
        try {
            //清空response
            response.reset();
            //设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            OutputStream os = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/vnd.ms-excel;charset=gb2312");
            //将excel写入到输出流中
            workbook.write(os);
            os.flush();
            os.close();
            log.info("设置浏览器下载成功！");
        } catch (Exception e) {
            log.info("设置浏览器下载失败！");
            e.printStackTrace();
        }
 
    }
 */
}
