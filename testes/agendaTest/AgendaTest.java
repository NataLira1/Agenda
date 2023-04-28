package agendaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import agenda.Agenda;
import agenda.Contato;

class AgendaTest {

	private Contato[] favoritos;
	private Contato[] contatos;
	private Agenda agendaTest;
	
	@BeforeEach
	void setUp() {
		
		this.agendaTest = new Agenda();
		this.contatos = new Contato[100];
		this.favoritos = new Contato[10];
	}
	
	@AfterEach
	void tearDown() {
		this.contatos[0] = null;
		this.favoritos[0] = null;
	}
	
	@Test
	@DisplayName("Quando preciso cadastrar um contato")
	void quandoPrecisoCadastrarUmContato() {
		
		String validacao = "CONTATO INVALIDO";
		String existeContato = "CONTATO JÁ CADASTRADO";
		String sucesso = "CONTATO CADASTRADO";
		
		assertNull(contatos[1]);
		assertEquals(this.agendaTest.cadastraContato(2, "Eliane", "Cristina", "(83)84444-0000"), sucesso);
		assertNotEquals(contatos[1], "");
		
		assertNull(contatos[2]);
		assertEquals(this.agendaTest.cadastraContato(3, "", "Onofre", "(83)96666-0000"), validacao);
		assertNull(contatos[2]);
		
		assertNull(contatos[3]);
		assertEquals(this.agendaTest.cadastraContato(4, "Lucas", "Macedo", ""), validacao);
		assertNull(contatos[3]);
		
		agendaTest.cadastraContato(6, "Natã", "Cavalcante", "(83)991870806");
		
		assertNull(contatos[4]);
		assertEquals(this.agendaTest.cadastraContato(5, "Natã", "Cavalcante", "(83)991870806"), existeContato);
		assertNull(contatos[4]);
		
	}

	@Test
	@DisplayName("Quando preciso exibir o contato")
	void quandoPrecisoExibirUmContato() {

		for(int i = 0; i < contatos.length; i++) {
			if(contatos[i] != null) {
				assertNull(contatos[0]);
				agendaTest.cadastraContato(1, "Natã", "Cavalcante", "(83)991870806");
				assertNotNull(contatos[0]);
				
				String contatoTemporario = "\nDados do contato:\n" + "\n" + this.contatos[0].exibirContatoNormal();
				
				assertEquals(this.agendaTest.exibirContato(1), contatoTemporario);
				
				assertNull(favoritos[1]);
				agendaTest.adcionaFavorito(1, 2);
				assertNotNull(favoritos[1]);
				
				String contatoFavoritado = "\nDados do contato:\n" + "\n" + this.contatos[0].exibirContatoCoracao();
				assertEquals(this.agendaTest.exibirContato(1), contatoFavoritado);
			}
		}
	}
	
	
	@Test
	@DisplayName("Condicao para validar a posicao do contato")
	void quandoVouValidarAPosicaoDoContato(){
		
		int posicao = 100;
		int posicao2 = 101;
		int posicao3 = 0;
		int posicao4 = 1;
		
		assertTrue(agendaTest.validarPosicaoCadastro(posicao));
		assertFalse(agendaTest.validarPosicaoCadastro(posicao2));
		assertFalse(agendaTest.validarPosicaoCadastro(posicao3));
		assertTrue(agendaTest.validarPosicaoCadastro(posicao4));
	}

	@Test
	@DisplayName("Quando vou adicionar um contato nos favoritos")
	void adicionarContatoFavoritos() { 
		
		assertNull(contatos[5]);
		agendaTest.cadastraContato(6, "Carlos", "Magno", "(83)95555-0000");
		assertNotEquals(this.contatos[5], "");
		
		for(int i = 0; i < favoritos.length; i++) {
			if(favoritos[i] != null){
		
				String jaCadastrado = "CONTATO JÁ FAVORITADO";
				String validar = "POSICOES INVALIDAS";
				
				assertNull(favoritos[3]);
				agendaTest.adcionaFavorito(6, 4);
				assertNotNull(favoritos[3]);
				
				String adicionado = "CONTATO FAVORITADO NA POSICAO" + this.favoritos[3].getPosicao();
				assertEquals(this.agendaTest.adcionaFavorito(6, 4), adicionado);
				
				
				assertNotNull(contatos[5]);
				assertEquals(this.agendaTest.adcionaFavorito(6, 5), jaCadastrado);
				assertNull(favoritos[4]);
				
				assertNull(contatos[9]);
				assertEquals(this.agendaTest.adcionaFavorito(10, 2), validar);
				assertNull(favoritos[1]);
			}
		}
	}
	
	@Test
	@DisplayName("Quando vou remover o favorito")
	void quandoVouRemoverFavorito() {
		
		agendaTest.cadastraContato(5, "Lucas", "Fernandes", "(83)44444-4444");
		agendaTest.adcionaFavorito(5, 1);
		
		assertEquals(this.favoritos[0] , this.contatos[4]);
		
		agendaTest.removerFavoritos(1);
		assertEquals(this.favoritos[1], null);
		
	}
	
}
