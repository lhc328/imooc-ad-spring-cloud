package com.imooc.ad.sender;

import com.imooc.ad.mysql.dto.MySqlRowData;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 17:34 2020/5/26
 * @Modified By:
 */
public interface ISender {

    void sender(MySqlRowData mySqlRowData);
}
