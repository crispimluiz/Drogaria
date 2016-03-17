package br.com.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Estado;

public class EstadoDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("Espirito Santo");
		estado.setSigla("EP");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);

	}

	@Test
	@Ignore
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.Listar();

		for (Estado estado : resultado) {
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 3L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum estado escontrado, favor colocar uma opção válida!");
		} else {
			System.out.println("Registro encontrado: ");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 6L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		if (estado == null) {
			System.out.println("Nenhum estado escontrado, favor colocar uma opção válida!");
		} else {
			estadoDAO.excluir(estado);
			System.out.println("Registro Removido: ");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
			
		}
		
	}
	@Test
	public void editar(){
		Long codigo = 5L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		if (estado == null) {
			System.out.println("Nenhum estado escontrado, favor colocar uma opção válida!");
		} else {
			System.out.println("Registro Antes: ");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
			
			estado.setNome("Minas Gerais");
			estado.setSigla("Mg");
			estadoDAO.editar(estado);
			System.out.println("Registro Editado: ");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
			
		}
		
	}
	
}
