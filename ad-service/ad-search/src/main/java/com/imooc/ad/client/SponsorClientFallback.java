package com.imooc.ad.client;

import com.imooc.ad.client.vo.AdPlan;
import com.imooc.ad.client.vo.AdPlanGetRequest;
import com.imooc.ad.vo.CommonResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 9:53 2020/5/23
 * @Modified By:
 */
@Component
public class SponsorClientFallback implements SponsorClient {
    @Override
    public CommonResponse<List<AdPlan>> getAdPlans(AdPlanGetRequest request) {
        return new CommonResponse<>(5000002,
                "eureka-client-ad-sponsor error");
    }
}
