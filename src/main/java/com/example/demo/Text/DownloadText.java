package com.example.demo.Text;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author 王慧
 * @description poi导出excel
 * @date 2020/1/8
 */
@RestController
public class DownloadText {

    /**
     * Text模板下载
     *
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/textExport")
    public ResponseEntity<Resource> excel2007Export(HttpServletResponse response, HttpServletRequest request) {
        try {
            ClassPathResource cpr = new ClassPathResource("/templates/test.txt");
            downLoadExcel("test.txt", response, cpr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Resource>(HttpStatus.OK);
    }

    public static void downLoadExcel(String fileName, HttpServletResponse response, ClassPathResource cpr) throws IOException {
        InputStream input = null;
        BufferedOutputStream output = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition",
                    "attachment;filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"");
            input = cpr.getInputStream();
            output = new BufferedOutputStream(response.getOutputStream());;
            String TxtBuff=null;
            String out="";
            InputStreamReader inputStreamReader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while ((TxtBuff = bufferedReader.readLine()) !=null) {
                TxtBuff = TxtBuff.replace("w", "====");
                out+= TxtBuff + "\r\n";
            }
            output.write(out.getBytes("UTF-8"));
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (input != null)
                input.close();
            if (output != null)
                output.close();
        }
    }

}
