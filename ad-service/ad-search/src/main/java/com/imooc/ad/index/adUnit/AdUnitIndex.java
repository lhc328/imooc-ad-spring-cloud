package com.imooc.ad.index.adUnit;

import com.imooc.ad.index.IndexAware;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 10:12 2020/5/23
 * @Modified By:
 */
@Slf4j
@Component
public class AdUnitIndex implements IndexAware<Long, AdUnitObject> {
    private static Map<Long, AdUnitObject> map;

    static {
        map = new ConcurrentHashMap<>();
    }

    /**
     * 找对应广告位的
     * @param positionType
     * @return
     */
    public Set<Long> match(Integer positionType) {
        Set<Long> adUnitIds = new HashSet<>();
        map.forEach((k, v) -> {
            if (AdUnitObject.isAdSlotTypeOK(positionType,
                    v.getPositionType())) {
                adUnitIds.add(k);
            }
        });
        return adUnitIds;
    }

    /**
     * 找所有ids的unit缓存，没有return
     * @param adUnitIds
     * @return
     */
    public List<AdUnitObject> fetch(Collection<Long> adUnitIds) {
        if (CollectionUtils.isEmpty(adUnitIds)) {
            return Collections.emptyList();
        }
        List<AdUnitObject> result = new ArrayList<>();
        adUnitIds.forEach(u -> {
            AdUnitObject object = get(u);
            if (object == null) {
                log.error("AdUnitObject not found: {}", u);
                return;
            }
            result.add(object);
        });
        return result;
    }

    @Override
    public AdUnitObject get(Long key) {
        return map.get(key);
    }

    @Override
    public void add(Long key, AdUnitObject value) {
        log.info("adunit before add: {}", map);
        map.put(key,value);
        log.info("adunit after add: {}", map);
    }

    @Override
    public void update(Long key, AdUnitObject value) {
        log.info("adunit before update: {}", map);

        AdUnitObject oldObject = map.get(key);
        if (null == oldObject) {
            map.put(key, value);
        } else {
            oldObject.update(value);
        }

        log.info("adunit after update: {}", map);
    }

    @Override
    public void delete(Long key, AdUnitObject value) {
        log.info("adunit before delete: {}", map);
        map.remove(key);
        log.info("adunit after delete: {}", map);
    }
}
