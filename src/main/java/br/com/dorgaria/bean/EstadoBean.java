package br.com.dorgaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.EstadoDAO;
import br.com.drogaria.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {
	private Estado estado;
	private List<Estado> estados;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.Listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Listar o Estado!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		estado = new Estado();
	}

	public void salvar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();

			estadoDAO.salvar(estado);

			novo();
			estados = estadoDAO.Listar();

			Messages.addGlobalInfo("Estado Salvo com Sucesso!");
		} catch (RuntimeException erro) {
			// COM OMNIFACES
			Messages.addGlobalError("Ocorreu um erro ao tentar Salvar o Estado!");
			erro.printStackTrace();

		}
	}
	public void excluir(ActionEvent evento){
		try{
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.excluir(estado);
		
		estados = estadoDAO.Listar();
		
		Messages.addGlobalInfo("Estado Removido com Sucesso!");
		}catch(RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao Excluir o Estado!");
			erro.printStackTrace();
		}
	}
}	
