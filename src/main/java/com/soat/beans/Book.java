package com.soat.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Book {
	private Author author;
	private List<Category> categories = new ArrayList<Category>();
	private Integer id;
	private String imageName;
	private String isbn;
	private String longDescription;
	private String shortDescription;

	private String title;

	public Book() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}


	public Integer getId() {
		return id;
	}

	public String getImageName() {
		return imageName;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getLongDescription() {
		return longDescription;
	}


	public String getShortDescription() {
		return shortDescription;
	}

	public String getTitle() {
		return title;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}


	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Author getAuthor() {
		return author;
	}
	
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public List<Category> getCategories() {
		return categories;
	}
	
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		final int maxLen = 5;
		return String.format("Book [id=%s, title=%s, author=%s, categories=%s]", id, title, author,
				getCategories() != null ? toString(getCategories(), maxLen) : null);
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}

	public void addCategory(Category category) {
		if(! this.categories.contains(category))
			this.categories.add(category);		
	}
}
