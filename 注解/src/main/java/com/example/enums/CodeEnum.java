package com.example.enums;

/**
 * @author zxy
 * @Classname CodeEnum
 * @Date 2022/4/24 12:06
 */
public enum CodeEnum{

    HH(100);

    private final Integer code;

    CodeEnum(int code) {
        this.code =code;
    }

    public int value(){
        return code;
    }


    public static void main(String[] args) {
        System.out.println(CodeEnum.HH);
        System.out.println(CodeEnum.HH.value());
    }
}
