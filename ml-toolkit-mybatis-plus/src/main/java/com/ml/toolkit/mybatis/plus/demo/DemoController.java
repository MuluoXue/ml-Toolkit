//package com.ml.toolkit.mybatis.plus.demo;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author ml
// * @date 2023年05月06日 22:42
// */
//@RestController
//@RequestMapping("/api/dome")
//public class DemoController {
//
//    @Resource
//    private DemoService demoService;
//
//    @RequestMapping("/test")
//    public void test() {
//        List<Demo> list = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//            Demo demo = new Demo();
//            demo.setName("ml" + i);
//            demo.setAge(i);
//            demo.setGender(1);
//            list.add(demo);
//        }
    // 自定义方法插入,执行分片
//        List<List<Demo>> partition = ListUtil.partition(list, 100);
//        for (List<Demo> demoList : partition) {
//              demoService.insertBatchSomeColumn(demoList);
//        }
//        System.out.println(result);
//    }
//}
