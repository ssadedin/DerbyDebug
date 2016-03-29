# Demonstration of Failure in Apache Derby with Vert.x

This failure occurs when updating rows via the Vert.x SQLConnection class.

To run it:

 * Install Vert.x, eg. by using [SDKMan](http://sdkman.io/).
 * You may need to remove the Ceylon jar file from the Vert.x distribution because it causes a bug. eg:

     rm ~/.sdkman/candidates/vertx/3.2.0/lib/*ceylon*

 * Run the example using the script:

     ./bin/run.sh

