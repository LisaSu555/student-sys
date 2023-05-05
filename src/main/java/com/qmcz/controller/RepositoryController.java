package com.qmcz.controller;

import com.qmcz.base.TransformData;
import com.qmcz.domain.MyRepository;
import com.qmcz.domain.vi.RepositoryVi;
import com.qmcz.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.ResultSet;

@Controller
@RequestMapping("/repo")
public class RepositoryController {
    @Autowired
    private RepositoryService repositoryService;

    @RequestMapping("/list")
    public String toPage(){
        return "pages/myrepo/myrepoList";
    }

    @ResponseBody
    @RequestMapping("/list_api")
    public TransformData<MyRepository> getAllPage(RepositoryVi vi){
        return repositoryService.getAllPage(vi);
    }

    @ResponseBody
    @RequestMapping("/getOneById")
    public TransformData<MyRepository> getOneById(RepositoryVi vi){
        return repositoryService.getOneById(vi);
    }

    @ResponseBody
    @RequestMapping("/deleteById")
    public TransformData<MyRepository> deleteById(RepositoryVi vi){
        return repositoryService.deleteById(vi);
    }
}
