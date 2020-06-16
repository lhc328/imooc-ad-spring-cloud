package com.imooc.ad.search.vo.media;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 22:51 2020/5/26
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class App {
    // 应用编码
    private String appCode;
    // 应用名称
    private String appName;
    // 应用包名
    private String packageName;
    // activity 名称
    private String activityName;
}
