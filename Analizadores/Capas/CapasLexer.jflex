package Analizadores;
import static Analizadores.symCapas.*;
import java_cup.runtime.Symbol;
%%

%public
%class CapasLexer
%cup
%cupdebug
%line
%column

//Espacios en blanco
SEPARADOR = \r|\r\n|\n
ESPACIO = {SEPARADOR} | [ \t\f]

HEXALETRA = [a-fA-F]
NUMERO = [0-9]+
DIGITO = [0-9]
HEXACARACTER = {HEXALETRA}|{DIGITO}
COLOR = "#"(({HEXACARACTER})({HEXACARACTER})({HEXACARACTER})({HEXACARACTER})({HEXACARACTER})({HEXACARACTER}))
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
    {COLOR} { return symbol(COLOR); }
    "{" { return symbol(LLAVE_A); }
    "}" { return symbol(LLAVE_C); }
    ";" { return symbol(PUNTOCOMA); }
    "," { return symbol(COMA); }
    {ESPACIO} {}
}

[^] {
    System.out.println("Error lexico en "+yytext());
}