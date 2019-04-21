package model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class Aluno extends DefaultEntity{
	@NotBlank(message="O campo Nome deve ser informado.")
	@Size(min=1, message="Tamanho do nome muito curto.")
	@Size( max=60, message="O tamanho do nome não pode ser maior que 60.")
	private String nome;
	
	@NotBlank(message="O campo Cpf deve ser informado.")
	@CPF(message="Cpf inválido.")
	private String cpf;
	
	@NotBlank
	private Endereco endereco;
	private List<Telefone> listaTelefone;
	
	public Aluno() {
		this.nome = "";
		this.cpf = "";
		this.endereco = new Endereco();
		this.listaTelefone = new ArrayList<Telefone>();
	}

	public Aluno(Integer id, String nome, String cpf) {
		super();
		setId(id);
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public List<Telefone> getListaTelefone() {
		return listaTelefone;
	}
	
	public void setListaTelefone(List<Telefone> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}