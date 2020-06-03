package com.example.demo.Excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 王慧
 * @description poi导出excel
 * @date 2020/1/8
 */
@RestController
public class DownloadExcel {

    /**
     * Excel模板下载
     *
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/excel2007Export")
    public ResponseEntity<Resource> excel2007Export(HttpServletResponse response, HttpServletRequest request) {
        try {
            ClassPathResource cpr = new ClassPathResource("/templates/student.xlsx");
            InputStream is = cpr.getInputStream();
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(0);
            int rowNum = 0;
            Cell cell;
            // 这里作为演示，造几个演示数据，模拟数据库里查数据
            List<String> list = new ArrayList<String>();
            list.add("1111");
            list.add("22");
            list.add("333");
            Row row = sheet.createRow(rowNum + 1);
            for (int i = 0; i < list.size(); i++) {
                cell = row.createCell(i);
                cell.setCellValue(list.get(i));
            }
            String fileName = "eeeee.xlsx";
            downLoadExcel(fileName, response, workbook);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Resource>(HttpStatus.OK);
    }

    public static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition",
                    "attachment;filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"");
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Excel下载无需模板
     *
     * @param response
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/exportExcel", method = {RequestMethod.GET, RequestMethod.POST})
    public void exportExcel(HttpServletResponse response) throws UnsupportedEncodingException {
        String fileName = "导出excel.xlsx";
        response.setContentType("application/excel");
        response.setHeader("Content-disposition",
                "attachment;filename=" + fileName + ";filename*=utf-8''" + URLEncoder.encode(fileName, "UTF-8"));
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        int rowNum = 0;
        Cell cell;
        Row row = sheet.createRow(rowNum);
        // 添加标题
        String[] headers = {"标题", "版块", "作者", "创建时间", "内容"};
        for (int i = 0; i < headers.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(headers[i]);
        }
        //添加行
        List<String> list = new ArrayList<String>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("4444");
        list.add("555");
        list.add("666");
        for (int i = 0; i < Math.ceil(list.size()/headers.length); i++) {
            Row row1 = sheet.createRow(rowNum + 1 + i);
            cell = row1.createCell(i);
            cell.setCellValue(list.get(i));
        }
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
