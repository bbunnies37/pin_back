FROM openjdk:17-alpine

# set arg
ARG WORKSPACE=/home/spring-docker
ARG BUILD_TARGET=${WORKSPACE}/build/libs
WORKDIR ${WORKSPACE}

# copy code & build
COPY . .
RUN ./gradlew clean bootJar

WORKDIR ${BUILD_TARGET}
RUN jar -xf *.jar

EXPOSE 8080/tcp
ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]
