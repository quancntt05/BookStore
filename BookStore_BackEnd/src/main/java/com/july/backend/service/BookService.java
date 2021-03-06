package com.july.backend.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.july.backend.models.Books;
import com.july.backend.models.Category;
import com.july.backend.repository.BookRepository;
import com.july.backend.util.HibernateUtil;

@Service
public class BookService implements BookRepository{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Books> listBooks() {
		Session session = HibernateUtil.getSessionFatory().openSession();
	    Query<Books> query = session.createQuery("FROM Books");
		List<Books> result = query.list();
		session.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Books> findByAuthor(String author) {
		Session session = HibernateUtil.getSessionFatory().openSession();
		Query<Books> query = session.createQuery("FROM Books b where b.author like '%"+author+"%'");
		List<Books> result = query.list();
		session.close();
		return result;
	}

	@Override
	public List<Books> findByCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Books findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBook(Books book) {
		Session session = HibernateUtil.getSessionFatory().openSession();
		session.persist(book);
		
	}


}
