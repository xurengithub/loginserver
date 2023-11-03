FROM java:11 as buidler

WORKDIR /opt/app/loginserver

COPY pom.xml pom.xml
COPY src src
RUN mvn --also-make --batch-mode --errors clean install -DskipTests

FROM java:11
WORKDIR /opt/app
COPY --from=buidler /opt/app/loginserver/loginserver.jar .
ENTRYPOINT java -jar /opt/app/loginserver.jar