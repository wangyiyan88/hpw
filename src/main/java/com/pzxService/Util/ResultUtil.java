package com.pzxService.Util;

import com.bootdo.user.Vo.Result;

/**
 * Created by W-YiYan on 2018/12/9.
 */
public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode("0000");
        result.setMsg("操作成功");
        if(object != null){
            result.setData(object);
        }
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
