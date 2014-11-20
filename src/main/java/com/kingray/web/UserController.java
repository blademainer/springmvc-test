package com.kingray.web;

import com.kingray.hibernate.domain.PUser;
import com.kingray.spring.mvc.bind.annotation.FormModel;
import com.kingray.vo.CodeVo;
import com.xiongyingqi.util.EntityHelper;
import com.xiongyingqi.util.SpringMVCHelper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;


@Controller
@RequestMapping("/user")
//@IgnoreProperties(value = {@IgnoreProperty(pojo = User.class, name = {"yxUserRoleRelations"}),
//        @IgnoreProperty(pojo = UserRoleRelation.class, name = "id")})
// @IgnoreProperty(pojo = User.class, name = "userPassword")
public class UserController {

    @ResponseBody
    @RequestMapping(value = "", method = {RequestMethod.POST})
    public CodeVo addUser(@Valid PUser user, BindingResult bindingResult){
//        SpringMVCHelper.assertBindingResult(bindingResult);
        EntityHelper.print(bindingResult.hasErrors());
        EntityHelper.print(user);
        EntityHelper.print(user.getBirthday());
        EntityHelper.print(user.getRegisterDate());
        CodeVo.SUCCESS.setResultObject(user);
        return CodeVo.SUCCESS;
    }

    @ResponseBody
    @RequestMapping(value = "/validate", method = {RequestMethod.POST})
    public CodeVo addUser2(@Valid @FormModel("user") PUser user, BindingResult bindingResult){
        SpringMVCHelper.assertBindingResult(bindingResult);
        EntityHelper.print(bindingResult.hasErrors());
        EntityHelper.print(user);
        EntityHelper.print(user.getBirthday());
        EntityHelper.print(user.getRegisterDate());
        CodeVo.SUCCESS.setResultObject(user);
        return CodeVo.SUCCESS;
    }
}
