package br.com.alura.servico;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.alura.dao.AgendamentoEmailDAO;
import br.com.alura.entidade.AgendamentoEmail;

@Stateless
public class AgendamentoEmailServico {
	
	private static final Logger log = Logger.getLogger(AgendamentoEmailServico.class.getName());
	
	@Inject
	private AgendamentoEmailDAO dao;

	public List<AgendamentoEmail> listar() {
		return dao.listar();
	}
	
	public void inserir(AgendamentoEmail agendamentoEmail) {
		agendamentoEmail.setAgendado(false);
		dao.inserir(agendamentoEmail);
	}
	
	public List<AgendamentoEmail> listarPorNaoAgendado(){
		return dao.listarPorNaoAgendado();
	}
	
	public void alterar(AgendamentoEmail obj) {
		obj.setAgendado(true);
		dao.alterar(obj);
	}
	
	public void enviar(AgendamentoEmail obj) {
		try {
			Thread.sleep(5000);
			log.info("E-mail Enviado");
		} catch (Exception e) {
			log.warning(e.getMessage());
		}
	}
}
