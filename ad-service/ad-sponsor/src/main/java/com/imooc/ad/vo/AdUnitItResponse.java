package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 19:12 2020/5/20
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitItResponse {
    private List<Long> ids;
}
