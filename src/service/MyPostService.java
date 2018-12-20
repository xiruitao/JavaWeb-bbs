package service;

import dao.MyPostDao;
import dao.impl.MyPostDaoImpl;
import vo.MyPost;

import java.util.ArrayList;

public class MyPostService {
    private MyPostDao myPostDao = new MyPostDaoImpl();

    public boolean PublicTie(MyPost myPost) {
        return myPostDao.PublishTie(myPost);
    }

    public ArrayList<MyPost> getScoreTieByTime() {
        return myPostDao.getScoreTieByTime();
    }

    public boolean updateFinishStatus(MyPost myPost) {
        return myPostDao.updateFinishStatus(myPost);
    }
}
