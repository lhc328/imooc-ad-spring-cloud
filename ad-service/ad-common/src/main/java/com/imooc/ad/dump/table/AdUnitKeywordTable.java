package com.imooc.ad.dump.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 13:52 2020/5/23
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitKeywordTable {
    private Long unitId;
    private String keyword;
}
