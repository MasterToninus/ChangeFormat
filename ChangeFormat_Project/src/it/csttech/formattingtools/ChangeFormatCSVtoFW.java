package it.csttech.formattingtools;

public class ChangeFormatCSVtoFW extends BaseChangeFormat implements ChangeFormat {

	@Override //usare metodi di String per tokenize e formattare fare anche FWtoCSV
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
