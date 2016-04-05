package it.csttech.formattingtools;

import java.io.*;

public class ReadWrite {

  private void transform(ChangeFormat changeFormat, BufferedReader br, PrintWriter printWriter, String inputFile) { 

		try {
			String line;
			while ((line = br.readLine()) != null){ //br.readLine throws IOException
				printWriter.println(changeFormat.transformString(line));
			}
		}catch(IOException e){
			System.out.println("Error in reading input file " + inputFile + ".");
		}

  }

  public void execute(String inputFile, String outputFile, ChangeFormat changeFormat){

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
		System.err.println("Error! Possible reasons may be:\n"
				+ "Input file " + inputFile + " not found.\n"
				+ "Output file " + outputFile + " exists but is a directory or a regular file.\n"
				+ "Output file " + outputFile + " does not exist but cannot be created.");
	}catch(SecurityException e){
		System.err.println("Error! Denied write access to the output file " + outputFile + ".");
	}finally{
		if(br != null && in != null) {
			try{
				br.close(); //br.close throws IOException
				in.close(); //in.close throws IOException
			}catch(IOException e){
				System.err.println("Error! Input file " + inputFile + " closing not succeded.");
			}
		}
		if(printWriter != null) {
			printWriter.close();
		}
		if (out != null) {
			try{
				out.close();
			}catch(IOException e){
    				System.err.println("Error in writing into output file " + outputFile + ".");
			}
		}
	}
  }

}
