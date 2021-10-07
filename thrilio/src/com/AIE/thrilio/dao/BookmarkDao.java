package com.AIE.thrilio.dao;

import com.AIE.thrilio.DataStore;
import com.AIE.thrilio.entities.Bookmark;
import com.AIE.thrilio.entities.UserBookmark;

// fetching Bookmark  Data from DataStore , in real world use Database use Database to fetch using mysql


public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
		
	}

}
