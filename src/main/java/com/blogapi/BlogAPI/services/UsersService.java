package com.blogapi.BlogAPI.services;

import com.blogapi.BlogAPI.dtos.ApiResponse;
import com.blogapi.BlogAPI.dtos.InfoRequest;
import com.blogapi.BlogAPI.dtos.UserProfile;
import com.blogapi.BlogAPI.dtos.UserSummary;
import com.blogapi.BlogAPI.models.user.User;

public interface UsersService {

	// UserSummary getCurrentUser(UserPrincipal currentUser);

	boolean checkUsernameAvailability(String username);

	boolean checkEmailAvailability(String email);

	UserProfile getUserProfile(String username);

	User addUser(User user);

	User updateUser(User newUser, String username, User currentUser);

	ApiResponse deleteUser(String username, User currentUser);

	ApiResponse giveAdmin(String username);

	ApiResponse removeAdmin(String username);

	UserProfile setOrUpdateInfo(User currentUser, InfoRequest infoRequest);

}
