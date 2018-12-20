# javaweb bbs部分api  
----------------------------------------------------------  

post: /api/adoptReply
---------------------
request:  
>{
>>account: “被采纳帖子的作者account”,
  post_id: “被采纳的帖子id”，
  post_score： “该需求贴的分值”

>}

response:
>{
>>status: 0(成功),
  message: "操作成功"
  data: "无"
  
  >}

get: /api/getScoreTie
---------------------
request: 无
response: 
>{
>>status: 0，
  message: "获取成功"
  data：[
  >>>{
     >>>>post_id: id,
     is_finish: 0(未完成),
     account: "发贴人account",
     image: "相关图片地址，没有则为null",
     post_content: "帖子内容",
     post_title: "帖子标题",
     post_score: "悬赏分值",
     post_time: "发帖时间"

>>>}
     
>>]
     
>}

post: /api/login
-----------------------
request: 
>{
>>account: "account",
  password: "密码"
  
>}

response:
>{
>>status: 0,
message:"登录成功/失败",
data: "无"

>}

post: /api/publishTie
-----------------------
request:
>{
>>account: "发贴人account",
category_id: "帖子类别",
image:"图片（没有则传null）",
post_content: "内容",
post_title: "标题",
post_score: "奖赏分值"，

>}

response: 成功or失败，同上

post: /api/register
------------------------
request: 
>{
>>account: "",
username: "名字啊"，
password： “mimaa”,
age: "年龄啊"，
occupation：“职业啊”，
place： “城市啊”，
sex： “性别啊”,
tel: "电话啊"

>}

response: 成功or失败，同上