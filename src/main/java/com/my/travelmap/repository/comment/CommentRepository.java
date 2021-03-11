package com.my.travelmap.repository.comment;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.travelmap.entity.Comment;
import com.my.travelmap.entity.Post;

public interface CommentRepository extends JpaRepository<Comment, UUID> {

	List<Comment> findCommentsByPost(Post post);
}
