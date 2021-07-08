package com.example.demo.calendar;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CalendarInfoMapper{


    /**
     *  根据ID查找对应的记录
     */
    CalendarInfo queryInfoById(String id);

    /**
     *  查询总条数
     */
    int selectCount();


    /**
     *  按照条件查询
     */
    List<CalendarInfo> selectByCondition(CalendarInfo entity);

    /**
     *  按照条件查询 一条数据
     */
    CalendarInfo  selectOneByCondition(CalendarInfo entity);

    /**
     *  按照条件查询记录对应的条数
     */
    int selectCountByCondition(CalendarInfo entity);

    /**
     *  按照id更新
     */
    int updateById(CalendarInfo entity);

    /**
     *  按照id删除
     */
    int deleteById(String id);

    /**
     *  新增
     */
    int insert(CalendarInfo entity);

    /**
     *  按照集合新增
     */
    int insertList(List<CalendarInfo> entityList);


    /**
     *  获取全部的数据
     */
    List<CalendarInfo>  getList();

    /**
     *  批量更新
     */
    int updateList(List<CalendarInfo> entityList);


}

