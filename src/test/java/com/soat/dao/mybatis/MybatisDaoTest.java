package com.soat.dao.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.soat.beans.Author;
import com.soat.beans.Book;
import com.soat.beans.Param;
import com.soat.beans.User;
import com.soat.dao.mybatis.mapper.BookMapper;
import com.soat.dao.mybatis.mapper.UserMapper;
import com.soat.dao.mybatis.util.MybatisUtil;

public class MybatisDaoTest extends TestCase {

	private static final Logger logger = Logger.getLogger(MybatisDaoTest.class);
	
	private static final SqlSession session = MybatisUtil.getSession();
	private static final BookMapper mapper = session.getMapper(BookMapper.class);
	
	private static final Map<String, Object> params = new HashMap<String, Object>();
	
	private static final Book book = new Book();
	private static final Param param = new Param();
	private static final String NAMESPACE = BookMapper.class.getName();
	private static String ns(String query){
		return NAMESPACE+"."+query; 
	}
	
	static{
		params.put("name", "titi");
		
		param.setName("mickey");

		final Author author = new Author();
		author.setId(1);
		author.setName("Zola");
		
		book.setIsbn("784-4564");
		book.setAuthor(author);
		book.setImageName("");
		book.setTitle("l'obscurité");
		book.setShortDescription("un ouvrage qui traite le sujet de l'obscurité");
		book.setLongDescription("un ouvrage qui traite le sujet de l'obscurité, c'est long, sombre, ennuyeux à mourir, une vraie perte de temps");
		
	}
	
	public void test_FunctionCall() throws Exception{
		String res = (String) session.selectOne(ns("helloFunction"), params);
		logger.info(res);
		assertNotNull(res);
	}
	
	public void test_FunctionCall_ProcStyle() throws Exception{
		session.update(ns("helloFunctionProc"), param);
		String res = param.getMessage();
		logger.info(res);
		assertNotNull(res);
	}
	
	public void test_ProcedureCall() throws Exception{		
		session.update(ns("helloProcedure"), param);
		String res = param.getMessage();
		logger.info(res);
		assertNotNull(res);
	}

	public void test_Insert() throws Exception{
		mapper.insertBook(book);
		logger.info(book.getId());
	}

	public void test_Update() throws Exception{
		final Author author = new Author();
		author.setId(2);
		author.setName("un autre auteur");
		book.setAuthor(author);
		mapper.updateBook(book);
	}

	public void test_Delete() throws Exception{
		mapper.deleteBook(book);
	}
	@SuppressWarnings("unchecked")
	public void test_GreedySelect() throws Exception{
		List<Book> selectList = session.selectList(ns("selectBookAndCategoryGreedy"));
		for (Book book : selectList) {
			System.out.println(book);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void test_LazySelect() throws Exception{
		List<Book> books = session.selectList("selectLazyBook");
		/* non lazy object property is accessed, nothing sould happen */
		System.out.println(books.get(0).getTitle());
		/* watch logs: lazy property is loaded  now */
		System.out.println(books.get(0).getCategories().get(0).getName());
		
		System.out.println(books.get(0).getAuthor().getName());
	}
	
	
	public void test_multiInsert() throws Exception{
		List<User> users = new ArrayList<User>();
		users.add(new User("u1@mail.com","Thomas", "Thierry", "1234"));
		users.add(new User("u2@mail.com","Antoine", "Raoul", "5678"));
		param.setUsers(users);		
		session.insert("insertUserList",param);
		
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<User> allUsers = userMapper.selectAllUsers();
		for (User user : allUsers) {
			System.out.println(user);
		}
//		session.commit();
		/* don't save to test again! */
		session.rollback(); 
	}
	
	@SuppressWarnings("unchecked")
	public void test_RowBounds() throws Exception{
		final int offset = 5, limit = 10;
		List<Book> books = session.selectList("selectAllBooks", null, new RowBounds(offset, limit));
		assertTrue(books.size() <= limit);
	}
	
	
	public void test_ResultHandler() throws Exception{
		final ResultHandler handler = new ResultHandler() {			
			@Override
			public void handleResult(ResultContext context) {
				final Book book = (Book) context.getResultObject();
				
				System.out.println(book.getTitle());
			}
		};		
		session.select("selectAllBooks", handler);
	}

}