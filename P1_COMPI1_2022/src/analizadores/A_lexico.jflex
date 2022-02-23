package analizadores;
import java_cup.runtime.*;
import java.util.LinkedList;

//@author moi

%%
%{
    public static LinkedList<TError> errores = new LinkedList<TError>(); 
%}

%public
%class Analizador_Lexico
%cupsym Simbolos
%cup
%char
%column
%full
%ignorecase
%line
%unicode
cn1=[.|]
cn2=[*+?]
letras=[a-zA-Z]
numeros=[0-9]

NT1={cn1}{letras}{letras}
NT2={cn2}{letras}
NT3={letras}"-"{letras}
NT4={numeros}+"-"{numeros}+
NT5n={numeros}*","{numeros}+//FIXME:no agarra todo
NT5l={letras}*","{letras}
NT5={numeros}{NT5n}*|{letras}{NT5l}*//[0-9][(0-9)+,(0-9)]*
NT6a=[\\]
NT6={NT6a}"n"|{NT6a}"'"|{NT6a}"\""


idAux={letras}|{numeros}|[_]//
ids={letras} {idAux}*

%%
<YYINITIAL> ";"     {
                    System.out.println("Reconocio token:<pcoma> lexema:"+yytext());
                    return new Symbol(Simbolos.pcoma, yycolumn, yyline, yytext());
                    }
<YYINITIAL> ("{")  {
    System.out.println("Reconocio token:<parentesisa> lexema:"+yytext());
    return new Symbol(Simbolos.parentesisa, yycolumn, yyline, yytext());
}
<YYINITIAL> ("CONJ")  {
    System.out.println("Reconocio token:<conj> lexema:"+yytext());
    return new Symbol(Simbolos.conj, yycolumn, yyline, yytext());
}
<YYINITIAL> (":") {
    System.out.println("Reconocio token:<dpuntos> lexema:"+yytext());
    return new Symbol(Simbolos.dpuntos, yycolumn, yyline, yytext());
}
<YYINITIAL> {ids}    {
                    System.out.println("Reconocio token:<id> lexema:"+yytext());
                    return new Symbol(Simbolos.id, yycolumn, yyline, yytext());
                    }
<YYINITIAL> ("->")  {
                    System.out.println("Reconocio token:<flecha> lexema:"+yytext());
                    return new Symbol(Simbolos.flecha, yycolumn, yyline, yytext());
                    }
<YYINITIAL> {NT1}|{NT2}|{NT3}|{NT4}|{NT5}|{NT6}   {
                    System.out.println("Reconocio token:<notacion> lexema:"+yytext());
                    return new Symbol(Simbolos.notacion, yycolumn, yyline, yytext());
                    }
<YYINITIAL> ("%%")   {
                    System.out.println("Reconocio token:<dosporcentajes> lexema:"+yytext());
                    return new Symbol(Simbolos.dosporcentajes, yycolumn, yyline, yytext());
                    }
[ \t\r\n\f]         {
                    /* Espacios en blanco, se ignoran */    
                    }

.                   {
                    TError tmp= new TError("Lexico", yytext(),"Caracter no encontrado", yyline, yycolumn );
                    errores.add(tmp);                    
                    }