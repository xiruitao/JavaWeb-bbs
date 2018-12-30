package service;
import dao.*;
import dao.impl.*;
import vo.Post;
import vo.PostStatistic;
import java.util.*;
public class PostService {
    private PostDao postDao=new PostDaoImpl();
    public boolean sendPost(Post post)
    {
        return postDao.sendPost(post);
    }
    public ArrayList<Post> showPostByTimeOrder(){
        return postDao.getPostsByTimeOrder();
    }
    public Post getPostByPostId(int postId){
        return postDao.getPostByPostId(postId);
    }
    public boolean updatePostContent(String PostContent,int PostId)
    {
        return postDao.updatePostContent(PostContent,PostId);
    }
    public ArrayList<Post> getPostByAccount(String account)
    {
        return postDao.getPostByAccount(account);
    }
    public ArrayList<PostStatistic> getPostStatisticsByReplyNum()
    {
        return postDao.getPostStatisticsByReplyNum();
    }
    public boolean deletePost(int post_id)
    {
        return postDao.deletePost(post_id);
    }
}
