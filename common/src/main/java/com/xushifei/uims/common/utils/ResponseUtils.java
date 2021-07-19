package com.xushifei.uims.common.utils;

import com.xushifei.uims.common.constant.SysConstants;
import com.xushifei.uims.common.entity.ApiResponse;
import com.xushifei.uims.common.enums.ApiCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author xushifei
 * @date 2020/9/21 9:53
 * @description 接口响应工具类
 */
@Slf4j
public class ResponseUtils {
  public static <T> ApiResponse<T> success() {
    ApiResponse<T> apiResponse = new ApiResponse<>();
    apiResponse.setCode(ApiCodeEnum.SUCCESS.getCode());
    apiResponse.setMsg(ApiCodeEnum.SUCCESS.getMsg());
    return apiResponse;
  }

  public static <T> ApiResponse<T> success(T object) {
    ApiResponse<T> apiResponse = new ApiResponse<>();
    apiResponse.setCode(ApiCodeEnum.SUCCESS.getCode());
    apiResponse.setMsg(ApiCodeEnum.SUCCESS.getMsg());
    apiResponse.setData(object);
    return apiResponse;
  }

  public static <T> ApiResponse<T> fail(ApiCodeEnum apiCodeEnum) {
    ApiResponse<T> apiResponse = new ApiResponse<>();
    apiResponse.setCode(apiCodeEnum.getCode());
    apiResponse.setMsg(apiCodeEnum.getMsg());
    return apiResponse;
  }

  public static <T> ApiResponse<T> fail(final String code, final String msg) {
    ApiResponse<T> apiResponse = new ApiResponse<>();
    apiResponse.setCode(code);
    apiResponse.setMsg(msg);
    return apiResponse;
  }

  public static void response(HttpServletResponse response, Object object, HttpStatus httpStatus) {
    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
    response.setStatus(httpStatus.value());
    try {
      response.getWriter().write(JsonUtils.objectToJson(ResponseUtils.success(object)));
    } catch (IOException e) {
      log.error("response方法获取HttpServletResponse失败:", e);
    }
  }

  /**
   * 响应成功
   *
   * @param response
   * @param object
   */
  public static void responseOk(HttpServletResponse response, Object object) {
    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
    response.setStatus(HttpStatus.OK.value());
    try {
      response.getWriter().write(JsonUtils.objectToJson(ResponseUtils.success(object)));
    } catch (IOException e) {
      log.error("responseOk方法获取HttpServletResponse失败:", e);
    }
  }

  /**
   * 响应失败
   *
   * @param response
   * @param code
   * @param msg
   */
  public static void responseFail(
      HttpServletResponse response, final String code, final String msg) {
    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
    response.setStatus(HttpStatus.OK.value());
    try {
      response.getWriter().write(JsonUtils.objectToJson(ResponseUtils.fail(code, msg)));
    } catch (IOException e) {
      log.error("responseFail方法获取HttpServletResponse失败:", e);
    }
  }
  /**
   * 响应失败
   *
   * @param response
   * @param apiCodeEnum
   * @param httpStatus
   */
  public static void responseFail(
      HttpServletResponse response, ApiCodeEnum apiCodeEnum, HttpStatus httpStatus) {
    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
    response.setStatus(httpStatus.value());
    try {
      response
          .getWriter()
          .write(
              JsonUtils.objectToJson(
                  ResponseUtils.fail(apiCodeEnum.getCode(), apiCodeEnum.getMsg())));
    } catch (IOException e) {
      log.error("responseFail方法获取HttpServletResponse失败:", e);
    }
  }
  /**
   * 导出文件初始化
   *
   * @param response
   * @param exportFileName 导出文件名
   */
  public static void initExportResponse(HttpServletResponse response, final String exportFileName) {
    // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
    response.setContentType(SysConstants.EXPORT_FILE_MEDIA_TYPE);
    response.setCharacterEncoding(StandardCharsets.UTF_8.name());
    // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
    String fileName =
        URLEncoder.encode(exportFileName, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
    response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
  }
}
