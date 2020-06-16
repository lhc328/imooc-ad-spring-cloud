package com.imooc.ad.search.vo.media;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 22:52 2020/5/26
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    // 设备id
    private String deviceId;
    // mac地址
    private String mac;
    // ip
    private String ip;
    // 机型编码
    private String model;
    // 分辨率尺寸
    private String displaySize;
    // 屏幕尺寸
    private String screenSize;
    // 设备序列号
    private String serialName;
}
