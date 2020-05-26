package com.imooc.ad.index;

import lombok.Getter;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 23:24 2020/5/26
 * @Modified By:
 */
@Getter
public enum CommonStatus {

    VALID(1, "有效状态"),
    INVALID(0, "无效状态");

    private Integer status;
    private String desc;

    CommonStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}