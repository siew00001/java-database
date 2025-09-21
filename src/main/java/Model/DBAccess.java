package Model;

import com.example.jooq.codegen.tables.Liste;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;

public class DBAccess {
    DSLContext context = new DefaultDSLContext(SQLDialect.SQLITE);

    public Result<Record> getAllProducts(){
        return context.select().from(Liste.LISTE).fetch();
    }
}
