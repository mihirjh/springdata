FROM fabric8/java-alpine-openjdk8-jdk
ENV JAVA_APP_JAR mihirSpringBootJPA-1.0.0.jar
ENV AB_OFF true
ADD target/mihirSpringBootJPA-1.0.0.jar /deployments/
