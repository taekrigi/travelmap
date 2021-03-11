package com.my.travelmap.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.travelmap.dto.PostDto;
import com.my.travelmap.param.PostParam;
import com.my.travelmap.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("post")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;
	
	@GetMapping
	public List<PostDto> getPosts() {
		return postService.getPosts();
	}
	
	@GetMapping("{id}")
	public PostDto getPostById(@PathVariable UUID id) {
		return postService.getPost(id);
	}
	
	@PostMapping
	public ResponseEntity<PostDto> addPost(@RequestBody PostParam postParam) throws URISyntaxException {
		PostDto post = postService.addPost(postParam);
		return ResponseEntity.created(new URI("/post/" + post.getId())).body(post);
	}
	
	@PutMapping("{id}")
	public PostDto updatePost(@PathVariable UUID id, @RequestBody PostParam postParam) {
		return postService.updatePost(id, postParam);
	}
	
	@DeleteMapping("{id}")
	public PostDto deletePost(@PathVariable UUID id) {
		return postService.deletePost(id);
	}
}
