package com.imooc.ad.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.ad.entity.AdPlan;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.service.IAdPlanService;
import com.imooc.ad.vo.AdPlanGetRequest;
import com.imooc.ad.vo.AdPlanRequest;
import com.imooc.ad.vo.AdPlanResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 23:01 2020/5/20
 * @Modified By:
 */
@Slf4j
@RestController
@RequestMapping("/ad-plan")
@CrossOrigin(value = "*", maxAge = 3600)
public class AdPlanController {
    private final IAdPlanService adPlanService;

    @Autowired
    public AdPlanController(IAdPlanService adPlanService) {
        this.adPlanService = adPlanService;
    }

    @PostMapping("/create")
    public AdPlanResponse createAdPlan(@RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: createPlan -> {}",
                JSON.toJSON(request));
        return adPlanService.createAdPlan(request);
    }

    @PostMapping("/get")
    public List<AdPlan> getAdPlanByIds(@RequestBody AdPlanGetRequest request) throws AdException {
        log.info("ad-sponsor: getAdPlanByIds -> {}",
                JSON.toJSON(request));
        return adPlanService.getAdPlanByIds(request);
    }

    @PutMapping("/")
    public AdPlanResponse updateAdPlan(@RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: updateAdPlan -> {}",
                JSON.toJSON(request));
        return adPlanService.updateAdPlan(request);
    }

    @DeleteMapping("/")
    public void deleteAdPlan(@RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: deleteAdPlan -> {}",
                JSON.toJSON(request));
        adPlanService.deleteAdPlan(request);
    }
}
