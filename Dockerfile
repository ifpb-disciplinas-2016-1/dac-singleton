FROM jboss/wildfly
ENV DEPLOY /opt/jboss/wildfly/standalone/deployments/
ADD target/singleton.war ${DEPLOY}
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-c", "standalone.xml", "-b", "0.0.0.0"]
