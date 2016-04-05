package it.csttech.formattingtools;

public class ChangeFormatCSVtoFW implements ChangeFormat {

	private static final int FIXED_WIDTH = 20;
  	private static final char SEPARATOR = ';';
  	private static final char EMPTY_CHAR = ' ';
  	private static final char END_CHAR = '*';

	public String transformString(String inputString) {
		char[] charInputString = inputString.toCharArray();
		StringBuilder builder = new StringBuilder(); //close? garbage?
		int count = 0;
		for (int i = 0; i < charInputString.length; i++) {
			if (charInputString[i] == SEPARATOR) {
				for (int j = 0; j < FIXED_WIDTH - count; j++)
					builder.append(EMPTY_CHAR);
				count=0;
			}else if (i == charInputString.length - 1){
				builder.append(charInputString[i]);
				count++;
				for (int j = 0; j < FIXED_WIDTH - count; j++)
					builder.append(EMPTY_CHAR);
				builder.append(END_CHAR);
			}else{
				builder.append(charInputString[i]);
				count++;
			}
		}

		return builder.toString();
	}
//righe con numero campi errato in outputfile diverso o da saltare o come vuoi
}
