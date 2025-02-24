package com.blogapi.BlogAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapi.BlogAPI.services.UsersService;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	@Autowired
	private UsersService userService;

	@Autowired
	private PostService postService;

	@Autowired
	private AlbumService albumService;

	@GetMapping("/me")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<UserSummary> getCurrentUser(@CurrentUser UserPrincipal currentUser) {
		UserSummary userSummary = userService.getCurrentUser(currentUser);

		return new ResponseEntity<>(userSummary, HttpStatus.OK);
	}
}
