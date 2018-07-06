#!/bin/bash
PID=$(cat ./wwwhackcom_project.pid)
kill -9 $PID
