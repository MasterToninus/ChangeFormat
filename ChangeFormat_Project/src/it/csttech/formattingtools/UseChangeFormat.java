package it.csttech.formattingtools;

import org.apache.commons.cli.*;
import org.apache.log4j.Logger;

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

  static final Logger log = Logger.getRootLogger();

  public static void main(String[] args) {

	CommandLine cmdLine = manageOption(args);
	if (cmdLine == null) {
		return;
	}

	ReadWrite readWrite = new ReadWrite();
	ChangeFormat changeFormat = null;

	if(cmdLine.getOptionValue(IN_FORMAT_OPT, CSV_FORMAT).equals(CSV_FORMAT) && cmdLine.getOptionValue(OUT_FORMAT_OPT, FW_FORMAT).equals(FW_FORMAT)) {
		changeFormat = new ChangeFormatCSVtoFW();
	}else if(cmdLine.getOptionValue(IN_FORMAT_OPT, CSV_FORMAT).equals(FW_FORMAT) && cmdLine.getOptionValue(OUT_FORMAT_OPT, FW_FORMAT).equals(CSV_FORMAT)) {
		changeFormat = new ChangeFormatFWtoCSV();
	}else{
		log.error("Invalid format(s).");
		return;
	}

	if(changeFormat != null) {
		readWrite.execute(cmdLine.getOptionValue(IN_FILE_OPT, DEFAULT_IN_FILE), cmdLine.getOptionValue(OUT_FILE_OPT, DEFAULT_OUT_FILE), changeFormat);
	}

  }



  static CommandLine manageOption(String[] args) {

		Option helpOption = Option.builder(HELP_OPT)
                          .longOpt("help")
			  .hasArg(false)
                          .required(false)
                          .desc("print guide")
                          .build();

     		Option inFileOption = Option.builder(IN_FILE_OPT)
			  .argName("input file")
                          .longOpt("inputFile")
                          .required(false)
			  .numberOfArgs(1)
                          .desc("input file")
                          .build();

     		Option outFileOption = Option.builder(OUT_FILE_OPT)
			 .argName("output file")
                         .longOpt("outputFile")
                         .numberOfArgs(1)
                         .required(false)
                         .desc("output file")
                         .build();

     		Option inFormatOption = Option.builder(IN_FORMAT_OPT)
			  .argName("input format")
                          .longOpt("inputFormat")
                          .required(false)
			  .numberOfArgs(1)
                          .desc("input file format")
                          .build();

    		Option outFormatOption = Option.builder(OUT_FORMAT_OPT)
			 .argName("output format")
                         .longOpt("outputFormat")
                         .numberOfArgs(1)
                         .required(false)
                         .desc("output file format")
                         .build();

     		Options options = new Options();
    		options.addOption(helpOption);
   		options.addOption(inFileOption);
     		options.addOption(outFileOption);
     		options.addOption(inFormatOption);
     		options.addOption(outFormatOption);

     		CommandLine cmdLine = null;

     		try{
     			CommandLineParser parser = new DefaultParser();
     			cmdLine = parser.parse(options, args); //throws ParseException. IF statement is skipped if ParseExc is catched.

     			if (cmdLine.hasOption("help")) {
     			    	HelpFormatter formatter = new HelpFormatter();
     			    	formatter.printHelp("Change Format", options);
				cmdLine = null;
     			}

     		}catch( ParseException pe ){
			log.error("Invalid option(s).");
			cmdLine = null;
		}finally{
     			return cmdLine;
     		}

  }

}
