package com.zyc.base.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @author ZengYc
 */
@ApiModel(description = "Text", value = "Text")
@Table(name = "tb_text")
@Data
public class Text {

    @ApiModelProperty(value = "id", required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "测试名称", required = false)
    @Column(name = "text_name")
    private String textName;

    @ApiModelProperty(value = "测试年纪", required = false)
    @Column(name = "text_age")
    private String textAge;

    @ApiModelProperty(value = "测试性别", required = false)
    @Column(name = "text_sex")
    private String textSex;

}
