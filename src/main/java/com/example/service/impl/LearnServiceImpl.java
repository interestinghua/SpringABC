package com.example.service.impl;

import com.example.dao.LearnResourceMapper;
import com.example.domain.LearnResource;
import com.example.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LearnServiceImpl extends BaseService<LearnResource>  {

    @Autowired
    private LearnResourceMapper learnResourceMapper;

    public void deleteBatch(Long[] ids) {
        Arrays.stream(ids).forEach(this::deleteByPrimaryKey);
    }

    public List<LearnResource> queryLearnResourceList() {
        return learnResourceMapper.queryLearnResourceList();
    }

}
