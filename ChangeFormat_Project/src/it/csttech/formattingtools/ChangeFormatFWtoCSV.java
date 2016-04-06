package it.csttech.formattingtools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class contains the definition of the string format conversion from  a FW to CSV
 *
*/
public class ChangeFormatFWtoCSV extends BaseChangeFormat implements ChangeFormat {

	private static final Logger log = LogManager.getLogger();

/**
 * 	String transformation method.
 *	<p>
 * 		It requires that the input string is correctly formatted.
 *  </p>
 * 	@param inputString string to be performed
 * 	@return trasformed string or a void string in case the input is not a FW string
*/
	@Override 
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
