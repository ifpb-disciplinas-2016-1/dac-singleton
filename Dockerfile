FROM payara/server-full
ENV DOMAIN domain1
RUN echo 'AS_ADMIN_PASSWORD=admin\n\
 EOF\n'\
>> /opt/pwdfile

RUN \
 $PAYARA_PATH/bin/asadmin start-domain ${DOMAIN} && \
 #$PAYARA_PATH/bin/asadmin --user admin --passwordfile=/opt/pwdfile enable-secure-admin && \
 $PAYARA_PATH/bin/asadmin --user admin --passwordfile=/opt/pwdfile 


ENV DEPLOY ${PAYARA_PATH}/glassfish/domains/${DOMAIN}/autodeploy/
ENTRYPOINT $PAYARA_PATH/bin/asadmin start-domain --verbose ${DOMAIN}
WORKDIR /opt/payara41/glassfish/bin
ADD target/singleton.war ${DEPLOY}


#FROM jboss/wildfly
#ENV DEPLOY /opt/jboss/wildfly/standalone/deployments/
#ADD target/singleton.war ${DEPLOY}
#CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-c", "standalone.xml", "-b", "0.0.0.0"]
#RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#007 --silent
#CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
#RUN /opt/jboss/wildfly/bin/add-user.sh -a ricardojob job.2016 --silent
#CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-c", "standalone.xml", "-b", "0.0.0.0"]
