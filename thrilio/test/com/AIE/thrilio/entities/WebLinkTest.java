package com.AIE.thrilio.entities;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import com.AIE.thrilio.manager.BookmarkManager;

class WebLinkTest {

	@Test
	void testIsKidFriendlyEligible() {
		//Test 1:porn in url : false
		WebLink webLink=BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger,Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html", "http://www.javaworld.com");
		boolean isKidFriendlyEligible=webLink.isKidFriendlyEligible();
		assertFalse("for porn in url - isKidFriendlyEligible() must return false", isKidFriendlyEligible);
		
		//Test 2:porn in title:false
		
		webLink=BookmarkManager.getInstance().createWebLink(2000, "Taming porn,Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com");
		isKidFriendlyEligible=webLink.isKidFriendlyEligible();
		assertFalse("for porn in title - isKidFriendlyEligible() must return false", isKidFriendlyEligible);
		
		//Test 3:adult in host:False
		
		webLink=BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger,Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.adult.com");
		isKidFriendlyEligible=webLink.isKidFriendlyEligible();
		assertFalse("for adult in host - isKidFriendlyEligible() must return false", isKidFriendlyEligible);
		
		//Test 4:adult in url but not in host: True
		
		webLink=BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger,Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html", "http://www.javaworld.com");
		isKidFriendlyEligible=webLink.isKidFriendlyEligible();
		assertTrue("for adult in url,but not in host - isKidFriendlyEligible() must return true", isKidFriendlyEligible);
		
		//Test 5: adult in title only: True
		
		webLink=BookmarkManager.getInstance().createWebLink(2000, "Taming adult,Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com");
		isKidFriendlyEligible=webLink.isKidFriendlyEligible();
		assertTrue("for adult in title - isKidFriendlyEligible() must return true", isKidFriendlyEligible);
	}

}
