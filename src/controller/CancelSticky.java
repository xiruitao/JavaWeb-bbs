package controller;

import dao.JDBCUtil;
import dao.ResJson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CancelSticky extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = JDBCUtil.getConnection();
        String id1 = request.getParameter("post_id");//发出取消置顶的帖子(属于置顶的帖子)的ID
        if (id1 == null || id1.equals("")) {
            response.getWriter().println(ResJson.generateResJson(-1, "null", "none"));
        }else{
            int id = Integer.parseInt(id1);
            try{
                //查询发出请求帖子的置顶键值
                String sql1="select pos_value from post where post_id='"+id+"';";
                Statement sta1=conn.createStatement();
                ResultSet rs1=sta1.executeQuery(sql1);
                int value = 0;
                while(rs1.next()){
                    value=rs1.getInt("pos_value");
                }

                //查询置顶帖子中置顶键值大于发出取消置顶请求的贴子的post_id和pos_value
                String sql2="select post_id,pos_value from post where pos_value>"+value+";";
                Statement sta2=conn.createStatement();
                ResultSet rs2=sta2.executeQuery(sql2);
                ArrayList<Integer> list=new ArrayList();
//                int col = rs2.getMetaData().getColumnCount();
                while ((rs2.next())){
                    list.add(rs2.getInt("post_id"));
                    list.add(rs2.getInt("pos_value"));
                }

                //如果发出请求的帖子为唯一置顶帖，则直接取消置顶；否则，则将置顶键值大于该帖子的所有帖子的置顶键值都减1，再取消置顶（即将置顶键值置为0）
                if(list.size()==0){
                    String sql="update post set pos_value='"+0+"' where post_id='"+id+"';";
                    Statement sta=conn.createStatement();
                    int rs=sta.executeUpdate(sql);
                    if(rs==1)
                        response.getWriter().println(ResJson.generateResJson(1, "Cancel Sticky Successful", id));
                    else
                        response.getWriter().println(ResJson.generateResJson(0, "Cancel Sticky Unsuccessful","none" ));
                }else{
                    int num=0;
                    for(int i=0;i<list.size()-1;i+=2){
                        int n1 = list.get(i);
                        int n2 = list.get(i+1)-1;
                        String sql3="update post set pos_value='"+n2+"' where post_id='"+n1+"';";
                        Statement sta3=conn.createStatement();
                        int rs3=sta3.executeUpdate(sql3);
                        if (rs3==1){
                            ++num;
                        }
                    }
//                    System.out.println("num="+num);
                    int number=list.size()/2;
                    if(num==number){
                        String sql="update post set pos_value='"+0+"' where post_id='"+id+"';";
                        Statement sta=conn.createStatement();
                        int rs=sta.executeUpdate(sql);
                        if(rs==1)
                            response.getWriter().println(ResJson.generateResJson(1, "Cancel Sticky Successful", id));
                        else
                            response.getWriter().println(ResJson.generateResJson(0, "Cancel Sticky Unsuccessful","none" ));
                    }else
                        response.getWriter().println(ResJson.generateResJson(0, "Cancel Sticky Unsuccessful","none" ));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
