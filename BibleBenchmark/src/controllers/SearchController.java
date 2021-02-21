package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Scripture;
import beans.Search;
import business.SearchBusinessInterface;

@ManagedBean
@SessionScoped
public class SearchController {
	@Inject
	SearchBusinessInterface service;
	
	public void findVerse(Search search) {
		
		
		//String link = "https://bible-api.com/" + search.getName() + "+" + search.getChapter() + ":" + search.getVerse() + "?callback=func";
		//System.out.println(link);
		String link = "https://api.biblia.com/v1/bible/content/LEB.txt.txt?passage="+search.getName() +search.getChapter() +"."+search.getVerse() + "&callback=myCallbackFunction&key=fd37d8f28e95d3be8cb4fbc37e15e18e";
		System.out.println(link);
		Scripture holy = new Scripture();
		holy.setScripture(service.findVerse(link));
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("scripture", holy);
		service.findVerse(link);
		//System.out.println("The verse is:" + holy.formattedScripture());
	}
	
	public void findWord(Search search) {
		String link = "https://api.biblia.com/v1/bible/search/LEB.txt.txt?query="+search.getName() + "&mode=verse&start=0&limit=1&key=fd37d8f28e95d3be8cb4fbc37e15e18e";
		System.out.println(link);
		Scripture holy = new Scripture();
		holy.setScripture(service.findVerse(link));
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("scripture", holy);
		service.findVerse(link);
		System.out.println("The Word is: " + search.getName());
		
	}
	
	public void findManyWords(Search search) {
		String link = "https://api.biblia.com/v1/bible/search/LEB.txt.txt?query="+search.getName() + "&mode=verse&start=0&limit=20&key=fd37d8f28e95d3be8cb4fbc37e15e18e";
		System.out.println(link);
		Scripture holy = new Scripture();
		holy.setScripture(service.findVerse(link));
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("scripture", holy);
		service.findVerse(link);
		System.out.println("The Word is: " + search.getName());
	}
	
	
	
}
