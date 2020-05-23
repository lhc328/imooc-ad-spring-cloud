package com.imooc.ad.index.creative;

import com.imooc.ad.index.IndexAware;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 10:36 2020/5/23
 * @Modified By:
 */
@Slf4j
@Component
public class CreativeIndex implements IndexAware<Long, CreativeObject> {
    private static Map<Long, CreativeObject> map;

    static {
        map = new ConcurrentHashMap<>();
    }

    public List<CreativeObject> fetch(Collection<Long> adIds) {
        if (CollectionUtils.isEmpty(adIds)) {
            return Collections.emptyList();
        }
        List<CreativeObject> result = new ArrayList<>();
        adIds.forEach(u -> {
            CreativeObject object = get(u);
            if (null == object) {
                log.error("CreativeObject not found: {}", u);
                return;
            }
            result.add(object);
        });
        return result;
    }

    @Override
    public CreativeObject get(Long key) {
        return map.get(key);
    }

    @Override
    public void add(Long key, CreativeObject value) {
        log.info("creative before add: {}", map);
        map.put(key, value);
        log.info("creative before after: {}", map);
    }

    @Override
    public void update(Long key, CreativeObject value) {
        log.info("creative before update: {}", map);

        CreativeObject oldObject = map.get(key);
        if (null == oldObject) {
            map.put(key, value);
        } else {
            oldObject.update(value);
        }

        log.info("creative after update: {}", map);
    }

    @Override
    public void delete(Long key, CreativeObject value) {
        log.info("creative before delete: {}", map);
        map.remove(key);
        log.info("creative before delete: {}", map);
    }
}
