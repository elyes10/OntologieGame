package com.example.demo;

import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.ontology.*;
import org.apache.jena.query.* ;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/API")
@RestController
public class ApiContoller {
	
	
	@RequestMapping(value = "/games",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<JSONObject> retrieveGames() {
		List<JSONObject> list=new ArrayList();
		String NS = "";
		// lire le model a partir d'une ontologie
		Model model = JenaEngine.readModel("data/Game.owl");

		if (model != null) {
		//lire le Namespace de l’ontologie
		NS = model.getNsPrefixURI("");

		// apply our rules on the owlInferencedModel
		Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
		// query on the model after inference
		String queryString = "PREFIX ns: <http://www.owl-ontologies.com/Game.owl#> "
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ "SELECT ?game "
				+ "WHERE{ "
				+ "	   ?game rdf:type ns:Game ."
				+ "} ";
		
		
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, inferedModel);
		    ResultSet results = qexec.execSelect() ;
		    while (results.hasNext())
		    {
		    	QuerySolution soln = results.nextSolution() ;
		    	System.out.println(soln);
		    	RDFNode x = soln.get("game") ;
		    ;
		    	
                JSONObject obj = new JSONObject();
                obj.put("game" ,x.toString().split("#")[1]);
             
				list.add(obj);
		    }
		} else {
		System.out.println("Error when reading model from ontology");
		}
		System.out.println("end : "+list);
		return list;
	}
	
	
	@RequestMapping(value = "/platforms",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<JSONObject> retrievePlatforms() {
		List<JSONObject> list=new ArrayList();
		String NS = "";
		// lire le model a partir d'une ontologie
		Model model = JenaEngine.readModel("data/Game.owl");

		if (model != null) {
		//lire le Namespace de l’ontologie
		NS = model.getNsPrefixURI("");

		// apply our rules on the owlInferencedModel
		Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
		// query on the model after inference
		String queryString = "PREFIX ns: <http://www.owl-ontologies.com/Game.owl#> "
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ "SELECT ?game "
				+ "WHERE{ "
				+ "	   ?game rdf:type ns:Platform ."
				+ "} ";
		
		//System.out.println(JenaEngine.executeQuery(inferedModel,queryString));
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, inferedModel);
		    ResultSet results = qexec.execSelect() ;
		    while (results.hasNext())
		    {
		    	QuerySolution soln = results.nextSolution() ;
		    	System.out.println(soln);
		    	RDFNode x = soln.get("game") ;
		    	//RDFNode y = soln.get("duration") ;
		    	
                JSONObject obj = new JSONObject();
                obj.put("game" ,x.toString().split("#")[1]);
                //obj.put("duration" ,y.toString());
				list.add(obj);
		    }
		} else {
		System.out.println("Error when reading model from ontology");
		}
		System.out.println("end : "+list);
		return list;
	}
	
	
	@RequestMapping(value = "/awards",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<JSONObject> retrieveAwards() {
		List<JSONObject> list=new ArrayList();
		String NS = "";
		// lire le model a partir d'une ontologie
		Model model = JenaEngine.readModel("data/Game.owl");

		if (model != null) {
		//lire le Namespace de l’ontologie
		NS = model.getNsPrefixURI("");

		// apply our rules on the owlInferencedModel
		Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
		// query on the model after inference
		String queryString = "PREFIX ns: <http://www.owl-ontologies.com/Game.owl#> "
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ "SELECT ?game "
				+ "WHERE{ "
				+ "	   ?game rdf:type ns:Award ."
				+ "} ";
		
		//System.out.println(JenaEngine.executeQuery(inferedModel,queryString));
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, inferedModel);
		    ResultSet results = qexec.execSelect() ;
		    while (results.hasNext())
		    {
		    	QuerySolution soln = results.nextSolution() ;
		    	System.out.println(soln);
		    	RDFNode x = soln.get("game") ;
		    	//RDFNode y = soln.get("duration") ;
		    	
                JSONObject obj = new JSONObject();
                obj.put("game" ,x.toString().split("#")[1]);
                //obj.put("duration" ,y.toString());
				list.add(obj);
		    }
		} else {
		System.out.println("Error when reading model from ontology");
		}
		System.out.println("end : "+list);
		return list;
	}
	
