package GraphQl;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

public class Mutation implements GraphQLRootResolver {

	private final RendezVousRepository rendezVousRepository;
	private final LogementRepository logementRepository;
	
	
	public Mutation(RendezVousRepository rendezVousRepository, LogementRepository logementRepository) {
		super();
		this.rendezVousRepository = rendezVousRepository;
		this.logementRepository = logementRepository;
	}
	
	public RendezVous addRendezVous(int id, String date, String heure, int refLog, String num) {
    	RendezVous rdv=new RendezVous(id, date, heure, logementRepository.getLogementsByReference(refLog), num);
    	rendezVousRepository.addRendezVous(rdv);
    	return rdv;
    }
	
	public boolean updateRendezVous(int id, String date, String heure,  String num) {
		RendezVous rendezVous = new RendezVous(id, date, heure, null, num);
		return rendezVousRepository.updateRendezVous(rendezVous);
	}
	
	public boolean deleteRendezVous(int id){
		return rendezVousRepository.deleteRendezVous(id);
	}

	public Logement saveLogement(int reference, String adresse) {
		Logement l = new Logement(reference,adresse);
		return logementRepository.saveLogement(l);
	}
	
}
