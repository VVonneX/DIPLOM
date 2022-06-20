FROM adoptopenjdk:11
EXPOSE 8080
ADD build/libs/template-REST-1.0-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java","-jar","/backend.jar"]





# указываем точку монтирования для внешних данных внутри контейнера (как мы помним, это Линукс)
#VOLUME /tmp

# внешний порт, по которому наше приложение будет доступно извне
#EXPOSE 8099

# указываем, где в нашем приложении лежит джарник
#ARG JAR_FILE=/web-back/template-REST.jar

# добавляем джарник в образ под именем rebounder-chain-backend.jar
#ADD ${JAR_FILE} backend.jar

# команда запуска джарника
#ENTRYPOINT ["java","-jar","/backend.jar"]
