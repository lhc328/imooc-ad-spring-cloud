package com.imooc.ad.dump.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 12:40 2020/5/23
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitTable {
    private Long unitId;
    private Long planId;
    private Integer unitStatus;
    private Integer positionType;
}
