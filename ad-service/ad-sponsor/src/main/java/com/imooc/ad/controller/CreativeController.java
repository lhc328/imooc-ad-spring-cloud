package com.imooc.ad.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.ad.service.ICreativeService;
import com.imooc.ad.vo.CreativeRequest;
import com.imooc.ad.vo.CreativeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 23:14 2020/5/21
 * @Modified By:
 */
@Slf4j
@RestController
@RequestMapping("/creative")
public class CreativeController {
    private final ICreativeService creativeService;

    @Autowired
    public CreativeController(ICreativeService creativeService) {
        this.creativeService = creativeService;
    }

    @PostMapping("/create")
    public CreativeResponse createCreative(
            @RequestBody CreativeRequest request
    ) {
        log.info("ad-sponsor: createCreative -> {}",
                JSON.toJSONString(request));
        return creativeService.createCreative(request);
    }
}
