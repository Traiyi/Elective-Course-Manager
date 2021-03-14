package com.lzc.common;

/**
 * @author ：Lzc
 * @Class : ErrorCode
 * @description：封装API的错误码
 * @date ：2021-03-07 16:37
 */

public interface ErrorCode {

    long getCode();

    String getMessage();
}