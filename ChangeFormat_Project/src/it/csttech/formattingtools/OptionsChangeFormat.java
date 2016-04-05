package it.csttech.formattingtools;

import org.apache.commons.cli.*;

public class OptionsChangeFormat extends BaseMyOptions implements MyOptions {

	public static final String IN_FILE_OPT = "i";
	public static final String OUT_FILE_OPT = "o";
	public static final String IN_FORMAT_OPT = "if";
	public static final String OUT_FORMAT_OPT = "of";
	public static final String HELP_OPT = "h";

	@Override
	public CommandLine manageOption(String[] args) {
		
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
				return cmdLine;
     			}else{
				check = true;	
			}
     		}catch( ParseException pe ){
			System.err.println("Error! Invalid option(s).");
		}finally{
     			return cmdLine;
     		}

	}

}
