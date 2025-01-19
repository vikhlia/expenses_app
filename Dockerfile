FROM maven:3.8.4-openjdk:17-jdk-slim AS build

# Копируем pom.xml и зависимости
COPY pom.xml .

# Копируем исходный код
COPY src ./src

# Собираем проект
RUN mvn clean package

# Используем JDK 17 для запуска (вместо Maven образа)
FROM openjdk:17-jdk-slim

# Копируем собранный артефакт
COPY target/vikhlia-1.0.1-SNAPSHOT.jar vikhlia-1.0.1-SNAPSHOT.jar

# Указываем команду для запуска приложения
CMD ["java","-jar","/vikhlia-1.0.1-SNAPSHOT.jar"]
