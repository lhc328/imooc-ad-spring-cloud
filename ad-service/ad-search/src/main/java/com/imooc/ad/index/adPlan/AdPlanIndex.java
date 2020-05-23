package com.imooc.ad.index.adPlan;

import com.imooc.ad.index.IndexAware;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 9:59 2020/5/23
 * @Modified By:
 */
@Slf4j
@Component
public class AdPlanIndex implements IndexAware<Long, AdPlanObject> {
    private static Map<Long, AdPlanObject> map;

    static {
        map = new ConcurrentHashMap<>();
    }

    @Override
    public AdPlanObject get(Long key) {
        return map.get(key);
    }

    @Override
    public void add(Long key, AdPlanObject value) {
        log.info("adplan before add: {}", map);
        map.put(key, value);
        log.info("adplan after add: {}", map);
    }

    @Override
    public void update(Long key, AdPlanObject value) {
        log.info("adplan before update: {}", map);
        AdPlanObject oldObject = map.get(key);
        if (null == oldObject) {
            map.put(key, value);
        } else {
            oldObject.update(value);
        }
        log.info("adplan after update: {}", map);
    }

    @Override
    public void delete(Long key, AdPlanObject value) {
        log.info("adplan before delete: {}", map);
        map.remove(key);
        log.info("adplan after delete: {}", map);
    }
}
