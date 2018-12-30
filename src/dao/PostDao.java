package dao;

import vo.Post;
import vo.PostStatistic;
import java.util.*;
public interface PostDao {
    public boolean sendPost(Post post);
    public ArrayList<Post> getPostsByTimeOrder();
    public Post getPostByPostId(int postId);
    public boolean updatePostContent(String PostContent,int PostId);
    public ArrayList<Post> getPostByAccount(String account);
    public ArrayList<PostStatistic> getPostStatisticsByReplyNum();
    public boolean deletePost(int post_id);
}
