package com.my.travelmap.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.travelmap.dto.CommentDto;
import com.my.travelmap.dto.PostDto;
import com.my.travelmap.param.CommentParam;
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
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
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
	
	@GetMapping("{id}/comments")
	public List<CommentDto> getCommentsInPost(UUID id) {
		return postService.getCommentsInPost(id);
	}
	
	@GetMapping("/comment/{commentId}")
	public CommentDto getCommentById(@PathVariable UUID commentId) {
		return postService.getCommentById(commentId);
	}
	
	@PostMapping("{id}/comment")
	public ResponseEntity<CommentDto> addCommentInPost(@PathVariable UUID id, @RequestBody CommentParam commentParam) throws URISyntaxException {
		CommentDto comment = postService.addCommentInPost(id, commentParam);
		return ResponseEntity.created(new URI("/comment/" + comment.getId())).body(comment);
	}
	
	@PutMapping("{id}/comment/{commentId}")
	public CommentDto updateCommentInPost(@PathVariable UUID id, @PathVariable UUID commentId, @RequestBody CommentParam commentParam) {
		return postService.updateCommentInPost(id, commentId, commentParam);
	}
	
	@DeleteMapping("/comment/{commentId}")
	public CommentDto deleteCommentInPost(@PathVariable UUID commentId) {
		return postService.deleteCommentInPost(commentId);
	}
	
}
