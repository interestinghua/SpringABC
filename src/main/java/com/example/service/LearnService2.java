package com.example.service;

import com.example.domain.LearnResource;
import com.example.model.QueryLearnListReq;
import com.example.util.Page;

import java.util.List;

public interface LearnService2 extends IService<LearnResource> {

    List<LearnResource> queryLearnResourceList(Page<QueryLearnListReq> page);

    void deleteBatch(Long[] ids);

}
