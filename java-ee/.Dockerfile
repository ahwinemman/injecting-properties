FROM jboss/wildfly:15.0.0.Final

MAINTAINER emmanuelthecoolest@rocketmail.com

ADD target/javaee-injectprops.war /opt/jboss/wildfly/standalone/deployments/javaee-injectprops.war

CMD [java -jar ]

EXPOSE 8080