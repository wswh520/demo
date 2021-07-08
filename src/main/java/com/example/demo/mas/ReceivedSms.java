package com.example.demo.mas;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RestController
public class ReceivedSms {

    private static Logger logger = Logger.getLogger(ReceivedSms.class);

    /**
     * 此方法描述的是：接收上行短信（采用推送的方式进行）
     * @param response
     * @param request
     */
//    @RequestMapping(params="action=doReceivedSms",method= RequestMethod.POST)
    @RequestMapping("doReceivedSms")
    public String doReceivedSms(HttpServletResponse response, HttpServletRequest request){
        try{
            String remoteHost = request.getRemoteAddr();
            logger.info("客户端地址：" + remoteHost);
            // request.setCharacterEncoding("GB2312");
            //  response.setContentType("type=text/html;charset=UTF-8");
            // 获取请求的报文
            String requestXml = getRequestXml(request);
            logger.info("接收到上行短信原文："+requestXml);
//            if(!requestXml.equals("")&&requestXml!=null){
//                ReadXML readXML = new ReadXML();
//                ArrayList<HashMap<String, String>> list=readXML.getListData(requestXml,"MOList/MORow");
//                MessageReceive messageReceive=null;
//                List<MessageReceive> receiveList=new ArrayList<MessageReceive>();
//                for (Map<String, String> m : list){
//                    messageReceive=new MessageReceive();
//                    messageReceive.setTelephone(m.get("Phone"));
//                    messageReceive.setContent(m.get("MOInfo"));
//                    messageReceive.setReceiveTime(DateUtil.strToDate(m.get("MO_Time"), "yyyy/MM/dd HH:mm:ss"));
//                    receiveList.add(messageReceive);
//                }
//            }
            return "OK";
        }catch (Exception e) {
            logger.error("推送上行方法解析出现异常"+e);
            return "ERROR";
        }
    }


    /**
     * 此方法描述的是：获取请求的报文
     * @param request
     * @return
     * @throws IOException
     */
    private String getRequestXml(HttpServletRequest request) throws IOException {
        InputStream inputStream = request.getInputStream();
        StringBuffer requestXml = new StringBuffer();
        /* byte[] b = new byte[2048];
        int length = 0;
        while ((length = inputStream.read(b)) != -1) {
            requestXml.append(new String(b, 0, length));
        }*/
        InputStreamReader isr = new InputStreamReader(inputStream,"utf-8");
        BufferedReader br = new BufferedReader(isr);
        String s = "" ;
        while((s=br.readLine())!=null){
            requestXml.append(s) ;
        }
        return requestXml.toString();
    }

}
