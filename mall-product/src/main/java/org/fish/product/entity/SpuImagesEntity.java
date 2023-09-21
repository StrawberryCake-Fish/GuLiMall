package org.fish.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * spu图片
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@TableName("pms_spu_images")
public class SpuImagesEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * spu_id
     */
    @TableField("spu_id")
    private Long spuId;

    /**
     * 图片名
     */
    @TableField("img_name")
    private String imgName;

    /**
     * 图片地址
     */
    @TableField("img_url")
    private String imgUrl;

    /**
     * 顺序
     */
    @TableField("img_sort")
    private Integer imgSort;

    /**
     * 是否默认图
     */
    @TableField("default_img")
    private Byte defaultImg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getImgSort() {
        return imgSort;
    }

    public void setImgSort(Integer imgSort) {
        this.imgSort = imgSort;
    }

    public Byte getDefaultImg() {
        return defaultImg;
    }

    public void setDefaultImg(Byte defaultImg) {
        this.defaultImg = defaultImg;
    }

    @Override
    public String toString() {
        return "SpuImagesEntity{" +
            "id = " + id +
            ", spuId = " + spuId +
            ", imgName = " + imgName +
            ", imgUrl = " + imgUrl +
            ", imgSort = " + imgSort +
            ", defaultImg = " + defaultImg +
        "}";
    }
}
