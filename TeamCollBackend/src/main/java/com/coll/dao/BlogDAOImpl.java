package com.coll.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.Blog;

@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO {
	@Autowired
	SessionFactory sessionFactory;

	public boolean addBlog(Blog blog) {
		try
		{
		sessionFactory.getCurrentSession().save(blog);
	    System.out.println("Blog data saved");
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	public boolean deleteBlog(Blog blog) {
		try
		{
		sessionFactory.getCurrentSession().delete(blog);
	    System.out.println("Blog data deleted");
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	public boolean updateBlog(Blog blog) {
		try
		{
		sessionFactory.getCurrentSession().update(blog);
	    System.out.println("Blog data updated");
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	public boolean incrementLikes(int blogid) {
		try {
			Blog blog=getBlog(blogid);
			blog.setLikes(blog.getLikes()+1);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean incrementDisLikes(int blogid) {
		try {
			Blog blog=getBlog(blogid);
			blog.setDislikes(blog.getDislikes()+1);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public List<Blog> listBlogs() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog");
		List<Blog> listBlogs=query.list();
		return listBlogs;
	}

	public Blog getBlog(int blogid) {
		Session session=sessionFactory.openSession();
		Blog blog=session.get(Blog.class,blogid);
		session.close();
		return blog;
	}

	public boolean approveBlog(int blogid) {
		try {
			Blog blog=getBlog(blogid);
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean rejectBlog(int blogId) {
		try {
			Blog blog=getBlog(blogId);
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

}
