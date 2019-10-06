package zztest.pojo;

public enum StatusEnum {
    START(1, "开始"), USE(2, "使用中"), END(3, "结束");
    private Integer code;
    private String name;

    private StatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
