package com.pzxService.user.service.impl;

import com.bootdo.common.utils.StringUtils;
import com.bootdo.tagLibrary.dao.TagLibraryDao;
import com.bootdo.tagLibrary.domain.TagLibrary;
import com.bootdo.user.Vo.Result;
import com.bootdo.user.domain.User;
import com.pzxService.Util.ResultUtil;
import com.pzxService.user.service.LoginService;
import com.pzxService.user.service.TagLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

;import java.sql.Date;

@Service
public class TagLibaryServiceImpl implements TagLibraryService {

    @Autowired
    private TagLibraryDao tagLibraryDao;
    @Autowired
    private LoginService loginService;

    @Override
    public Result addTag(TagLibrary tagLibrary) throws Exception {
        String userid = tagLibrary.getUserId();
        if(StringUtils.isBlank(userid)) {
            return ResultUtil.error("0001","参数中没有用户的id");
        }
        User user = loginService.get(tagLibrary.getUserId());
        if(ObjectUtils.isEmpty(user)) {
            return ResultUtil.error("0002","没有找到对应的用户");
        }
        Result result = null;
        tagLibrary.setCreateTime(new Date(System.currentTimeMillis()));
        tagLibrary.setTagStatus("0");
         int i = tagLibraryDao.insert(tagLibrary);
         if(i>0) {
             result = ResultUtil.success("成功");
         }else{
             result =ResultUtil.error("0003","添加标签失败");
         }
        return result;
    }
}
