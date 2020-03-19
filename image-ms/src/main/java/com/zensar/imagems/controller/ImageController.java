package com.zensar.imagems.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.imagems.entities.Image;

@RestController
@RequestMapping("/")
public class ImageController {
	
	@Value("${server.instance.name}")
	private String instance;
	
	@Value("${some.property}")
	private String someProperty;  // class,instance,local
	
	//http://localhost:8082/images
	@RequestMapping(value = "/images")
	public List<Image> getAllImages() {
		
		System.out.println(someProperty);
		
		System.out.println(instance);

		return Arrays.asList(
				new Image(1, "Treehouse of Horror V", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3842005760"),
				new Image(2, "The Town", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3698134272"), new Image(3,
						"The Last Traction Hero", "https://www.imdb.com/title/tt0096697/mediaviewer/rm1445594112"));

	}

}
