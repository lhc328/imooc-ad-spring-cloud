package com.imooc.ad.index.district;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 11:07 2020/5/23
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitDistrictObject {
    private Long unitId;
    private String province;
    private String city;
}
