package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Dado;

class DadoTest {
	
	static Dado dado;
	
	@BeforeEach
	void initTest() {
		dado = new Dado();
	}

	@Test
	void testLancia() {
		try {
			dado.lancia();
			int valoreDado = dado.getValoreFaccia();
			assertTrue(valoreDado >= 1 && valoreDado <= 6);
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}


}
