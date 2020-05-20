package com.imooc.ad.service;

import com.imooc.ad.exception.AdException;
import com.imooc.ad.vo.CreateUserRequest;
import com.imooc.ad.vo.CreateUserResponse;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 22:48 2020/5/20
 * @Modified By:
 */
public interface IUserSevice {
    /**
     * <h2>创建用户</h2>
     * */
    CreateUserResponse createUser(CreateUserRequest request)
            throws AdException;
}
