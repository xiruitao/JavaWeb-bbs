package dao.impl;
import dao.JDBCUtil;
import vo.User;
import dao.UserDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class UserDaoImpl implements UserDao{
    public User getUserInformationByAccount(String account)
    {
        User user=new User();
        Connection conn= JDBCUtil.getConnection();
        try{
            String sql="select * from user_information_p where account=?";
            PreparedStatement psta=conn.prepareStatement(sql);
            psta.setString(1,account);
            ResultSet rs=psta.executeQuery();
            while (rs.next()) {
                user.setAccount(rs.getString("account"));
                user.setUser_name(rs.getString("user_name"));
                user.setBirthday(rs.getDate("birthday"));
                user.setSex(rs.getString("sex"));
                user.setPlace_of_province(rs.getString("place_of_province"));
                user.setOccupation(rs.getString("occupation"));
                user.setHead_image(rs.getString("head_image"));
                user.setScore(rs.getInt("score"));
                user.setTel(rs.getString("tel"));
            }
            psta.close();
            rs.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return user;
    }
    public ArrayList<Integer> getUserNumbersGroupBySex()
    {
        Connection conn=JDBCUtil.getConnection();
        ArrayList<Integer> sexStatistics=new ArrayList<Integer>();
        for(int i=0;i<2;i++)
        {
            sexStatistics.add(0);
        }
        try{
            String sql="select sex,count(*) as number  from user_information_p group by sex";
            Statement sta=conn.createStatement();
            ResultSet rs=sta.executeQuery(sql);
            while(rs.next())
            {
                String sex=rs.getString("sex");
                int number=rs.getInt("number");
                if(sex.equals("男"))
                {
                    sexStatistics.set(0,number);
                }
                else
                {
                    sexStatistics.set(1,number);
                }
            }
            sta.close();
            rs.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return sexStatistics;
    }
    public ArrayList<Integer> getUserStatisticsByProvince()
    {
        ArrayList<Integer> statistics=new ArrayList<Integer>();
        //ArrayList<Integer> data=new ArrayList<Integer>();
        for(int i=0;i<35;i++)
        {
            statistics.add(0);
        }
        Connection conn=JDBCUtil.getConnection();
        try
        {
            String sql="select place_of_province,count(*) as number from user_information_p group by place_of_province";
            Statement sta=conn.createStatement();
            ResultSet rs=sta.executeQuery(sql);
            while(rs.next())
            {
                String province=rs.getString("place_of_province");
                int number=rs.getInt("number");
                switch (province)
                {
                    case "北京":statistics.set(0,number);break;
                    case "上海":statistics.set(1,number);break;
                    case "天津":statistics.set(2,number);break;
                    case "重庆":statistics.set(3,number);break;
                    case "河北":statistics.set(4,number);break;
                    case "山西":statistics.set(5,number);break;
                    case "吉林":statistics.set(6,number);break;
                    case "辽宁":statistics.set(7,number);break;
                    case "黑龙江":statistics.set(8,number);break;
                    case "陕西":statistics.set(9,number);break;
                    case "甘肃":statistics.set(10,number);break;
                    case "青海":statistics.set(11,number);break;
                    case "山东":statistics.set(12,number);break;
                    case "福建":statistics.set(13,number);break;
                    case "浙江":statistics.set(14,number);break;
                    case "台湾":statistics.set(15,number);break;
                    case "河南":statistics.set(16,number);break;
                    case "湖北":statistics.set(17,number);break;
                    case "湖南":statistics.set(18,number);break;
                    case "江西":statistics.set(19,number);break;
                    case "江苏":statistics.set(20,number);break;
                    case "安徽":statistics.set(21,number);break;
                    case "广东":statistics.set(22,number);break;
                    case "海南":statistics.set(23,number);break;
                    case "四川":statistics.set(24,number);break;
                    case "贵州":statistics.set(25,number);break;
                    case "云南":statistics.set(26,number);break;
                    case "内蒙古":statistics.set(27,number);break;
                    case "新疆":statistics.set(28,number);break;
                    case "宁夏":statistics.set(29,number);break;
                    case "广西":statistics.set(30,number);break;
                    case "西藏":statistics.set(31,number);break;
                    case "香港":statistics.set(32,number);break;
                    case "澳门":statistics.set(33,number);break;
                    default:int num=statistics.get(34);
                    num+=number;
                    statistics.set(34,num);
                }
            }
            /*int maxIndex1=0;
            int num1;
             for(int i=0;i<35;i++)
            {
                sum+=statistics.get(i);
                if(statistics.get(i)>statistics.get(maxIndex1))
                {
                    maxIndex1=i;
                }
            }
            num1=statistics.get(maxIndex1);
            statistics.set(maxIndex1,0);
            data.add(maxIndex1);
            data.add(num1);
            int num2;
            int maxIndex2=0;
            for(int i=0;i<35;i++)
            {
                if(statistics.get(i)>statistics.get(maxIndex2))
                {
                    maxIndex2=i;
                }
            }
            num2=statistics.get(maxIndex2);
            statistics.set(maxIndex2,0);
            data.add(maxIndex2);
            data.add(num2);
            int maxIndex3=0;
            int num3;
            for(int i=0;i<35;i++)
            {
                if(statistics.get(i)>statistics.get(maxIndex3))
                {
                    maxIndex3=i;
                }
            }
            num3=statistics.get(maxIndex3);
            data.add(maxIndex3);
            data.add(num3);
            data.add(sum);*/
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return statistics;
    }
    public String parseProvinceId(int id)
    {
        String provinceName="";
        switch (id)
        {
            case 0:provinceName="北京";break;
            case 1:provinceName="上海";break;
            case 2:provinceName="天津";break;
            case 3:provinceName="重庆";break;
            case 4:provinceName="河北";break;
            case 5:provinceName="山西";break;
            case 6:provinceName="吉林";break;
            case 7:provinceName="辽宁";break;
            case 8:provinceName="黑龙江";break;
            case 9:provinceName="陕西";break;
            case 10:provinceName="甘肃";break;
            case 11:provinceName="青海";break;
            case 12:provinceName="山东";break;
            case 13:provinceName="福建";break;
            case 14:provinceName="浙江";break;
            case 15:provinceName="台湾";break;
            case 16:provinceName="河南";break;
            case 17:provinceName="湖北";break;
            case 18:provinceName="湖南";break;
            case 19:provinceName="江西";break;
            case 20:provinceName="江苏";break;
            case 21:provinceName="安徽";break;
            case 22:provinceName="广东";break;
            case 23:provinceName="海南";break;
            case 24:provinceName="四川";break;
            case 25:provinceName="贵州";break;
            case 26:provinceName="云南";break;
            case 27:provinceName="内蒙古";break;
            case 28:provinceName="新疆";break;
            case 29:provinceName="宁夏";break;
            case 30:provinceName="广西";break;
            case 31:provinceName="西藏";break;
            case 32:provinceName="香港";break;
            case 33:provinceName="澳门";break;
            case 34:provinceName="其他";break;
        }
        return provinceName;
    }
    public ArrayList<Integer> getUserStatisticsByBirthday()
    {
        ArrayList<Integer> statistics=new ArrayList<>();
        Connection conn=JDBCUtil.getConnection();
        for(int i=0;i<7;i++)
        {
            statistics.add(0);//00 90 80 70 60 其他 sum
        }
        try{
            String sql="select YEAR(birthday) as birth_year from user_information_p";
            Statement sta=conn.createStatement();
            ResultSet rs=sta.executeQuery(sql);
            int sum=0;
            while (rs.next())
            {
                String syear=rs.getString("birth_year");
                int year=Integer.parseInt(syear);
                sum++;
                if(year>=2000)
                {
                    int num=statistics.get(0);
                    num++;
                    statistics.set(0,num);
                }
                else if(year>=1990)
                {
                    int num=statistics.get(1);
                    num++;
                    statistics.set(1,num);
                }
                else if(year>=1980)
                {
                    int num=statistics.get(2);
                    num++;
                    statistics.set(2,num);
                }
                else if(year>=1970)
                {
                    int num=statistics.get(3);
                    num++;
                    statistics.set(3,num);
                }
                else if(year>=1960)
                {
                    int num=statistics.get(4);
                    num++;
                    statistics.set(4,num);
                }
                else {
                    int num=statistics.get(5);
                    num++;
                    statistics.set(5,num);
                }
            }
            statistics.set(6,sum);
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return statistics;
    }
}
