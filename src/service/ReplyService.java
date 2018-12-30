package service;
import vo.Reply;
import dao.ReplyDao;
import dao.impl.ReplyDaoImpl;
import java.util.*;
public class ReplyService {
    private ReplyDao replyDao=new ReplyDaoImpl();
    public boolean replyAndInsert(Reply reply)
    {
         return  replyDao.replyAndInsert(reply);
    }
    public ArrayList<ArrayList<Reply>> getReplyInformation(int post_id)
    {
        return replyDao.getReplyInformation(post_id);
    }
}
