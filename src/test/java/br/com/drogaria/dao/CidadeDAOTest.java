package br.com.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Cidade;
import br.com.drogaria.domain.Estado;

public class CidadeDAOTest {
	@Test
	@Ignore
	public void salvar(){
		EstadoDAO estadoDAO = new EstadoDAO();
		
		Estado estado = estadoDAO.buscar(5L);
		
		Cidade cidade = new Cidade();
		cidade.setNome("Uberlândia");
		cidade.setEstado(estado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
	}
	@Test
	@Ignore
	public void listar(){
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.Listar();
		
		for(Cidade cidade: resultado){
			System.out.println("Código da cidade: "+ cidade.getCodigo());
			System.out.println("Nome da cidade: "+ cidade.getNome());
			System.out.println("Código do Estado: "+ cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: "+ cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: "+ cidade.getEstado().getNome());
			System.out.println();
		}
	}
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 7L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		
			System.out.println("Código da cidade: "+ cidade.getCodigo());
			System.out.println("Nome da cidade: "+ cidade.getNome());
			System.out.println("Código do Estado: "+ cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: "+ cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: "+ cidade.getEstado().getNome());
			System.out.println();
	}
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 12L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		cidadeDAO.excluir(cidade);
		
		System.out.println("Código da cidade: "+ cidade.getCodigo());
		System.out.println("Nome da cidade: "+ cidade.getNome());
		System.out.println("Código do Estado: "+ cidade.getEstado().getCodigo());
		System.out.println("Sigla do Estado: "+ cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: "+ cidade.getEstado().getNome());
		System.out.println();
	}
	@Test
	public void editar(){
		Long codigoCidade = 13L;
		Long codigoEstado = 1L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoEstado);
		
		System.out.println("Código do Estado: "+ estado.getCodigo());
		System.out.println("Sigla do Estado: "+ estado.getSigla());
		System.out.println("Nome do Estado: "+ estado.getNome());
		System.out.println();
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		System.out.println("Código da cidade: "+ cidade.getCodigo());
		System.out.println("Nome da cidade: "+ cidade.getNome());
		System.out.println("Código do Estado: "+ cidade.getEstado().getCodigo());
		System.out.println("Sigla do Estado: "+ cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: "+ cidade.getEstado().getNome());
		System.out.println();
		
		cidade.setNome("Campo Verde");
		cidade.setEstado(estado);
		
		cidadeDAO.editar(cidade);
		
		System.out.println("Código da cidade: "+ cidade.getCodigo());
		System.out.println("Nome da cidade: "+ cidade.getNome());
		System.out.println("Código do Estado: "+ cidade.getEstado().getCodigo());
		System.out.println("Sigla do Estado: "+ cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: "+ cidade.getEstado().getNome());
		System.out.println();
	}
}
