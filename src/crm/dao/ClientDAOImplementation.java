package crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import crm.entity.ClientClass;



@Repository
public class ClientDAOImplementation implements ClientDAO{

@Autowired
private SessionFactory generateurDeSession;

//Retourne la liste des clients au controllerCRM
//@Transactional, il faut utiliser le tag <annotation-driven> de l'espace de nommage tx pour préciser à Spring 
//que les annotations sont utilisées pour la définition des transactions.
//indique au conteneur les méthodes qui doivent s'exécuter dans un contexte transactionnel.
//@Transactional. Enlève l'obligation d'ajouter du code tel que
//Begin transtation , commit transaction….

//Avec projet_crm_spring_hibernate.xml
	@Override
	@Transactional
	public List<ClientClass> getClients() {
		
		//Obtenir la session en cours d'hibernate
		Session sessionEnCours =generateurDeSession.getCurrentSession();
		
		//Créer une requete sur la ClassClient pour obtenir la liste
		Query<ClientClass> uneRequete = sessionEnCours.createQuery("from ClientClass", ClientClass.class);
		
		//Obtenir ke resultat final
		List<ClientClass> listClients = uneRequete.getResultList();
		
		//Retour sous forme de liste
		return listClients;
		
	}

}
