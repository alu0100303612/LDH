package Pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import problem.definition.Problem;

public class Prueba {
	
	@Test
	public void TestCreaObjeto() {

		assertNotNull("EL Objeto ha sido creado Correctamente",new Problem());
		System.out.println("EL Objeto ha sido creado Correctamente\n");
	}

}
