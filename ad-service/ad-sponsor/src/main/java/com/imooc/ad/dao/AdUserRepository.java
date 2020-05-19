package com.imooc.ad.dao;

import com.imooc.ad.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 0:27 2020/5/20
 * @Modified By:
 */
public interface AdUserRepository extends JpaRepository<AdUser, Long> {
    /**
     * <h2>根据用户名查找用户记录</h2>
     * */
    AdUser findByUsername(String username);
}
