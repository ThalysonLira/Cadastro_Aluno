package model;

import javax.validation.constraints.NotBlank;

public class Endereco extends DefaultEntity{
	@NotBlank(message="O campo Rua deve ser informado.")
	private String rua;
	
	@NotBlank(message="O campo Número deve ser informado.")
	private String numero;
	
	@NotBlank(message="O campo Cep deve ser informado.")
	private String cep;
	
	@NotBlank(message="O campo Cidade deve ser informado.")
	private String cidade;
	
	@NotBlank(message="O campo Estado deve ser informado.")
	private String estado;
	
	public Endereco() {

	}
	
	public Endereco(String rua, String numero, String cep, String cidade, String estado) {
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}