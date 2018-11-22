package com.example.dao;

import com.example.domain.LearnResource;
import com.example.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LearnResourceMapper extends MyMapper<LearnResource> {
    List<LearnResource> queryLearnResouceList(Map<String, Object> map);
}
