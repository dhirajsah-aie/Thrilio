package com.AIE.thrilio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.AIE.thrilio.constant.BookGenre;
import com.AIE.thrilio.manager.BookmarkManager;

class BookTest {

	@Test
	void testIsKidFriendlyEligible() {
		//test 1;
		
		Book book=BookmarkManager.getInstance().createBook(4000,"Walden",1854,"Wilder Publications",new String[] {"Henry David Thoreau"},BookGenre.PHILOSOPHY,4.3);
		boolean isKidFriendlyEligible=book.isKidFriendlyEligible();
		assertFalse("for philosphy genre - isKidFriendlyEligible() must return false", isKidFriendlyEligible);
		
		//test 2;
		book=BookmarkManager.getInstance().createBook(4000,"Walden",1854,"Wilder Publications",new String[] {"Henry David Thoreau"},BookGenre.SELF_HELP,4.3);
		isKidFriendlyEligible=book.isKidFriendlyEligible();
		assertFalse("for self help genre - isKidFriendlyEligible() must return false", isKidFriendlyEligible);
	}

}
