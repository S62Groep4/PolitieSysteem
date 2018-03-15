FROM payara/server-full:181

RUN wget http://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-5.1.46.tar.gz

RUN tar -xvzf mysql-connector-java-5.1.46.tar.gz

RUN mv mysql-connector-java-5.1.46/mysql-connector-java-5.1.45.jar ~/glassfish/domains/domain1/lib/

RUN rm -rf mysql-connector-java-5.1.45

COPY ./target/*.war /opt/payara41/deployments
