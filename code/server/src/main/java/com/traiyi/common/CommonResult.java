package com.traiyi.common;

/**
 * @author ��Traiyi
 * @Class : CommonResult
 * @description��TODO
 * @date ��2021-03-07 16:38
 */

public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResult(){
    }

    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * @description: �ɹ����ؽ��
     * @param data ��ȡ������
     * @return com.example.tiny1.common.CommonResult<T>
     */
    public static <T> CommonResult<T> success(T data){

        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }

    /**
     * @description: �ɹ����ؽ��
     * @param data ��ȡ������
     * @param  message ��ʾ��Ϣ
     * @return com.example.tiny1.common.CommonResult<T>
     */
    public static <T> CommonResult<T> success(T data,String message){

        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),message,data);
    }
    /**
     * @description: ʧ�ܷ��ؽ��
     * @param errorCode  ������
     * @return com.example.tiny1.common.CommonResult<T>
     */
    public static <T> CommonResult<T> failed(ErrorCode errorCode){

        return new CommonResult<T>(errorCode.getCode(),errorCode.getMessage(),null);
    }

    /**
     * ʧ�ܷ��ؽ��
     * @param message ��ʾ��Ϣ
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * ʧ�ܷ��ؽ��
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * ������֤ʧ�ܷ��ؽ��
     */
    public static <T> CommonResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * ������֤ʧ�ܷ��ؽ��
     * @param message ��ʾ��Ϣ
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * δ��¼���ؽ��
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * δ��Ȩ���ؽ��
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }


    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

