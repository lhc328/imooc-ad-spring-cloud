package com.imooc.ad.index.adPlan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 9:59 2020/5/23
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdPlanObject {
    private Long planId;
    private Long userId;
    private Integer planStatus;
    private Date startDate;
    private Date endDate;

    public void update(AdPlanObject newObject) {

        if (null != newObject.getPlanId()) {
            this.planId = newObject.getPlanId();
        }
        if (null != newObject.getUserId()) {
            this.userId = newObject.getUserId();
        }
        if (null != newObject.getPlanStatus()) {
            this.planStatus = newObject.getPlanStatus();
        }
        if (null != newObject.getStartDate()) {
            this.startDate = newObject.getStartDate();
        }
        if (null != newObject.getEndDate()) {
            this.endDate = newObject.getEndDate();
        }
    }
}
