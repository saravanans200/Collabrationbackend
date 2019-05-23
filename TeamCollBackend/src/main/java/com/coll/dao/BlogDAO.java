package com.coll.dao;

import java.util.List;

import com.coll.model.Blog;

public interface BlogDAO {
	public boolean addBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public boolean incrementLikes(int Blogid);
	public boolean incrementDisLikes(int Blogid);
	public List<Blog> listBlogs();
	public Blog getBlog(int Blogid);
	public boolean approveBlog(int blogid);
	public boolean rejectBlog(int blogid);	

}
