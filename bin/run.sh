#!/bin/bash

rm -rf testdb; 

CLASSPATH=lib/*:. vertx run  src/TestDerbyUpdate.java 
