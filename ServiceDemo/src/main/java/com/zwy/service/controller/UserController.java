package com.zwy.service.controller;

import com.zwy.service.bean.AccountBean;
import com.zwy.service.service.AccountService;
import com.zwy.service.service.impl.AccountServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("/balance")
    public ModelAndView balance(String name) {
        AccountService service = new AccountServiceImpl();
        AccountBean bean = service.queryBalace(name);
        ModelAndView mav = new ModelAndView();
        mav.addObject("account", bean);
        mav.setViewName("balance");
        return mav;
    }
}
