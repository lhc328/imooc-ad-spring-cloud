package com.imooc.ad.mysql.listener;

import com.imooc.ad.mysql.dto.BinlogRowData;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 15:20 2020/5/26
 * @Modified By:
 */
public interface Ilistener {
    void register();

    void onEvent(BinlogRowData binlogRowData);
}
