#!/bin/bash
rm -rf ./out
javac -classpath ./libs/commons-lang3-3.4.jar -d out $(find . -type f ! -name "module-info.java" -name "*.java")
