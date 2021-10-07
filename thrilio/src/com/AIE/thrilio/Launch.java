package com.AIE.thrilio;

import com.AIE.thrilio.entities.Bookmark;
import com.AIE.thrilio.entities.User;
import com.AIE.thrilio.manager.BookmarkManager;
import com.AIE.thrilio.manager.UserManager;

public class Launch {
	private static User[] users;
	private static Bookmark[][] bookmarks;
	
	private static void loadData() {
		System.out.println("1. Loading Data...");
		DataStore.loadData();
		users=UserManager.getInstance().getUsers();
		bookmarks=BookmarkManager.getInstance().getBookmarks();
		
		//test whether we r loading data properly
//		System.out.println("printing Data...");
//		printUserData();
//		printBookmarkData();
		
	}

	private static void printBookmarkData() {
		for(Bookmark[] bookmarkList:bookmarks) {
			for(Bookmark bookmark:bookmarkList ) {
				System.out.println(bookmark);
			}
		}
		
	}

	private static void printUserData() {
		for(User user:users) {
			System.out.println(user);
		}
		
	}
	
	private static void start() {
		//System.out.println("\n 2 Bookmarking...");
		for(User user:users) {
			View.browse(user,bookmarks);
			
		}
		
		
	}


	public static void main(String[] args) {
		loadData();
		start();

	}

	
	

}
