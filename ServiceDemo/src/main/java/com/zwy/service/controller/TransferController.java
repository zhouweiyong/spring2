package com.zwy.service.controller;

import com.zwy.service.service.AccountService;
import com.zwy.service.service.impl.AccountServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TransferController {

    /**
     * 张三转账给李四
     */
    @PostMapping("/ztol")
    public String zToL(HttpServletRequest request) {
        int amount = 0;
        boolean b = false;
        try {
            amount = Integer.parseInt(request.getParameter("amount"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (amount > 0) {
            AccountService service = new AccountServiceImpl();
            b = service.zToL(amount);
        }
        if (b) {
            return "redirect:/success.html";

        } else {
            return "redirect:/fail.html";
        }
    }

    /**
     * 李四转账给张三
     */
    @PostMapping("/ltoz")
    public String lToZ(HttpServletRequest request) {
        int amount = 0;
        boolean b = false;
        try {
            amount = Integer.parseInt(request.getParameter("amount"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (amount > 0) {
            AccountService service = new AccountServiceImpl();
            b = service.lToZ(amount);
        }
        if (b) {
            return "redirect:/success.html";

        } else {
            return "redirect:/fail.html";
        }
    }

}
