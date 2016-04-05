package it.csttech.formattingtools;

public abstract class BaseChangeFormat {

  //Constants
  protected static final int FIXED_WIDTH = 20;
  protected static final char SEPARATOR = ';';
  protected static final char EMPTY_CHAR = ' ';
  protected static final char END_CHAR = '*';

  public abstract String transformString(String inputString);

}
