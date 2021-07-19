package com.xushifei.uims.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.xushifei.uims.common.constant.SysConstants;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 公共实体类
 *
 * @author xushifei
 * @date 2021/5/8
 */
@Data
public class BaseEntity {
  /** id */
  @TableId(value = "id", type = IdType.AUTO)
  protected Long id;
  /** 是否被删除，1：被删除，0：未删除 */
  @TableLogic protected Boolean deleted;

  /** 状态，1：启用，2：禁用 */
  protected Integer status;
  /** 排序值，默认为1 */
  protected Integer sort;
  /** 创建时间 */
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  protected LocalDateTime createTime;

  /** 更新时间 */
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  protected LocalDateTime modifyTime;

  /** 创建人id */
  protected Long creatorId;

  /** 更新人id */
  protected Long modifierId;

  /** 新增时初始化信息 */
  protected void assignCreateInfo() {
    this.deleted = false;
    this.status = SysConstants.STATUS_ENABLE;
    this.createTime = LocalDateTime.now();
  }

  /** 更新时初始化信息 */
  protected void assignModifyInfo() {
    this.modifyTime = LocalDateTime.now();
  }

  /** 更新时初始化信息 */
  protected void assignDelInfo() {
    this.modifyTime = LocalDateTime.now();
    this.deleted = true;
  }
}
