FROM java:8

MAINTAINER zhaoziyun zhaoziyun890217@163.com

VOLUME /tmp

ADD tencent-video-api.jar openApi.jar

RUN bash -c 'touch /openApi.jar'

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "openApi.jar"]
