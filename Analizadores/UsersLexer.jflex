package Analizadores;
import static Analizadores.symUsers.*;
import java_cup.runtime.Symbol;
%%

%public
%class UsersLexer
%cup
%cupdebug
%line
%column


//Espacios en blanco
SEPARADOR = \r|\r\n|\n
ESPACIO = {SEPARADOR} | [ \t\f]

NUMERO = [0-9]+
ID = [:jletterdigit:]+

%{
    private Symbol symbol(int type){
        String lexeme = yytext();
       // System.out.printf("Token tipo %d, lexeme %s, en linea %d, columna %d\n", type, lexeme == null ? "" : lexeme, yyline + 1, yycolumn + 1);
        return new Symbol(type,new Token(lexeme,yyline+1,yycolumn+1));
    }
%}

%%

<YYINITIAL> {
    {NUMERO} { return symbol(NUMERO); }
    {ID} { return symbol(ID); }
    "," { return symbol(COMA); }
    ":" { return symbol(DOSPUNTOS); }
    ";" { return symbol(PUNTOCOMA); }
    {ESPACIO} {}
}

[^] {
    System.out.println("Error lexico en "+yytext());
}