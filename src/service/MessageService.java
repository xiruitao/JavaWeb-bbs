package service;
import dao.impl.*;
import dao.*;
import vo.*;

import java.util.ArrayList;

public class MessageService {
    private MessageDao messageDao=new MessageDaoImpl();
    public boolean sendMessage(Message message){
        return messageDao.sendMessage(message);
    }
    public ArrayList<Message> showConversation(String account_1,String account_2)
    {
        return messageDao.showConversation(account_1,account_2);
    }
    public ArrayList<User> getUsersOfCommunication(String account){
        return messageDao.getUsersOfCommunication(account);
    }
}
