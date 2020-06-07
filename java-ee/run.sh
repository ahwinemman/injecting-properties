#!/bin/bash

if  ! mvn clean package;
then
  echo 'maven is not installed so use maven wrapper'
  ./mvnw clean package;
fi
docker build -t javaee-injectprops .

docker run -it -p 8080:8080 javaee-injectprops