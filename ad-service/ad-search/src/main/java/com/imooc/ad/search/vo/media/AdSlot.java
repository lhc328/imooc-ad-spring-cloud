package com.imooc.ad.search.vo.media;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 22:37 2020/5/26
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdSlot {
    // 广告编码
    private String adSlotCode;
    // 流量类型
    private Integer positionType;
    // 宽 高
    private Integer width;
    private Integer height;

    // 物料类型 图片 视频
    private List<Integer> type;

    // 最低出价
    private Integer minCpm;
}
