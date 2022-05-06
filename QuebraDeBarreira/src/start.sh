#!/bin/bash

make
rm  controller/*.class view/*.class model/*.class dao/*.class control/*.class
clear
java -jar QuebraDeBarreira.jar