package com.example.controller;

import com.example.domain.LearnResource;
import com.example.service.impl.LearnServiceImpl;
import com.example.util.ReturnObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learn")
public class LearnController extends AbstractController {

    @Autowired
    private LearnServiceImpl learnService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("")
    public String learn() {
        logger.debug("调用了 learn");
        return "learn-resource";
    }

    @RequestMapping(value = "/queryLearnResource/{id}", method = RequestMethod.GET)
    @ResponseBody
    public LearnResource queryLearnResource(@PathVariable Integer id) {
        return learnService.selectByKey(id);
    }

    /**
     * 查询教程列表
     *
     * @return
     */
    @RequestMapping(value = "/queryLearnList", method = RequestMethod.GET)
    @ResponseBody
    public List<LearnResource> queryLearnList() {
        return learnService.queryLearnResourceList();
    }

    /**
     * 新添教程
     *
     * @param learn
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ReturnObject addLearn(@RequestBody LearnResource learn) {
        learnService.save(learn);
        return ReturnObject.ok();
    }

    /**
     * 修改教程
     *
     * @param learn
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ReturnObject updateLearn(@RequestBody LearnResource learn) {
        learnService.updateNotNull(learn);
        return ReturnObject.ok();
    }

    /**
     * 删除教程
     *
     * @param ids
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ReturnObject deleteLearn(@RequestBody Long[] ids) {
        learnService.deleteBatch(ids);
        return ReturnObject.ok();
    }
}
