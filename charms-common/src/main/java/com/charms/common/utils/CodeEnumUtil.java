package com.charms.common.utils;

import com.charms.common.enums.BaseCodeEnum;

public class CodeEnumUtil {

    public static <E extends Enum<?> & BaseCodeEnum> E codeOf(Class<E> enumClass,int code){
        E[] enumContants = enumClass.getEnumConstants();
        for(E e : enumContants){
            if(e.getCode() == code){
                return e;
            }
        }

        return null;
    }
}
