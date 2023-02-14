mvn clean package -DskipTests
docker login registry.gitlab.com
docker build -t registry.gitlab.com/canevim/mp-booking-service:arm64-dev . --platform linux/arm64
docker push registry.gitlab.com/canevim/mp-booking-service:arm64-dev
