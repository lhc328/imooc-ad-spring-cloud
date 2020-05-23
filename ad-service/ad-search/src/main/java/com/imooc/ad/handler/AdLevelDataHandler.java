package com.imooc.ad.handler;

import com.alibaba.fastjson.JSON;
import com.imooc.ad.dump.table.*;
import com.imooc.ad.index.DataTable;
import com.imooc.ad.index.IndexAware;
import com.imooc.ad.index.adPlan.AdPlanIndex;
import com.imooc.ad.index.adPlan.AdPlanObject;
import com.imooc.ad.index.adUnit.AdUnitIndex;
import com.imooc.ad.index.adUnit.AdUnitObject;
import com.imooc.ad.index.creative.CreativeIndex;
import com.imooc.ad.index.creative.CreativeObject;
import com.imooc.ad.index.creativeUnit.CreativeUnitIndex;
import com.imooc.ad.index.creativeUnit.CreativeUnitObject;
import com.imooc.ad.index.district.UnitDistrictIndex;
import com.imooc.ad.index.interest.UnitItIndex;
import com.imooc.ad.index.keyword.UnitKeywordIndex;
import com.imooc.ad.mysql.constant.OpType;
import com.imooc.ad.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 12:32 2020/5/23
 * @Modified By:
 */
@Slf4j
public class AdLevelDataHandler {
    private static <K, V> void handleBinlogEvent(
            IndexAware<K, V> index,
            K key,
            V value,
            OpType type
    ) {
        switch (type) {
            case ADD:
                index.add(key, value);
                break;
            case UPDATE:
                index.update(key, value);
                break;
            case DELETE:
                index.delete(key, value);
                break;
            default:
                break;
        }
    }

    public static void handleLevel2(AdPlanTable adPlanTable, OpType type) {
        AdPlanObject adPlanObject = new AdPlanObject(
                adPlanTable.getId(),
                adPlanTable.getUserId(),
                adPlanTable.getPlanStatus(),
                adPlanTable.getStartDate(),
                adPlanTable.getEndDate()
        );
        handleBinlogEvent(
                DataTable.of(AdPlanIndex.class),
                adPlanObject.getPlanId(),
                adPlanObject,
                type
        );
    }

    public static void handleLevel2(AdCreativeTable adCreativeTable, OpType type) {
        CreativeObject creativeObject = new CreativeObject(
                adCreativeTable.getAdid(),
                adCreativeTable.getName(),
                adCreativeTable.getType(),
                adCreativeTable.getMaterialType(),
                adCreativeTable.getHeight(),
                adCreativeTable.getWidth(),
                adCreativeTable.getAuditStatus(),
                adCreativeTable.getAdUrl()
        );
        handleBinlogEvent(
                DataTable.of(CreativeIndex.class),
                creativeObject.getAdId(),
                creativeObject,
                type
        );
    }

    public static void handleLevel3(AdUnitTable adUnitTable, OpType type) {
        AdPlanObject adPlanObject = DataTable.of(
                AdPlanIndex.class
        ).get(adUnitTable.getPlanId());
        if (null == adPlanObject) {
            log.error("handleLevel3 found adPlanObject error: {}", JSON.toJSON(adUnitTable));
            return;
        }

        AdUnitObject adUnitObject = new AdUnitObject(
                adUnitTable.getUnitId(),
                adUnitTable.getUnitStatus(),
                adUnitTable.getPositionType(),
                adUnitTable.getPlanId(),
                adPlanObject
        );
        handleBinlogEvent(
                DataTable.of(AdUnitIndex.class),
                adUnitTable.getUnitId(),
                adUnitObject,
                type
        );
    }

    public static void handleLevel3(AdCreativeUnitTable adCreativeUnitTable, OpType type) {
        if (type == OpType.UPDATE) {
            log.error("creativeUnit could not be updated");
            return;
        }
        CreativeObject creativeObject = DataTable.of(
                CreativeIndex.class
        ).get(adCreativeUnitTable.getAdId());
        AdUnitObject adUnitObject = DataTable.of(
                AdUnitIndex.class
        ).get(adCreativeUnitTable.getUnitId());
        if (null == adUnitObject || null == creativeObject) {
            log.error("handleLevel3 found adunit or creative error: {}", JSON.toJSON(adCreativeUnitTable));
            return;
        }

        CreativeUnitObject creativeUnitObject = new CreativeUnitObject(
                adCreativeUnitTable.getAdId(),
                adCreativeUnitTable.getUnitId()
        );
        handleBinlogEvent(
                DataTable.of(CreativeUnitIndex.class),
                CommonUtils.stringConcat(adCreativeUnitTable.getAdId().toString(), adCreativeUnitTable.getUnitId().toString()),
                creativeUnitObject,
                type
        );
    }

    public static void handleLevel4(AdUnitDistrictTable adUnitDistrictTable, OpType type) {
        if (type == OpType.UPDATE) {
            log.error("district index can not support update");
            return;
        }
        AdUnitObject adUnitObject = DataTable.of(AdUnitIndex.class).get(adUnitDistrictTable.getUnitId());
        if (null == adUnitObject) {
            log.error("AdUnitDistrictTable index unit error: {}", adUnitDistrictTable.getUnitId());
            return;
        }
        String key = CommonUtils.stringConcat(adUnitDistrictTable.getProvince(), adUnitDistrictTable.getCity());
        Set<Long> value = new HashSet<>(
                Collections.singleton(adUnitDistrictTable.getUnitId())
        );
        handleBinlogEvent(
                DataTable.of(UnitDistrictIndex.class),
                key, value,
                type
        );
    }

    public static void handleLevel4(AdUnitItTable adUnitItTable, OpType type) {
        if (type == OpType.UPDATE) {
            log.error("it index can not support update");
            return;
        }
        AdUnitObject adUnitObject = DataTable.of(AdUnitIndex.class).get(adUnitItTable.getUnitId());
        if (null == adUnitObject) {
            log.error("AdUnitItTable index unit error: {}", adUnitItTable.getUnitId());
            return;
        }
        Set<Long> value = new HashSet<>(
                Collections.singleton(adUnitItTable.getUnitId())
        );
        handleBinlogEvent(
                DataTable.of(UnitItIndex.class),
                adUnitItTable.getItTag(),
                value,
                type
        );
    }

    public static void handleLevel4(AdUnitKeywordTable adUnitKeywordTable, OpType type) {
        if (type == OpType.UPDATE) {
            log.error("keyword index can not support update");
            return;
        }
        AdUnitObject adUnitObject = DataTable.of(AdUnitIndex.class).get(adUnitKeywordTable.getUnitId());
        if (null == adUnitObject) {
            log.error("AdUnitKeywordTable index unit error: {}", adUnitKeywordTable.getUnitId());
            return;
        }
        Set<Long> value = new HashSet<>(
                Collections.singleton(adUnitKeywordTable.getUnitId())
        );
        handleBinlogEvent(
                DataTable.of(UnitKeywordIndex.class),
                adUnitKeywordTable.getKeyword(),
                value,
                type
        );
    }
}
