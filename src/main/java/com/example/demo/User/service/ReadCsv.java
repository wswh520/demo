package com.example.demo.User.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//import com.thinkive.common.function.gastatisics.bean.Bean;

public class ReadCsv {

    public static void readCsvAndInstallDB(String path, int ignoreRows) throws Exception {
//        File file = new File(path);
//        BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), Constants.CHAR_CODING_GBK));
//        String line = "";
//        List<Bean> beanList = new ArrayList<Bean>();
//        int count = 0;
//        // 忽略前几行标题
//        if(ignoreRows > 0) {
//            for (int i = 0; i < ignoreRows; i++) {
//                line = bReader.readLine();
//            }
//        }
//        try {
//            while((line = bReader.readLine()) != null) {
//                //          System.out.println(++count+"  "+line);
//                if(line.trim() != "") {
//                    String[] pills = line.split(",");
//                    Bean bean = new Bean(pills[0].trim(), pills[1].trim(), pills[2].trim(), pills[3].trim(), Constants.CHANNEL_TYPE_GUI_TAI);
//                    beanList.add(bean);
//                    if(++count%Constants.BATCH_NUM == 0) {
//                        // 数据库操作， 见“jdbc批量插入一文”
//                        DBHelp.executeUpate(DBHelp.SQL_INSTALL_IDNO_THIRD, beanList, Constants.DATE_FORMATE_DEFAULT);
//                        beanList.clear();
//                    }
//                }
//            }
//            // 操作集合中最后一批数据  <span style="font-family:Arial, Helvetica, sans-serif;">数据库操作， 见“jdbc批量插入一文”</span>
//            DBHelp.executeUpate(DBHelp.SQL_INSTALL_IDNO_THIRD, beanList, Constants.DATE_FORMATE_DEFAULT);
//            beanList.clear();
//            DBHelp.closeSources(DBHelp.getConn(), DBHelp.getPs());
//            beanList = null;
//        }finally {
//            if(bReader != null) {
//                bReader.close();
//            }
//        }
    }
}
