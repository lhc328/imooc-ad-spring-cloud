package com.imooc.ad.dump.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 13:54 2020/5/23
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitDistrictTable {
    private Long unitId;
    private String province;
    private String city;
}
