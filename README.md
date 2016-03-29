# Demonstration of Failure in Apache Derby with Vert.x

This failure occurs when updating rows via the Vert.x SQLConnection class.

To run it:

 * Install Vert.x, eg. by using [SDKMan](http://sdkman.io/).
 * You may need to remove the Ceylon jar file from the Vert.x distribution because it causes a bug. eg:

     `rm ~/.sdkman/candidates/vertx/3.2.0/lib/*ceylon*`

 * Run the example using the script:

     ./bin/run.sh

The output I get when I run the program is:

```
MLog initialization issue: slf4j found no binding or threatened to use its (dangerously silent) NOPLogger. We consider the slf4j library not found.
MLog clients using java 1.4+ standard logging. 
Initializing c3p0-0.9.5.1 [built 16-June-2015 00:06:36 -0700; debug? true; trace: 10] 
Succeeded in deploying verticle 
Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 3, acquireRetryAttempts -> 30, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> false, checkoutTimeout -> 0, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, contextClassLoaderSource -> caller, dataSourceName -> 1hgekzc9f1ht6moa1pe4s5h|3399283d, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> org.apache.derby.jdbc.EmbeddedDriver, extensions -> {}, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, forceSynchronousCheckins -> false, forceUseNamedDriverClass -> false, identityToken -> 1hgekzc9f1ht6moa1pe4s5h|3399283d, idleConnectionTestPeriod -> 0, initialPoolSize -> 3, jdbcUrl -> jdbc:derby:testdb;create=true, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 0, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 15, maxStatements -> 0, maxStatementsPerConnection -> 0, minPoolSize -> 3, numHelperThreads -> 3, preferredTestQuery -> null, privilegeSpawnedThreads -> false, properties -> {}, propertyCycle -> 0, statementCacheNumDeferredCloseThreads -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, userOverrides -> {}, usesTraditionalReflectiveProxies -> false ] 
Database 'testdb' not created, connection made to existing database instead. 
java.sql.SQLWarning: Database 'testdb' not created, connection made to existing database instead.
	at org.apache.derby.iapi.error.SQLWarningFactory.newSQLWarning(SQLWarningFactory.java:54)
	at org.apache.derby.impl.jdbc.EmbedConnection.createDatabase(EmbedConnection.java:2652)
	at org.apache.derby.impl.jdbc.EmbedConnection.<init>(EmbedConnection.java:435)
	at org.apache.derby.jdbc.InternalDriver$1.run(InternalDriver.java:663)
	at org.apache.derby.jdbc.InternalDriver$1.run(InternalDriver.java:659)
	at java.security.AccessController.doPrivileged(Native Method)
	at org.apache.derby.jdbc.InternalDriver.getNewEmbedConnection(InternalDriver.java:657)
	at org.apache.derby.jdbc.InternalDriver.connect(InternalDriver.java:306)
	at org.apache.derby.jdbc.InternalDriver.connect(InternalDriver.java:963)
	at org.apache.derby.jdbc.AutoloadedDriver.connect(AutoloadedDriver.java:147)
	at com.mchange.v2.c3p0.DriverManagerDataSource.getConnection(DriverManagerDataSource.java:161)
	at com.mchange.v2.c3p0.WrapperConnectionPoolDataSource.getPooledConnection(WrapperConnectionPoolDataSource.java:161)
	at com.mchange.v2.c3p0.WrapperConnectionPoolDataSource.getPooledConnection(WrapperConnectionPoolDataSource.java:147)
	at com.mchange.v2.c3p0.impl.C3P0PooledConnectionPool$1PooledConnectionResourcePoolManager.acquireResource(C3P0PooledConnectionPool.java:202)
	at com.mchange.v2.resourcepool.BasicResourcePool.doAcquire(BasicResourcePool.java:1138)
	at com.mchange.v2.resourcepool.BasicResourcePool.doAcquireAndDecrementPendingAcquiresWithinLockOnSuccess(BasicResourcePool.java:1125)
	at com.mchange.v2.resourcepool.BasicResourcePool.access$700(BasicResourcePool.java:44)
	at com.mchange.v2.resourcepool.BasicResourcePool$ScatteredAcquireTask.run(BasicResourcePool.java:1870)
	at com.mchange.v2.async.ThreadPoolAsynchronousRunner$PoolThread.run(ThreadPoolAsynchronousRunner.java:696)

Database 'testdb' not created, connection made to existing database instead. 
java.sql.SQLWarning: Database 'testdb' not created, connection made to existing database instead.
	at org.apache.derby.iapi.error.SQLWarningFactory.newSQLWarning(SQLWarningFactory.java:54)
	at org.apache.derby.impl.jdbc.EmbedConnection.createDatabase(EmbedConnection.java:2652)
	at org.apache.derby.impl.jdbc.EmbedConnection.<init>(EmbedConnection.java:435)
	at org.apache.derby.jdbc.InternalDriver$1.run(InternalDriver.java:663)
	at org.apache.derby.jdbc.InternalDriver$1.run(InternalDriver.java:659)
	at java.security.AccessController.doPrivileged(Native Method)
	at org.apache.derby.jdbc.InternalDriver.getNewEmbedConnection(InternalDriver.java:657)
	at org.apache.derby.jdbc.InternalDriver.connect(InternalDriver.java:306)
	at org.apache.derby.jdbc.InternalDriver.connect(InternalDriver.java:963)
	at org.apache.derby.jdbc.AutoloadedDriver.connect(AutoloadedDriver.java:147)
	at com.mchange.v2.c3p0.DriverManagerDataSource.getConnection(DriverManagerDataSource.java:161)
	at com.mchange.v2.c3p0.WrapperConnectionPoolDataSource.getPooledConnection(WrapperConnectionPoolDataSource.java:161)
	at com.mchange.v2.c3p0.WrapperConnectionPoolDataSource.getPooledConnection(WrapperConnectionPoolDataSource.java:147)
	at com.mchange.v2.c3p0.impl.C3P0PooledConnectionPool$1PooledConnectionResourcePoolManager.acquireResource(C3P0PooledConnectionPool.java:202)
	at com.mchange.v2.resourcepool.BasicResourcePool.doAcquire(BasicResourcePool.java:1138)
	at com.mchange.v2.resourcepool.BasicResourcePool.doAcquireAndDecrementPendingAcquiresWithinLockOnSuccess(BasicResourcePool.java:1125)
	at com.mchange.v2.resourcepool.BasicResourcePool.access$700(BasicResourcePool.java:44)
	at com.mchange.v2.resourcepool.BasicResourcePool$ScatteredAcquireTask.run(BasicResourcePool.java:1870)
	at com.mchange.v2.async.ThreadPoolAsynchronousRunner$PoolThread.run(ThreadPoolAsynchronousRunner.java:696)

Create table suceeded
The update failed :-(

java.sql.SQLDataException: Invalid character string format for type long.
	at org.apache.derby.impl.jdbc.SQLExceptionFactory.getSQLException(SQLExceptionFactory.java:84)
	at org.apache.derby.impl.jdbc.Util.generateCsSQLException(Util.java:233)
	at org.apache.derby.impl.jdbc.TransactionResourceImpl.wrapInSQLException(TransactionResourceImpl.java:424)
	at org.apache.derby.impl.jdbc.TransactionResourceImpl.handleException(TransactionResourceImpl.java:353)
	at org.apache.derby.impl.jdbc.EmbedConnection.handleException(EmbedConnection.java:2405)
	at org.apache.derby.impl.jdbc.ConnectionChild.handleException(ConnectionChild.java:88)
	at org.apache.derby.impl.jdbc.EmbedStatement.executeStatement(EmbedStatement.java:1432)
	at org.apache.derby.impl.jdbc.EmbedPreparedStatement.executeStatement(EmbedPreparedStatement.java:1709)
	at org.apache.derby.impl.jdbc.EmbedPreparedStatement.executeLargeUpdate(EmbedPreparedStatement.java:320)
	at org.apache.derby.impl.jdbc.EmbedPreparedStatement.executeUpdate(EmbedPreparedStatement.java:309)
	at com.mchange.v2.c3p0.impl.NewProxyPreparedStatement.executeUpdate(NewProxyPreparedStatement.java:410)
	at io.vertx.ext.jdbc.impl.actions.JDBCUpdate.execute(JDBCUpdate.java:50)
	at io.vertx.ext.jdbc.impl.actions.JDBCUpdate.execute(JDBCUpdate.java:34)
	at io.vertx.ext.jdbc.impl.actions.AbstractJDBCAction.handle(AbstractJDBCAction.java:48)
	at io.vertx.ext.jdbc.impl.actions.AbstractJDBCAction.handle(AbstractJDBCAction.java:33)
	at io.vertx.core.impl.ContextImpl.lambda$executeBlocking$15(ContextImpl.java:296)
	at io.vertx.core.impl.OrderedExecutorFactory$OrderedExecutor.lambda$new$261(OrderedExecutorFactory.java:91)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
Caused by: ERROR 22018: Invalid character string format for type long.
	at org.apache.derby.iapi.error.StandardException.newException(StandardException.java:290)
	at org.apache.derby.iapi.error.StandardException.newException(StandardException.java:285)
	at org.apache.derby.iapi.types.SQLChar.getLong(SQLChar.java:447)
	at org.apache.derby.impl.sql.execute.UpdateResultSet.collectAffectedRows(UpdateResultSet.java:534)
	at org.apache.derby.impl.sql.execute.UpdateResultSet.open(UpdateResultSet.java:272)
	at org.apache.derby.impl.sql.GenericPreparedStatement.executeStmt(GenericPreparedStatement.java:473)
	at org.apache.derby.impl.sql.GenericPreparedStatement.execute(GenericPreparedStatement.java:352)
	at org.apache.derby.impl.jdbc.EmbedStatement.executeStatement(EmbedStatement.java:1340)
	... 13 more
```
