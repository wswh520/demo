//package com.example.demo.xxljob;
//
//import com.xxl.job.core.biz.model.ReturnT;
//import com.xxl.job.core.handler.annotation.XxlJob;
//import com.xxl.job.core.log.XxlJobLogger;
//import com.xxl.job.executor.sample.frameless.jobhandler.SampleXxlJob;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//
///**
// * XxlJob开发示例
// */
//@Component
//@Slf4j
//public class SampleXxlJobPools {
//    private static Logger logger = LoggerFactory.getLogger(SampleXxlJob.class);
//
//    @XxlJob(value = "testJobHandler", init = "init", destroy = "destroy")
//    public ReturnT<String> demoJobHandler(String param) throws Exception {
//        XxlJobLogger.log("执行定时任务");
//        return ReturnT.SUCCESS;
//    }
//
//    public void init() {
//        logger.info("testJobHandler init");
//    }
//
//    public void destroy() {
//        logger.info("testJobHandler destory");
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
