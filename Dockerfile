# Utiliser une image de base Java
FROM openjdk:21-jdk-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le JAR de l'application dans le conteneur
COPY target/nextLine-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port sur lequel l'application écoute
EXPOSE 8081

# Définir la commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
