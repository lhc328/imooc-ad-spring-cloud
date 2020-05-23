package com.imooc.ad.service;

import com.alibaba.fastjson.JSON;
import com.imooc.ad.Application;
import com.imooc.ad.constant.CommonStatus;
import com.imooc.ad.dao.AdPlanRepository;
import com.imooc.ad.dao.AdUnitRepository;
import com.imooc.ad.dao.CreativeRepository;
import com.imooc.ad.dao.unit_condition.AdUnitDistrictRepository;
import com.imooc.ad.dao.unit_condition.AdUnitItRepository;
import com.imooc.ad.dao.unit_condition.AdUnitKeywordRepository;
import com.imooc.ad.dao.unit_condition.CreativeUnitRepository;
import com.imooc.ad.dump.DConstant;
import com.imooc.ad.dump.table.*;
import com.imooc.ad.entity.AdPlan;
import com.imooc.ad.entity.AdUnit;
import com.imooc.ad.entity.Creative;
import com.imooc.ad.entity.unit_condition.AdUnitDistrict;
import com.imooc.ad.entity.unit_condition.AdUnitIt;
import com.imooc.ad.entity.unit_condition.AdUnitKeyword;
import com.imooc.ad.entity.unit_condition.CreativeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 14:19 2020/5/23
 * @Modified By:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DumpDataService {
    @Autowired
    private AdPlanRepository planRepository;
    @Autowired
    private AdUnitRepository unitRepository;
    @Autowired
    private CreativeRepository creativeRepository;
    @Autowired
    private CreativeUnitRepository creativeUnitRepository;
    @Autowired
    private AdUnitDistrictRepository unitDistrictRepository;
    @Autowired
    private AdUnitItRepository unitItRepository;
    @Autowired
    private AdUnitKeywordRepository unitKeywordRepository;

    @Test
    public void dumpAdTableData() {
        dumpAdPlanTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_PLAN)
        );
        dumpAdUnitTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_UNIT)
        );
        dumpAdCreativeTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_CREATIVE)
        );
        dumpAdCreativeUnitTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_CREATIVE_UNIT)
        );
        dumpAdUnitDistrictTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_UNIT_DISTRICT)
        );
        dumpAdUnitItTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_UNIT_IT)
        );
        dumpAdUnitKeywordTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_UNIT_KEYWORD)
        );
    }

    private void dumpAdPlanTable(String fileName) {
        List<AdPlan> adPlans = planRepository.findAllByPlanStatus(
                CommonStatus.VALID.getStatus()
        );
        if (CollectionUtils.isEmpty(adPlans)) {
            return;
        }
        List<AdPlanTable>  planTables = new ArrayList<>();
        adPlans.forEach(p -> planTables.add(
                new AdPlanTable(p.getId(), p.getUserId(), p.getPlanStatus(),
                        p.getStartDate(), p.getEndDate())));
        Path path = Paths.get(fileName);
        try {
            BufferedWriter writer = Files.newBufferedWriter(path);
            for (AdPlanTable adPlanTable : planTables) {
                writer.write(JSON.toJSONString(adPlanTable));
                writer.newLine();
            }
            writer.close();
        } catch (IOException ioe) {
            log.error("dumpAdPlanTable error");
        }
    }

    private void dumpAdUnitTable(String filename) {
        List<AdUnit> adUnits = unitRepository.findAllByUnitStatus(
                CommonStatus.VALID.getStatus()
        );
        if (CollectionUtils.isEmpty(adUnits)) {
            return;
        }
        List<AdUnitTable>  unitTables = new ArrayList<>();
        adUnits.forEach(u -> unitTables.add(
                new AdUnitTable(u.getId(), u.getPlanId(), u.getUnitStatus(),
                        u.getPositionType())));
        Path path = Paths.get(filename);
        try {
            BufferedWriter writer = Files.newBufferedWriter(path);
            for (AdUnitTable adUnitTable : unitTables) {
                writer.write(JSON.toJSONString(adUnitTable));
                writer.newLine();
            }
            writer.close();
        } catch (IOException ioe) {
            log.error("dumpAdUnitTable error");
        }
    }
    private void dumpAdCreativeTable(String filename) {
        List<Creative> creatives = creativeRepository.findAll();
        if (CollectionUtils.isEmpty(creatives)) {
            return;
        }
        List<AdCreativeTable> creativeTables = new ArrayList<>();
        creatives.forEach(c -> creativeTables.add(
                new AdCreativeTable(c.getId(), c.getName(), c.getType(), c.getMaterialType(),
                        c.getHeight(), c.getWidth(), c.getAuditStatus(), c.getUrl()))
                );
        Path path = Paths.get(filename);
        try {
            BufferedWriter writer = Files.newBufferedWriter(path);
            for (AdCreativeTable creativeTable : creativeTables) {
                writer.write(JSON.toJSONString(creativeTable));
                writer.newLine();
            }
            writer.close();
        } catch (IOException ioe) {
            log.error("dumpAdCreativeTable error");
        }
    }

    private void dumpAdCreativeUnitTable(String filename) {
        List<CreativeUnit> creativeUnits = creativeUnitRepository.findAll();
        if (CollectionUtils.isEmpty(creativeUnits)) {
            return;
        }
        List<AdCreativeUnitTable> creativeUnitTables = new ArrayList<>();
        creativeUnits.forEach(cu -> creativeUnitTables.add(
                new AdCreativeUnitTable(cu.getId(), cu.getUnitId())
        ));
        Path path = Paths.get(filename);
        try {
            BufferedWriter writer = Files.newBufferedWriter(path);
            for (AdCreativeUnitTable creativeUnitTable : creativeUnitTables) {
                writer.write(JSON.toJSONString(creativeUnitTable));
                writer.newLine();
            }
            writer.close();
        } catch (IOException ioe) {
            log.error("dumpAdCreativeUnitTable error");
        }
    }

    private void dumpAdUnitDistrictTable(String filename) {
        List<AdUnitDistrict> adUnitDistricts = unitDistrictRepository.findAll();
        if (CollectionUtils.isEmpty(adUnitDistricts)) {
            return;
        }
        List<AdUnitDistrictTable> unitDistrictTables = new ArrayList<>();
        adUnitDistricts.forEach(ud -> unitDistrictTables.add(
                new AdUnitDistrictTable(ud.getUnitId(), ud.getProvince(), ud.getCity())
        ));
        Path path = Paths.get(filename);
        try {
            BufferedWriter writer = Files.newBufferedWriter(path);
            for (AdUnitDistrictTable adUnitDistrictTable : unitDistrictTables) {
                writer.write(JSON.toJSONString(adUnitDistrictTable));
                writer.newLine();
            }
            writer.close();
        } catch (IOException ioe) {
            log.error("dumpAdUnitDistrictTable error");
        }
    }

    private void dumpAdUnitItTable(String filename) {
        List<AdUnitIt> adUnitIts = unitItRepository.findAll();
        if (CollectionUtils.isEmpty(adUnitIts)) {
            return;
        }
        List<AdUnitItTable> unitItTables = new ArrayList<>();
        adUnitIts.forEach(ut -> unitItTables.add(
                new AdUnitItTable(ut.getUnitId(), ut.getItTag())
        ));
        Path path = Paths.get(filename);
        try {
            BufferedWriter writer = Files.newBufferedWriter(path);
            for (AdUnitItTable adUnitItTable : unitItTables) {
                writer.write(JSON.toJSONString(adUnitItTable));
                writer.newLine();
            }
            writer.close();
        } catch (IOException ioe) {
            log.error("dumpAdUnitItTable error");
        }
    }

    private void dumpAdUnitKeywordTable(String filename) {
        List<AdUnitKeyword> adUnitKeywords = unitKeywordRepository.findAll();
        if (CollectionUtils.isEmpty(adUnitKeywords)) {
            return;
        }
        List<AdUnitKeywordTable> unitKeywordTables = new ArrayList<>();
        adUnitKeywords.forEach(uk -> unitKeywordTables.add(
                new AdUnitKeywordTable(uk.getUnitId(), uk.getKeyword())
        ));
        Path path = Paths.get(filename);
        try {
            BufferedWriter writer = Files.newBufferedWriter(path);
            for (AdUnitKeywordTable adUnitKeywordTable : unitKeywordTables) {
                writer.write(JSON.toJSONString(adUnitKeywordTable));
                writer.newLine();
            }
            writer.close();
        } catch (IOException ioe) {
            log.error("dumpAdUnitKeywordTable error");
        }
    }
}
