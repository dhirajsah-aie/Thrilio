package com.AIE.thrilio.entities;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.AIE.thrilio.constant.BookGenre;
import com.AIE.thrilio.partner.Shareable;

public class Book extends Bookmark implements Shareable{
	private int publicationYear;
	private String publisher;
	private String[] author;
	private String genre;
	private double amazonRating;
	
	
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String[] getAuthor() {
		return author;
	}
	public void setAuthor(String[] author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getAmazonRating() {
		return amazonRating;
	}
	public void setAmazonRating(double amazonRating) {
		this.amazonRating = amazonRating;
	}
	@Override
	public String toString() {
		return "Book [publicationYear=" + publicationYear + ", publisher=" + publisher + ", author="
				+ Arrays.toString(author) + ", genre=" + genre + ", amazonRating=" + amazonRating + "]";
	}
	@Override
	public boolean isKidFriendlyEligible() {
		// TODO Auto-generated method stub
		if(genre.equals(BookGenre.PHILOSOPHY)||genre.equals(BookGenre.SELF_HELP)) {
			return false;
		}
		return true;
	}
	@Override
	public String getItemData() {
		StringBuilder builder=new StringBuilder();
		builder.append("<item>");
			builder.append("<type>Book</type>");
			builder.append("<title>").append(getTitle()).append("</title>");
			builder.append("<author>").append(StringUtils.join(author,",")).append("</author>");
			builder.append("<publisher>").append(publisher).append("</publisher>");
			builder.append("<publicationYear>").append(publicationYear).append("</publicationYear>");
			builder.append("<genre>").append(genre).append("</genre>");
			builder.append("<amazonRating>").append(amazonRating).append("</amazonRating>");
		builder.append("</item>");
		
		return builder.toString();
	}
	

}
