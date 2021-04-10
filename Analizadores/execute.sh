#! /bin/bash 
echo "STARTING COMPILING"
java -jar jflex-full-1.8.2.jar UsersLexer.jflex
java -jar java-cup-11b.jar -parser UsersParser -symbols symUsers UsersParser.cup
