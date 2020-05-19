package com.imooc.ad.service.impl;

import com.imooc.ad.constant.Constants;
import com.imooc.ad.dao.AdPlanRepository;
import com.imooc.ad.dao.AdUserRepository;
import com.imooc.ad.entity.AdPlan;
import com.imooc.ad.entity.AdUser;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.service.IAdPlanService;
import com.imooc.ad.utils.CommonUtils;
import com.imooc.ad.vo.AdPlanRequest;
import com.imooc.ad.vo.AdPlanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 0:45 2020/5/20
 * @Modified By:
 */
@Service
public class AdPlanServiceImpl implements IAdPlanService {
    private final AdPlanRepository adPlanRepository;
    private final AdUserRepository adUserRepository;

    @Autowired
    public AdPlanServiceImpl(AdPlanRepository adPlanRepository, AdUserRepository adUserRepository) {
        this.adPlanRepository = adPlanRepository;
        this.adUserRepository = adUserRepository;
    }

    @Override
    @Transactional
    public AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException {
        if (!request.createValid()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        // 确保关联的user存在
        Optional<AdUser> adUser = adUserRepository.findById(request.getUserId());

        if (!adUser.isPresent()) {
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }

        AdPlan oldPlan = adPlanRepository.findByUserIdAndPlanName(request.getUserId(),
                request.getPlanName());
        if (oldPlan != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_PLAN_ERROR);
        }

        AdPlan newPlan = adPlanRepository.save(
                new AdPlan(request.getUserId(), request.getPlanName(),
                        CommonUtils.parseStringDate(request.getStartDate()),
                        CommonUtils.parseStringDate(request.getEndDate()))
        );
        return new AdPlanResponse(newPlan.getId(), newPlan.getPlanName());
    }
}