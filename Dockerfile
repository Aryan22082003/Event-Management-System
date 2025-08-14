# 1. Use Maven image with Java 21 for build stage
FROM maven:3.9.8-eclipse-temurin-21 AS builder

WORKDIR /app

# 2. Copy pom.xml and testng.xml first for caching
COPY pom.xml testng.xml ./
# UPDATED LINE: Added -U flag to force dependency update
RUN mvn dependency:go-offline -B -U

# 3. Copy source code
COPY src ./src

# 4. Package framework (skip tests during build)
RUN mvn clean package -DskipTests


# -------------------------
# Runtime container
# -------------------------
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Install Maven and Google Chrome.
RUN apt-get update && apt-get install -y maven wget gnupg \
 && wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - \
 && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list \
 && apt-get update && apt-get install -y google-chrome-stable \
 && rm -rf /var/lib/apt/lists/*

# Copy your project files from the builder stage
COPY --from=builder /app /app

# The command to run your tests
CMD ["mvn", "test"]