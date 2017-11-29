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

("ENC") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_ENC);
    }
("APG") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_APG);
    }
("MTM") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_MTM);
    }
("ENCC") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_ENCC);
    }
("APGC") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_APGC);
    }
("GDC") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_GDC);
    }
("GIC") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_GIC);
    }
("CRT") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_CRT);
    }
("CPI") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_CPI);
    }
("CPV") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_CPV);
    }
("INT") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_INT);
    }
("MOVA") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_MOVA);
    }
("MOVAT") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_MOVAT);
    }
("MOVI") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_MOVI);
    }
("MOVD") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_MOVD);
    }
("ENCR") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_ENCR);
    }
("APGR") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_APGR);
    }
("RTM") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_RTM);
    }
("TMP") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_TMP);
    }
("HMD") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_HMD);
    }
("LMN") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_LMN);
    }
("ENT") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_ENT);
    }
("DEC") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_DEC);
    }
("BUCLE") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_BUCLE);
    }

("CIERTO") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_CIERTO);
    }
("FALSO") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_FALSO);
    }
("NUEVO") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_NUEVO);
    }
("SI") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_SI);
    }
("CAR") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_CAR);
    }
("CORT") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_CORT);
    }
("PUBLICO") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_PUBLICO);
    }
("PRIVADO") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_PRIVADO);
    }
("PROTEGIDO") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_PROTEGIDO);
    }
("ESTATICO") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_ESTATICO);
    }
("MIENTRAS") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_MIENTRAS);
    }
("HACER") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_HACER);
    }
("ABSTRACTO") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_ABSTRACTO);
    }

("EJECUTAR") {
    lexeme = yytext();
    linea = yyline;
    return new Symbol(sym.PALABRA_RESERVADA_EJECUTAR);
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




