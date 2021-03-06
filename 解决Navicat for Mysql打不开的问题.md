## 解决Navicat for Mysql打不开的问题 

        **对**于学习数据库的同学来讲,直接使用控制台打开数据库或者对自己的数据表进行操作是很不方便的，所以，我们都是用NaviCat直接对数据库进行操作。但是，有一次我打开我的Navicat，突然显示错误，但是之前一直都是好的，为什么突然打不开了，显示下面的错误。



![](https://github.com/AlyssaMiaomiao/base/blob/master/%E6%95%B0%E6%8D%AE%E5%BA%93%E6%89%93%E4%B8%8D%E5%BC%80.jpg?raw=true)



### 1、重装数据库

​        **对**于初学者来讲，遇到这种问题，第一件事肯定是去百度了，我也是，但是看到的答案都是 *重装数据库*  ，但是重安装数据库是一件非常复杂的事情，因为重新安装，就必须要把之前的数据库里面的内容删除干净，这对于初学者来讲是非常困难的（因为我之前试过哈哈），所以我排除了这种方法。不过，如果没有别的办法的话，这是最直接最有效的方法，因为这个方法可以解决一切数据库的问题哈哈。

### 2、在cmd下直接运行

​        **于**是我又看到第二种方法，直接去cmd下面直接打开数据库，具体步骤如下：

+ 使用快捷键Windows键（在键盘上有个Windows标志的按键）+R输入cmd后回车。


+ 切换到数据库的bin目录所在的盘

+ 在CMD命令窗口敲入命令 mysql -hlocalhost -uroot -p 后按回车

+ 输入用户名，密码  

  ---

  但是这种方法还是失败了，仍显示`can't connect to mysql on localhost  `

  于是似乎就只剩下重装数据库这一条路了，但是小编仍然不死心（重装数据库对于小编来讲实在太麻烦），经过不断查找资料，终于在没有重装的情况下解决了。下面介绍简便的方法：

  1、我的电脑--->（右键）管理

  2、找到**服务和应用程序** -->找到 **服务**

  ​

  ![](https://github.com/AlyssaMiaomiao/base/blob/master/a.jpg?raw=true)

  ​

  ![](https://github.com/AlyssaMiaomiao/base/blob/master/b.jpg?raw=true)

  ​

  3、双击进入**服务**，找到**MYSQL**，将MySQL启动，就行啦(**有些人的是mysql有些人的是mysql1等等**)

  ​

  ![](https://github.com/AlyssaMiaomiao/base/blob/master/c.jpg?raw=true)

  ​

  ​

希望小编的方法可以帮到你！

