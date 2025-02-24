package com.blogapi.BlogAPI.service;

import com.blogapi.BlogAPI.models.Comment;
import com.blogapi.BlogAPI.payload.ApiResponse;
import com.blogapi.BlogAPI.payload.CommentRequest;
import com.blogapi.BlogAPI.payload.PagedResponse;
import com.blogapi.BlogAPI.security.UserPrincipal;

public interface CommentService {

	PagedResponse<Comment> getAllComments(Long postId, int page, int size);

	Comment addComment(CommentRequest commentRequest, Long postId, UserPrincipal currentUser);

	Comment getComment(Long postId, Long id);

	Comment updateComment(Long postId, Long id, CommentRequest commentRequest, UserPrincipal currentUser);

	ApiResponse deleteComment(Long postId, Long id, UserPrincipal currentUser);

}
