package com.example.service.impl;

import com.example.dao.LearnResourceMapper;
import com.example.domain.LearnResource;
import com.example.model.QueryLearnListReq;
import com.example.service.LearnService2;
import com.example.util.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LearnServiceImpl2 extends BaseService<LearnResource> implements LearnService2 {

    @Autowired
    private LearnResourceMapper learnResourceMapper;

    @Override
    public void deleteBatch(Long[] ids) {
        Arrays.stream(ids).forEach(id -> learnResourceMapper.deleteByPrimaryKey(id));
    }

    @Override
    public List<LearnResource> queryLearnResourceList(Page<QueryLearnListReq> page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        return learnResourceMapper.queryLearnResouceList(page.getCondition());
    }

}
