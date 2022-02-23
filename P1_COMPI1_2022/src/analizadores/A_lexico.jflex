package analizadores;
import java_cup.runtime.*;
import java.util.LinkedList;

//@author moi

%%
%{
    public String help="";
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

L=[a-zA-Z]
N=[0-9]
CN1=[.|]
CN2=[*+?]

NT1={CN1}{L}{L}//[.|][a-zA-Z][a-zA-Z]

NT2={CN2}{L}//[*+?][a-zA-Z]

NT3={L}"-"{L}//[a-zA-Z]-[a-zA-Z]

NT4={N}+"-"{N}+//[0-9]+-[0-9]+

NT5n={N}*","{N}//FIXME:no agarra todo
NT5l={L}*","{L}
NT5={N}{NT5n}*|{L}{NT5l}*//[0-9][(0-9)+,(0-9)]*

NT6a=[\\]
NT6={NT6a}"n"|{NT6a}"'"|{NT6a}"\""

IDaux={L}|{N}|[_]//
ID={L}{IDaux}*//[a-zA-Z][(a-zA-Z)|(0-9)|_]*

CADENA=[\"][^\"\n]*[\"]|[\'][^\"\n]*[\']
/*EXPRESIONa={CADENA}|"{"[ID]"}"
EXPRESION={EXPRESIONa}|{EXPRESIONa}"+"|{EXPRESIONa}"?"|{EXPRESIONa}"*"*/
OR="|"
PUNTO=[.]
POR=["*"]
INTERROGACION=["?"]
MAS=["+"]

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
//CADENAS
/*<YYINITIAL> "\""    {
    System.out.println("Inicio del estado cadena");
    yybegin(ESTADOcADENA); 
}
<ESTADOcADENA> [^\"] {}
<ESTADOcADENA> ["\""] {
    System.out.println("Fin del estado cadena");
    yybegin(YYINITIAL); 
    System.out.println("Reconocio token:<cadena>");
    return new Symbol(Simbolos.Cadena, yycolumn, yyline, help+yytext());   
}*/
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
//EXPRESIONES
/*<YYINITIAL> {EXPRESION}    {
    System.out.println("Reconocio token:<Expresion> lexema:"+yytext());
    return new Symbol(Simbolos.Expresion, yycolumn, yyline, yytext());
}*/
//OR
<YYINITIAL> {OR}    {
    System.out.println("Reconocio token:<Or> lexema:"+yytext());
    return new Symbol(Simbolos.Or, yycolumn, yyline, yytext());
}
//PUNTO
<YYINITIAL> {PUNTO}    {
    System.out.println("Reconocio token:<Punto> lexema:"+yytext());
    return new Symbol(Simbolos.Punto, yycolumn, yyline, yytext());
}
//POR
<YYINITIAL> {POR}    {
    System.out.println("Reconocio token:<Por> lexema:"+yytext());
    return new Symbol(Simbolos.Por, yycolumn, yyline, yytext());
}
//INTERROGACION
<YYINITIAL> {INTERROGACION}    {
    System.out.println("Reconocio token:<Interrogacion> lexema:"+yytext());
    return new Symbol(Simbolos.Interrogacion, yycolumn, yyline, yytext());
}
//MAS
<YYINITIAL> {MAS}    {
    System.out.println("Reconocio token:<Mas> lexema:"+yytext());
    return new Symbol(Simbolos.Mas, yycolumn, yyline, yytext());
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
/*letra = [a-zA-Z]
id = {letra}+
<YYINITIAL> ","     {
                    System.out.println("Reconocio token:<coma> lexema:"+yytext());
                    return new Symbol(Simbolos.coma, yycolumn, yyline, yytext());
                    }

<YYINITIAL> {id}    {
                    System.out.println("Reconocio token:<id> lexema:"+yytext());
                    return new Symbol(Simbolos.id, yycolumn, yyline, yytext());
                    }

[ \t\r\n\f]         {
                        // 
                    }

.                   {
                    TError tmp= new TError("Lexico", yytext(),"Caracter no encontrado", yyline, yycolumn );
                    errores.add(tmp);                    
                    }
*/