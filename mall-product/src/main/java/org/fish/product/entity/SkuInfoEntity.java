package org.fish.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * sku信息
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@Data
@TableName("pms_sku_info")
public class SkuInfoEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * skuId
     */
    @TableId(value = "sku_id", type = IdType.AUTO)
    private Long skuId;

    /**
     * spuId
     */
    @TableField("spu_id")
    private Long spuId;

    /**
     * sku名称
     */
    @TableField("sku_name")
    private String skuName;

    /**
     * sku介绍描述
     */
    @TableField("sku_desc")
    private String skuDesc;

    /**
     * 所属分类id
     */
    @TableField("catalog_id")
    private Long catalogId;

    /**
     * 品牌id
     */
    @TableField("brand_id")
    private Long brandId;

    /**
     * 默认图片
     */
    @TableField("sku_default_img")
    private String skuDefaultImg;

    /**
     * 标题
     */
    @TableField("sku_title")
    private String skuTitle;

    /**
     * 副标题
     */
    @TableField("sku_subtitle")
    private String skuSubtitle;

    /**
     * 价格
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 销量
     */
    @TableField("sale_count")
    private Long saleCount;
}
