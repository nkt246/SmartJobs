package dm.smartjobs.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.jena.iri.impl.Main;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.util.FileManager;

public class OWLDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		sparqlTest();

	}

	private static void sparqlTest() {
		// TODO Auto-generated method stub
		// FileManager.get().addLocatorClassLoader(Main.class.getClassLoader());
		// Model m =
		// FileManager.get().loadModel("F:/M. Tech/2nd Sem/DM/Project/smartJobsNew.owl",
		// "TURTLE");

		Model m = ModelFactory.createDefaultModel();
		try {
			m.read(new FileInputStream(
					"F:/M. Tech/2nd Sem/Eclipse WS/SmartJobsOWL/src/final.owl"),
					null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("hello after 1st try");
		String ns = System.getProperty("line.separator");

		String qs = "PREFIX ab: <http://www.owl-ontologies.com/Ontology1428565241.owl#>"
				+ "SELECT ?name WHERE {" + " ?c"
				// + i
				+ " ab:cname ?name ."
				// + ns + "?js ab:hasskil ?skill"
//				+ ns + "?js ab:jname ?name" 
				+ "}";

		System.out.println("hello after query");

		Query query = QueryFactory.create(qs);

		QueryExecution qexec = QueryExecutionFactory.create(query, m);
		String name1;
		try {
			ResultSet r = qexec.execSelect();

			while (r.hasNext()) {
				QuerySolution soln = r.nextSolution();
				Literal name = soln.getLiteral("name");
				// Resource rsrc1 = soln.getResource("c");
				// Resource rsrc2 = soln.getResource("skill");
				// RDFNode node = soln.get("x");
				// Resource rsrc3 = soln.getResource("skill");
				name1 = name.toString();
				// System.out.println(rsrc1);
				// System.out.println(rsrc2);
				System.out.println(name1);

				// System.out.println("hello in loop");
			}
		} finally {
			qexec.close();
		}
		System.out.println("hello near end");

	}
}
