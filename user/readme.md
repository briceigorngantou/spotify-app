<!-- Build application -->
docker compose build

<!-- Create new network  -->
docker network create java_microservice

<!-- Update application properties -->
spring.datasource.url=jdbc:mariadb://${COMPOSE_PROJECT_NAME:-}_database:3306/user_db?useTimezone=true&serverTimezone=UTC
spring.datasource.username=springuser
spring.datasource.password=ThePassword
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MariaDBDialect
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
spring.jpa.show-sql=true

<!-- Create composer -->
docker composer up
