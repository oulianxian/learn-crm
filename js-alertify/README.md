##注意
------jQuery提示插件alertify使用指南
学习怎么引入包，怎么搭进系统

引入web 包来控制，引入thymeleaf 来响应返回来的页面,不然报404 找不到页面而不是找不到url
然后引入js ,需要将文件放在static.否则找不到，引入的写法是 src="/static/目录一/文件" static 一定要去掉，绝对路径
还要引入css
  能否使用npm 开管理包
Javascript中点击（click）事件的3种写法
                        var btn = document.getElementById("btn");
                           		btn.onclick=function(){
                           			alert("hello world");
                           		}
                           		
                           		
                           
                            	btn.addEventListener('click',function(){
                                			alert("hello wrold");
                                		},false)


onclick="test()"   function test(){
                   			alert("hello world");
                   		}
                   		
                   		
                   		官方文档https://alertifyjs.com/
