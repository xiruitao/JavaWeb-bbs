package dao;

import vo.Post;

import java.util.ArrayList;

public interface PostDao {
    public ArrayList<Post> findAll();
    public ArrayList<Post> postSticky();
    public ArrayList<Post> postEditing();
}
