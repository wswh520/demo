package com.example.demo.controller;

import info.monitorenter.cpdetector.io.*;
import info.monitorenter.util.FileUtil;
import org.mozilla.universalchardet.UniversalDetector;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
//import org.springframework.cloud.context.config.annotation.RefreshScope;

@RequestMapping("/test")
@RestController
//@RefreshScope
public class DemoTestController {

    private Set<ICodepageDetector> detectors = new LinkedHashSet();

    @RequestMapping("test")
    public String test(MultipartFile file) throws IOException {
//        return getFileEncode(file);
//        return fingFileEncode(file);
        return null;
    }

    public String fingFileEncode(MultipartFile file){
        String fileName = file.getOriginalFilename();
        try{
            java.io.InputStream ios=file.getInputStream();
            byte[] b=new byte[3];
            ios.read(b);
            ios.close();
            if(b[0]==-17&&b[1]==-69&&b[2]==-65)
                return "UTF-8";
            else return "GBK";
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 利用第三方开源包cpdetector获取文件编码格式
     *
     //     * @param path
     *            要判断文件编码格式的源文件的路径
     * @author huanglei
     * @version 2012-7-12 14:05
     */
        public String getFileEncode(MultipartFile file) {
            /*------------------------------------------------------------------------
              detector是探测器，它把探测任务交给具体的探测实现类的实例完成。
              cpDetector内置了一些常用的探测实现类，这些探测实现类的实例可以通过add方法
              加进来，如ParsingDetector、 JChardetFacade、ASCIIDetector、UnicodeDetector。
              detector按照“谁最先返回非空的探测结果，就以该结果为准”的原则返回探测到的
              字符集编码。
            --------------------------------------------------------------------------*/
            CodepageDetectorProxy detector =
                    CodepageDetectorProxy.getInstance();
            /*-------------------------------------------------------------------------
              ParsingDetector可用于检查HTML、XML等文件或字符流的编码,构造方法中的参数用于
              指示是否显示探测过程的详细信息，为false不显示。
            ---------------------------------------------------------------------------*/
            detector.add(new ParsingDetector(false));
            /*--------------------------------------------------------------------------
              JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码
              测定。所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以
              再多加几个探测器，比如下面的ASCIIDetector、UnicodeDetector等。
             ---------------------------------------------------------------------------*/
            detector.add(JChardetFacade.getInstance());
            //ASCIIDetector用于ASCII编码测定
            detector.add(ASCIIDetector.getInstance());
            //UnicodeDetector用于Unicode家族编码的测定
            detector.add(UnicodeDetector.getInstance());
            java.nio.charset.Charset charset = null;
//            File f=new File("待测的文本文件名");
            try {
                InputStream inp = file.getInputStream();
                BufferedInputStream in = new BufferedInputStream(inp);
                charset = detector.detectCodepage(in,file.getBytes().length);
            } catch (Exception ex) {ex.printStackTrace();}
            if(charset!=null){
                return charset.name();
            }else
                return null;
//        /*
//         * detector是探测器，它把探测任务交给具体的探测实现类的实例完成。
//         * cpDetector内置了一些常用的探测实现类，这些探测实现类的实例可以通过add方法 加进来，如ParsingDetector、
//         * JChardetFacade、ASCIIDetector、UnicodeDetector。
//         * detector按照“谁最先返回非空的探测结果，就以该结果为准”的原则返回探测到的
//         * 字符集编码。使用需要用到三个第三方JAR包：antlr.jar、chardet.jar和cpdetector.jar
//         * cpDetector是基于统计学原理的，不保证完全正确。
//         */
//        CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
//        /*
//         * ParsingDetector可用于检查HTML、XML等文件或字符流的编码,构造方法中的参数用于
//         * 指示是否显示探测过程的详细信息，为false不显示。
//         */
//            detector.add(new cpdetector.io.ParsingDetector(false));
////        detector.add(new ParsingDetector(false));
//        /*
//         * JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码
//         * 测定。所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以
//         * 再多加几个探测器，比如下面的ASCIIDetector、UnicodeDetector等。
//         */
//        detector.add(JChardetFacade.getInstance());// 用到antlr.jar、chardet.jar
//        // ASCIIDetector用于ASCII编码测定
//        detector.add(ASCIIDetector.getInstance());
//        // UnicodeDetector用于Unicode家族编码的测定
//        detector.add(UnicodeDetector.getInstance());
//        java.nio.charset.Charset charset = null;
////        File f = new File(path);
//        try {
//           InputStream inp = file.getInputStream();
//            BufferedInputStream in = new BufferedInputStream(inp);
////            charset = detector.detectCodepage(f.toURI().toURL());
////            charset = detector.detectCodepage(in,2147483647);
//            charset = detector.detectCodepage(in,file.getBytes().length);
////            charset = codeTest(in,2147483647);
//            System.out.println(charset);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        if (charset != null)
//            return charset.name();
//        else
//            return null;
    }
}
