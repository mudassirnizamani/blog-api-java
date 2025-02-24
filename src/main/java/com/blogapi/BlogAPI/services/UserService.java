package com.blogapi.BlogAPI.services;

import com.blogapi.BlogAPI.models.user.User;
import com.blogapi.BlogAPI.dtos.ApiResponse;
import com.blogapi.BlogAPI.dtos.InfoRequest;
import com.blogapi.BlogAPI.dtos.UserIdentityAvailability;
import com.blogapi.BlogAPI.dtos.UserProfile;
import com.blogapi.BlogAPI.dtos.UserSummary;
import com.blogapi.BlogAPI.security.UserPrincipal;

public interface UserService {

	UserSummary getCurrentUser(UserPrincipal currentUser);

	UserIdentityAvailability checkUsernameAvailability(String username);

	UserIdentityAvailability checkEmailAvailability(String email);

	UserProfile getUserProfile(String username);

	User addUser(User user);

	User updateUser(User newUser, String username, UserPrincipal currentUser);

	ApiResponse deleteUser(String username, UserPrincipal currentUser);

	ApiResponse giveAdmin(String username);

	ApiResponse removeAdmin(String username);

	UserProfile setOrUpdateInfo(UserPrincipal currentUser, InfoRequest infoRequest);

}
