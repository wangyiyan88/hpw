package com.bootdo.user.controller;

import com.alibaba.fastjson.JSON;
import com.bootdo.Utils.CommonUtil;
import com.bootdo.common.config.Constant;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.user.Vo.MemberVo;
import com.bootdo.user.domain.User;
import com.bootdo.user.domain.UserInfo;
import com.bootdo.user.service.MemberService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by W-YiYan on 2018/12/9.
 */

@Controller
@RequestMapping("/member/user")
public class MemberController  extends BaseController {
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
        List<MemberVo> sysUserList = memberService.userList(query);
        long total = memberService.countuser(query);
        PageUtils pageUtil = new PageUtils(sysUserList, Integer.parseInt(String.valueOf(total)));
        return pageUtil;
    }

    @GetMapping("/add")
    @RequiresPermissions("member:user:add")
    String add() {
        return "member/user/add";
    }

    /**
     * 保存
     */
    @ResponseBody
    @Transactional
    @RequiresPermissions("member:user:add")
    @PostMapping("/save")
    public R save(MemberVo member) {
        if (StringUtils.isEmpty(member.getPhone())) {
            return R.error(0001,"手机号码不能为空！");
        }
        if(StringUtils.isEmpty(member.getIsverified())){
            member.setIsverified(0);
        }
        if(StringUtils.isEmpty(member.getStatus())){
            member.setStatus(0);
        }
        int count;
        if (StringUtils.isEmpty(member.getId())) {
            try{
                User user = new User();
                user.setId(CommonUtil.getUUID32());
                user.setPhone(member.getPhone());
                user.setIsverified(member.getIsverified());
                user.setStatus(member.getStatus());
                user.setCreateTime(new Date());

                UserInfo userinfo = new UserInfo();
                userinfo.setAccount(member.getAccount());
                userinfo.setUserid(user.getId());
                userinfo.setCreateTime(new Date());
                memberService.saveUser(user);
                memberService.saveUserInfo(userinfo);
                count = 1;
            }catch (Exception e){
                logger.info("新增会员账号#########error######"+e);
                count = 0;
            }
        } else {
            count = 0;
        }
        if (count > 0) {
            return R.ok().put("id", member.getId());
        }
        return R.error();
    }




}
