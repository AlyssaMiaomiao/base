## Mybatis学习错误总结

1、在mybatis的config.xml文件的头文件里面，不能使用这种写法

```
<!DOCTYPE mapper
 PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
 "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
```

要使用这种写法

```
 <!DOCTYPE configuration
 PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
 "http://mybatis.org/dtd/mybatis-3-config.dtd">
```

报错

```
Error creating document instance.  Cause: org.xml.sax.SAXParseException; lineNumber: 5; columnNumber: 16; 文档根元素 "configuration" 必须匹配 DOCTYPE 根 "mapper"。
```

原因:



2、在mybatis的xml文件里面，配置映射mapper的时候，不要使用resource，而使用其他的方法

引入映射器的方法

（1）、用文件路径

```
<mapper resource="com.Alyssa.mybatisTest.mapper.StudentMapper.xml">
```

(2)、用包名

```
<package name="com.Alyssa.mybatisTest.mapper">
```

(3)、用类注册引入

```
<mapper class="com.Alyssa.mybatisTest.mapper.StudentMapper">
```

不要直接使用文件路径的方式

报错

```
Could not find resource com.Alyssa.mybatisTest.mapper.StudentMapper.xml
```

原因：

**IDEA的Maven是不会编译src的java目录的xml文件，所以在Mybatis的配置文件中找不到xml文件！**

3、在mapper的配置文件里面，写的SQL语句不能用 **；** 结尾，会产生非常长非常长的错误

4、在给类取名的时候，千万不要与自带的类重名 ，不然会出现说你强制转换类的错误