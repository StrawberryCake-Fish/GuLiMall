package org.fish.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品评价
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@TableName("pms_spu_comment")
public class SpuCommentEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * sku_id
     */
    @TableField("sku_id")
    private Long skuId;

    /**
     * spu_id
     */
    @TableField("spu_id")
    private Long spuId;

    /**
     * 商品名字
     */
    @TableField("spu_name")
    private String spuName;

    /**
     * 会员昵称
     */
    @TableField("member_nick_name")
    private String memberNickName;

    /**
     * 星级
     */
    @TableField("star")
    private Boolean star;

    /**
     * 会员ip
     */
    @TableField("member_ip")
    private String memberIp;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 显示状态[0-不显示，1-显示]
     */
    @TableField("show_status")
    private Boolean showStatus;

    /**
     * 购买时属性组合
     */
    @TableField("spu_attributes")
    private String spuAttributes;

    /**
     * 点赞数
     */
    @TableField("likes_count")
    private Integer likesCount;

    /**
     * 回复数
     */
    @TableField("reply_count")
    private Integer replyCount;

    /**
     * 评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]
     */
    @TableField("resources")
    private String resources;

    /**
     * 内容
     */
    @TableField("content")
    private String content;

    /**
     * 用户头像
     */
    @TableField("member_icon")
    private String memberIcon;

    /**
     * 评论类型[0 - 对商品的直接评论，1 - 对评论的回复]
     */
    @TableField("comment_type")
    private Byte commentType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public String getMemberNickName() {
        return memberNickName;
    }

    public void setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName;
    }

    public Boolean getStar() {
        return star;
    }

    public void setStar(Boolean star) {
        this.star = star;
    }

    public String getMemberIp() {
        return memberIp;
    }

    public void setMemberIp(String memberIp) {
        this.memberIp = memberIp;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Boolean getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Boolean showStatus) {
        this.showStatus = showStatus;
    }

    public String getSpuAttributes() {
        return spuAttributes;
    }

    public void setSpuAttributes(String spuAttributes) {
        this.spuAttributes = spuAttributes;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMemberIcon() {
        return memberIcon;
    }

    public void setMemberIcon(String memberIcon) {
        this.memberIcon = memberIcon;
    }

    public Byte getCommentType() {
        return commentType;
    }

    public void setCommentType(Byte commentType) {
        this.commentType = commentType;
    }

    @Override
    public String toString() {
        return "SpuCommentEntity{" +
            "id = " + id +
            ", skuId = " + skuId +
            ", spuId = " + spuId +
            ", spuName = " + spuName +
            ", memberNickName = " + memberNickName +
            ", star = " + star +
            ", memberIp = " + memberIp +
            ", createTime = " + createTime +
            ", showStatus = " + showStatus +
            ", spuAttributes = " + spuAttributes +
            ", likesCount = " + likesCount +
            ", replyCount = " + replyCount +
            ", resources = " + resources +
            ", content = " + content +
            ", memberIcon = " + memberIcon +
            ", commentType = " + commentType +
        "}";
    }
}
