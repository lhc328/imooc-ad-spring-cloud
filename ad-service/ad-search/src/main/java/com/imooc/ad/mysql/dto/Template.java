package com.imooc.ad.mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 11:10 2020/5/25
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Template {
    private String databases;
    private List<JsonTable> tableList;
}
