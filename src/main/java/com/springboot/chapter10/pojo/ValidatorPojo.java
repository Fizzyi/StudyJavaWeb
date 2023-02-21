package com.springboot.chapter10.pojo;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class ValidatorPojo {

    @NotNull(message = "ID不能为空")
    private Long id;

    @Future(message = "需要一个将来的日期") //只能是将来的日期
    //@Past 只能是过去的日期
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 日期格式化转换
    @NotNull
    private Date date;

    @NotNull
    @DecimalMin(value = "0.1") //最小值为 0.1
    @DecimalMax(value = "10000") //最大值为10000
    private Double doubleValue = null;

    @Min(value = 1,message = "最小值为1")
    @Max(value = 88,message = "最大值为88")
    @NotNull
    private Integer integer;

    @Range(min = 1,max = 888,message = "范围从1至888")
    private Long range;

    @Email(message = "邮箱格式验证")
    private String email;

    @Size(min = 20,max = 30,message = "字符串长度要求20-30")
    private String size;

    public Integer getInteger(){
        return integer;
    }
    public Long getId(){
        return id;
    }
    public Date getDate(){
        return date;
    }

    public Double getDoubleValue(){
        return doubleValue;
    }
}
