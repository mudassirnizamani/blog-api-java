package com.blogapi.BlogAPI.controllers;

import com.blogapi.BlogAPI.exception.UnauthorizedException;
import com.blogapi.BlogAPI.models.Category;
import com.blogapi.BlogAPI.payload.ApiResponse;
import com.blogapi.BlogAPI.payload.PagedResponse;
import com.blogapi.BlogAPI.security.CurrentUser;
import com.blogapi.BlogAPI.security.UserPrincipal;
import com.blogapi.BlogAPI.service.CategoryService;
import com.blogapi.BlogAPI.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public PagedResponse<Category> getAllCategories(
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
		return categoryService.getAllCategories(page, size);
	}

	@PostMapping
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category,
			@CurrentUser UserPrincipal currentUser) {

		return categoryService.addCategory(category, currentUser);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable(name = "id") Long id) {
		return categoryService.getCategory(id);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Category> updateCategory(@PathVariable(name = "id") Long id,
			@Valid @RequestBody Category category, @CurrentUser UserPrincipal currentUser) throws UnauthorizedException {
		return categoryService.updateCategory(id, category, currentUser);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable(name = "id") Long id,
			@CurrentUser UserPrincipal currentUser) throws UnauthorizedException {
		return categoryService.deleteCategory(id, currentUser);
	}

}
