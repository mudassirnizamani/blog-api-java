package com.blogapi.BlogAPI.service;

import com.blogapi.BlogAPI.payload.ApiResponse;
import com.blogapi.BlogAPI.payload.PagedResponse;
import com.blogapi.BlogAPI.payload.PhotoRequest;
import com.blogapi.BlogAPI.payload.PhotoResponse;
import com.blogapi.BlogAPI.security.UserPrincipal;

public interface PhotoService {

	PagedResponse<PhotoResponse> getAllPhotos(int page, int size);

	PhotoResponse getPhoto(Long id);

	PhotoResponse updatePhoto(Long id, PhotoRequest photoRequest, UserPrincipal currentUser);

	PhotoResponse addPhoto(PhotoRequest photoRequest, UserPrincipal currentUser);

	ApiResponse deletePhoto(Long id, UserPrincipal currentUser);

	PagedResponse<PhotoResponse> getAllPhotosByAlbum(Long albumId, int page, int size);

}