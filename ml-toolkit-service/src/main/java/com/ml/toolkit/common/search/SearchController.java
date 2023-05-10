package com.ml.toolkit.common.search;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ml
 * @date 2023年05月10日 22:13
 */
@RestController
@RequestMapping("/search")
public class SearchController {

    @RequestMapping("/generateSql")
    public void generateSql(@RequestBody SearchDto dto) {
        System.out.println("--");
        String s = SearchSqlUtil.generateSql(dto.getParamList(), dto.getCondition());
        System.out.println(s);
    }
}
