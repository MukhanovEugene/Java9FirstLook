#!/bin/bash
rm -rf image
jlink --module-path jars/:$JAVA_HOME/jmods --add-modules easytext.cli,easytext.analysis.coleman,easytext.analysis.kincaid --strip-debug --compress=2 --output image --launcher launch=easytext.cli/javamodularity.easytext.cli.Main
