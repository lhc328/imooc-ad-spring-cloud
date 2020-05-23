package com.imooc.ad.dump.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 13:55 2020/5/23
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdCreativeTable {
    private Long adid;
    private String name;
    private Integer type;
    private Integer materialType;
    private Integer height;
    private Integer width;
    private Integer auditStatus;
    private String adUrl;
}