	@RequestMapping(value = "/game/{gamename}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<JSONObject> retrieveOneMovie(@PathVariable("gamename") String gamename) {
		List<JSONObject> list=new ArrayList();
		String NS = "";
		// lire le model a partir d'une ontologie
		Model model = JenaEngine.readModel("data/Game.owl");

		if (model != null) {
		//lire le Namespace de l’ontologie
		NS = model.getNsPrefixURI("");

		// apply our rules on the owlInferencedModel
		Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
		// query on the model after inference
		String queryString = "PREFIX ns: <http://www.owl-ontologies.com/Game.owl#> "
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ "SELECT ?game "
				+ "WHERE{ "
				+ "	   ?game rdf:type ns:Game ."
				+ "	   ?game ns:name '"+gamename+"' ."
				+ "} ";
		//System.out.println(JenaEngine.executeQuery(inferedModel,queryString));
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, inferedModel);
		    ResultSet results = qexec.execSelect() ;
		    while (results.hasNext())
		    {
		    	QuerySolution soln = results.nextSolution() ;
		    	System.out.println(soln);
		    	RDFNode x = soln.get("game") ;
		    	//RDFNode y = soln.get("duration") ;
		    	
                JSONObject obj = new JSONObject();
                obj.put("game" ,x.toString().split("#")[1]);
                //obj.put("duration" ,y.toString());
				list.add(obj);
		    }
		} else {
		System.out.println("Error when reading model from ontology");
		}
		System.out.println("end : "+list);
		return list;
	}
	
	@RequestMapping(value = "/online",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<JSONObject> retrieveOnline() {
		List<JSONObject> list=new ArrayList();
		String NS = "";
		// lire le model a partir d'une ontologie
		Model model = JenaEngine.readModel("data/Game.owl");

		if (model != null) {
		//lire le Namespace de l’ontologie
		NS = model.getNsPrefixURI("");

		// apply our rules on the owlInferencedModel
		Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
		// query on the model after inference
		String queryString = "PREFIX ns: <http://www.owl-ontologies.com/Game.owl#> "
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ "SELECT ?game "
				+ "WHERE{ "
				+ "	   ?game rdf:type ns:Online ."
				+ "} ";
		
		//System.out.println(JenaEngine.executeQuery(inferedModel,queryString));
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, inferedModel);
		    ResultSet results = qexec.execSelect() ;
		    while (results.hasNext())
		    {
		    	QuerySolution soln = results.nextSolution() ;
		    	System.out.println(soln);
		    	RDFNode x = soln.get("game") ;
		    	//RDFNode y = soln.get("duration") ;
		    	
                JSONObject obj = new JSONObject();
                obj.put("game" ,x.toString().split("#")[1]);
                //obj.put("duration" ,y.toString());
				list.add(obj);
		    }
		} else {
		System.out.println("Error when reading model from ontology");
		}
		System.out.println("end : "+list);
		return list;
	}
	@RequestMapping(value = "/ofline",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<JSONObject> retrieveOfline() {
		List<JSONObject> list=new ArrayList();
		String NS = "";
		// lire le model a partir d'une ontologie
		Model model = JenaEngine.readModel("data/Game.owl");

		if (model != null) {
		//lire le Namespace de l’ontologie
		NS = model.getNsPrefixURI("");

		// apply our rules on the owlInferencedModel
		Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
		// query on the model after inference
		String queryString = "PREFIX ns: <http://www.owl-ontologies.com/Game.owl#> "
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ "SELECT ?game "
				+ "WHERE{ "
				+ "	   ?game rdf:type ns:Offline ."
				+ "} ";
		
		//System.out.println(JenaEngine.executeQuery(inferedModel,queryString));
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, inferedModel);
		    ResultSet results = qexec.execSelect() ;
		    while (results.hasNext())
		    {
		    	QuerySolution soln = results.nextSolution() ;
		    	System.out.println(soln);
		    	RDFNode x = soln.get("game") ;
		    	//RDFNode y = soln.get("duration") ;
		    	
                JSONObject obj = new JSONObject();
                obj.put("game" ,x.toString().split("#")[1]);
                //obj.put("duration" ,y.toString());
				list.add(obj);
		    }
		} else {
		System.out.println("Error when reading model from ontology");
		}
		System.out.println("end : "+list);
		return list;
	}
}
