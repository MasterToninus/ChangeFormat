#!/bin/bash 

	MAIN_CLASS_FILE="it.csttech.placeholderpackage.PlaceHolderClass"
	CLASS_PATH=".;lib/*;bin/classes"


	echo "---------------------------------"
	echo "*** Launching $FILENAME.class $@ ***"
	echo "---------------------------------"
	echo " "


    java -cp $CLASS_PATH $MAIN_CLASS_FILE $@
	
	echo " "
	echo "---------------------------------"
	
