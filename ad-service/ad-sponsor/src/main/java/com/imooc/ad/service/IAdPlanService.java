package com.imooc.ad.service;

import com.imooc.ad.exception.AdException;
import com.imooc.ad.vo.AdPlanRequest;
import com.imooc.ad.vo.AdPlanResponse;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 0:36 2020/5/20
 * @Modified By:
 */
public interface IAdPlanService {
    /**
     * 创建推广计划
     * @return
     */
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;
    /**
     * <h2>更新推广计划</h2>
     * */
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    /**
     * <h2>删除推广计划</h2>
     * */
    void deleteAdPlan(AdPlanRequest request) throws AdException;
}
