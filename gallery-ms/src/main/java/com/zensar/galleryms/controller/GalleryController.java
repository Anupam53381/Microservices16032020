package com.zensar.galleryms.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

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
	public Gallery getAllImagesFromImageMS(@PathVariable("id")int imageId) throws RestClientException, URISyntaxException{
		
		
		Gallery gallery=new Gallery();
		gallery.setId(imageId);
		

		//System.out.println(restTemplate.getForObject(new URI("http://IMAGE-SERVICE/images/"), List.class));
		List<Object> images = restTemplate.getForObject("http://IMAGE-SERVICE/images", List.class);
		
		//List<Object> images = restTemplate.getForObject("http://localhost:8082/images", List.class);
		
		gallery.setImages(images);
		
		return gallery;
	}

}
