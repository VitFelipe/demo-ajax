package com.vitorlipe.demoajax.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vitorlipe.demoajax.domain.SocialMetaTag;
import com.vitorlipe.demoajax.service.SocialMetaTagService;

@Controller
@RequestMapping("/meta")
public class SocialMetaTagController {

	@Autowired
	private SocialMetaTagService socialMetaTagService;

	@PostMapping("/info")
	public ResponseEntity<SocialMetaTag> getDadosViaUrl(@RequestParam("url") String url) {
		try {
		SocialMetaTag socialMetaTag = socialMetaTagService.getSocialMetaTagByUrl(url);

		if (socialMetaTag == null) {
			System.out.println("not found");
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(socialMetaTag);
		
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}
