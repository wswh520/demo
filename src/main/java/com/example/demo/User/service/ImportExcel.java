package com.example.demo.User.service;

import com.microsoft.schemas.office.visio.x2012.main.RowType;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ImportExcel {

    public static boolean isXls(String fileName){
        // (?i)忽略大小写
        if(fileName.matches("^.+\\.(?i)(xls)$")){
             return true;
         }else if(fileName.matches("^.+\\.(?i)(xlsx)$")){
             return false;
         }else{
             throw new RuntimeException("格式不对");
         }
     }

     public static List<Map<String, Object>> readExcel(String fileName, InputStream inputStream) throws Exception{
         boolean ret = isXls(fileName);
         Workbook workbook = null;
         // 根据后缀创建不同的对象
         if(ret){
             workbook = new HSSFWorkbook(inputStream);
         }else{
             workbook = new XSSFWorkbook(inputStream);
         }


         Sheet sheet = workbook.getSheetAt(0);

         // 得到标题行
         Row titleRow = sheet.getRow(0);
         int lastRowNum = sheet.getLastRowNum();
         int lastCellNum = titleRow.getLastCellNum();
         List<Map<String, Object>> list = new ArrayList<>();

         for(int i = 1; i <= lastRowNum; i++ ){
             Map<String, Object> map = new HashMap<>();
             Row row = sheet.getRow(i);
             CellStyle cellStyle = workbook.createCellStyle();
             cellStyle.setWrapText(true);
             row.setRowStyle(cellStyle);
             for(int j = 0; j < lastCellNum; j++){
                 // 得到列名
                 String key = titleRow.getCell(j).getStringCellValue();
                 Cell cell = row.getCell(j);
                 if(cell != null){
                     cell.setCellType(CellType.STRING);
                     map.put(key, cell.getStringCellValue());
                 }
             }
             if(checkMap(map)){
                 list.add(map);
             }
         }
         workbook.close();
         return list;
     }

     public static boolean checkMap(Map<String, Object> map){
         boolean flag = true;
         Set set = map.keySet();
         int num = 0;
         for (Iterator iterator = set.iterator(); iterator.hasNext();) {
             Object obj = (Object) iterator.next();
             if(StringUtils.isEmpty(map.get(obj)+"")){
                 num = num + 1;
             }
         }
         if(num == map.size()){
             flag = false;
         }
         return flag;
     }

}
