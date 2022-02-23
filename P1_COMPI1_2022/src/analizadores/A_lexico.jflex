package analizadores;
import java_cup.runtime.*;
import java.util.LinkedList;


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

LETRAS=[a-zA-Z]
NUMEROS=[0-9]
CN1=[.|]
CN2=[*+?]

NT1={CN1}{LETRAS}{LETRAS}//[.|][a-zA-Z][a-zA-Z]

NT2={CN2}{LETRAS}//[*+?][a-zA-Z]

NT3={LETRAS}"-"{LETRAS}//[a-zA-Z]-[a-zA-Z]

NT4={NUMEROS}+"-"{NUMEROS}+//[0-9]+-[0-9]+

NT5n={NUMEROS}*","{NUMEROS}//FIXME:no agarra todo
NT5l={LETRAS}*","{LETRAS}
NT5={NUMEROS}{NT5n}*|{LETRAS}{NT5l}*//[0-9][(0-9)+,(0-9)]*

NT6a=[\\]
NT6={NT6a}"n"|{NT6a}"'"|{NT6a}"\""

IDaux={LETRAS}|{NUMEROS}|[_]
ID={LETRAS}{IDaux}*

CADENA=[\"][^\"\n]*[\"]|[\'][^\"\n]*[\']

%state ESTADOcOMENTARIOuNO ESTADOcOMENTARIOdOS
%%
<YYINITIAL> (";") {
    System.out.println("Reconocio token:<pComa> lexema:"+yytext());
    return new Symbol(Simbolos.pComa, yycolumn, yyline, yytext());
}
//ESTADOS SALTO COMENTARIO UNO
<YYINITIAL> ("//")  {
    System.out.println("Inicio del estado comentario Barras");
    yybegin(ESTADOcOMENTARIOuNO);    
}
<ESTADOcOMENTARIOuNO>   [^"\n"]   {
    /*Ignore*/
}
<ESTADOcOMENTARIOuNO> ("\n")  {
    System.out.println("Fin del estado comentario Barras");
    yybegin(YYINITIAL); 
}
//ESTADO SALTO COMENTARIO DOS
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
//PARENTESIS{
<YYINITIAL> ("{")  {
    System.out.println("Reconocio token:<ParentesisA> lexema:"+yytext());
    return new Symbol(Simbolos.ParentesisA, yycolumn, yyline, yytext());
}
//CONJUNTOS
<YYINITIAL> ("CONJ")  {
    System.out.println("Reconocio token:<Conj> lexema:"+yytext());
    return new Symbol(Simbolos.Conj, yycolumn, yyline, yytext());
}
//DOS PUNTOS
<YYINITIAL> (":") {
    System.out.println("Reconocio token:<dPuntos> lexema:"+yytext());
    return new Symbol(Simbolos.dPuntos, yycolumn, yyline, yytext());
}
//ID
<YYINITIAL> {ID}    {
    System.out.println("Reconocio token:<Id> lexema:"+yytext());
    return new Symbol(Simbolos.Id, yycolumn, yyline, yytext());
}
//FLECHITA
<YYINITIAL> ("->")    {
    System.out.println("Reconocio token:<Flecha> lexema:"+yytext());
    return new Symbol(Simbolos.Flecha, yycolumn, yyline, yytext());
}
//NOTACIONES
<YYINITIAL> {NT1}|{NT2}|{NT3}|{NT4}|{NT5}|{NT6}   {
    System.out.println("Reconocio token:<Notacion> lexema:"+yytext());
    return new Symbol(Simbolos.Notacion, yycolumn, yyline, yytext());
}
//PORCENTAJES
<YYINITIAL> ("%%")    {
    System.out.println("Reconocio token:<DosPorcentajes> lexema:"+yytext());
    return new Symbol(Simbolos.DosPorcentajes, yycolumn, yyline, yytext());
}
//CADENAS
<YYINITIAL> {CADENA}    {
    System.out.println("Reconocio token:<Cadena> lexema:"+yytext());
    return new Symbol(Simbolos.Cadena, yycolumn, yyline, yytext());
}
//PARENTESIS}
<YYINITIAL> ("}")  {
    System.out.println("Reconocio token:<ParentesisB> lexema:"+yytext());
    return new Symbol(Simbolos.ParentesisB, yycolumn, yyline, yytext());
}
//NO HACER NADA           
[ \t\r\n\f] {/*Ignore*/}
//ERRORES
. {
    TError tmp= new TError("Lexico", yytext(),"Caracter no encontrado", yyline, yycolumn );
    errores.add(tmp);                    
}

.                   {
                    TError tmp= new TError("Lexico", yytext(),"Caracter no encontrado", yyline, yycolumn );
                    errores.add(tmp);                    
                    }