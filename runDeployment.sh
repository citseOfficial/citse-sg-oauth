#!/bin/bash -ex
echo "Deploying app.jar to coker folder"
packageName=`ls target/*.jar`
versionid=`echo $packageName | awk -F "-" '{print $2}'`
versionName=`echo $packageName | awk -F "-" '{print $3}' | awk -F "." '{print $1}'`
version=`echo $versionid-$versionName`
dockerImageName=citse-sg-oauth
dockerpid=`docker ps -a | grep $dockerImageName | grep "Up" | awk -F " " '{print $1}'`
if [[ $dockerpid != "" ]];then
      docker stop $dockerpid
      docker rm $dockerpid
fi
docker build -t $dockerImageName:v1 .
docker run -d -p 0005:0005 --name $dockerImageName --network citse-server $dockerImageName:v1
dockerImageId=`docker images | grep $dockerImageName | grep v1 | awk -F " " '{print $3}'`
docker tag $dockerImageId $dockerImageName:v1
docker rmi $(docker images -f "dangling=true" -q)