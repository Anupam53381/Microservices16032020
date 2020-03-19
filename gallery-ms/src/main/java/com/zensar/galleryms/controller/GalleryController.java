package com.zensar.galleryms.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zensar.galleryms.entities.Gallery;

@RestController
public class GalleryController {
	
	
	
	@Autowired
	//@LoadBalanced
	private RestTemplate restTemplate;
	
	
	@RequestMapping("/")
	public String hi() {
		return "hi";

	}
	
	
	@RequestMapping(value = "/gallery/{id}")
	@HystrixCommand(fallbackMethod ="fallbackMethod" )
	public Gallery getAllImagesFromImageMS(@PathVariable("id")int imageId) throws RestClientException, URISyntaxException{
		
		System.out.println("Ram");
		
		

		//System.out.println(restTemplate.getForObject(new URI("http://IMAGE-SERVICE/images/"), List.class));
		//List<Object> images = restTemplate.getForObject("http://IMAGE-SERVICE/images", List.class);
		//config-client-app
		System.out.println("Before call");
		List<Object> images = restTemplate.getForObject("http://config-client-app/images", List.class);
		Gallery gallery=new Gallery();
		gallery.setId(imageId);
		System.out.println(images);
		System.out.println("After call ");
		//List<Object> images = restTemplate.getForObject("http://localhost:8082/images", List.class);
		
		gallery.setImages(images);
		
		return gallery;
	}
	
	public  Gallery fallbackMethod(int imageId) {
		System.out.println("Default Stuff");
		return new Gallery();
	}

}
