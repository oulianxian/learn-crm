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
 