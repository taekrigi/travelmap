package com.my.travelmap.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.my.travelmap.dto.CommentDto;
import com.my.travelmap.dto.PostDto;
import com.my.travelmap.entity.Comment;
import com.my.travelmap.entity.Post;
import com.my.travelmap.mapper.CommentMapper;
import com.my.travelmap.mapper.PostMapper;
import com.my.travelmap.param.CommentParam;
import com.my.travelmap.param.PostParam;
import com.my.travelmap.repository.comment.CommentRepository;
import com.my.travelmap.repository.post.PostRepository;
import com.my.travelmap.util.CommonUtilService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;
	private final PostMapper postMapper;
	private final CommentRepository commentRepository;
	private final CommentMapper commentMapper;
	
	public List<PostDto> getPosts() {
		return postMapper.toListDto(postRepository.findAll());
	}
	
	public PostDto getPost(UUID id) {
		return postMapper.toDto(findPostById(id));
	}
	
	public PostDto addPost(PostParam postParam) {
		return postMapper.toDto(postRepository.save(postMapper.toEntity(postParam)));
	}
	
	public PostDto updatePost(UUID id, PostParam postParam) {
		Post post = findPostById(id);
		post.update(postParam);
		return postMapper.toDto(post);
	}
	
	public PostDto deletePost(UUID id) {
		Post post = findPostById(id);
		postRepository.deleteById(id);
		return postMapper.toDto(post);
	}
	
	public List<CommentDto> getCommentsInPost(UUID id) {
		Post post = findPostById(id);
		return commentMapper.toListDto(post.getComments());
	}
	
	public CommentDto getCommentById(UUID commentId) {
		return commentMapper.toDto(findCommentById(commentId));
	}
	
	public CommentDto addCommentInPost(UUID id, CommentParam commentParam) {
		Post post = findPostById(id);
		Comment comment = commentMapper.toEntity(commentParam);
		comment.setPost(post);
		return commentMapper.toDto(comment);
	}
	
	public CommentDto updateCommentInPost(UUID id, UUID commentId, CommentParam commentParam) {
		Post post = findPostById(id);
		Comment comment = findCommentById(commentId);
		comment.setPost(post);
		comment.update(commentParam);
		return commentMapper.toDto(comment);
	}
	
	public CommentDto deleteCommentInPost(UUID commentId) {
		Comment comment = findCommentById(commentId);
		commentRepository.deleteById(commentId);
		return commentMapper.toDto(comment);
	}
	
	private Post findPostById(UUID id) {
		return CommonUtilService.throwIfNotExist(postRepository.findById(id), id);
	}
	
	private Comment findCommentById(UUID commentId) {
		return CommonUtilService.throwIfNotExist(commentRepository.findById(commentId), commentId);
	}
}
