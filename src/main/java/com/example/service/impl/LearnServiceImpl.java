package com.example.service.impl;

import com.example.dao.LearnMapper;
import com.example.dao.LearnMapperV2;
import com.example.domain.LearnResource;
import com.example.service.LearnService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LearnServiceImpl implements LearnService {

    @Autowired
    LearnMapperV2 learnMapper;

    @Override
    public int add(LearnResource LearnResource) {
        return this.learnMapper.add(LearnResource);
    }

    @Override
    public int update(LearnResource LearnResource) {
        return this.learnMapper.update(LearnResource);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return this.learnMapper.deleteByIds(ids);
    }

    @Override
    public LearnResource queryLearnResourceById(Long id) {
        return this.learnMapper.queryLearnResourceById(id);
    }

    @Override
    public List<LearnResource> queryLearnResourceList(Map<String, Object> params) {
        PageHelper.startPage(Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("rows").toString()));
        return this.learnMapper.queryLearnResourceList(params);
    }

}
