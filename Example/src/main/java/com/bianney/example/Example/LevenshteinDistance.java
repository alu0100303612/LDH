package com.bianney.example.Example;

/**
 * 
 * Clase que calcula en cuanto difiere una palabra de otra
 * @author Bianney Cabrera Delgado
 *
 */
public class LevenshteinDistance {
	
	/**
	 * Método que devuelve el mínimo de entre tres enteros
	 * @param a El parámetro a representa una distancia
	 * @param b El parámetro b representa una distancia
	 * @param c El parámetro c representa una distancia
	 * @return
	 */
    private static int minimum(int a, int b, int c) {
        if(a<=b && a<=c){
            return a;
        } 
        if(b<=a && b<=c){
            return b;
        }
        return c;
    }

    /**
     * Método que llama al método computeLevenshteinDistance pasándole como parámetro las palabras convertidas en arrays de char
     * @param str1 El parámetro str1 es uno de los strings a evaluar
     * @param str2 El parámetro str2 es el otro string a evaluar
     * @return Devuelve el entero resultante al llamar a computeLevenshteinDistance pasando como argumento dos arrays de caracteres
     */
    public static int computeLevenshteinDistance(String str1, String str2) {
        return computeLevenshteinDistance(str1.toCharArray(), str2.toCharArray());
    }

    /**
     * Método que calcula la distancia que exixte entre dos palabras
     * @param str1 El parámetro str1 es un array de caracteres que representa la primera palabra a evaluar
     * @param str2 El parámetro str2 es un array de caracteres que representa la segunda palabra a evaluar
     * @return Devuelve un entero con la distancia que hay entre las palabras
     */
    private static int computeLevenshteinDistance(char [] str1, char [] str2) {
        int [][]distance = new int[str1.length+1][str2.length+1];
        for(int i=0;i<=str1.length;i++){
                distance[i][0]=i;
        }
        for(int j=0;j<=str2.length;j++){
                distance[0][j]=j;
        }
        for(int i=1;i<=str1.length;i++){
            for(int j=1;j<=str2.length;j++){ 
                  distance[i][j]= minimum(distance[i-1][j]+1,
                                        distance[i][j-1]+1,
                                        distance[i-1][j-1]+
                                        ((str1[i-1]==str2[j-1])?0:1));
            }
        }
        return distance[str1.length][str2.length];   
    }
    
    /**
     * Programa principal
     * @param args El parámetro args se pasa por defecto al main
     */
    public static void main(String args[]) {
    	LevenshteinDistance l = new LevenshteinDistance();
    	int di;
    	di = l.computeLevenshteinDistance("Amor", "Coche");
    	System.out.println(""+di);
    }
}