package com.pzxService.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.bootdo.Utils.CommonUtil;
import com.bootdo.user.Vo.LoginVo;
import com.bootdo.user.Vo.MemberVo;
import com.bootdo.user.Vo.RegisterResult;
import com.bootdo.user.Vo.Result;
import com.bootdo.user.dao.LoginUserDao;
import com.bootdo.user.dao.UserAuthenticationDao;
import com.bootdo.user.dao.UserInfoDao;
import com.bootdo.user.domain.User;
import com.bootdo.user.domain.UserAuthentication;
import com.bootdo.user.domain.UserExample;
import com.bootdo.user.domain.UserInfo;

import com.pzxService.Util.ResultUtil;
import com.pzxService.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by W-YiYan on 2018/12/9.
 */
@Service
public class LoginServiceImpl implements LoginService {
    private Logger logger = Logger.getLogger(LoginServiceImpl.class.getSimpleName());
    private static String FilePath ="D:\\path\\";
    @Autowired
    LoginUserDao  loginUserMapper;
    @Autowired
    UserInfoDao userInfoDao;
    @Autowired
    UserAuthenticationDao userAuthenticationDao;


    @Override
    public Result certification(MultipartFile positiveFile, MultipartFile reverseFile, String idCard,String userId) {

        if (positiveFile.isEmpty()||  reverseFile.isEmpty()) {
            return ResultUtil.error("0001","请上传文件");
        }
        if(StringUtils.isEmpty(userId)) {
            return ResultUtil.error("0004","请传入userid参数");
        }
        String positiveFileNane = positiveFile.getOriginalFilename();
        String reverseFileNane  = reverseFile.getOriginalFilename();
        File destpositive = new File(FilePath + positiveFileNane);
        File destreverse = new File(FilePath + reverseFileNane);
        logger.info("idCard:    "+idCard );
        try {
            User user = get(userId);
            if(ObjectUtils.isEmpty(user)) {
                return ResultUtil.error("0003","没有找到对应的用户");
            }
            if(checkIdCard(positiveFile,idCard)) {
                UserAuthentication  userAuthentication = new UserAuthentication();
                userAuthentication.setIdcard(idCard);
                userAuthentication.setUserid(userId);
                userAuthentication.setIdpositiveimg(destpositive.getPath());
                userAuthentication.setIdsideimg(destreverse.getPath());
                userAuthentication.setCreatetime(new Date(System.currentTimeMillis()));
                userAuthentication.setUpdatetime(new Date(System.currentTimeMillis()));
                positiveFile.transferTo(destpositive);
                reverseFile.transferTo(destreverse);
                user.setIsverified(1);
                int i =  userAuthenticationDao.insert(userAuthentication);
                if(i>0) {
                    loginUserMapper.updateByPrimaryKeySelective(user);
                }
                return ResultUtil.success("认证成功");
            }else{
                return ResultUtil.error("0002","身份证验证不通过");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultUtil.error("0007","认证出现异常");
        }

    }



    private boolean  checkIdCard(MultipartFile positiveFile,String idCard) {
       return true;
    }



    @Override
    public User get(String id) throws  Exception{
        UserExample userExample = new UserExample();
       UserExample.Criteria criteria = userExample.createCriteria();
       criteria.andOpenidEqualTo(id);
       List<User> userlist  = loginUserMapper.selectByExample(userExample);
       User  user =null;
        if(!ObjectUtils.isEmpty(userlist))  {
            user =   userlist.get(0);
        }
        return user;
    }

    public Result registered(LoginVo loginVo)  throws Exception {
        Result result = null;
        RegisterResult registerResult = new RegisterResult();
        if(!ObjectUtils.isEmpty(get(loginVo.getOpenid()))) {
            result = ResultUtil.error("0001","0penid不能重复注册");
        }else{
        User user = blid(loginVo);
        UserInfo userInfo = bildUserInfo(loginVo,user.getId());
        int i=0;
        i  =  loginUserMapper.insert(user);
        userInfoDao.insert(userInfo);
       if(i==1) {
           registerResult.setStatus("0000");
           registerResult.setStatusText("注册成功");
           result  = ResultUtil.success(registerResult);
       }else{
           result = ResultUtil.error("0002","注册失败");
       }
        }
       return result;
    }

    private User blid (LoginVo loginVo) {
        User user= null;
        if(!ObjectUtils.isEmpty(loginVo) && !StringUtils.isEmpty(loginVo.getOpenid())) {
            user = new User();
            user.setId(CommonUtil.getUUID32());
            user.setIsverified(0);
            user.setOpenid(loginVo.getOpenid());
            user.setPhone(loginVo.getPhone());
            user.setStatus(1);
            user.setPassword(loginVo.getPassword());
            user.setCreateTime(new Date(System.currentTimeMillis()));
            user.setLastUpdatetime(new Date(System.currentTimeMillis()));
        }
        return user;
    }

    private UserInfo bildUserInfo(LoginVo loginVo,String userid) {
        UserInfo userInfo = new UserInfo();
        userInfo.setAccount(loginVo.getAccount());
        userInfo.setAge(loginVo.getAge());
        userInfo.setHeadImage(loginVo.getHeadImage());
        userInfo.setMail(loginVo.getMail());
        userInfo.setPhone(loginVo.getPhone());
        userInfo.setUserid(userid);
        userInfo.setSex(loginVo.getSex());
        userInfo.setTrueName(loginVo.getTrueName());
        userInfo.setCreateTime(new Date(System.currentTimeMillis()));
        userInfo.setLastUpdatetime(new Date(System.currentTimeMillis()));
        return userInfo;
    }

}
