<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/12/11
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="api/replyAndSave">
    测试回复贴子:
    所回复帖子的号post_id:<input type="text" name="post_id"> <br>
    回复人账号account:<input type="text" name="account"> <br>
    回复内容reply_content<input type="text" name="reply_content"> <br>
    这是针对哪条回复的,请给出这条回复的id:reply_id<input type="text" name="reply_id"> <br>
    回复图片image:<input type="text" name="image"> <br>
    <input type="submit" value="提交">
</form>
  <form action="api/sendPost">
    测试发帖:
    发帖标题post_title:<input type="text" name="post_title"> <br>
    发帖内容post_content:<input type="text" name="post_content"> <br>
    贴子种类category_id:<input type="category_id" name="category_id"> <br>
    发帖人账号account:<input type="text" name="account"> <br>
    图片image:<input type="text" name="image"><<br>
    <input type="submit" value="提交">
  </form>

  <form action="api/getReplyInformationByPostID">
    测试获取回复:
    针对哪条贴子的回复post_id:<input type="text" name="post_id" > <br>
    <input type="submit" value="提交">
  </form>


  <form action="api/sendMessage">
    测试发送私信:
    发送方account_send:<input type="text" name="account_send"> <br>
    接受方account_receive:<input type="text" name="account_receive"> <br>
    发送内容message_content:<input type="text" name="message_content"> <br>
    <input type="submit" value="提交">
  </form>

  <form action="api/showConversation">
    测试查看私信: <br>
    第一个人的账号account_1<input type="text" name="account_1"><br>
    第二个人的账号account_2<input type="text" name="account_2"><br>
    <input type="submit" value="提交">
  </form>
  <form action="api/getPostByPostId">
    测试通过贴子号查询贴子:<br>
    要查询的贴子号post_id:<input type="text" name="post_id"> <br>
    <input type="submit" value="提交"> <br>
  </form>

  <form action="api/updatePostContent">
    测试修改文章内容:<br>
    要修改贴子号post_id:<input type="text" name="post_id"> <br>
    要修改的内容post_content:<input type="text" name="post_content"> <br>

    <input type="submit" value="提交">
  </form>

  <form action="api/getCategory">
    测试获取贴子的种类
    <input type="submit" value="提交">
  </form>

  <form action="api/getPostByAccount">
    测试通过用户名查询他发的贴子:<br>
    用户名account:<input type="text" name="account">
    <input type="submit" value="提交">
  </form>

  <form action="api/getUserInformationByAccount">
    测试查询个人信息:<br>
    要查询的account:<input type="text" name="account" >
    <input type="submit" value="提交">
  </form>

  <form action="api/getUserStatisticsBySex">
    获取用户性别的统计信息:
    <input type="submit"  value="提交">
  </form>

  <form action="api/getUserStatisticsByProvince">
    获取省份统计信息:
    <input type="submit" value="提交">
  </form>
  <form action="api/getUserStatisticsByBirthday">
    获取用户出生日期的统计信息:<input type="submit" value="提交">
  </form>
  <form action="api/getPostStatisticsByReplyNum">
    测试获取热点贴:
    <input type="submit" value="提交">
  </form>

  <form action="api/getCategoryStatisticsByPostNum">
    测试获取贴子类别的统计信息:
    <input type="submit" value="提交">
  </form>
  <form action="api/getUsersOfCommunication">
    测试获取和当前用户发送私信的其他用户: <br>
    当前用户account<input type="text" name="account"> <br>
    <input type="submit" value="提交"> <br>
  </form>
  <form action="api/deletePost">
      测试删帖:<br>
      要删除贴子的post_id:<input type="text" name="post_id">
      <input type="submit" value="提交">
  </form>
  </body>
</html>
