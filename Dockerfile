FROM docker.io/jboss/keycloak:6.0.1
COPY target/keycloak-group-password-policy-0.1-SNAPSHOT.jar /opt/jboss/keycloak/standalone/deployments
RUN /opt/jboss/keycloak/bin/add-user-keycloak.sh -u admin -p admin
#RUN /opt/jboss/keycloak/
