package com.my.travelmap.repository.post;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.travelmap.entity.Post;

public interface PostRepository extends JpaRepository<Post, UUID> {

}
