# step one: build application image
docker build -t docker-spring-boot .

# step two: run application image
docker-compose up -d



For test the webservice
http:/localhost:8085/BHR
