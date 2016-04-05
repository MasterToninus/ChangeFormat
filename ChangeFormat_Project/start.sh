#!/bin/bash 

	MAIN_CLASS_FILE="it.csttech.formattingtools.UseChangeFormat"
	CLASS_PATH=".;lib/*;bin"


	echo "---------------------------------"
	echo "*** Launching $MAIN_CLASS_FILE $@ ***"
	echo "---------------------------------"
	echo " "


	java -cp $CLASS_PATH $MAIN_CLASS_FILE $@
	
	echo " "
	echo "---------------------------------"
	
