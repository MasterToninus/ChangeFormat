package it.csttech.formattingtools;

import org.apache.log4j.Logger;

public class ChangeFormatFWtoCSV implements ChangeFormat {

	static final Logger log = Logger.getRootLogger();

	private static final int FIXED_WIDTH = 20;
  	private static final char SEPARATOR = ';';
  	private static final char END_CHAR = '*';

	//Non presuppone la conoscenza di FIXED_WIDTH ma può generare un problema se fra un campo e un altro rimane un singolo spazio
	/* 
	public String transformString(String inputString) {
		StringBuilder builder = new StringBuilder(); //close? garbage?
		String[] splitted = inputString.split("\\s{2,}|\\" + END_CHAR);
		for (int i = 0; i < splitted.length; i++)  //TODO change for(String line : splitted)
			builder.append(splitted[i] + SEPARATOR);

		builder.deleteCharAt(builder.length() - 1);
		return builder.toString();
	}*/

	//Più sicuro a patto di conoscere FIXED_WIDTH
	public String transformString(String inputString) {
		StringBuilder builder = new StringBuilder(); //close? garbage?
		int fieldsNumber;
		if ((inputString.length() - 1) % FIXED_WIDTH == 0) {

			fieldsNumber = (inputString.length() - 1) / FIXED_WIDTH;

			for (int i = 0; i < fieldsNumber; i++)
				builder.append(inputString.substring(i*FIXED_WIDTH, (i+1)*FIXED_WIDTH).trim() + SEPARATOR);
			
			builder.deleteCharAt(builder.length() - 1);

		}else{
			log.warn("Line bad format. Skipped and continue!");
		}
		
		return builder.toString();
	}

}
