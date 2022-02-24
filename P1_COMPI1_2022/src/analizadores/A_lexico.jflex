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

cadenas=[\"][^\"\n]*[\"]|[\'][^\"\n]*[\']

expreiones="{"{ids}"}"

%state ESTADOcOMENTARIOuNO ESTADOcOMENTARIOdOS
%%
<YYINITIAL> ("//")  {
    System.out.println("Inicio del estado comentario Barras");
    yybegin(ESTADOcOMENTARIOuNO);    
}
<ESTADOcOMENTARIOuNO>   [^"\n"]   {
    /*Ignore*/
}
<YYINITIAL> ("<!")  {
    System.out.println("Inicio del estado comentario FleInt");
    yybegin(ESTADOcOMENTARIOdOS);
}
<ESTADOcOMENTARIOdOS>   [^"!>"]   {
    /*Ignore*/
}
<ESTADOcOMENTARIOdOS>   ("!>")  {
    System.out.println("Fin del estado comentario FleInt");
    yybegin(YYINITIAL); 
}


<ESTADOcOMENTARIOuNO> ("\n")  {
    System.out.println("Fin del estado comentario Barras");
    yybegin(YYINITIAL); 
}


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
<YYINITIAL> ("*")  {
                    System.out.println("Reconocio token:<por> lexema:"+yytext());
                    return new Symbol(Simbolos.por, yycolumn, yyline, yytext());
                    }
<YYINITIAL> ("?")  {
                    System.out.println("Reconocio token:<interrogacion> lexema:"+yytext());
                    return new Symbol(Simbolos.interrogacion, yycolumn, yyline, yytext());
                    }
<YYINITIAL> ("+")  {
                    System.out.println("Reconocio token:<mas> lexema:"+yytext());
                    return new Symbol(Simbolos.mas, yycolumn, yyline, yytext());
                    }
<YYINITIAL> (".")  {
                    System.out.println("Reconocio token:<punto> lexema:"+yytext());
                    return new Symbol(Simbolos.punto, yycolumn, yyline, yytext());
                    }   
<YYINITIAL> ("|")  {
                    System.out.println("Reconocio token:<or> lexema:"+yytext());
                    return new Symbol(Simbolos.or, yycolumn, yyline, yytext());
                    }                                                             
<YYINITIAL> {expreiones}  {
                    System.out.println("Reconocio token:<expresion> lexema:"+yytext());
                    return new Symbol(Simbolos.expresion, yycolumn, yyline, yytext());
                    }
<YYINITIAL> ("%%")   {
                    System.out.println("Reconocio token:<dosporcentajes> lexema:"+yytext());
                    return new Symbol(Simbolos.dosporcentajes, yycolumn, yyline, yytext());
                    }
<YYINITIAL> {cadenas}    {
                    System.out.println("Reconocio token:<cadena> lexema:"+yytext());
                    return new Symbol(Simbolos.cadena, yycolumn, yyline, yytext());
                }
<YYINITIAL> ("}")  {
    System.out.println("Reconocio token:<parentesisb> lexema:"+yytext());
    return new Symbol(Simbolos.parentesisb, yycolumn, yyline, yytext());
}                

[ \t\r\n\f]         {
                    /* Espacios en blanco, se ignoran */    
                    }

.                   {
                    TError tmp= new TError("Lexico", yytext(),"Caracter no encontrado", yyline, yycolumn );
                    errores.add(tmp);                    
                    }