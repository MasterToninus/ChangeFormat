package it.csttech.formattingtools;

import java.io.*;
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
 * @author Drago-Orsone, (MasterTonius)
 * 
 */
public class ReadWrite {

  private static final Logger log = LogManager.getLogger();

  private static void transform(ChangeFormat changeFormat, BufferedReader br, PrintWriter printWriter, String inputFile) { 		
		try {
			String line;
			while ((line = br.readLine()) != null){ //br.readLine throws IOException
				printWriter.println(changeFormat.transformString(line));
			}
		}catch(IOException e){
			log.error("Input file " + inputFile + " reading failed.");
		}
  }

  /**
   * Execute a ChangeFormat on each line of the input file
   * 
   * @param inputFile file to be transformed
   * @param outputFile result of the transformation.
   * @param changeFormat interface of the class defining the transformation to be performed.
   */
  public static void execute(String inputFile, String outputFile, ChangeFormat changeFormat){

	BufferedReader br = null;
 	InputStream in = null;
	OutputStream out = null;
	PrintWriter printWriter = null;

	try {
		in = new FileInputStream(inputFile); //FileNotFoundException
		br = new BufferedReader(new InputStreamReader(in));
		out = new FileOutputStream(outputFile); //FileNotFoundException & SecurityException
		printWriter = new PrintWriter(out);

		transform(changeFormat, br, printWriter, inputFile);

  	}catch(FileNotFoundException e){
		log.error("File not Found Error");
		log.info( "\t Possible reasons may be:\n"
				+ "\t Input file " + inputFile + " not found.\n"
				+ "\t Output file " + outputFile + " exists but is a directory or a regular file.\n"
				+ "\t Output file " + outputFile + " does not exist but cannot be created.");
	}catch(SecurityException e){
		log.error("Denied write access to the output file " + outputFile + ".");
	}finally{
		if(br != null && in != null) {
			try{
				br.close(); //br.close throws IOException
				in.close(); //in.close throws IOException
			}catch(IOException e){
				log.error("Input file " + inputFile + " closing not succeded.");
			}
		}
		if(printWriter != null) {
			printWriter.close();
		}
		if (out != null) {
			try{
				out.close();
			}catch(IOException e){
    				log.error("Writing on output file " + outputFile + " failed.");
			}
		}
	}
  }

}
