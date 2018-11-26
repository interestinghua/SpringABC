package com.example.controller;

import com.example.domain.LearnResource;
import com.example.service.impl.LearnServiceImpl;
import com.example.util.ReturnObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //consumes = "application/json",
    //params = {"id"}
    @RequestMapping(value = "/queryLearnResource/{id}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    @ResponseBody
    public LearnResource queryLearnResource(@PathVariable("id") Integer id) {
        return learnService.selectByKey(id);
    }

    //根据名字查询记录
    @RequestMapping(value = "/queryLearnResourceByName/{name}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    @ResponseBody
    public List<LearnResource> queryLearnResourceByName(@PathVariable("name") String name) {
        return learnService.queryLearnResourceListByName(name);
    }

    //根据名字查询记录
    @RequestMapping(value = "/queryLearnResourceByTitle/{title}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    @ResponseBody
    public List<LearnResource> queryLearnResourceByTitle(@PathVariable("title") String title) {
        return learnService.queryLearnResourceListByTitle(title);
    }

    /**
     * 查询教程列表
     *
     * @return
     */
    @RequestMapping(value = "/queryLearnList",
            method = RequestMethod.GET,
            produces = "application/json")
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
        int result = learnService.save(learn);
        if (result == 1) {
            Map resultMap = new HashMap<>();
            resultMap.put("data", learn);
            return ReturnObject.ok(resultMap);
        } else {
            return ReturnObject.error(500, "插入数据失败");
        }
    }

    /**
     * 修改教程
     *
     * @param learn
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ReturnObject updateLearn(@RequestBody LearnResource learn) {
        int result = learnService.updateNotNull(learn);
        if (result == 1) {
            Map resultMap = new HashMap<>();
            resultMap.put("data", learn);
            return ReturnObject.ok(resultMap);
        } else {
            return ReturnObject.error(500, "更新数据失败");
        }
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
