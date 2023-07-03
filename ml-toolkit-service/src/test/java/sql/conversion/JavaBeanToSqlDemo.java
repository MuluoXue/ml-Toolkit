package sql.conversion;

import com.ml.toolkit.form.domain.data.FormDataDetail;
import com.toolkit.sql.conversion.util.JavaBeanToSqlUtil;
import org.junit.Test;

import java.io.Serializable;

public class JavaBeanToSqlDemo implements Serializable {

    private static final long serialVersionUID = -2722072876965496989L;

    @Test
    public void toSql() {
        System.out.println(JavaBeanToSqlUtil.toCreateSql(new FormDataDetail(), null));
    }
}
