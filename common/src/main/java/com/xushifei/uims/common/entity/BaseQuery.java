package com.xushifei.uims.common.entity;

import com.xushifei.uims.common.enums.ApiCodeEnum;
import com.xushifei.uims.common.exception.BusinessException;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

/**
 * @author xushifei
 * @date 2021/5/24
 */
@Data
public class BaseQuery {
  /** 页码 */
  @NotNull(message = "page必填")
  @Min(value = 1L, message = "页码不能小于1")
  protected Integer page;
  /** 页大小 */
  @NotNull(message = "size必填")
  @Max(value = 500L, message = "页大小不能大于500")
  protected Integer size;
  /** 分页起始偏移量 */
  protected Integer offset;
  /** 类型 */
  protected List<Integer> types;
  /** 是否启用，1：启用，0：禁用 */
  protected List<Integer> status;
  /** 名称 */
  protected String name;
  /**
   * 需要分页
   *
   * @return
   */
  public Boolean needPage() {
    return Objects.nonNull(this.getPage()) && Objects.nonNull(this.getSize());
  }

  /**
   * 获取偏移量
   *
   * @return
   */
  public int calculateOffset() {
    if (!needPage()) {
      throw new BusinessException(ApiCodeEnum.PARAM_ERROR.getCode(), "不需要分页时，不用计算偏移量");
    }
    return (page - 1) * size;
  }
}
