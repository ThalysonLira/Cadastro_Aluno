package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Util;
import model.Aluno;
import model.Endereco;
import model.Telefone;

@Named
@ViewScoped
public class AlunoController implements Serializable {

	private static final long serialVersionUID = 5133323995601528105L;

	private Aluno aluno;
	private Telefone telefone;
	private List<Aluno> listaAluno;

	public void verificarId() {
		for (Aluno a : this.listaAluno) {
			if (a.getId().equals(this.getAluno().getId())) {
				Util.addMessageError("Este id ja existe. Informe outro.");
//				return;
			}
		}
	}

	public Boolean validarCpf() {
		if (!this.getAluno().getCpf().contains(".")) {
			Util.addMessageError("O cpf deve conter ponto e hífen. Ex: XXX.XXX.XXX-XX.");
			return false;
		}

		for (Aluno a : this.listaAluno) {
			if (a.getCpf().equals(this.getAluno().getCpf())) {
				Util.addMessageError("Este cpf já está cadastrado para outro aluno.");
				return false;
			}
		}
		return true;
	}

	public void editar(Aluno aluno) {
		this.setAluno((Aluno) aluno.getClone());
	}

	public void adicionarTelefone() {
		if (this.getAluno().getListaTelefone() == null)
			this.getAluno().setListaTelefone(new ArrayList<Telefone>());

		if ((this.getTelefone().getCodigoArea() == null) ||
				(this.getTelefone().getCodigoArea().isEmpty())
				|| (this.getTelefone().getNumero() == null) 
				|| (this.getTelefone().getNumero().isEmpty())) {
			Util.addMessageError("Os campos DDD e Número devem estar preenchidos.");
			return;
		}

		this.getAluno().getListaTelefone().add(this.getTelefone());
		this.setTelefone(null);
	}

	public void removerTelefone(Telefone telefone) {
		this.getAluno().getListaTelefone().remove(telefone);
	}

	public void incluir() {
		this.getListaAluno().add(this.getAluno());
		this.limpar();
	}

	public void alterar() {
		// obtendo o indice (posicao da lista)
		int index = this.getListaAluno().indexOf(this.getAluno());
		if (index != -1) {
			// alterando a posicao da lista com um novo usuario
			this.getListaAluno().set(index, getAluno());
			this.limpar();
		}
	}

	public void excluir() {
		int index = this.getListaAluno().indexOf(this.getAluno());
		this.getListaAluno().remove(index);
		if (index != -1)
			this.limpar();
	}

	public void limpar() {
		this.aluno = null;
		this.telefone = null;
	}

	public Aluno getAluno() {
		if (this.aluno == null)
			this.setAluno(new Aluno());
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Telefone getTelefone() {
		if (this.telefone == null)
			this.setTelefone(new Telefone());
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	private void adicionarAlunosLista() {
		// Adicionando aluno 1
		this.setAluno(new Aluno(1, "Joao", "404.750.231-61"));
		this.getAluno().setEndereco(new Endereco("Rua 1", "1A", "11111-111", "Palmas", "Tocantins"));
		this.listaAluno.add(this.getAluno());

		// Adicionando aluno 2
		this.setAluno(new Aluno(2, "Maria", "050.801.241-48"));
		this.getAluno().setEndereco(new Endereco("Rua 2", "2B", "22222-222", "Palmas", "Tocantins"));
		this.listaAluno.add(this.getAluno());

		this.limpar();
	}

	public List<Aluno> getListaAluno() {
		if (this.listaAluno == null) {
			this.listaAluno = new ArrayList<Aluno>();
			this.adicionarAlunosLista();
		}
		return listaAluno;
	}
}