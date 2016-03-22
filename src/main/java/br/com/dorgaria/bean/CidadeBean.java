package br.com.dorgaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.CidadeDAO;
import br.com.drogaria.dao.EstadoDAO;
import br.com.drogaria.domain.Cidade;
import br.com.drogaria.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable{
	private Cidade cidade;
	private List<Cidade> cidades;
	private List<Estado> estados;

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public List<Estado> getEstados() {
		return estados;
	}
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	@PostConstruct
	public void listar(){
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.Listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao Listar as Cidades");
			erro.printStackTrace();
		}
	}
	public void novo(){
		try{
		cidade = new Cidade();
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estados = estadoDAO.Listar();
		
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao Gerar uma nova Cidade");
			erro.printStackTrace();
		}
	}
	public void salvar(){
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.merge(cidade);
			
			cidade = new Cidade();
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.Listar();
			
			cidades = new CidadeDAO().Listar();
			
			Messages.addGlobalInfo("Cidade Slava com Sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao Salvar uma nova Cidade");
			erro.printStackTrace();
		}
	}

	
}
