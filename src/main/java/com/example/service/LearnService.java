package com.example.service;

import com.example.domain.LearnResource;

import java.util.List;
import java.util.Map;

public interface LearnService {

    int add(LearnResource LearnResource);
    int update(LearnResource LearnResource);
    int deleteByIds(String[] ids);
    LearnResource queryLearnResourceById(Long LearnResource);
    List<LearnResource> queryLearnResourceList(Map<String, Object> params);
    
}
