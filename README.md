#### 获取帖子（未置顶）信息  get：GetPost

##### req:  null

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
> }

#### 获取置顶帖子信息  get:  GetStickyPost

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

#### 获取加精帖子信息  get:  GetEditingPost

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
>}

#### 帖子置顶  get:  DoPostSticky

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
>"message":  null" / "Sticky Successful" / "Sticky Usuccessful"
>
>"status":  -1 / 1 / 0
>
>}

#### 帖子加精  get:  DoPostEditing

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
> "message":  null" / "Editing Successful" / "Editing Usuccessful"
>
> "status":  -1 / 1 / 0
>
> }

#### 置顶帖中帖子上移  get:  MoveUpPost

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

#### 置顶帖中帖子下移  get:  MoveDownPost

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

#### 取消置顶  get:  CancelSticky

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

#### 取消加精  get:  CancelEditing

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

