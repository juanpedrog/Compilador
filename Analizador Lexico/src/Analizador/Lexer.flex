package Analizador;
import static Analizador.Token.*;
import java.cup.runtime.*;
import java.io.Reader.*;
%%
%class Lexer
%type Token
%line

%cup

%{
    private Symbol(int type){
        return new Symbol(type,yyline,yycolumn,value);
    }
    private Symbol(int type,Object value){
        return new Symbol(type,yyline,yycolumn,value);
    }
}



%column
%unicode

dig = [0-9]

PALABRA_RESERVADA = ("A"("CTM"|"PG")|"BOO"|"C"("JT"|"LX"|"OM")|"DET"|"DETENTE"|"E"("CD"|"FEC"|"NT"|"XC")|"F"("LO"|"LS"|"UNC")|"GIRA"("I"|"D")|"LUZ"|"MOVA"("D"|"T")|"NT"|"S"("N"|"PD")|"S"|"VDD")
IDENTIFICADOR = [a-z][a-zA-Z0-9_]*
OP_ARITMETICO = "+"|"-"|"*"|"/"
NUM_FLOTANTE = {dig}+"."{dig}+|(("+"|"-"){dig}+"."{dig}+)
NUM_ENTERO = {dig}+|(("+"|"-"){dig}+)
OP_RELACIONAL = "=="|"<="|">="|"!="|"<"|">"
SIMBOLO_AGRUPACION = "("|")"|":"|";"|"["|"]"
SIMBOLO_ASIGNACION = "="
OP_SINTAXIS = ","
FIN_LINEA = "|"
SIMBOLOS = {OP_ARITMETICO}|{OP_RELACIONAL}|{SIMBOLO_AGRUPACION}|{SIMBOLO_ASIGNACION}|{OP_SINTAXIS}|{FIN_LINEA}
COMENTARIOS = "{"({WHITE}|[a-zA-Z0-9]|{OP_ARITMETICO}|{OP_RELACIONAL}|{SIMBOLO_AGRUPACION}|{SIMBOLO_ASIGNACION}|{OP_SINTAXIS}|{FIN_LINEA}|"."|\n|{SIMBOLOS})*"}"


WHITE=[ \t\r\n]
%{
public String lexeme;
public int linea;
%}
%%

{WHITE} {/*Ignore*/}
{COMENTARIOS} {/*Ignore*/}

{OP_ARITMETICO} {
    lexeme = yytext();
    linea = yyline;
    return OP_ARITMETICO;
    }
{NUM_FLOTANTE} {
    lexeme = yytext();
    linea = yyline;
    return NUM_FLOTANTE;
    }
{NUM_ENTERO} {
    lexeme = yytext();
    linea = yyline;
    return NUM_ENTERO;
    }
{OP_RELACIONAL} {
    lexeme = yytext();
    linea = yyline;
    return OP_RELACIONAL;
    }
{SIMBOLO_ASIGNACION} {
    lexeme = yytext();
    linea = yyline;
    return SIMBOLO_ASIGNACION;
    }
{SIMBOLO_AGRUPACION} {
    lexeme = yytext();
    linea = yyline;
    return SIMBOLO_AGRUPACION;
    }
{OP_SINTAXIS} {
    lexeme = yytext();
    linea = yyline;
    return OP_SINTAXIS;
    }
{FIN_LINEA} {
    lexeme = yytext();
    linea = yyline;
    return FIN_LINEA;
    }

{PALABRA_RESERVADA} {
    lexeme = yytext();
    linea = yyline;
    return PALABRA_RESERVADA;
    }

{IDENTIFICADOR} {
    lexeme = yytext();
    linea = yyline;
    return IDENTIFICADOR;
    }

([A-Z0-9]+|[A-Z0-9]+{IDENTIFICADOR})+ {
    lexeme = yytext();
    linea = yyline;
    return CADENA_DESCONOCIDA;
    }



. {
    lexeme = yytext();
    linea = yyline;
    return SIMBOLO_DESCONOCIDO;
    }




