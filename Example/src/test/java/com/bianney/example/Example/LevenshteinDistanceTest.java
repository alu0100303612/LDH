package com.bianney.example.Example;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bianney.example.Example.LevenshteinDistance;


public class LevenshteinDistanceTest {
	
	String str1 = "Amor";
	String str2 = "Amar";
	
	@Before
	public void setUp()
	{
		System.out.print("Comienza el test: ");
	}

	@Test
	public void TestCreaObjeto() {
		System.out.println("Creación correcta Objeto");
		System.out.println("EL Objeto ha sido creado Correctamente\n");

		assertNotNull("EL Objeto ha sido creado Correctamente",new LevenshteinDistance());
	}
	
	@Test
	public void TestSonDistintos() {
		
		System.out.println("Son Distintos");
		System.out.println("\""+str1+"\" y \""+str2+"\" se diferencian en:  1\n");
		assertEquals("\""+str1+"\" y \""+str2+"\" se diferencian en: ", 1, 
					LevenshteinDistance.computeLevenshteinDistance(str1,str2));
	}
	
	@Test
	public void TestSonIguales() {
		System.out.println("Son Iguales");
		System.out.println("\""+str1+"\" y \""+str1+"\" no se diferencian\n");
		assertNotEquals("\""+str1+"\" y \""+str1+"\" son iguales", 1, LevenshteinDistance.computeLevenshteinDistance(str1,str1));
	}


}
