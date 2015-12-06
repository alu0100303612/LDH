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
	 * @param a El parámetro a representa la distancia
	 * @param b
	 * @param c
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

    public static int computeLevenshteinDistance(String str1, String str2) {
        return computeLevenshteinDistance(str1.toCharArray(), str2.toCharArray());
    }

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
    
    public static void main(String args[]) {
    	LevenshteinDistance l = new LevenshteinDistance();
    	int di;
    	di = l.computeLevenshteinDistance("Amor", "Coche");
    	System.out.println(""+di);
    }
    
}