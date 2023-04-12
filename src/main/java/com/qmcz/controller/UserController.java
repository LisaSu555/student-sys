package com.qmcz.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.qmcz.base.TransformData;
import com.qmcz.domain.User;
import com.qmcz.domain.vi.UserVi;
import com.qmcz.domain.vo.UserVoEdit;
import com.qmcz.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pcf
 * @date 2022/01/27
 */
@Controller
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String getUserList(ModelMap modelMap, User user){
        String queryName = user.getName();
        TransformData<User> userListTrans = userService.getUserList(user);
        TransformData<User> userListApi = userService.getUserListApi(null);
        List<User> userList = userListTrans.getRows();
        int dataCount = userListApi.getRows().size();
        int pageCount = (int)Math.ceil(dataCount / 10.0);
        modelMap.addAttribute("list", userList);
        modelMap.addAttribute("query", queryName);
        modelMap.addAttribute("userListSize", pageCount);
        modelMap.addAttribute("currentPageNumber", user.getPageNumber());
        return "pages/user/userList";
    }

    @RequestMapping("/list_api")
    @ResponseBody
    public TransformData<User> getUserListApi(User user){
        return userService.getUserListApi(user);
    }

    /**
     * 编辑使用的ajax
     * @param user 入参
     * @return 出参
     */
    @RequestMapping("/list_ajax")
    @ResponseBody
    public TransformData<UserVoEdit> getUserListAjax(User user){
        TransformData<UserVoEdit> userListAjax = userService.getUserListAjax(user);
        return userListAjax;
    }

    /**
     * 分页查询时防止页面跳转而刷新数据
     * @param user 入参
     * @return 出参
     */
    @RequestMapping("/list_page_ajax")
    @ResponseBody
    public TransformData<User> getListForPageAjax(User user){
        return userService.getUserList(user);
    }

    @RequestMapping("/to_add_page")
    public String toAddPage(ModelMap modelMap){
        modelMap.addAttribute("test","one");
        return "pages/user/userAdd";
    }

    @RequestMapping("/add_user")
    @ResponseBody
    public TransformData<User> addUser(UserVi user){
        //int i = 1 / 0;
        return userService.addUser(user);
    }

    @ResponseBody
    @PostMapping("/edit_user")
    public TransformData<User> editUser(User user){
        return userService.editUser(user);
    }

    @ResponseBody
    @PostMapping("/delete_user")
    public TransformData<User> deleteUser(User user){
        return userService.deleteUser(user);
    }

    /**
     * 模糊查询user
     * @return 集合
     */
    @GetMapping("{name}/get_user_mohu/{age}")
    @ResponseBody
    public List<User> getUserList(@PathVariable("name") String name , @PathVariable("age") Integer age){
        User user = new User();
        if(StringUtils.isNotBlank(name)){
            user.setName(name);
        }
        if(age != null){
            user.setAge(age);
        }
        TransformData<User> userListData = userService.getUserList(user);
        return userListData.getRows();
    }

}
