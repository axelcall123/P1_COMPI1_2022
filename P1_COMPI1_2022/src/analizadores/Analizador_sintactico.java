
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package analizadores;

import java_cup.runtime.Symbol;
import java.util.LinkedList;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Analizador_sintactico extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return Simbolos.class;
}

  /** Default constructor. */
  @Deprecated
  public Analizador_sintactico() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Analizador_sintactico(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Analizador_sintactico(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\023\000\002\002\004\000\002\002\003\000\002\012" +
    "\004\000\002\003\010\000\002\003\011\000\002\004\003" +
    "\000\002\004\004\000\002\006\003\000\002\006\005\000" +
    "\002\007\003\000\002\007\004\000\002\007\004\000\002" +
    "\007\004\000\002\010\004\000\002\010\004\000\002\010" +
    "\004\000\002\010\003\000\002\005\007\000\002\005\010" +
    "" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\013\000\004\006\004\001\002\000\004\007\010\001" +
    "\002\000\004\002\000\001\002\000\004\002\007\001\002" +
    "\000\004\002\001\001\002\000\004\010\011\001\002\000" +
    "\004\011\012\001\002\000\004\012\013\001\002\000\004" +
    "\004\014\001\002\000\006\002\ufffe\006\004\001\002\000" +
    "\004\002\ufffd\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\013\000\006\002\005\003\004\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\003\014\001\001\000\002\001\001" +
    "" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Analizador_sintactico$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Analizador_sintactico$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Analizador_sintactico$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    public static LinkedList<TError> errores = new LinkedList<TError>(); 

    //Metodo al que se llama automaticamente ante algun error sintactico
    public void syntax_error(Symbol s)
    {        
        String lexema = s.value.toString();
        int fila = s.right;
        int columna = s.left;
      
        System.out.println("!!!!!!! Error Sintactico Recuperado !!!!!!!");
        System.out.println("\t\tLexema: "+lexema);
        System.out.println("\t\tFila: "+fila);
        System.out.println("\t\tColumna: "+columna);

        TError tmp = new TError("Sintactico",lexema,"Caracter no esperado",fila,columna);
        errores.add(tmp);
        
    }

    //Metodo al que se llama en el momento en que ya no es posible una recuperacion de errores
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception
    {        
        String lexema = s.value.toString();
        int fila = s.right;
        int columna = s.left;
        
        System.out.println("!!!!!!! Error Sintactico, Panic Mode !!!!!!! ");
        System.out.println("\t\tLexema: "+lexema);
        System.out.println("\t\tFila: "+fila);
        System.out.println("\t\tColumna: "+columna);
        
        TError tmp = new TError("Sintactico",lexema, "Caracter no esperado",fila,columna);
        errores.add(tmp);
     
    }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Analizador_sintactico$actions {
  private final Analizador_sintactico parser;

  /** Constructor */
  CUP$Analizador_sintactico$actions(Analizador_sintactico parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Analizador_sintactico$do_action_part00000000(
    int                        CUP$Analizador_sintactico$act_num,
    java_cup.runtime.lr_parser CUP$Analizador_sintactico$parser,
    java.util.Stack            CUP$Analizador_sintactico$stack,
    int                        CUP$Analizador_sintactico$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Analizador_sintactico$result;

      /* select the action based on the action number */
      switch (CUP$Analizador_sintactico$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)).value;
		RESULT = start_val;
              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Analizador_sintactico$parser.done_parsing();
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // INICIO ::= CONJUNTOS 
            {
              Object RESULT =null;
		System.out.println("Fin de analisis de entrada");
              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // AYUDA ::= Conj dPuntos 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("AYUDA",8, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // CONJUNTOS ::= Conj dPuntos Id Flecha Notacion pComa 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("CONJUNTOS",1, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-5)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // CONJUNTOS ::= Conj dPuntos Id Flecha Notacion pComa CONJUNTOS 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("CONJUNTOS",1, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-6)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // PORPOR ::= DosPorcentajes 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("PORPOR",2, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // PORPOR ::= DosPorcentajes PORPOR 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("PORPOR",2, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // EXPRESIONa ::= Cadena 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("EXPRESIONa",4, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // EXPRESIONa ::= ParentesisA Id ParentesisB 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("EXPRESIONa",4, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // EXPRESIONb ::= EXPRESIONa 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("EXPRESIONb",5, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // EXPRESIONb ::= EXPRESIONa Mas 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("EXPRESIONb",5, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // EXPRESIONb ::= EXPRESIONa Interrogacion 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("EXPRESIONb",5, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // EXPRESIONb ::= EXPRESIONa Por 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("EXPRESIONb",5, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // EXPRESION ::= Or B 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("EXPRESION",6, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // EXPRESION ::= Punto B 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("EXPRESION",6, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // EXPRESION ::= EXPRESIONb B 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("EXPRESION",6, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // EXPRESION ::= EXPRESIONb 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("EXPRESION",6, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // LEXEMA ::= Id dPuntos Cadena EXPRESION pComa 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("LEXEMA",3, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-4)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // LEXEMA ::= Id dPuntos Cadena EXPRESION pComa LEXEMA 
            {
              Object RESULT =null;

              CUP$Analizador_sintactico$result = parser.getSymbolFactory().newSymbol("LEXEMA",3, ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.elementAt(CUP$Analizador_sintactico$top-5)), ((java_cup.runtime.Symbol)CUP$Analizador_sintactico$stack.peek()), RESULT);
            }
          return CUP$Analizador_sintactico$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Analizador_sintactico$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Analizador_sintactico$do_action(
    int                        CUP$Analizador_sintactico$act_num,
    java_cup.runtime.lr_parser CUP$Analizador_sintactico$parser,
    java.util.Stack            CUP$Analizador_sintactico$stack,
    int                        CUP$Analizador_sintactico$top)
    throws java.lang.Exception
    {
              return CUP$Analizador_sintactico$do_action_part00000000(
                               CUP$Analizador_sintactico$act_num,
                               CUP$Analizador_sintactico$parser,
                               CUP$Analizador_sintactico$stack,
                               CUP$Analizador_sintactico$top);
    }
}

}
