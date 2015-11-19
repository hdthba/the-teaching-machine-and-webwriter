/* Generated By:JavaCC: Do not edit this line. PreprocessorConstants.java */
package tm.cpp.preprocessor ;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface PreprocessorConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int PEDAGOGICALMARKUP2 = 1;
  /** RegularExpression Id. */
  int PEDAGOGICALMARKUP3 = 2;
  /** RegularExpression Id. */
  int PEDAGOGICALMARKUP4 = 3;
  /** RegularExpression Id. */
  int PEDAGOGICALMARKUP_INVISIBLE_ALL = 4;
  /** RegularExpression Id. */
  int KEEP_SPACE = 9;
  /** RegularExpression Id. */
  int CSTYLECOMMENTSTART = 10;
  /** RegularExpression Id. */
  int NEWLINE = 11;
  /** RegularExpression Id. */
  int LINECOMMENTSTART = 12;
  /** RegularExpression Id. */
  int STARTDIRECTIVE = 13;
  /** RegularExpression Id. */
  int PPINCLUDE = 19;
  /** RegularExpression Id. */
  int PPIF = 20;
  /** RegularExpression Id. */
  int PPIFDEF = 21;
  /** RegularExpression Id. */
  int PPIFNDEF = 22;
  /** RegularExpression Id. */
  int PPELIF = 23;
  /** RegularExpression Id. */
  int PPELSE = 24;
  /** RegularExpression Id. */
  int PPENDIF = 25;
  /** RegularExpression Id. */
  int PPDEFINE = 26;
  /** RegularExpression Id. */
  int PPUNDEF = 27;
  /** RegularExpression Id. */
  int PPLINE = 28;
  /** RegularExpression Id. */
  int PPERROR = 29;
  /** RegularExpression Id. */
  int PPPRAGMA = 30;
  /** RegularExpression Id. */
  int UNEXPECTED = 31;
  /** RegularExpression Id. */
  int DQFILENAME = 32;
  /** RegularExpression Id. */
  int AQFILENAME = 33;
  /** RegularExpression Id. */
  int KEEP_KEYWORD = 34;
  /** RegularExpression Id. */
  int KEEP_NCONST = 35;
  /** RegularExpression Id. */
  int INT = 36;
  /** RegularExpression Id. */
  int INTSUFFIX = 37;
  /** RegularExpression Id. */
  int FLOATCONST = 38;
  /** RegularExpression Id. */
  int LOCAL_FLOATCONST = 39;
  /** RegularExpression Id. */
  int DIGITS = 40;
  /** RegularExpression Id. */
  int EXPPART = 41;
  /** RegularExpression Id. */
  int KEEP_ACONST = 42;
  /** RegularExpression Id. */
  int CHARACTER = 43;
  /** RegularExpression Id. */
  int STRING = 44;
  /** RegularExpression Id. */
  int SIMPLEESCAPESEQ = 45;
  /** RegularExpression Id. */
  int OCTALESCAPESEQ = 46;
  /** RegularExpression Id. */
  int HEXESCAPESEQ = 47;
  /** RegularExpression Id. */
  int UCODENAME = 48;
  /** RegularExpression Id. */
  int HEXQUAD = 49;
  /** RegularExpression Id. */
  int HEXDIG = 50;
  /** RegularExpression Id. */
  int KEEP_ID = 51;
  /** RegularExpression Id. */
  int KEEP_REST = 52;

  /** Lexical state. */
  int AFTERINCLUDE = 0;
  /** Lexical state. */
  int DIRECTIVE0 = 1;
  /** Lexical state. */
  int IN_C_COMMENT = 2;
  /** Lexical state. */
  int IN_LINE_COMMENT = 3;
  /** Lexical state. */
  int IN_PEDAGOGICAL_COMMENT = 4;
  /** Lexical state. */
  int MIDLINE = 5;
  /** Lexical state. */
  int DEFAULT = 6;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "<PEDAGOGICALMARKUP2>",
    "<PEDAGOGICALMARKUP3>",
    "\"/*#\"",
    "\"/*#I\"",
    "\"*/\"",
    "\"*/\"",
    "\"\\n\"",
    "<token of kind 8>",
    "<KEEP_SPACE>",
    "\"/*\"",
    "<NEWLINE>",
    "\"//\"",
    "\"#\"",
    "\"\\n\"",
    "<token of kind 15>",
    "\"*/\"",
    "<token of kind 17>",
    "<token of kind 18>",
    "\"include\"",
    "\"if\"",
    "\"ifdef\"",
    "\"ifndef\"",
    "\"elif\"",
    "\"else\"",
    "\"endif\"",
    "\"define\"",
    "\"undef\"",
    "\"line\"",
    "\"error\"",
    "\"pragma\"",
    "<UNEXPECTED>",
    "<DQFILENAME>",
    "<AQFILENAME>",
    "<KEEP_KEYWORD>",
    "<KEEP_NCONST>",
    "<INT>",
    "<INTSUFFIX>",
    "<FLOATCONST>",
    "<LOCAL_FLOATCONST>",
    "<DIGITS>",
    "<EXPPART>",
    "<KEEP_ACONST>",
    "<CHARACTER>",
    "<STRING>",
    "<SIMPLEESCAPESEQ>",
    "<OCTALESCAPESEQ>",
    "<HEXESCAPESEQ>",
    "<UCODENAME>",
    "<HEXQUAD>",
    "<HEXDIG>",
    "<KEEP_ID>",
    "<KEEP_REST>",
  };

}