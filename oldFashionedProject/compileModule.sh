#!/bin/bash
rm -rf ./outModule
javac --module-path ./libs/ --module-source-path src -d outModule $(find . -name '*.java')
