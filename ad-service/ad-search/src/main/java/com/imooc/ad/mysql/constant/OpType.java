package com.imooc.ad.mysql.constant;

import com.github.shyiko.mysql.binlog.event.EventType;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 12:39 2020/5/23
 * @Modified By:
 */
public enum OpType {

    ADD,
    UPDATE,
    DELETE,
    OTHER;

    public static OpType to(EventType eventType) {

        switch (eventType) {
            case EXT_WRITE_ROWS:
                return ADD;
            case EXT_UPDATE_ROWS:
                return UPDATE;
            case EXT_DELETE_ROWS:
                return DELETE;

            default:
                return OTHER;
        }
    }
}
