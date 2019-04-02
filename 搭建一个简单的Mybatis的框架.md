## 搭建一个简单的Mybatis的框架

1、在数据库里面建好表，然后插入几条数据

2、在esclipe里面导入mybatis所需要的包

3、创建一个pojo类用来将查询结果映射到上面，或者将其保存到数据库里面

4、创建一个mapper接口

5、创建mapper的xml文件

6、创建mybatis的config.xml文件

7、创建一个类获取sqlsession（通过SqlSessionFactoryBuilder的.build(resource)创建一个SqlSessionFactory，resource=mybatis的config.xml文件,然后通过SqlSessionFactory的openSession()方法获得一个sqlsession）

8、可以在main函数里面使用sqlsession，同时

```
String statement = "com.Alyssa.mybatisTest.mapper.StudentMapper.getStudent";//映射sql的标识字符串
```

     //执行查询返回一个唯一user对象的sql
     Student student = session.selectOne(statement, "sp009");