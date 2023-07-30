package com.ml.toolkit.config;
import com.ml.toolkit.service.kzz.KzzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * 定时任务
 * @author ml
 * @date 2023年03月02日 22:31
 */
@Slf4j
@Component
public class ScheduledTask implements Serializable {
    private static final long serialVersionUID = 7613250391877199357L;

    @Resource
    private KzzService kzzService;

    /**
     * 获取集思录数据
     */
    @Scheduled(cron = "0 10 15 * * ?")
    public void gradJiSiLuData() {
        try {
            kzzService.gradJiSiLuData();
        } catch (Exception e) {
            log.error("ScheduledTask gradJiSiLuData error", e);
        }
    }

}
