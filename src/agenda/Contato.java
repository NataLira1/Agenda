package agenda;

import java.util.Objects;

public class Contato {
	
	private int posicao;
	private String nome;
	private String sobrenome;
	private String telefone;
	
	/**
	 * Contrutor de contato, no qual constroi um contato
	 * 
	 * @param posicao do contato
	 * @param nome do contato
	 * @param sobrenome do contato
	 * @param telefone do contato
	 */
	public Contato(int posicao, String nome, String sobrenome, String telefone) {
		this.posicao = posicao;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	
	/**
	 * Responsavel por exibir o contato favoritado
	 * 
	 * @return String com um coracao junto ao nome, logo apos o sobrenome e o nome
	 */
	public String exibirContatoCoracao() {
		return "♥ " + this.nome + " " + this.sobrenome + System.lineSeparator() + this.telefone;
	}
	
	/**
	 * Responsavel por exibir o contato normal, ou seja, que nao foi favoritado
	 * 
	 * @return String com o nome, sobrenome e o telefone do contato
	 */
	public String exibirContatoNormal() {
		return this.nome + " " + this.sobrenome + System.lineSeparator() + this.telefone;
	}

	/**
	 * @return retorna uma string com o nome e o sobrenome
	 */
	public String toString() {
		return this.nome + " " + this.sobrenome;
	}
	/**
	 * @return retorna uma numeracao de inteiro referente ao objeto
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nome, sobrenome);
	}
	/**
	 * Responsavel por comprar se dois objetos sao iguais, do tipo contato comparando apenas o nome e o sobrenome
	 * 
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(sobrenome, other.sobrenome);
	}
	/**
	 * Acessar a posicao do contato
	 * 
	 * @return posicao retorna a posicao do contato
	 */
	public int getPosicao() {
		return (posicao - 1);
	}
	
	/**
	 * Acessa o sobrenome do contato
	 * 
	 * @return sobrenome retorna o sobrenome do contato
	 */
	public String getSobrenome() {
		return sobrenome;
	}
	
	/**
	 * Acessa o nome do contato
	 * 
	 * @return nome retorna o nome do contato
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Atualiza o nome do contato
	 * 
	 * @param nome O nome para atulizar o contato
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Acessa o telefone do contato
	 * 
	 * @return telefone retorna o telefone do contato
	 */
	public String getTelefone() {
		return telefone;
	}
	
	/**
	 * Atualizo o telefone do contato
	 * 
	 * @param telefone O telefone para atualizar em contato
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
