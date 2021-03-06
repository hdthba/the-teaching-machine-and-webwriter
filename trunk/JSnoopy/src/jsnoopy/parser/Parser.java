/* Generated By:JavaCC: Do not edit this line. Parser.java */
package jsnoopy.parser ;

import java.util.* ;
import java.lang.reflect.* ;
import java.io.* ;

import jsnoopy.Trace ;
import jsnoopy.Event ;
import jsnoopy.CallEvent ;
import jsnoopy.ReturnEvent ;
import jsnoopy.ExceptionEvent ;
import jsnoopy.PrimaryCallEvent ;
import jsnoopy.Format ;

public class Parser implements ParserConstants {
    static Parser parserObj ;
    static private void init(java.io.InputStream stream) {
        if( parserObj == null ) {
            parserObj = new Parser( stream ) ; }
        else {
            Parser.ReInit( stream ) ; }
    }
    static private void init(java.io.Reader reader ) {
        if( parserObj == null ) {
            parserObj = new Parser( reader ) ; }
        else {
            Parser.ReInit( reader ) ; }
    }

    static public Trace parseTrace( java.io.InputStream stream )
    throws ParseException, TokenMgrError {
        init( stream ) ;
        return trace() ;
    }

    static private String methodName ;
    static private Class[] parameterTypes ;

    static public Method parseMethod( String fullMethodName, Class klass )
    throws ParseException, TokenMgrError, NoSuchMethodException,
           SecurityException, ClassNotFoundException, IOException
    {
        init( new StringReader( fullMethodName ) ) ;
        method() ;
        //System.out.println( "Getting method name <"+methodName+">" ) ;
        for( int j=0 ; j<parameterTypes.length ; ++j ) {
            Class paramType = parameterTypes[j] ;
            //System.out.println( "Param type "+j+" is "+paramType.getName() );
        }
        return klass.getMethod( methodName, parameterTypes ) ;
    }

    static public Object[] parseArgs( String[] fullArgs )
    throws ParseException, TokenMgrError, ClassNotFoundException {
        Vector vec = new Vector() ;
        for( int i=0 ; i<fullArgs.length ; ++i ) {
            init( new StringReader( fullArgs[i] ) ) ;
            Object obj = fullyFormattedObject() ;
            vec.addElement( obj ) ; }
        return vectorToObjectArray( vec ) ;
    }

    static Object[] vectorToObjectArray( Vector v ) {
        final int sz = v.size() ;
        Object[] rtn = new Object[sz ] ;
        for( int i=0 ; i<sz ; ++i ) {
            rtn[i] = v.elementAt(i) ; }
        return rtn ;
    }

    static String[] vectorToStringArray( Vector v ) {
        final int sz = v.size() ;
        String[] rtn = new String[sz ] ;
        for( int i=0 ; i<sz ; ++i ) {
            rtn[i] = (String) v.elementAt(i) ; }
        return rtn ;
    }

    static Class[] vectorToClassArray( Vector v ) {
        final int sz = v.size() ;
        Class[] rtn = new Class[sz ] ;
        for( int i=0 ; i<sz ; ++i ) {
            rtn[i] = (Class) v.elementAt(i) ; }
        return rtn ;
    }

