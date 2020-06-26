package com.vitorlipe.demoajax.service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.vitorlipe.demoajax.domain.SocialMetaTag;

@Service
public class SocialMetaTagService {
	
	
 private static  Logger logger =  LoggerFactory.getLogger(SocialMetaTagService.class);
	
 
 
 public SocialMetaTag getSocialMetaTagByUrl(String url) {
	 
	 SocialMetaTag twitter = getTwitterByUrl(url);
	 
	 if(!isEmpty(twitter)) {
		 return twitter;
	 }
	 
	 SocialMetaTag op = getOpenGraficByUrl(url);
	 if(!isEmpty(op)) {
		 return op;
	 }
	 
	 return null;
 }
	
	
	private  SocialMetaTag getOpenGraficByUrl(String url) {
	
		SocialMetaTag metaTag =   new SocialMetaTag();
		
		try {
			Document document =  Jsoup.connect(url).get();
			
			metaTag.setTitulo(document.head().select("meta[property=og:title]").attr("content"));
			metaTag.setSite(document.head().select("meta[property=og:site_name]").attr("content"));
			metaTag.setImagem(document.head().select("meta[property=og:image]").attr("content"));
			metaTag.setUrl(document.head().select("meta[property=og:url]").attr("content"));
			
		} catch (IOException e) {
		
			logger.error(e.getMessage(),e.getCause());
		}
		
		return metaTag;
	}
	
	
	
	

	
	private  SocialMetaTag getTwitterByUrl(String url) {
	
		SocialMetaTag metaTag =   new SocialMetaTag();
		
		try {
			Document document =  Jsoup.connect(url).get();
			
			metaTag.setTitulo(document.head().select("meta[name=twitter:title]").attr("content"));
			metaTag.setSite(document.head().select("meta[name=twitter:site]").attr("content"));
			metaTag.setImagem(document.head().select("meta[name=twitter:image]").attr("content"));
			metaTag.setUrl(document.head().select("meta[name=twitter:url]").attr("content"));
			
		} catch (IOException e) {
			
			logger.error(e.getMessage(),e.getCause());
		}
		
		return metaTag;
	}
	
	
	
	
	private boolean isEmpty(SocialMetaTag socialMetaTag) {
		
		if(socialMetaTag.getImagem().isEmpty()) {
			return true;
		}
		
		if(socialMetaTag.getUrl().isEmpty()) {
			return true;
		}
		
		if(socialMetaTag.getTitulo().isEmpty()) {
			return true;
		}
		
		if(socialMetaTag.getSite().isEmpty()) {
			return true;
		}
		
		return false;
	}
	

}
