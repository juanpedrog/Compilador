/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador;

import java.io.File;

/**
 *
 * @author Cherne
 */
public class Main {
    
    
    public static void main(String ar[]){
        String path = "C:/Lexer.flex";
        generarLexer(path);
    }
    
    public static void generarLexer(String path){
        File file = new File(path);
        jflex.Main.generate(file);
    }
    
}
