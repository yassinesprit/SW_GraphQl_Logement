package GraphQl;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import entite.Logement;
import entite.RendezVous;
import entite.Logement.Type;
import repository.LogementRepository;
import repository.RendezVousRepository;

public class Query implements GraphQLRootResolver {

	private final RendezVousRepository rendezVousRepository;
	private final LogementRepository logementRepository;
	
	
	
	
	public Query(RendezVousRepository rendezVousRepository, LogementRepository logementRepository) {
		this.rendezVousRepository = rendezVousRepository;
		this.logementRepository = logementRepository;
	}

	public List<RendezVous> getListeRendezVous(){
		return rendezVousRepository.getListeRendezVous();
	}
	
	
	public List<RendezVous> getListeRendezVousByLogementRef(int reference){
		return rendezVousRepository.getListeRendezVousByLogementRef(reference);
	}

	public RendezVous getRdvById(int id) {
      return rendezVousRepository.getRendezVousById(id);
	}

	public Logement getLogementsByReference(int reference){
		return logementRepository.getLogementsByReference(reference);
	}
	
	public List<Logement> getLogementsByType(Type type){
		return logementRepository.getLogementsByType(type);
	}
	
	
}
