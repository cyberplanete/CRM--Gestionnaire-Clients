package crm.controleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/ajoutClient")
	public String ajouterClientMethode(Model modelClient) {
		
		//Creer un attribut Model lier au formulaire ajouter-client.jp
		ClientClass unClientClass = new ClientClass();		
		modelClient.addAttribute("client", unClientClass);

		return "ajouter-client";
	}
	
	@PostMapping("/sauvegardeClient")
	public String sauvegardeClient(@ModelAttribute("client") ClientClass clientClass ) {
		
		serviceClient.ajoutClient(clientClass);
		
		return "redirect:/clients/liste/";
		
	}
	
	@GetMapping("/miseAJourClient")
	public String miseAJourClient(@RequestParam("idClient")int idClient, Model modelclient ) {
		
		//Obtenir le client depuis la base de donnée
		ClientClass clientClass =serviceClient.GetClient(idClient);
		
		//Auto complete le formulaire  
		modelclient.addAttribute("clientUpdate", clientClass);
		//et envoyé sur la page
		return "miseAJour-client";
		
		
	}
	
}

