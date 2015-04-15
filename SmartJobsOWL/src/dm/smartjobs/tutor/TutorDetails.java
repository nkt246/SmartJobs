package dm.smartjobs.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;


/**
 * Servlet implementation class CompanyDetails
 */
@WebServlet("/TutorDetails")
public class TutorDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<String> tname;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TutorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
				+ "SELECT ?name WHERE {" + " ?t"
				// + i
				+ " ab:tname ?name ."
				// + ns + "?js ab:hasskil ?skill"
				// + ns + "?skill ab:skname ?name"
				+ "}";

		System.out.println("hello after query");

		Query query = QueryFactory.create(qs);

		QueryExecution qexec = QueryExecutionFactory.create(query, m);

		try {
			ResultSet r = qexec.execSelect();
			int i = 1;
			tname = new ArrayList<String>();
			while (r.hasNext()) {
				QuerySolution soln = r.nextSolution();
				Literal name = soln.getLiteral("name");
				// Resource rsrc1 = soln.getResource("c");
				// Resource rsrc2 = soln.getResource("skill");
				// RDFNode node = soln.get("x");
				// Resource rsrc3 = soln.getResource("skill");
				String tutor = name.toString();
				tname.add(tutor);
				// System.out.println(rsrc1);
				// System.out.println(rsrc2);
				System.out.println(tutor);

				// System.out.println("hello in loop");
			}
		} finally {
			qexec.close();
		}
		System.out.println("hello near end");
		request.setAttribute("tname", tname);
//		response.sendRedirect("CompanyDetails.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("TutorDetails.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
