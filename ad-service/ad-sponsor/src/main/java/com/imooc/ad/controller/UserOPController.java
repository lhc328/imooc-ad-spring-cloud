package com.imooc.ad.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.service.IUserSevice;
import com.imooc.ad.vo.CreateUserRequest;
import com.imooc.ad.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 22:45 2020/5/21
 * @Modified By:
 */
@Slf4j
@RestController
@RequestMapping("/user")
@CrossOrigin(value = "*", maxAge = 3600)
public class UserOPController {
    private final IUserSevice userSevice;

    @Autowired
    public UserOPController(IUserSevice userSevice) {
        this.userSevice = userSevice;
    }

    @PostMapping("/create")
    public CreateUserResponse createUser(
            @RequestBody CreateUserRequest request) throws AdException {
        log.info("ad-sponsor: createUser -> {}",
                JSON.toJSON(request));
        return userSevice.createUser(request);
    }
}
