package controller;

import dao.JDBCUtil;
import dao.ResJson;
import org.json.JSONObject;
import service.PostService;
import vo.Post;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GetEditingPost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String id1 = request.getParameter("category_id");//请求该分类帖子的类别ID
        if (id1 == null || id1.equals("")) {
            PostService postService=new PostService();
            ArrayList<Post> posts=postService.postEditing();
            JSONObject data1=new JSONObject();
            data1.put("posts",posts);
            out.println(ResJson.generateResJson(1,"贴吧加精帖子(未置顶)信息",data1));
        } else{
            int id = Integer.parseInt(id1);
            if(id==1005){
                response.getWriter().println(ResJson.generateResJson(0, "这个类别是需求帖，不做操作", "none"));
            }else {
                JSONObject data=new JSONObject();
                Connection conn= JDBCUtil.getConnection();
                ArrayList<Post> EditingPostByCategory=new ArrayList<Post>();
                try{
                    String sql="select * from post where pos_value=0 and is_refinement=1 and category_id="+id+";";
                    Statement sta=conn.createStatement();
                    ResultSet rs=sta.executeQuery(sql);
                    while(rs.next()){
                        Post post=new Post();
                        int post_id=rs.getInt("post_id");
                        int category_id=rs.getInt("category_id");
                        String post_title=rs.getString("post_title");
                        String post_content=rs.getString("post_content");
                        String account=rs.getString("account");
                        String image=rs.getString("image");
                        int pos_value=rs.getInt("pos_value");
                        int is_refinement=rs.getInt("is_refinement");
                        String post_time=rs.getString("post_time");
                        post.setPost_id(post_id);
                        post.setCategory_id(category_id);
                        post.setPost_title(post_title);
                        post.setPost_content(post_content);
                        post.setAccount(account);
                        post.setImage(image);
                        post.setPos_value(pos_value);
                        post.setIs_refinement(is_refinement);
                        post.setPost_time(post_time);
                        EditingPostByCategory.add(post);
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
                if (EditingPostByCategory.size()==0){
                    response.getWriter().println(ResJson.generateResJson(2, "该类别暂时还没有帖子", "none"));
                } else {
                    data.put("posts",EditingPostByCategory);
                    out.println(ResJson.generateResJson(1,"该类帖子信息(未置顶、加精)",data));
                }
            }
        }
    }
}
