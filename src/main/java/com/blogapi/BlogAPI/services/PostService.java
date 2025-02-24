package com.blogapi.BlogAPI.services;

import com.blogapi.BlogAPI.models.Post;
import com.blogapi.BlogAPI.dtos.ApiResponse;
import com.blogapi.BlogAPI.dtos.PagedResponse;
import com.blogapi.BlogAPI.dtos.PostRequest;
import com.blogapi.BlogAPI.dtos.PostResponse;
import com.blogapi.BlogAPI.security.UserPrincipal;

public interface PostService {
	PagedResponse<Post> getAllPosts(int page, int size);

	PagedResponse<Post> getPostsByCreatedBy(String username, int page, int size);

	PagedResponse<Post> getPostsByCategory(Long id, int page, int size);

	PagedResponse<Post> getPostsByTag(Long id, int page, int size);

	Post updatePost(Long id, PostRequest newPostRequest, UserPrincipal currentUser);

	ApiResponse deletePost(Long id, UserPrincipal currentUser);

	PostResponse addPost(PostRequest postRequest, UserPrincipal currentUser);

	Post getPost(Long id);

}
