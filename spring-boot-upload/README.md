###说明
访问 [测试体验](http://localhost:8080/index )
###设计一个用来上传一个或多个文件的功能
暂只支持简单的功能,这里要注意点如下
 1. FILE_PATH 这里可以填写比如绝对路径c:\upload(window),/opt/site/wise-crm/upload(linux),以及相对路径/,相对路径会在springboot启动的c盘下的一个tomcat 的一个位置,所以要记得处理
 2. 待续
 3. 待续
 
 结果
    定义一个方法 upload 上传文件,成功
    
    后续方向
    - 文件读取,
    - 文件fildid 管理
    - 文件规格
    - 文件是怎么自己清理的
    
    

文件上传要准备什么jar,不需要
如何设置目录——可以直接复制你的路径，如果是\开头的则是相对路径，要自己在tomcat里面找
form 表单里传数据给controller 的三个要素——1：action="/img/multiUpload"   对应 @PostMapping("/img/multiUpload")   2：声明好enctype="multipart/form-data" 3，name=file 对应controller 中的String file 

 