package com.AIE.thrilio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.AIE.thrilio.constant.BookGenre;
import com.AIE.thrilio.constant.MovieGenre;
import com.AIE.thrilio.manager.BookmarkManager;

class MovieTest {

	@Test
	void testIsKidFriendlyEligible() {
		//test 1;
		
		Movie movie = BookmarkManager.getInstance().createMovie(3000,"Citizen Kane","",1941,new String[]{"Orson Welles","Joseph Cotten"},new String[]{"Orson Welles"},MovieGenre.HORROR,8.5);
		boolean isKidFriendlyEligible=movie.isKidFriendlyEligible();
		assertFalse("for Horror genre - isKidFriendlyEligible() must return false", isKidFriendlyEligible);
				
		//test 2;
		 movie = BookmarkManager.getInstance().createMovie(3000,"Citizen Kane","",1941,new String[]{"Orson Welles","Joseph Cotten"},new String[]{"Orson Welles"},MovieGenre.THRILLERS,8.5);
		 isKidFriendlyEligible=movie.isKidFriendlyEligible();
		 assertFalse("for thriller genre - isKidFriendlyEligible() must return false", isKidFriendlyEligible);
	}

}
