package br.com.alura.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;

import br.com.alura.entidade.AgendamentoEmail;
import br.com.alura.servico.AgendamentoEmailServico;


@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/EmailQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class AgendamentoEmailMDB implements MessageListener{
	
	@Inject
	private AgendamentoEmailServico service;
	
	
	
	@Override
	public void onMessage(Message message) {
		try {
			AgendamentoEmail obj = message.getBody(AgendamentoEmail.class);
			service.enviar(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
