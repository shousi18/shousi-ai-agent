package com.shousi.shousiaiagent.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName merchant2
 */
@TableName(value ="merchant2")
@Data
public class Merchant2 implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 商家id
     */
    private Long merchantId;

    /**
     * 商品id
     */
    private Long goodId;

    /**
     * 商品名字
     */
    private String goodName;

    /**
     * 城市
     */
    private String cityName;

    /**
     * 问题
     */
    private String problem;

    /**
     * 其他信息
     */
    private String goodInfo;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}