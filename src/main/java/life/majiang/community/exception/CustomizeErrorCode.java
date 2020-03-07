package life.majiang.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {


    QUESTION_NOT_FOUND(2001,"你找的问题不存在，要不要换一个试试?"),
    TARGET_PARAM_NOT_FOUND(2002,"未选择任何问题或评论进行恢复"),
    NOT_LOGIN(2003,"未登录，请登陆后重试"),
    SYS_ERROR(2004,"服务器冒烟了，要不然稍后再试  ");
    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }


    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
