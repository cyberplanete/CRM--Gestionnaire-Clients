package crm.controleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import crm.dao.ClientDAO;
import crm.entity.ClientClass;
import crm.service.ServiceClient;


@Controller
@RequestMapping("/clients")
public class ControleurClient {
	
	//Créer un lien automatiquement grace à cette annotation
	@Autowired
	private ServiceClient serviceClient;

	
	@RequestMapping("/liste")
	public String listClients(Model pageClients) {
		
		//Obenir les clients depuis clientDAO
		List<ClientClass> listClient = serviceClient.GetListClient();
		
		//ajouter les clients à la page clients - listclientjsp est utilisé dans un foreach sur la page list-clients
		pageClients.addAttribute("listClientJSP", listClient);
		
		
		//retourne la liste des clients sur la page jsp suivante
		return "list-clients";
	}
	

}
