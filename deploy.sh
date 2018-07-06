#!/bin/bash
mvn clean install
cd `dirname $0`
for filename in `find .  -type f  -name '*-jar-without-dependencies.jar' | sort `;do
echo $filename
done
nohup java -jar $filename >/dev/null 2>&1 &
echo $! > ./wwwhackcom_project.pid
echo '[success!]'
sleep 5
open  http://localhost:8081/apis-docs.html
