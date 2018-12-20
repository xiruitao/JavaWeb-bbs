package dao;

import vo.MyPost;
import vo.MyUser;

import java.util.ArrayList;

public interface MyPostDao {
    public boolean PublishTie(MyPost myPost);

    public ArrayList<MyPost> getScoreTieByTime();

    public boolean updateFinishStatus(MyPost myPost);
}
