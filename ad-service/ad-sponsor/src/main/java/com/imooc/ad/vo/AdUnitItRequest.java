package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 19:11 2020/5/20
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitItRequest {
    private List<UnitIt> unitIts;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UnitIt {
        private Long unitId;
        private String itTag;
    }
}
