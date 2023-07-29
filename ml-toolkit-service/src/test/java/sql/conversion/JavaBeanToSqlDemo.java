package sql.conversion;

import com.ml.toolkit.domain.sql.SqlExecutionRecord;
import com.ml.toolkit.form.domain.data.FormDataDetail;
import com.ml.toolkit.form.domain.form.Form;
import com.ml.toolkit.form.domain.sys.SimpleUser;
import com.toolkit.sql.conversion.util.JavaBeanToSqlUtil;
import org.junit.Test;

import java.io.Serializable;
import java.util.Date;

public class JavaBeanToSqlDemo implements Serializable {

    private static final long serialVersionUID = -2722072876965496989L;

    @Test
    public void toSql() {
        System.out.println(JavaBeanToSqlUtil.toCreateSql(new SqlExecutionRecord(), "sql_execution_record"));
    }

    @Test
    public void toInsertSql() {
        Form form = new Form();
        form.setId(1L);
        form.setName("ceshi");
        SimpleUser user = new SimpleUser();
        user.setId(2L);
        form.setCreator(user);
        form.setCreateTime(new Date());

        System.out.println(JavaBeanToSqlUtil.toInsertSql(form, null));
    }
}
