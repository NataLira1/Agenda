package agenda;


/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	
	private Contato[] contatos;
	
	private Contato[] favoritos = new Contato[10];
	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}
	
	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao - 1];
	}
	


	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. Verifico se o nome e telefone
	 * estao vazios e tambem se o contato ja foi cadastrado 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		
		
			Contato contatoTemporario = new Contato(posicao, nome.trim(), sobrenome.trim(), telefone);
		
			if(verificarNomeVazio(contatoTemporario)) {
				return "CONTATO INVALIDO";
			}
			
			if(verificarTelefoneVazio(contatoTemporario)) {
				return "CONTATO INVALIDO";
			}
			
			if(jaExisteCadastro(contatoTemporario)) {
				return "CONTATO JÁ CADASTRADO";
			}
			contatos[posicao - 1] = new Contato(posicao, nome, sobrenome, telefone);
			return "CONTATO CADASTRADO";
		
	}
	/**
	 * Exibe um contato, se o contato for favoritado aparece um coração, caso não seja favorito e mostrado da forma normal.
	 * Também é verificado se a posição inserida existe nos contatos
	 * 
	 * @param posicao a posição do contato a ser exibido
	 * @return String com os dados do contato
	 */
	
	public String exibirContato(int posicao) {
		
		boolean contatoFavorito = false;
		if(validarPosicaoExibir(posicao)) {
			for(int j = 0; j < favoritos.length; j++) {
				if(favoritos[j] != null) {
					if(contatos[posicao - 1].equals(favoritos[j])) {
						contatoFavorito = true;
					}
				}
			}
			if(contatoFavorito) {
				return "\nDados do contato:\n" + "\n" + contatos[posicao - 1].exibirContatoCoracao();
				
			}else {
				return "\nDados do contato:\n" + "\n" + contatos[posicao - 1].exibirContatoNormal();
			}
		}else {
			return"POSICAO INVALIDA";
		}
		
		
	}
	/**
	 * Responsável por validar se a posição passada esta obdecendo os critérios
	 * 
	 * @param posicao a posição que vai ser verificada
	 * @return true se a posição atende aos requisitos
	 * @return false se a posição não atende aos requisitos
	 */
	
	public boolean validarPosicaoCadastro(int posicao) {
		
		if(posicao >= 1 && posicao <= 100) {
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * Responsavel por verificar se o contato a ser cadastrado já exite no array de contatos, isso no metodo cadastraContato 
	 * 
	 * @param contatoTemporario passo o os dados do contato do tipo Contato
	 * @return true se o contato a ser cadastrado já existe como contato
	 * @return false se o contato a ser cadastrado for diferente dos contatos já cadastrados
	 */
	private boolean jaExisteCadastro(Contato contatoTemporario) {
	
		for(int i = 0; i < contatos.length; i++) {
			if(contatos[i] != null) {
				if(contatoTemporario.equals(contatos[i])){
					return true;
				}
			}
		}
		return false;
		
	}
	
	
	/**
	 * Verifica se o nome inserido é vazio em cadastraContato
	 * 
	 * @param contatoTemporario possui todos os dados do contato
	 * @return true se o nome for vazio
	 * @return false se o nome for diferente de vazio
	 */
	private boolean verificarNomeVazio(Contato contatoTemporario) {
		
		if(contatoTemporario.getNome().isEmpty()) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Verifica se o telefone do contato é vazio em cadastraContato
	 * 
	 * @param contatoTemporario possui o telefone do contato
	 * @return true se o telefone for vazio
	 * @return false se o telefone não for vazio
	 */
	private boolean verificarTelefoneVazio(Contato contatoTemporario) {
		
		if(contatoTemporario.getTelefone().isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Responsavel por validar a posição para o método exibirContato 
	 * 
	 * @param posicao a posição a ser verificada
	 * @return true se a posicao existe nos contatos já cadastrados
	 * @return false se a posição não existir nos contatos cadastrados
	 */
	private boolean validarPosicaoExibir(int posicao) {
		
		for(int i = 0; i < contatos.length; i++) {
			if(contatos[i] != null) {
				if(contatos[i].getPosicao() == (posicao - 1)) {
					return true;
				}
			}
			
		}
		return false;
	}
	
	
	/**
	 * Responsavel por adicionar um contato como favorito, utilizando a posição do contato a ser favoritado e a posição do array de favoritos
	 * 
	 * @param posicaoContato a posição do contato a ser favoritado
	 * @param posicaoFavorito a posição da alocação do contato favoritado
	 * @return String CONTATO JÁ FAVORITADO, para o contato que já esta no array de favoritos
	 * @return String CONTATO FAVORITADO NA POSIÇÃO + POSICAOFAVORITO, para o contato que foi favoritado com sucesso
	 * @return String POSICOES INVALIDAS, se acontecer do usuario digitar posições tanto da posição do contato como do favorito inválidas
	 */
	public String adcionaFavorito(int posicaoContato, int posicaoFavorito) {
		
		
		if(verificaPosicaoFavorito(posicaoContato, posicaoFavorito)) {
			if(existeRepeticaoFavorito(posicaoContato)) {
				return "CONTATO JÁ FAVORITADO";
			}else {
				favoritos[posicaoFavorito - 1] = contatos[posicaoContato - 1];
				return "CONTATO FAVORITADO NA POSIÇÃO " + posicaoFavorito;
			}
			
		}else {
			return "POSICOES INVALIDAS";
		}
		
	}
	
	
	/**
	 * Responsavel por verificar as posições passadas pelo usuario se estão atendedo os pre requisitos
	 * 
	 * @param posicaoContato a posição do contato
	 * @param posicaoFavorito a posição do favorito
	 * @return true se as posições estão atendendo aos requisitos
	 * @return false se as posições não estiverem atendendo aos requisitos
	 */
	private boolean verificaPosicaoFavorito(int posicaoContato, int posicaoFavorito) {
		
		if(posicaoFavorito >= 1 && posicaoFavorito <= 10) {
			for(int i = 0; i < contatos.length; i++) {
				if(contatos[i] != null) {
					if((posicaoContato - 1) == contatos[i].getPosicao()) {
						return true;
					}
				}
				
			}
		}
		return false;
	}
	
	
	/**
	 * Responsavel por verificar a existência de uma repetição dentro do array que armazena os contatos favoritados
	 * 
	 * @param posicaoContato a posição do contato a ser verificado
	 * @return true se a posição do contato repetir no array de favoritos
	 * @return false se a posição do contato não se repetir no array de favoritos
	 */
	private boolean existeRepeticaoFavorito(int posicaoContato) {
		
		for(int i = 0; i < favoritos.length; i++) {
			if(favoritos[i] != null) {
				if(contatos[posicaoContato - 1].equals(favoritos[i])){
					return true;
				}
			}
		}
		return false;
		
	}
	
	
	/**
	 * Responsavel por listar os contatos que foram favoritados
	 *
	 */
	public void listarFavoritos() {
		
		for(int i = 0; i < favoritos.length; i++) {
			if(favoritos[i] != null) {
				System.out.println("Lista Contatos Favoritados: \n"+(i + 1) + " - " + favoritos[i].getNome() + " " + favoritos[i].getSobrenome());
			}
		}
	}
	
	/**
	 * Responsavel por remover um contato favoritado do array de favoritos
	 * 
	 * @param posicaoRemover a posição do contato favoritado a ser removido
	 */
	public void removerFavoritos(int posicaoRemover) {
		favoritos[posicaoRemover - 1] = null;
	}
}