    static Object vectorToArray( Vector v, Class klass ) {
        final int sz = v.size() ;
        Object rtn = Array.newInstance(klass, sz) ;
        for( int i=0 ; i<sz ; ++i ) {
            Array.set( rtn, i, v.elementAt(i) ) ; }
        return rtn ;
    }

///////////////////////////////////////////////////////////////////
// Here begins the context free grammar
///////////////////////////////////////////////////////////////////
  static final public Trace trace() throws ParseException {
    Event e ;
    String comment ;
    Trace t = new Trace() ;
    string();
    comment = string();
      t.appendComment( comment ) ;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER_LITERAL:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      jj_consume_token(INTEGER_LITERAL);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 16:
        jj_consume_token(16);
        e = primary_call();
        break;
      case 17:
        jj_consume_token(17);
        e = call();
        break;
      case 18:
        jj_consume_token(18);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 25:
          e = exception_return();
          break;
        case 23:
          e = normal_return();
          break;
        default:
          jj_la1[1] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
        t.add(e) ;
    }
    jj_consume_token(0);
     {if (true) return t ;}
    throw new Error("Missing return statement in function");
  }

  static final public Event primary_call() throws ParseException {
    String objectName ;
    String methodName ;
    String[] arguments ;
    String fullMethodName ;
    String[] fullArgs ;
    Vector vec = new Vector() ;
    String temp ;
    objectName = string();
    jj_consume_token(19);
    methodName = string();
    jj_consume_token(20);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STRING:
      temp = string();
                                 vec.addElement(temp);
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 21:
          ;
          break;
        default:
          jj_la1[3] = jj_gen;
          break label_2;
        }
        jj_consume_token(21);
        temp = string();
                                 vec.addElement(temp);
      }
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
    jj_consume_token(22);
                                 arguments = vectorToStringArray(vec) ;
    fullMethodName = string();
    jj_consume_token(20);
                                 vec = new Vector() ;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STRING:
      temp = string();
                                 vec.addElement(temp);
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 21:
          ;
          break;
        default:
          jj_la1[5] = jj_gen;
          break label_3;
        }
        jj_consume_token(21);
        temp = string();
                                 vec.addElement(temp);
      }
      break;
    default:
      jj_la1[6] = jj_gen;
      ;
    }
    jj_consume_token(22);
                                 fullArgs = vectorToStringArray(vec) ;
     {if (true) return new PrimaryCallEvent( objectName, methodName, arguments, fullMethodName, fullArgs ) ;}
    throw new Error("Missing return statement in function");
  }

  static final public Event call() throws ParseException {
    String objectName ;
    String methodName ;
    String[] arguments ;
    Vector vec = new Vector() ;
    String temp ;
    objectName = string();
    jj_consume_token(19);
    methodName = string();
    jj_consume_token(20);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STRING:
      temp = string();
                                 vec.addElement(temp);
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 21:
          ;
          break;
        default:
          jj_la1[7] = jj_gen;
          break label_4;
        }
        jj_consume_token(21);
        temp = string();
                                 vec.addElement(temp);
      }
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    jj_consume_token(22);
                                 arguments = vectorToStringArray(vec) ;
     {if (true) return new CallEvent( objectName, methodName, arguments ) ;}
    throw new Error("Missing return statement in function");
  }

  static final public Event normal_return() throws ParseException {
    String objectName ;
    String methodName ;
    String rtnVal ;
    jj_consume_token(23);
    objectName = string();
    jj_consume_token(19);
    methodName = string();
    jj_consume_token(24);
    rtnVal = string();
     {if (true) return new ReturnEvent( objectName, methodName, rtnVal ) ;}
    throw new Error("Missing return statement in function");
  }

  static final public Event exception_return() throws ParseException {
    String objectName ;
    String methodName ;
    String exceptVal ;
    jj_consume_token(25);
    objectName = string();
    jj_consume_token(19);
    methodName = string();
    jj_consume_token(24);
    exceptVal = string();
     {if (true) return new ExceptionEvent( objectName, methodName, exceptVal ) ;}
    throw new Error("Missing return statement in function");
  }

  static final public String string() throws ParseException {
    Token t ;
    t = jj_consume_token(STRING);
      {if (true) return Format.unformatString( t.image ) ;}
    throw new Error("Missing return statement in function");
  }

  static final public void method() throws ParseException, ClassNotFoundException {
    Vector vec = new Vector() ;
    String temp ;
    Class klass ;
    methodName = string();
    jj_consume_token(26);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 28:
    case 29:
    case 30:
    case 31:
    case 32:
    case 33:
    case 34:
    case 35:
    case 36:
    case IDENTIFIER:
      klass = classNT();
                                    vec.addElement(klass);
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 21:
          ;
          break;
        default:
          jj_la1[9] = jj_gen;
          break label_5;
        }
        jj_consume_token(21);
        klass = classNT();
                                    vec.addElement(klass);
      }
      break;
    default:
      jj_la1[10] = jj_gen;
      ;
    }
    jj_consume_token(27);
                                    parameterTypes = vectorToClassArray(vec) ;
  }

  static final public Class classNT() throws ParseException, ClassNotFoundException {
    Token t;
    String str = "";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 28:
      jj_consume_token(28);
                  {if (true) return boolean.class ;}
      break;
    case 29:
      jj_consume_token(29);
                  {if (true) return byte.class ;}
      break;
    case 30:
      jj_consume_token(30);
                  {if (true) return char.class ;}
      break;
    case 31:
      jj_consume_token(31);
                  {if (true) return double.class ;}
      break;
    case 32:
      jj_consume_token(32);
                  {if (true) return float.class ;}
      break;
    case 33:
      jj_consume_token(33);
                  {if (true) return int.class ;}
      break;
    case 34:
      jj_consume_token(34);
                  {if (true) return long.class ;}
      break;
    case 35:
      jj_consume_token(35);
                  {if (true) return short.class ;}
      break;
    case 36:
    case IDENTIFIER:
      label_6:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 36:
          ;
          break;
        default:
          jj_la1[11] = jj_gen;
          break label_6;
        }
        jj_consume_token(36);
                  str += "[" ;
      }
      t = jj_consume_token(IDENTIFIER);
                              str += t.image ;
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 19:
          ;
          break;
        default:
          jj_la1[12] = jj_gen;
          break label_7;
        }
        jj_consume_token(19);
        t = jj_consume_token(IDENTIFIER);
                              str += "."+t.image ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 37:
        jj_consume_token(37);
                              str += ";" ;
        break;
      default:
        jj_la1[13] = jj_gen;
        ;
      }
                              {if (true) return Class.forName( str ) ;}
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Object fullyFormattedObject() throws ParseException, ClassNotFoundException {
    double dbl ;
    long lng ;
    Vector vec ;
    Object obj ;
    String str ;
    Class klass ;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 38:
      jj_consume_token(38);
                                              {if (true) return null ;}
      break;
    case 39:
      jj_consume_token(39);
                                              {if (true) return new Boolean( true ) ;}
      break;
    case 40:
      jj_consume_token(40);
                                              {if (true) return new Boolean( false ) ;}
      break;
    case 29:
      jj_consume_token(29);
      lng = integer();
                                              {if (true) return new Byte( (byte)lng ) ;}
      break;
    case 30:
      jj_consume_token(30);
      str = string();
                                              {if (true) return new Character( str.charAt(0) ) ;}
      break;
    case 31:
      jj_consume_token(31);
      dbl = floatingPoint();
                                              {if (true) return new Double( dbl ) ;}
      break;
    case 32:
      jj_consume_token(32);
      dbl = floatingPoint();
                                              {if (true) return new Float( dbl ) ;}
      break;
    case INTEGER_LITERAL:
    case 43:
      lng = integer();
                                              {if (true) return new Integer( (int)lng ) ;}
      break;
    case 34:
      jj_consume_token(34);
      lng = integer();
                                              {if (true) return new Long( lng ) ;}
      break;
    case 35:
      jj_consume_token(35);
      lng = integer();
                                              {if (true) return new Short( (short)lng ) ;}
      break;
    case STRING:
      str = string();
                                              {if (true) return str ;}
      break;
    case 41:
      jj_consume_token(41);
                                              vec = new Vector() ;
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STRING:
      case INTEGER_LITERAL:
      case 29:
      case 30:
      case 31:
      case 32:
      case 34:
      case 35:
      case 38:
      case 39:
      case 40:
      case 41:
      case 43:
        obj = fullyFormattedObject();
                                              vec.addElement(obj);
        label_8:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case 21:
            ;
            break;
          default:
            jj_la1[15] = jj_gen;
            break label_8;
          }
          jj_consume_token(21);
          obj = fullyFormattedObject();
                                              vec.addElement(obj);
        }
        break;
      default:
        jj_la1[16] = jj_gen;
        ;
      }
      jj_consume_token(42);
      klass = classNT();
                                              {if (true) return vectorToArray(vec, klass) ;}
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public double floatingPoint() throws ParseException {
    Token t ;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      t = jj_consume_token(IDENTIFIER);
      if (getToken(0).image.equals( "NaN" )
                      || getToken(0).image.equals( "Infinity" )) {

      } else {
        jj_consume_token(-1);
        throw new ParseException();
      }
                                              if( t.image.equals( "NaN" ) ) {
                                                {if (true) return Double.NaN ;} }
                                              else {
                                                {if (true) return Double.POSITIVE_INFINITY ;} }
      break;
    case 43:
      jj_consume_token(43);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
        jj_consume_token(IDENTIFIER);
        if (getToken(0).image.equals( "Infinity" )) {

        } else {
          jj_consume_token(-1);
          throw new ParseException();
        }
                                              {if (true) return Double.NEGATIVE_INFINITY ;}
        break;
      case FLOATING_POINT_LITERAL:
        t = jj_consume_token(FLOATING_POINT_LITERAL);
                                              {if (true) return - Double.parseDouble( t.image ) ;}
        break;
      default:
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case FLOATING_POINT_LITERAL:
      t = jj_consume_token(FLOATING_POINT_LITERAL);
                                              {if (true) return Double.parseDouble( t.image ) ;}
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public long integer() throws ParseException {
    Token t ;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 43:
      jj_consume_token(43);
      t = jj_consume_token(INTEGER_LITERAL);
                                              {if (true) return Long.parseLong( "-"+t.image ) ;}
      break;
    case INTEGER_LITERAL:
      t = jj_consume_token(INTEGER_LITERAL);
                                              {if (true) return Long.parseLong( t.image ) ;}
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  static public ParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  static public Token token, jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[21];
  static final private int[] jj_la1_0 = {0x2000,0x2800000,0x70000,0x200000,0x100,0x200000,0x100,0x200000,0x100,0x200000,0xf0000000,0x0,0x80000,0x0,0xf0000000,0x200000,0xe0002100,0xe0002100,0x4000,0x4000,0x2000,};
  static final private int[] jj_la1_1 = {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x101f,0x10,0x0,0x20,0x101f,0x0,0xbcd,0xbcd,0x1000,0x1800,0x800,};

  public Parser(java.io.InputStream stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  static public void ReInit(java.io.InputStream stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  public Parser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  public Parser(ParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  public void ReInit(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  static final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.Vector jj_expentries = new java.util.Vector();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  static final public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[48];
    for (int i = 0; i < 48; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 21; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 48; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  static final public void enable_tracing() {
  }

  static final public void disable_tracing() {
  }

}
