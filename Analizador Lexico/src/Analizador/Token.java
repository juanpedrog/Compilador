package Analizador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cherne
 */
public enum Token {
    
    PALABRA_RESERVADA,
    IDENTIFICADOR,
    OP_RELACIONAL,
    OP_ARITMETICO,
    NUM_ENTERO,
    NUM_FLOTANTE,
    SIMBOLO_AGRUPACION,
    OP_SINTAXIS,
    FIN_LINEA,
    SIMBOLO_ASIGNACION,
    SIMBOLO_DESCONOCIDO,
    CADENA_DESCONOCIDA
    
}
