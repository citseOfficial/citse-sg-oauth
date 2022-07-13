FROM bellsoft/liberica-openjdk-alpine:latest
RUN apk add -U tzdata
ENV TZ America/Lima
RUN ln -snf /usr/share/zoneinfo/${TZ} /etc/localtime
RUN echo "${TZ}" > /etc/timezone
VOLUME /tmp
EXPOSE 8761
ADD ./target/citse-sg-oauth-0.0.1-SNAPSHOT.jar oauth.jar
ENTRYPOINT ["java", "-jar", "/oauth.jar"]