package ejemplocup;
import java_cup.runtime.*;
import java_cup.runtime.Symbol;
%%
%class AnalizadorLexico

%cup
%line
%column
%ignorecase

%unicode

dig = [0-9]

IDENTIFICADOR = [a-z][a-zA-Z0-9_]*
NUM_FLOTANTE = {dig}+"."{dig}+|(("+"|"-"){dig}+"."{dig}+)
NUM_ENTERO = {dig}+|(("+"|"-"){dig}+)
OP_ARITMETICO = "+"|"-"|"*"|"/"
OP_RELACIONAL = "=="|"<="|">="|"!="|"<"|">"
SIMBOLO_AGRUPACION = "("|")"|":"|";"|"["|"]"
SIMBOLOS = {OP_ARITMETICO}|{OP_RELACIONAL}|{SIMBOLO_AGRUPACION}|"="|","|"|"
COMENTARIOS = "{"({WHITE}|[a-zA-Z0-9]|{OP_ARITMETICO}|{OP_RELACIONAL}|{SIMBOLO_AGRUPACION}|"="|","|"|"|"."|\n{SIMBOLOS})*"}"
WHITE=[ \t\r\n]
%{
public String lexeme;
public int linea;
%}
%%

{WHITE} {/*Ignore*/}
{COMENTARIOS} {/*Ignore*/}

("+") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.OP_ARITMETICO_ADD);
    }
("-") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.OP_ARITMETICO_SUB);
    }
("*") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.OP_ARITMETICO_MUL);
    }
("/") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.OP_ARITMETICO_DIV);
    }

{NUM_FLOTANTE} {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.NUM_FLOTANTE);
    }
{NUM_ENTERO} {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.NUM_ENTERO);
    }

("==") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.OP_RELACIONAL_IIGUAL);
    }
(">=") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.OP_RELACIONAL_MAIGUAL);
    }
("<=") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.OP_RELACIONAL_MEIGUAL);
    }
("!=") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.OP_RELACIONAL_DIFERENTE);
    }
(">") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.OP_RELACIONAL_MAQUE);
    }
("<") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.OP_RELACIONAL_MEQUE);
    }

("=") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.SIMBOLO_ASIGNACION);
    }

("(") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.SIMBOLO_AGRUPACION_PABRE);
    }
(")") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.SIMBOLO_AGRUPACION_PACIERRA);
    }
(":") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.SIMBOLO_AGRUPACION_DOSP);
    }
(";") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.SIMBOLO_AGRUPACION_PCOMA);
    }
("[") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.SIMBOLO_AGRUPACION_CABRE);
    }
("]") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.SIMBOLO_AGRUPACION_CCIERRA);
    }

(",") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.COMA);
    }
("|") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.FIN_LINEA);
    }

("ACTM") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_ACTM);
    }
("APG") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_APG);
    }
("BOO") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_BOO);
    }
("CJT") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_CJT);
    }
("CLX") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_CLX);
    }
("COM") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_COM);
    }
("DET") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_DET);
    }
("DETENTE") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_DETENTE);
    }
("ECD") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_ECD);
    }
("EFEC") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_EFEC);
    }
("ENT") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_ENT);
    }
("EXC") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_ENT);
    }
("FLO") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_FLO);
    }
("FLS") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_FLS);
    }
("FUNC") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_FUNC);
    }
("GIRAI") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_GIRAI);
    }
("GIRAD") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_GIRAD);
    }
("LUZ") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_LUZ);
    }
("MOVAD") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_MOVAD);
    }
("MOVAT") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_MOVAT);
    }
("S") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_S);
    }
("SN") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_SN);
    }
("SPD") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_SPD);
    }
("VDD") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_VDD);
    }

{IDENTIFICADOR} {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.IDENTIFICADOR);
    }

([A-Z0-9]+|[A-Z0-9]+{IDENTIFICADOR})+ {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.CADENA_DESCONOCIDA);
    }

. {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.SIMBOLO_DESCONOCIDO);
    }




