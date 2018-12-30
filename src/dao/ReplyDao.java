package dao;

import vo.Reply;
import java.util.*;
public interface ReplyDao {
    public boolean replyAndInsert(Reply reply);
    public ArrayList<ArrayList<Reply>> getReplyInformation(int post_id);
}
