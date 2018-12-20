package service;

import dao.PostDao;
import dao.impl.PostDaoImpl;
import vo.Post;

import java.util.ArrayList;

public class PostService {
    private PostDao post = new PostDaoImpl();

    public ArrayList<Post> findAll(){
        return post.findAll();
    }
    public ArrayList<Post> postSticky(){
        return post.postSticky();
    }
    public ArrayList<Post> postEditing(){
        return post.postEditing();
    }

}
