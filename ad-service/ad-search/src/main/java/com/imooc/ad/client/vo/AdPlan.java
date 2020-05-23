package com.imooc.ad.client.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 9:53 2020/5/23
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlan {
    private Long id;
    private Long userId;
    private String planName;
    private Integer planStatus;
    private Date startDate;
    private Date endDate;
    private Date createTime;
    private Date updateTime;
}
