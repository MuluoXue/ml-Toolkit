package com.ml.toolkit.form.dao.data;

import com.ml.toolkit.form.domain.data.FormDataDetail;
import com.ml.toolkit.mybatis.plus.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ml
 * @date 2023年05月06日 22:50
 */
@Mapper
public interface FormDataDetailDao extends BaseDao<FormDataDetail> {

    List<FormDataDetail> listByDataIdList(@Param("dataIdList") List<Long> dataIdList);

    void deleteByFormDataIds(@Param("dataIdList") List<Long> idList);
}
