package com.imooc.ad.search;

import com.imooc.ad.search.vo.SearchRequest;
import com.imooc.ad.search.vo.SearchResponse;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 22:33 2020/5/26
 * @Modified By:
 */
public interface ISearch {
    SearchResponse fetchAds(SearchRequest request);
}
