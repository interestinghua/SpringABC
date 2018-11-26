package com.example.service.impl;

import com.example.dao.LearnResourceMapper;
import com.example.domain.LearnResource;
import com.example.service.BaseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;

@Service
public class LearnServiceImpl extends BaseService<LearnResource> {

//    @Autowired
//    private LearnResourceMapper learnResourceMapper;

    public void deleteBatch(Long[] ids) {
        Arrays.stream(ids).forEach(this::deleteByPrimaryKey);
    }

    public List<LearnResource> queryLearnResourceList() {
        return mapper.selectAll();
    }

    public List<LearnResource> queryLearnResourceListByName(String name) {
        Example example = new Example(LearnResource.class);
        Example.Criteria criteria = example.createCriteria();
//        criteria.orEqualTo("author", name);
//        criteria.andEqualTo("author", name);
        criteria.orLike("author", "%" + name + "%");
        return mapper.selectByExample(example);
    }

}
