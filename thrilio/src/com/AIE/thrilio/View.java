package com.AIE.thrilio;

import com.AIE.thrilio.constant.KidFriendlyStatus;
import com.AIE.thrilio.constant.UserType;
import com.AIE.thrilio.controllers.BookmarkController;
import com.AIE.thrilio.entities.Bookmark;
import com.AIE.thrilio.entities.User;
import com.AIE.thrilio.partner.Shareable;

public class View {

	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + "is browsing items...");
		int bookmarkCount = 0;

		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if (isBookmarked) {
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);

						System.out.println("new item bookmarked--" + bookmark);
					}
				}

				
				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
					// mark as kid friendly
					
					if (bookmark.isKidFriendlyEligible()
							&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus= getKidFriendlyStatusDecision(bookmark);
						if(!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							BookmarkController.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus,bookmark);
							
						}
					}
					
					// sharing!!
					if(bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.Approved) && bookmark instanceof Shareable){
						boolean isShared=getShareDecision();
						if(isShared) {
							BookmarkController.getInstance().share(user,bookmark);
						}
					}
				}

			}

		}

	}

	private static boolean getShareDecision() {
		return Math.random() < 0.5 ? true : false;
		
	}

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
		double randomVal = Math.random();
		return randomVal < 0.4 ? KidFriendlyStatus.Approved
				: (randomVal >= 0.4 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED
						: KidFriendlyStatus.UNKNOWN;

	}
	/*
	 * public static void bookmark(User user, Bookmark[][] bookmarks ) {
	 * System.out.println("\n" + user.getEmail() + "is bookmarking"); for(int
	 * i=0;i<DataStore.USER_BOOKMARK_LIMIT;i++) { int typeOffset=(int)
	 * (Math.random()*DataStore.BOOKMARK_TYPES_COUNT); int bookmarkOffset=(int)
	 * (Math.random()*DataStore.BOOKMARK_COUNT_PER_TYPE);
	 * 
	 * Bookmark bookmark=bookmarks[typeOffset][bookmarkOffset];
	 * 
	 * BookmarkController.getInstance().saveUserBookmark(user,bookmark);
	 * 
	 * System.out.println(bookmark);
	 * 
	 * }
	 * 
	 * 
	 * }
	 */

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;

	}

}
