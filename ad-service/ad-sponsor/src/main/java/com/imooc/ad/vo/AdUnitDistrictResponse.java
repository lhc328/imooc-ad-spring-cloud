package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 19:14 2020/5/20
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitDistrictResponse {
    private List<Long> ids;
}
