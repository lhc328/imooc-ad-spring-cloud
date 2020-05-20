package com.imooc.ad.service;

import com.imooc.ad.vo.CreativeRequest;
import com.imooc.ad.vo.CreativeResponse;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 22:44 2020/5/20
 * @Modified By:
 */
public interface ICreativeService {
    CreativeResponse createCreative(CreativeRequest request);
}
