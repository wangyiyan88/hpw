package com.bootdo.exception.exceptionHandler;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.bootdo.user.Vo.Result;
import com.pzxService.Util.ResultUtil;
import org.springframework.core.Ordered;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler implements HandlerExceptionResolver, Ordered {

    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        Result result = null;
        if (e instanceof HttpMessageNotReadableException) {
            result = ResultUtil.error("0007","參數入參異常");
        } else {
            result = ResultUtil.error("0007","未知異常");
        }
        ModelAndView mv = new ModelAndView();
        /* 使用FastJson提供的FastJsonJsonView视图返回，不需要捕获异常 */
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("code",result.getCode());
        attributes.put("msg",result.getMsg() );
        view.setAttributesMap(attributes);
        mv.setView(view);
        return mv;


    }
}
