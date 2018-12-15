package com.pzxService.user.service;


import com.bootdo.user.Vo.LoginVo;
import com.bootdo.user.Vo.Result;
import com.bootdo.user.domain.User;
import org.springframework.web.multipart.MultipartFile;


/**
 * Created by W-YiYan on 2018/12/9.
 */
public interface LoginService {

    User get(String id) throws  Exception;

    Result registered(LoginVo loginVo)throws  Exception;

    Result certification (MultipartFile  positiveFile,MultipartFile reverseFile,String idCard,String userid ) throws  Exception;



}
