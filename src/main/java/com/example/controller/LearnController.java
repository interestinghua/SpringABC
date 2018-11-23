package com.example.controller;

import com.example.domain.LearnResource;
import com.example.model.QueryLearnListReq;
import com.example.service.LearnService;
import com.example.util.AjaxObject;
import com.example.util.Page;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/learn")
public class LearnController extends AbstractController {

    @Autowired
    private LearnService learnService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("")
    public String learn(Model model) {
        model.addAttribute("ctx", getContextPath() + "/");
        return "learn-resource";
    }

    /**
     * 查询教程列表
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/queryLearnList", method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject queryLearnList(Page<QueryLearnListReq> page) {
        List<LearnResource> learnList = learnService.queryLearnResourceList(page);
        PageInfo<LearnResource> pageInfo = new PageInfo<LearnResource>(learnList);
        return AjaxObject.ok().put("page", pageInfo);
    }

    /**
     * 新添教程
     *
     * @param learn
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject addLearn(@RequestBody LearnResource learn) {
        learnService.save(learn);
        return AjaxObject.ok();
    }

    /**
     * 修改教程
     *
     * @param learn
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject updateLearn(@RequestBody LearnResource learn) {
        learnService.updateNotNull(learn);
        return AjaxObject.ok();
    }

    /**
     * 删除教程
     *
     * @param ids
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject deleteLearn(@RequestBody Long[] ids) {
        learnService.deleteBatch(ids);
        return AjaxObject.ok();
    }
}
