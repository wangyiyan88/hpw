package com.bootdo.user.controller;

import com.alibaba.fastjson.JSON;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.user.Vo.MemberVo;
import com.bootdo.user.domain.User;
import com.bootdo.user.service.MemberService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by W-YiYan on 2018/12/9.
 */

@Controller
@RequestMapping("/member/user")
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    private String prefix="member/user"  ;

    @Autowired
    MemberService memberService;

    @RequiresPermissions("member:user:user")
    @GetMapping()
    String member() {
        return prefix + "/user";
    }


    @GetMapping("/list")
    @ResponseBody
    @RequiresPermissions("member:user:user")
    PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        List<MemberVo> sysUserList = memberService.userList();
        long total = memberService.countuser();
        PageUtils pageUtil = new PageUtils(sysUserList, Integer.parseInt(String.valueOf(total)));
        return pageUtil;
    }


}
