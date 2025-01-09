FROM eclipse-temurin:17-jdk-alpine
ENV TZ=America/Sao_Paulo
ENV CEP_DATABASE_URL=jdbc:postgresql://localhost:5432/your_database
ENV CEP_DATABASE_USERNAME=your_username
ENV CEP_DATABASE_PASSWORD=your_password
ENV URL_API_EXTERNO_VIA_CEP=url_api_via_cep
VOLUME /tmp
COPY target/api-cep-0.0.1-SNAPSHOT.jar api-cep.jar
ENTRYPOINT ["java","-Duser.timezone=America/Sao_Paulo","-jar","/api-cep.jar"]