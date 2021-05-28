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
	 * The Class TestOrderManager.
	 */
	public class TestOrderManager {

		/** The id pedido. */
		private String[] idPedido;
		
		/** The id empleado. */
		private String[] idEmpleado;
		
		/**
		 * Inits the.
		 */
		@BeforeEach
		public void init() {
		System.out.println("--------------INICIO--------------");
		idPedido = new String[] {"30", "31", "32", "33", "34"};
		idEmpleado = new String[] {"9", "3", "40", "50"};
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
		 * Test id empleado.
		 */
		@Test
		public void testIdEmpleado() {
			assumeTrue(idEmpleado != null && idEmpleado.length > 0);
			List<String> resultados = Stream.of(idEmpleado).filter(data -> data.contains("9"))
					.collect(Collectors.toList());
			assertTrue(resultados.size() > 0);
			assertEquals(1, resultados.size());
			assertThat(resultados, Matchers.hasSize(1));
			assertThat(resultados, Matchers.contains("9"));
			assertThat(resultados, Matchers.not(Matchers.contains("3", "40", "50")));
			
		}
		
		/**
		 * Test id pedido.
		 */
		@Test
		public void testIdPedido() {
			assumeTrue(idPedido != null && idPedido.length > 0);
			List<String> resultados = Stream.of(idPedido).filter(data -> data.contains("30"))
					.collect(Collectors.toList());
			assertTrue(resultados.size() > 0);
			assertEquals(1, resultados.size());
			assertThat(resultados, Matchers.hasSize(1));
			assertThat(resultados, Matchers.contains("30"));
			assertThat(resultados, Matchers.not(Matchers.contains("31", "32", "33", "34")));
			
		}
	
}