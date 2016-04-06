package it.csttech.formattingtools;

import org.apache.commons.cli.CommandLine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A simple format converter.
 * 
 * <p>
 * 	Format : FW, CSV
 *
 * </p>
 * 
 *
 * @author Drago-Orsone, (MasterTonius)
 * @todo. conversion metod csv -> db
 * @see 
 */
public class UseChangeFormat {

  public static final String CSV_FORMAT = "CSV";
  public static final String FW_FORMAT = "FW";
  public static final String IN_FILE_OPT = "i";
  public static final String OUT_FILE_OPT = "o";
  public static final String IN_FORMAT_OPT = "if";
  public static final String OUT_FORMAT_OPT = "of";
  public static final String HELP_OPT = "h";
  public static final String DEFAULT_IN_FILE = "data.csv";
  public static final String DEFAULT_OUT_FILE = "output.dat";

  private static final Logger log = LogManager.getLogger();


/**
 * (main) 
 * 	Parse arguments, convert imputed file to desidered format
 *
 * @param  args options
*/
  public static void main(String[] args) {

	log.debug("Executing UseChangeFormat.class");
	
	MyOptions myOptions = new OptionsChangeFormat();
	CommandLine cmdLine = myOptions.manageOption(args);
	if (!myOptions.isCheck())
		return;

	ReadWrite readWrite = new ReadWrite();
	ChangeFormat changeFormat = null;

	if(cmdLine.getOptionValue(IN_FORMAT_OPT, CSV_FORMAT).equals(CSV_FORMAT) && cmdLine.getOptionValue(OUT_FORMAT_OPT, FW_FORMAT).equals(FW_FORMAT)) {
		changeFormat = new ChangeFormatCSVtoFW();
	}else if(cmdLine.getOptionValue(IN_FORMAT_OPT, CSV_FORMAT).equals(FW_FORMAT) && cmdLine.getOptionValue(OUT_FORMAT_OPT, FW_FORMAT).equals(CSV_FORMAT)) {
		changeFormat = new ChangeFormatFWtoCSV();
	}else{
		//System.err.println("Error! Invalid format(s).");
		log.error("Invalid format(s).");
		return;
	}

	if(changeFormat != null) {
		readWrite.execute(cmdLine.getOptionValue(IN_FILE_OPT, DEFAULT_IN_FILE), cmdLine.getOptionValue(OUT_FILE_OPT, DEFAULT_OUT_FILE), changeFormat);
	}

  }

}
