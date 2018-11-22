package com.example.dao02;

import com.example.domain.LearnResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LearnMapper {
    int add(LearnResource LearnResource);
    int update(LearnResource LearnResource);
    int deleteByIds(String[] ids);
    LearnResource queryLearnResourceById(Long id);
    List<LearnResource> queryLearnResourceList(Map<String, Object> params);
}
