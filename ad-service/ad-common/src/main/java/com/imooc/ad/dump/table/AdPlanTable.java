package com.imooc.ad.dump.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 12:36 2020/5/23
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanTable {
    private Long id;
    private Long userId;
    private Integer planStatus;
    private Date startDate;
    private Date endDate;
}
