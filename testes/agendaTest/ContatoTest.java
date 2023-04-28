package agendaTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import agenda.Contato;

class ContatoTest {
	
	private Contato contatoTest;
	
	@BeforeEach
	void setUp() {
		this.contatoTest = new Contato(1, "Matheus", "Gaudencio","555-5551");
		
	}
	
	@AfterEach
	void tearDown() {
		this.contatoTest = null;
	}

	@Test
	@DisplayName("Quando quero exibir o contato desfavoritado")
	void quandoQueroExibirOContatoDesfavoritado() {
		String contatoTemporario = "Matheus Gaudencio"+System.lineSeparator()+"555-5551";
		assertEquals(this.contatoTest.exibirContatoNormal(), contatoTemporario);
	}
	
	@Test
	@DisplayName("Quando quero exibir o contato favoritado")
	void quandoQueroExibirOContatoFavorito() {
		String contatoCoracao = "♥ Matheus Gaudencio"+ System.lineSeparator()+"555-5551";
		assertEquals(this.contatoTest.exibirContatoCoracao(), contatoCoracao);
	}
	@Test
	@DisplayName("Exibir nome e sobrenome")
	void exibirNomeSobrenome() {
		String nomeCompleto = "Matheus Gaudencio";
		assertEquals(this.contatoTest.toString(), nomeCompleto);
	}

}
