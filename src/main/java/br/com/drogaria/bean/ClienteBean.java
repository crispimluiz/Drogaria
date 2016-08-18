package br.com.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.ClienteDAO;
import br.com.drogaria.dao.PessoaDAO;
import br.com.drogaria.domain.Cliente;
import br.com.drogaria.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {
	private Cliente cliente;

	private List<Cliente> clientes;
	private List<Pessoa> pessoas;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@PostConstruct
	public void listar() {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.Listar("dataCadastro");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro tentar Listar os Clientes");
			erro.printStackTrace();
		}

	}

	public void novo() {
		try{
		cliente = new Cliente();
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoas = pessoaDAO.Listar("nome");
		}catch(RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar Criar um novo Cliente");
			erro.printStackTrace();
		}
	}
		public void salvar() {
			try {
				ClienteDAO clienteDAO = new ClienteDAO();
				clienteDAO.merge(cliente);

				cliente = new Cliente();
				
				clientes = clienteDAO.Listar("dataCadastro");

				PessoaDAO pessoaDAO = new PessoaDAO();
				pessoas = pessoaDAO.Listar("nome");
				
				Messages.addGlobalInfo("Cliente salvo com sucesso");
			} catch (RuntimeException erro) {
				Messages.addGlobalError("Ocorreu um erro ao tentar salvar o cliente");
				erro.printStackTrace();
			}
		
	}
}
