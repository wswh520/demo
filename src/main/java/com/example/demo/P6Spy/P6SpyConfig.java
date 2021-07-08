//package com.example.demo.P6Spy;
//
//import com.p6spy.engine.spy.P6DataSource;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.core.PriorityOrdered;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class P6SpyConfig {
//
//    /**
//     * P6数据源包装, 打印SQL语句
//     */
//    @Bean
//    public P6DataSourceBeanPostProcessor p6DataSourceBeanPostProcessor() {
//        return new P6DataSourceBeanPostProcessor();
//    }
//
//    class P6DataSourceBeanPostProcessor implements BeanPostProcessor, PriorityOrdered {
//        @Override
//        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//            return bean;
//        }
//
//        @Override
//        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//            if (bean instanceof DataSource) {
//                return new P6DataSource((DataSource) bean);
//            }
//            return bean;
//        }
//
//        @Override
//        public int getOrder() {
//            return Ordered.LOWEST_PRECEDENCE;
//        }
//    }
//
//}
