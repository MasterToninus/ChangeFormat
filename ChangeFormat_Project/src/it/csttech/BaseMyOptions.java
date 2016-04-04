package it.csttech;

import org.apache.commons.cli.CommandLine;

public abstract class BaseMyOptions {

	protected boolean check;

	public boolean isCheck(){
		return check;
	}

	public abstract CommandLine manageOption(String[] args);

}
