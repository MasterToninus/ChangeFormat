package it.csttech.formattingtools;

import org.apache.commons.cli.CommandLine;

public interface MyOptions {
	
	public CommandLine manageOption(String[] args);

	public boolean isCheck();

}
