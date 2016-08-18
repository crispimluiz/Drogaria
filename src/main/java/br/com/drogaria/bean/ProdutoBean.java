package br.com.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable{
	private Produto produto;
	private List<Produto> produtos;
	private List<Fabricante> fabricantes;
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}
	
	@PostConstruct
	public void listar(){
		try{
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtos = produtoDAO.Listar();
		}catch(RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar Listar os Produtos");
			erro.printStackTrace();
		}
		
	}
	public void novo(){
		try{
			produto = new Produto();
		
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricantes = fabricanteDAO.Listar();
		} catch(RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar Gerar os Produtos");
			erro.printStackTrace();
		}
	}
	public void editar(ActionEvent evento){
		try {
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
			
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.Listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Selecionar os Produtos");
			erro.printStackTrace();
		}
	}
	public void salvar(){
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.merge(produto);
			
			produto = new Produto();
			
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.Listar();
			
			produtos = produtoDAO.Listar();
			
			Messages.addGlobalInfo("Produto Salvo com Sucesso!");
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao Salvar o Produto");
			erro.printStackTrace();
		}
	}
	public void excluir (ActionEvent evento){
		try {
			produto = (Produto)evento.getComponent().getAttributes().get("produtoSelecionado");
			
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.excluir(produto);
			
			produtos = produtoDAO.Listar();
			
			Messages.addGlobalInfo("Produto Removido com Sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao Excluir o Produto");
			erro.printStackTrace();
		}
	}
	
}

