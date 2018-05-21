package crm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crm.dao.ClientDAO;
import crm.entity.ClientClass;

@Service
public class ServiceClientImplementation implements ServiceClient {

	@Autowired
	private ClientDAO clientDAO;
	
	
	@Override
	@Transactional
	public List<ClientClass> GetListClient() {
		
		List<ClientClass> listClients = clientDAO.getClients();
		
		return listClients;
	}

}
