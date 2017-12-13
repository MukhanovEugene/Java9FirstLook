#!/bin/bash
rm -rf jars && mkdir -p jars
jar --create --file jars/easytext.analysis.api.jar -C out/easytext.analysis .
jar --create --file jars/easytext.analysis.coleman.jar -C out/easytext.analysis.coleman .
jar --create --file jars/easytext.analysis.kincaid.jar -C out/easytext.analysis.kincaid .
jar --create --file jars/easytext.analysis.cli.jar --main-class=javamodularity.easytext.cli.Main -C out/easytext.cli .
