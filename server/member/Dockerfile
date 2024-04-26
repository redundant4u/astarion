FROM eclipse-temurin:17-jre-alpine

WORKDIR /home/astarion

RUN ln -sf /usr/share/zoneinfo/Asia/Seoul /etc/localtime

COPY dependencies .
COPY spring-boot-loader .
COPY snapshot-dependencies .
COPY application .

ENTRYPOINT [ \
    "java", \
    "-Dspring.profiles.active=deploy", \
    "-Duser.timezone=Asia/Seoul", \
    "org.springframework.boot.loader.launch.JarLauncher" \
]
