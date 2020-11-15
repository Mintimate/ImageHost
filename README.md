# ImgShare
![](https://github.com/Mintimate/ImgShare/blob/master/JavaWebProject.png?raw=true)
# 项目概述
这个其实就是我个人的期末小项目，不是毕业设计……也不是什么大工程……没有用Springboot，就是最基础的JSP和Servlet，大佬们就别喷我了:-)
项目目的：部署在任意一台个人服务器，可以把服务器变成个人图床服务器。

# 项目迁移
项目架构升级为Springboot+Mybatis Plus+Thymeleaf，该仓库暂停更新。新仓库源：[Image-FileHost](https://github.com/Mintimate/Image-FileHost)

# 项目说明
请移步到我的个人博客：[Mintimate's Blog](https://www.mintimate.cn/2020/06/01/JavaWeb/)
博客内也有我联系方式。

# 关于开源 
这个，其实我是很不愿意的；因为代码……我现在就知道写的很乱；但是还是开源吧，大家就偷偷笑我好了，以后我会开自己代码，应该也会忍不住笑出声吧，哈哈哈

# 更新日志
## 停止更新
为了彻底解决Tomcat假死，也为了响应架构不好的问题。升级架构，本项目暂停更新，请迁移到新项目：[Image-FileHost](https://github.com/Mintimate/Image-FileHost)
## 07.01
感谢很多人私信给我的建议；但是也有人自己自以为是，**连JavaWeb都没学过，就指着我这个练手的JavaWeb项目说？你这么厉害，你自己实现给我看啊。**
## 06.10
再次更改JDBC运行机制，防止Tomcat"假死"
增加敏感词屏蔽
## 06.01
精简部分代码，规范部分代码；
尝试增加数据库最大连接和更改c3p0设置，防止Tomcat"假死"
修复其他错误
