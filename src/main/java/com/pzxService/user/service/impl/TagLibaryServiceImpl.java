package com.pzxService.user.service.impl;

import com.bootdo.tagLibrary.dao.TagLibraryDao;
import com.bootdo.tagLibrary.domain.TagLibrary;
import com.pzxService.user.service.TagLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagLibaryServiceImpl implements TagLibraryService {

    @Autowired
    private TagLibraryDao tagLibraryDao;

    @Override
    public String addTag(TagLibrary tagLibrary) throws Exception {
        return null;
    }
}
