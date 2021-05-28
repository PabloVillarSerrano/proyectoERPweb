package edu.fpdual.proyectoERP.testManager;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class TestCustomerManagerC.
 */
public class TestCustomerManagerC {
	
	/** The companias. */
	private String[] companias;
	
	/** The apellidos. */
	private String[] apellidos;
	
	/**
	 * Inits the.
	 */
	@BeforeEach
	public void init() {
	System.out.println("--------------INICIO--------------");
	companias = new String[] {"Company GG", "Company H", "Company M", "Company L", "Company S"};
	apellidos = new String[] {"michael@northwindtraders.com", "robert@northwindtraders.com", "laura@northwindtraders.com", "pvillarserrano@gmail.com"};
	}
	
	/**
	 * Teat down.
	 */
	@AfterEach
	public void teatDown() {
		System.out.println("======================TERMINO=================");
	}

	/**
	 * General teat down.
	 */
	@AfterAll
	public static void generalTeatDown() {
		System.out.println("======================FIN GENERAL=================");
	}
	
	
	/**
	 * Test ciudades.
	 */
	@Test
	public void testCiudades() {
		assumeTrue(companias != null && companias.length > 0);
		List<String> resultados = Stream.of(companias).filter(data -> data.contains("G") || data.contains("M"))
				.collect(Collectors.toList());
		assertTrue(resultados.size() > 0);
		assertEquals(2, resultados.size());
		assertThat(resultados, Matchers.hasSize(2));
		assertThat(resultados, Matchers.contains("Company GG", "Company M"));
		assertThat(resultados, Matchers.not(Matchers.contains("Company H", "Company L", "Company S")));
		assertThat(resultados, Matchers.containsInAnyOrder("Company GG", "Company M"));
		
	}
	
//	@Test
//	public void testEmails() {
//		assumeTrue(emails != null && emails.length > 0);
//		List<String> resultados = Stream.of(emails).filter(data -> data.contains("@gmail.com"))
//				.collect(Collectors.toList());
//		assertTrue(resultados.size() > 0);
//		assertEquals(1, resultados.size());
//		assertThat(resultados, Matchers.hasSize(1));
//		assertThat(resultados, Matchers.contains("pvillarserrano@gmail.com"));
//		assertThat(resultados, Matchers.not(Matchers.contains("michael@northwindtraders.com", "robert@northwindtraders.com", "laura@northwindtraders.com")));
//		
//	}
}