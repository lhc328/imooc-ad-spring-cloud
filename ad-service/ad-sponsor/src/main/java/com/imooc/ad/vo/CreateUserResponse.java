package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 22:49 2020/5/20
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {
    private Long userId;
    private String username;
    private String token;
    private Date createTime;
    private Date updateTime;
}
