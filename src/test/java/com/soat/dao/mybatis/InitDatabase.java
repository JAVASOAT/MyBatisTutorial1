package com.soat.dao.mybatis;

import org.apache.ibatis.session.SqlSession;

import com.soat.beans.Author;
import com.soat.beans.Book;
import com.soat.beans.Category;
import com.soat.dao.mybatis.util.MybatisUtil;

public class InitDatabase {


	public static void main(String[] args)throws Exception {
		
		SqlSession session = MybatisUtil.getSession();
				
		Author zola = new Author();
		zola.setName("Emile Zola");
		session.insert("insertAuthor", zola);
		
		Author jkrowling = new Author();
		jkrowling.setName("J K Rowling");		
		session.insert("insertAuthor", jkrowling);
		
		Category roman = new Category();
		roman.setName("Roman");
		session.insert("insertCategory", roman);
		
		Category nouvelle = new Category();
		nouvelle.setName("Nouvelle");
		session.insert("insertCategory", nouvelle);
		
		Category aventure = new Category();
		aventure.setName("Nouvelle");
		session.insert("insertCategory", aventure);
		
		Book b;
		
		b=new Book();
		b.setTitle("Nana");
		b.setIsbn("547E45");
		b.setShortDescription("Un ouvrage de Zola");
		b.setLongDescription("Un très long ouvrage écrit par Zola");
		b.setAuthor(zola);
		b.addCategory(roman);
		session.insert("insertBook", b);
		session.insert("insertBookCategories", b);
		
		b=new Book();
		b.setTitle("Germinal");
		b.setIsbn("874F98");
		b.setShortDescription("Un autre ouvrage de Zola");
		b.setLongDescription("Une histoire toujorus aussi longue écrite par Zola");
		b.setAuthor(zola);
		b.addCategory(nouvelle);
		session.insert("insertBook", b);
		session.insert("insertBookCategories", b);
		
		b=new Book();
		b.setTitle("Harry Potter");
		b.setIsbn("8647SW54");
		b.setShortDescription("On ne présente plus Harry");
		b.setLongDescription("Les aventures de Harry le magicien, en 7 ou 8 tomes");
		b.setAuthor(jkrowling);
		b.addCategory(roman);
		b.addCategory(aventure);
		session.insert("insertBook", b);
		session.insert("insertBookCategories", b);
		
		session.commit();
		session.close();
	}
	
}
