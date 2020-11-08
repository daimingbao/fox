FROM jre
VOLUME /tmp
COPY target/*.jar fox-1.0.jar
RUN sh -c "touch /fox-1.0.jar"
EXPOSE 12345
ENTRYPOINT ["java","-jar","fox-1.0.jar"]