package com.example.dao;

import com.example.domain.LearnResource;
import com.example.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

public interface LearnResourceMapper extends MyMapper<LearnResource> {
    List<LearnResource> queryLearnResourceList();
//    List<LearnResource> queryLearnResourceListByName(String name);
}
