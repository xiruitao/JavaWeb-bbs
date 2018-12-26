#### 获取(全部或某类)帖子（未置顶）信息  get：/getPost

##### req:  

> {
>
> "category_id" : xxx
>
> }

##### res:

> {
>
> ​    "data":[
>
> >{
> >
> >image :  ""  
> >
> >post_content : "xxx"    
> >
> >category_id : xxx  
> >
> >post_title : "xxx"  
> >
> >post_id : xxx   
> >
> >is_refinement : xxx   
> >
> >account : "6130116007"  
> >
> >pos_value : 0
> >
> >}
> >
> >{
> >
> >  ……
> >
> >}
>
> ​    ]
>
> "message":  "这个类别是需求帖，不做操作"" / "贴吧帖子信息(未置顶)" / 
>
> ​                      "该类帖子信息(未置顶)" / "该类别暂时还没有帖子"
>
> "status":  0 / 1 / 2
>
> }

#### 获取置顶帖子信息  get:  /getStickyPost

##### req:  null

##### res:

>{
>
>"data":[
>
>>{
>>
>>image :  ""  
>>
>>post_content : "xxx"    
>>
>>category_id : xxx  
>>
>>post_title : "xxx"  
>>
>>post_id : xxx   
>>
>>is_refinement : xxx   
>>
>>account : "6130116007"  
>>
>>pos_value : 0
>>
>>}
>>
>>{
>>
>>……
>>
>>}
>
>]
>
>}

#### 获取(全部或某类)加精帖子信息  get:  /getEditingPost

##### req:  

> {
>
> "category_id" : xxx
>
> }

##### res:

>{
>
>"data":[
>
>>{
>>
>>image :  ""  
>>
>>post_content : "xxx"    
>>
>>category_id : xxx  
>>
>>post_title : "xxx"  
>>
>>post_id : xxx   
>>
>>is_refinement : 1   
>>
>>account : "6130116007"  
>>
>>pos_value : xxx
>>
>>}
>>
>>{
>>
>>……
>>
>>}
>
>]
>
>"message":  "这个类别是需求帖，不做操作"" / "贴吧加精帖子(未置顶)信息" / 
>
>​                      "该类帖子信息(未置顶、加精)" / "该类别暂时还没有帖子"
>
>"status":  0 / 1 / 2
>
>}

#### 帖子置顶  get:  /doPostSticky

##### req:

>{
>
>"post_id":  xxx
>
>}

##### res:

>{
>
>"data":  "none" / "post_id"
>
>"message":  null" / "Sticky Successful" / "Sticky Usuccessful" / "Already Sticky"
>
>"status":  -1 / 1 / 0 / 2
>
>}

#### 帖子加精  get:  /doPostEditing

##### req:

> {
>
> "post_id":  xxx
>
> }

##### res:

> {
>
> "data":  "none" / "post_id"
>
> "message":  null" / "Editing Successful" / "Editing Usuccessful" / "Already Editing"
>
> "status":  -1 / 1 / 0 / 2
>
> }

#### 置顶帖中帖子上移  get:  /moveUpPost

##### req:

> {
>
> "post_id":  xxx
>
> }

##### res:

> {
>
> "data":  "none" / "post_id"
>
> "message":  null" / "Move Up Successful" / "Already the top" / "Move UP Usuccessful"
>
> "status":  -1 / 1 / 0
>
> }

#### 置顶帖中帖子下移  get:  /moveDownPost

##### req:

> {
>
> "post_id":  xxx
>
> }

##### res:

> {
>
> "data":  "none" / "post_id"
>
> "message":  null" / "Move Down Successful" / "Already the down" / "Move Down Usuccessful"
>
> "status":  -1 / 1 / 0
>
> }

#### 取消置顶  get:  /cancelSticky

##### req:

> {
>
> "post_id":  xxx
>
> }

##### res:

> {
>
> "data":  "none" / "post_id"
>
> "message":  null" / "Cancel Sticky Successful" / "Cancel Sticky Usuccessful"
>
> "status":  -1 / 1 / 0
>
> }

#### 取消加精  get:  /cancelEditing

##### req:

> {
>
> "post_id":  xxx
>
> }

##### res:

> {
>
> "data":  "none" / "post_id"
>
> "message":  null" / "Cancel Editing Successful" / "Cancel Editing Usuccessful"
>
> "status":  -1 / 1 / 0
>
> }

>