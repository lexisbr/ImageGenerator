#! /bin/bash 
echo "STARTING COMPILING"
java -jar jflex-full-1.8.2.jar CapasLexer.jflex
java -jar java-cup-11b.jar -parser CapasParser -symbols symCapas CapasParser.cup