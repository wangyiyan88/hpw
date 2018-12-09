package com.bootdo.Utils;

import java.util.UUID;

public class CommonUtil {
    public static String getUUID32(){
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
    }


}
