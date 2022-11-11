package GraphQl;

import javax.servlet.annotation.WebServlet;
import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.LogementRepository;
import repository.RendezVousRepository;

@WebServlet(urlPatterns = "/graphql")
public class GraphQlEndPoint extends SimpleGraphQLServlet {

	public GraphQlEndPoint() {
		super(buildSchema());
	}

	private static GraphQLSchema buildSchema() {
		LogementRepository logementRepository = new LogementRepository();
		RendezVousRepository rendezVousRepository = new RendezVousRepository();
		return SchemaParser.newParser().file("Schema.graphqls").
				resolvers(new Query(rendezVousRepository ,logementRepository),new Mutation(rendezVousRepository, logementRepository))
				.build()
				.makeExecutableSchema();
	}

}
