package com.example.demo.calendar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@ApiModel(description = "日历表数据实体")
public class CalendarInfo implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    /**
     * 当前日期
     */
//    @ApiModelProperty(value = "当前日期")
    private Date dateInfo;
    /**
     * 第几周
     */
//    @ApiModelProperty(value = "第几周")
//    private String weekOfYear;
    /**
     * 周几
     */
//    @ApiModelProperty(value = "周几")
    private String dayOfWeek;
    /**
     * 0 上班  1周末 2节假日
     */
//    @ApiModelProperty(value = "0 上班  1周末 2节假日 ")
    private String dateFlag;
    /**
     * 日期备注
     */
//    @ApiModelProperty(value = "日期备注")
    private String dateRemark;
}

