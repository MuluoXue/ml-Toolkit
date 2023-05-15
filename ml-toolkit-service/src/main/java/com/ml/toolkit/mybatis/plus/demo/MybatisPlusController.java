package com.ml.toolkit.mybatis.plus.demo;

import com.ml.toolkit.common.collection.ListUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ml
 * @date 2023年05月08日 20:35
 */
@RestController
@RequestMapping("/mybatisPlus")
public class MybatisPlusController {

    public static final int DATA_SIZE = 1000;

    @Resource
    private DemoDao demoDao;

    @Resource
    private DemoService demoService;

    @RequestMapping("/test")
    public void test() {
        List<Demo> list = new ArrayList<>();
        for (int i = 0; i < DATA_SIZE; i++) {
            Demo demo = new Demo();
            demo.setName("ml" + i);
            demo.setAge(i);
            demo.setGender(1);
            list.add(demo);
        }
        // 自定义方法插入,执行分片
        List<List<Demo>> partition = ListUtil.partition(list, 100);
        for (List<Demo> demoList : partition) {
            demoDao.insertBatchSomeColumn(demoList);
        }
    }

    @RequestMapping("/sqlInterceptor")
    public void sqlInterceptor() {
        Demo demo = new Demo();
        demo.setGender(1);
        // 自定义方法插入,执行分片
        demoService.save(demo);
    }
}
