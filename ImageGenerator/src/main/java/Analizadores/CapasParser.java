
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Analizadores;

import EDD.Matriz;
import Nodos.NodoMatriz;
import Nucleo.Estructuras;
import java_cup.runtime.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class CapasParser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return symCapas.class;
}

  /** Default constructor. */
  @Deprecated
  public CapasParser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public CapasParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public CapasParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\006\000\002\002\004\000\002\002\004\000\002\002" +
    "\002\000\002\003\006\000\002\004\011\000\002\004\002" +
    "" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\020\000\006\002\uffff\004\004\001\002\000\004\010" +
    "\011\001\002\000\006\002\uffff\004\004\001\002\000\004" +
    "\002\007\001\002\000\004\002\001\001\002\000\004\002" +
    "\000\001\002\000\006\006\012\011\ufffc\001\002\000\004" +
    "\012\015\001\002\000\004\011\014\001\002\000\006\002" +
    "\ufffe\004\ufffe\001\002\000\004\006\016\001\002\000\004" +
    "\012\017\001\002\000\004\005\020\001\002\000\004\007" +
    "\021\001\002\000\006\006\012\011\ufffc\001\002\000\004" +
    "\011\ufffd\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\020\000\006\002\005\003\004\001\001\000\002\001" +
    "\001\000\006\002\007\003\004\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\004\012\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\004\021\001\001\000\002\001\001" +
    "" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$CapasParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$CapasParser$actions(this);
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
    return action_obj.CUP$CapasParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    Matriz matriz = new Matriz();
    public CapasParser(CapasLexer lex){
        super(lex);
    }

    @Override
    public void syntax_error(Symbol st) {
        Token error = (Token) st.value;
        report_error("Error Sintactico con el Token:"+ error.getLexeme()+" este no pertenece a la estructura  >linea: "+error.getLine()+" >columna: "+error.getColumn() + "\n",null);
    }



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$CapasParser$actions {
  private final CapasParser parser;

  /** Constructor */
  CUP$CapasParser$actions(CapasParser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$CapasParser$do_action_part00000000(
    int                        CUP$CapasParser$act_num,
    java_cup.runtime.lr_parser CUP$CapasParser$parser,
    java.util.Stack            CUP$CapasParser$stack,
    int                        CUP$CapasParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$CapasParser$result;

      /* select the action based on the action number */
      switch (CUP$CapasParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= s0 EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$CapasParser$stack.elementAt(CUP$CapasParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$CapasParser$stack.elementAt(CUP$CapasParser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$CapasParser$stack.elementAt(CUP$CapasParser$top-1)).value;
		RESULT = start_val;
              CUP$CapasParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$CapasParser$stack.elementAt(CUP$CapasParser$top-1)), ((java_cup.runtime.Symbol)CUP$CapasParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$CapasParser$parser.done_parsing();
          return CUP$CapasParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // s0 ::= s1 s0 
            {
              Object RESULT =null;

              CUP$CapasParser$result = parser.getSymbolFactory().newSymbol("s0",0, ((java_cup.runtime.Symbol)CUP$CapasParser$stack.elementAt(CUP$CapasParser$top-1)), ((java_cup.runtime.Symbol)CUP$CapasParser$stack.peek()), RESULT);
            }
          return CUP$CapasParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // s0 ::= 
            {
              Object RESULT =null;

              CUP$CapasParser$result = parser.getSymbolFactory().newSymbol("s0",0, ((java_cup.runtime.Symbol)CUP$CapasParser$stack.peek()), RESULT);
            }
          return CUP$CapasParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // s1 ::= ID LLAVE_A s2 LLAVE_C 
            {
              Object RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$CapasParser$stack.elementAt(CUP$CapasParser$top-3)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$CapasParser$stack.elementAt(CUP$CapasParser$top-3)).right;
		Token id = (Token)((java_cup.runtime.Symbol) CUP$CapasParser$stack.elementAt(CUP$CapasParser$top-3)).value;
		 
        Matriz nuevaMatriz = matriz;
        nuevaMatriz.setId(id.getLexeme());
        nuevaMatriz.imprimirNodos();
        Estructuras.insertarCapa(nuevaMatriz);
        matriz = new Matriz();
    
              CUP$CapasParser$result = parser.getSymbolFactory().newSymbol("s1",1, ((java_cup.runtime.Symbol)CUP$CapasParser$stack.elementAt(CUP$CapasParser$top-3)), ((java_cup.runtime.Symbol)CUP$CapasParser$stack.peek()), RESULT);
            }
          return CUP$CapasParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // s2 ::= NUMERO COMA NUMERO COMA COLOR PUNTOCOMA s2 
            {
              Object RESULT =null;
		int filaleft = ((java_cup.runtime.Symbol)CUP$CapasParser$stack.elementAt(CUP$CapasParser$top-6)).left;
		int filaright = ((java_cup.runtime.Symbol)CUP$CapasParser$stack.elementAt(CUP$CapasParser$top-6)).right;
		Token fila = (Token)((java_cup.runtime.Symbol) CUP$CapasParser$stack.elementAt(CUP$CapasParser$top-6)).value;
		int columnaleft = ((java_cup.runtime.Symbol)CUP$CapasParser$stack.elementAt(CUP$CapasParser$top-4)).left;
		int columnaright = ((java_cup.runtime.Symbol)CUP$CapasParser$stack.elementAt(CUP$CapasParser$top-4)).right;
		Token columna = (Token)((java_cup.runtime.Symbol) CUP$CapasParser$stack.elementAt(CUP$CapasParser$top-4)).value;
		int colorleft = ((java_cup.runtime.Symbol)CUP$CapasParser$stack.elementAt(CUP$CapasParser$top-2)).left;
		int colorright = ((java_cup.runtime.Symbol)CUP$CapasParser$stack.elementAt(CUP$CapasParser$top-2)).right;
		Token color = (Token)((java_cup.runtime.Symbol) CUP$CapasParser$stack.elementAt(CUP$CapasParser$top-2)).value;
		
        int x = Integer.parseInt(columna.getLexeme());
        int y = Integer.parseInt(fila.getLexeme());
        System.out.println("Pixel: "+x+","+y+" Color: "+color.getLexeme());
        matriz.insertarPixel(new NodoMatriz(x,y,color.getLexeme()));
    
              CUP$CapasParser$result = parser.getSymbolFactory().newSymbol("s2",2, ((java_cup.runtime.Symbol)CUP$CapasParser$stack.elementAt(CUP$CapasParser$top-6)), ((java_cup.runtime.Symbol)CUP$CapasParser$stack.peek()), RESULT);
            }
          return CUP$CapasParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // s2 ::= 
            {
              Object RESULT =null;

              CUP$CapasParser$result = parser.getSymbolFactory().newSymbol("s2",2, ((java_cup.runtime.Symbol)CUP$CapasParser$stack.peek()), RESULT);
            }
          return CUP$CapasParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$CapasParser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$CapasParser$do_action(
    int                        CUP$CapasParser$act_num,
    java_cup.runtime.lr_parser CUP$CapasParser$parser,
    java.util.Stack            CUP$CapasParser$stack,
    int                        CUP$CapasParser$top)
    throws java.lang.Exception
    {
              return CUP$CapasParser$do_action_part00000000(
                               CUP$CapasParser$act_num,
                               CUP$CapasParser$parser,
                               CUP$CapasParser$stack,
                               CUP$CapasParser$top);
    }
}

}
