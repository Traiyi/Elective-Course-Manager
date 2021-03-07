package com.traiyi.common;

/**
 * @author ��Traiyi
 * @Class : ResultCode
 * @description��ö����һЩ����API������
 * @date ��2021-03-07 16:35
 */

public enum ResultCode implements ErrorCode {

    SUCCESS(200, "�����ɹ�"),
    FAILED(500, "����ʧ��"),
    VALIDATE_FAILED(404, "��������ʧ��"),
    UNAUTHORIZED(401, "��δ��¼��token�Ѿ�����"),
    FORBIDDEN(403, "û�����Ȩ��");

    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

