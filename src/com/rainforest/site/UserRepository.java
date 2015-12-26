package com.rainforest.site;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.rainforest.entities.User;

public class UserRepository {
	
	public static Set<User> users = new HashSet<>();
	
	public static Map<Integer, User> userMap = new HashMap<Integer, User>();
	
	private static int seq;

	public static int getSeq() {
//		return ++UserRepository.seq;
//		UserRepository.seq += 1;
		return UserRepository.seq;
	}

	public static void setSeq(int seq) {
		UserRepository.seq = seq;
	}

	public static Set<User> getUsers() {
		return users;
	}

	public static void setUsers(Set<User> users) {
		UserRepository.users = users;
	}

	public static Map<Integer, User> getUserMap() {
		return userMap;
	}

	public static void setUserMap(Map<Integer, User> userMap) {
		UserRepository.userMap = userMap;
	}

}
