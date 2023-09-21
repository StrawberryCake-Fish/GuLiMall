package org.fish.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 品牌分类关联
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@TableName("pms_category_brand_relation")
public class CategoryBrandRelationEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 品牌id
     */
    @TableField("brand_id")
    private Long brandId;

    /**
     * 分类id
     */
    @TableField("cate_log_id")
    private Long cateLogId;

    @TableField("brand_name")
    private String brandName;

    @TableField("cate_log_name")
    private String cateLogName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCateLogId() {
        return cateLogId;
    }

    public void setCateLogId(Long cateLogId) {
        this.cateLogId = cateLogId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCateLogName() {
        return cateLogName;
    }

    public void setCateLogName(String cateLogName) {
        this.cateLogName = cateLogName;
    }

    @Override
    public String toString() {
        return "CategoryBrandRelationEntity{" +
            "id = " + id +
            ", brandId = " + brandId +
            ", cateLogId = " + cateLogId +
            ", brandName = " + brandName +
            ", cateLogName = " + cateLogName +
        "}";
    }
}
