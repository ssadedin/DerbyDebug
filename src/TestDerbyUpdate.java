import java.util.HashMap;
import java.util.Map;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.sql.UpdateResult;

public class TestDerbyUpdate extends AbstractVerticle {
    
    public static final JsonObject DB_CONFIG = new JsonObject() {{
        put("url", "jdbc:derby:testdb;create=true");
        put("driver_class","org.apache.derby.jdbc.EmbeddedDriver");
    }};
    
    public static final String CREATE_TABLE = 
        "create table PIPELINE_COMMAND ("+
                "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) primary key,"+
                "pipeline_id integer, "+
                "pguid varchar(40),"+
                "command varchar(512),"+
                "arguments varchar(512),"+
                "status varchar(15)"+
         ")";    
        

    @Override
    public void start() throws Exception {
        
        System.out.println("Started!");
        
        System.out.println("The java version is " + System.getProperty("java.version"));
        
        Vertx vertx = getVertx();
        
         JDBCClient jdbc = JDBCClient.createShared(vertx, DB_CONFIG);
        
         jdbc.getConnection( (AsyncResult<SQLConnection> result) ->  { 
             SQLConnection conn = result.result();
             
             conn.execute(CREATE_TABLE, (AsyncResult<Void> res) -> {
                 if(res.succeeded()) {
                     System.out.println("Create table suceeded");
                     doInsert(conn);
                 }
                 else {
                     System.out.println("Create table failed: ");
                     res.cause().printStackTrace();
                 }
             });
         });
    }
    
    void doInsert(SQLConnection conn) {
         conn.execute("insert into PIPELINE_COMMAND (PIPELINE_ID, PGUID, COMMAND, ARGUMENTS, STATUS) "+ 
                      "values (1, 'pguid','command','args','status')",
                      (AsyncResult<Void> res) -> {
                          if(res.succeeded())
                               doUpdate(conn);
                          else {
                              System.out.println("Insert failed: ");
                              res.cause().printStackTrace();
                          }
                      });
        
    }
    
    void doUpdate(SQLConnection conn) {
        
        conn.update("update PIPELINE_COMMAND set status='bar' where pipeline_id = 1", (AsyncResult<UpdateResult> res) -> {
            if(res.succeeded()) {
                System.out.println("The update succeeded!");
            }
            else {
                System.out.println("The update failed :-(\n");
                res.cause().printStackTrace();
            }
        });
        
    }
}
