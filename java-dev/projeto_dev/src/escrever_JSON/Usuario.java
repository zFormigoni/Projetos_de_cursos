package escrever_JSON;

import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable{
@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", login=" + login + ", senha=" + senha + ", cpf=" + cpf + "]";
	}
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String nome;
	String login;
	String senha;
	String cpf;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf, login, senha);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(login, other.login)
				&& Objects.equals(senha, other.senha);
	}

}
