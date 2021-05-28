package edu.fpdual.proyectoERP.testManager;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

// TODO: Auto-generated Javadoc
/**
 * The Class TestEmployeeManager.
 */
public class TestEmployeeManager {

	/** The ciudades. */
	private String[] ciudades;
	
	/** The emails. */
	private String[] emails;

	/**
	 * Inits the.
	 */
	@BeforeEach
	public void init() {
		System.out.println("--------------INICIO--------------");
		ciudades = new String[] { "Sevilla", "Redmon", "Kirkland", "Seattle", "Pablo" };
		emails = new String[] { "michael@northwindtraders.com", "robert@northwindtraders.com",
				"laura@northwindtraders.com", "pvillarserrano@gmail.com" };
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
		assumeTrue(ciudades != null && ciudades.length > 0);
		List<String> resultados = Stream.of(ciudades).filter(data -> data.contains("S") || data.contains("s"))
				.collect(Collectors.toList());
		assertTrue(resultados.size() > 0);
		assertEquals(2, resultados.size());
		assertThat(resultados, Matchers.hasSize(2));
		assertThat(resultados, Matchers.contains("Sevilla", "Seattle"));
		assertThat(resultados, Matchers.not(Matchers.contains("Kirkland", "Pablo", "Redmon")));
		assertThat(resultados, Matchers.containsInAnyOrder("Sevilla", "Seattle"));

	}

	/**
	 * Test emails.
	 */
	@Test
	public void testEmails() {
		assumeTrue(emails != null && emails.length > 0);
		List<String> resultados = Stream.of(emails).filter(data -> data.contains("@gmail.com"))
				.collect(Collectors.toList());
		assertTrue(resultados.size() > 0);
		assertEquals(1, resultados.size());
		assertThat(resultados, Matchers.hasSize(1));
		assertThat(resultados, Matchers.contains("pvillarserrano@gmail.com"));
		assertThat(resultados, Matchers.not(Matchers.contains("michael@northwindtraders.com",
				"robert@northwindtraders.com", "laura@northwindtraders.com")));

	}

}