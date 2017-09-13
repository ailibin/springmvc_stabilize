# SpringMVCDemo

## 介绍
这个来自另外一个学习项目，向原作者致敬！
这是一个增加了规范、技术底层方面迭代更新的demo，公开部分主要用于准企业级的方案框架和公司内部机试题目需要。
因为改动量太大，所以没有从原库中fork（几乎没有合并的可能）。
请先阅读原文的介绍如何部署，再看后面我们的介绍新规范要求

## 原文介绍

这是我个人在学习过程中整理的一个SpringMVCDemo项目。

如果要运行这个项目，首先要创建一个"springdemo"数据库，注意选择utf-8格式，然后将springdemo.sql导入到数据库中。

如果需要查看完整的教程，请访问[Gaussic OSChina](http://my.oschina.net/gaussik/blog/385697) 。

最好使用最新版本的 IntelliJ IDEA, JDK 1.8.x，还有Tomcat8.x。

任何由升级带来的问题，请查阅[Spring Framework Reference](http://docs.spring.io/spring/docs/4.3.0.BUILD-SNAPSHOT/spring-framework-reference/htmlsingle/)。

如果你有什么问题，或者宝贵的意见，可以在Issues中提出，我会及时回应。谢谢关注 :)

此外，还有一个旧的 spring 3.2.0 版本的项目：[See the spring3.2 branch](https://github.com/gaussic/SpringMVCDemo/tree/spring3.2)

欢迎访问我的个人博客首页：[Gaussic](http://gaussic.top)

## 本项目介绍
demo是Spring最新的4.2.6版本。做了如下操作：

1.增加Simple-spring-memcached作为缓存

2.目录分层做到了MVC分层，M层进一步分层，符合企业级的架构

3.包名换成公司规范要求

### 1.MVC框架里面，我们根据MVC以及下面的分层要求

划分号目录，保持调用结构：

#### Controller层：

Controller，对应@Controller注解，只做路由转发+耦合view层的东西（输出html或者json）

#### view层
html或者json等数据格式，HTML使用JSP模板。
JSP放在webapp/WEB-INF/pages底下，注意按照目录方式存放。
json格式通过对象方式，然后在controller里面一行代码转换成json，根据对象命名，例如用户信息为UserInfo．
如果无特别的json或者数据结构，直接输出了来自model返回的对象转换成的json，则无需在view层上面放json有关的东西。


### model层
业务逻辑和模型，M层再进一步分层ABCR：

A层：Application应用层，简写App，对应@Service注解，包含有参数检查，权限控制，事务控制，业务流程入口。  
B层：Business业务曾，简写biz，对应@Service注解，包含业务逻辑处理的主要代码、流程描述  
C层（为了避免误会，以后都称为Component层、组件层）：Component零件层，没有简写，对应@Component注解，包含逻辑的小零件，方便业务层组合逻辑。  
如果有对外的API调用等等也使用这个注解并且在此归类。  
为什么叫零件不叫组件纯粹是为了让这些代码尽可能小，复用性高，规避网砂锅内滥用“组件”概念导致意思混淆    
R层：Repository，没有简写，SQL操作对应@Repository注解，包含数据库操作，Dao，model对象等。数据对象对应@Entity注解，  
comm包：英文communication，Application层的数据打包给controller时，主要通过里面的类的实例传递数据包装在公用类里面完成。  
entity包：Hibernate框架所需要，表的实体对象。类名均以Entity结尾。  

不通过Spring管理的，以其他方式管理，目录结构在业务的包下独立存在，例如工具为com.aiitec.user.utils。

标准的结构参考例子如下：
```
├─controller
│      BlogController.java
│      MainController.java
│
├─model
│  ├─app  ->应用层
│  │      LoginApp.java
│  │
│  ├─biz  ->业务曾
│  │      LoginBiz.java
│  │
│  ├─component ->零件层
│  │      PasswordComponent.java
│  │      UserInfoComponent.java
│  │
│  ├─entity ->实体对象
│  │      BlogEntity.java
│  │      UserEntity.java
│  │
│  ├─repository ->R层
│  │      BlogRepository.java
│  │      UserRepository.java
│  └─comm  ->通讯实体层
│          UserMap.java
│          UserReqBody.java
│          UserRespBody.java
├─utils ->工具类
└─view ->view层可选
    └─object
            UserInfo.java
```
2.架构里面，要维持自上而下的调用架构，Controller->A->B->C->R,允许同级调用，不允许调用上级（例如不允许C-->Controller）

3.不同的子系统，通过不同包名区分，可能以jar包方式（可能没有源码）提供，每个包的子系统可能包括以上提到的所有目录结构。
例如com.aiitec.user, com.aiitec.goods、com.aiitec.order等，允许跨包调用、下级调用、同级调用，但是同样不允许调用上级。

## FAQ
1.我有一个component层的代码，简单的调用一下application层的代码就能完成功能了，为什么不允许这么做？应该怎么做？

答：a)因为component层只是小零件，不应该承担太多工作，有这样的需求说明一些业务层或者应用层应该做的东西放在了这里，
或者你想调用的功能被放在了上层；  
b)按照架构应该是受到上层控制和调用，不应该控制上层，如果架构乱了，对后面维护的人不利，因为他们很可能找不到自己想要的代码。  
c)应该把调用application层的事情交给自己application层的代码来做。    
有时候可能需要application重构一下，把部分逻辑放在biz层做，然后再biz层调用，因为biz层互相调用和复用逻辑很正常。  

2.包里面的controller/entity/XXX类太多了，我想整合到一个文件里面。  
答：大部分的情况下，这种整合都不正确，原因有：  
a)Spring根据类为单位处理注解的bean，如果不需要一起初始化的bean放在同一个类，会有不必要的性能开销。  
b)条理不够清晰，影响维护，这是大罪。  
c)架构上面要求按照不同的业务分不同的业务包。    
如果太多文件很有可能是因为没有按照业务正确划分包，因此应该做的是分包而不是想着合并文件。  
d)哪些是合理呢？局限于当前范围内创建的类，例如通讯对象有很多层次的，例如controller里面用于提取参数的类，
这时应该整合到一个文件里面（使用staitc class）


## 注意事项
1)本项目中使用了ajax来访问标签,数据库工具使用的是mysql,要运行本项目就要配置好mysql数据库,不然会报错.

2)如果Tomcat的port被占用了执行：taskkill /f /t /im java.exe

3)每个功能都有相应的controller来执行,具体的请看demo下面controller类中的注释说明.

4)我的开发环境是使用idea的,如果是eclipse来运行本项目就需要:convert to maven project.其它如果还有报错的信息,请自己查看是哪里报错.

5)如果出现import javax.servlet.http.HttpServletRequest这个包报错,请在project_struct里面添加libraries：servlet-api,版本自己选择.

