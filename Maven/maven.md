总目标：
阅读源码，试图写出简易版maven。

POM（Project Object Model)

Maven将项目流程标准化，本身就是Java写成的

基于Java平台的项目构建，依赖管理和项目信息管理

常用cmd命令：
dir
md
rd
cd(change directory)
cd\
cd..
echo text  >> dir name(将text写入名字为name的directory)

Maven用于：
1. 项目构建：
高度自动化，跨平台，可重用的组件，标准化
2. 依赖管理：jar包
3. 项目信息：
- 项目名称描述，开发人员信息，开发者信息等

Ant:
被Maven取代
原因：
- 没有一个约定的目录结构
- 必须明确让ant做什么，什么时候做，然后编译，打包
- 没有集成依赖管理

Maven:
- 拥有约定（有目录结构）
- 有生命周期，只需执行mvn install就可以
- 只需定义一个pom.xml，然后把源码放到目录中

### [Running Apache Maven](http://maven.apache.org/run.html)
 
The syntax for running Maven is as follows:
运行Maven的语法如下：

```
mvn [options] [<goal(s)>] [<phase(s)>]
```
 
All available options are documented in the built in help that you can access with
所有的操作都内置在文档中，你可以使用mvn -h 获得帮助信息

```
mvn -h
```

 The typical invocation for building a Maven project uses a Maven life cycle phase. E.g.
### Maven生命周期阶段：
 
mvn package

 The built in life cycles and their phases are in order are:
内置生命周期（life cycles）和他们的 阶段（phase）按顺序如下：

■ clean   (清理项目的)
- pre-clean(执行一些需要在clean之前完成的工作） pre(词根：在。。。之前  如：prepare(预先))
- clean
- post-clean post(词根：在。。。之后 )

- Clean Lifecycle 在进行真正的构建之前进行的一些清理工作

■ default   (构建项目的)
- *validate*（验证）
-initialize（初始化）, generate-sources, process-sources, generate-resources, process-resources, 
- compile（编译项目的源代码)
process-classes, generate-test-sources, process-test-sources, generate-test-resources, process-test-resources, test-compile, process-test-classes, 
- test（编译测试源代码）
 prepare-package, package, pre-integration-test, integration-test, post-integration-test, 
- verify（确认）
- install（将包安装至本地仓库(.m2->repository)，以让其他项目依赖） 
- deploy（将最终的包复制到远程的仓库，以让其他开发人员与项目共享）
 
- Default Lifecycle 构建的核心部分，编译，测试，打包，部署等等

■ site  (生成项目站点的)
- pre-site, site（站点）, post-site, site-deploy（发布站点）
- Site Lifecycle 生成项目报告，站点，发布站点

### 项目生命周期（Project Lifecycle）
清理(clean )，编译(compile)，测试(test)，报告(?)，打包(package)，部署(deploy)，站点生成(site)等

A fresh build of a project generating all packaged outputs and the documentation site and deploying it to a repository manager could be done with

```
mvn clean deploy site-deploy
```

Just creating the package and installing it in the local repository for re-use from other projects can be done with

```
mvn verify
```

This is the most common build invocation for a Maven project.

When not working with a project, and in some other use cases, you might want to invoke a specific task implemented by a part of Maven - this is called a goal of a plugin. E.g.:

```
mvn archetype:generate
```
or

```
mvn checkstyle:check
```

There are many different plugins available and they all implement different goals.

### What is Maven?
At first glance Maven can appear to be many things, but in a nutshell Maven is an attempt **to apply patterns to a project's build infrastructure in order to promote comprehension and productivity by providing a clear path in the use of best practices.** Maven is essentially a project management and comprehension tool and as such provides a way to help with managing:

- Builds
- Documentation
- Reporting
- Dependencies
- SCMs
- Releases
- Distribution

[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Archetype: maven-archetype-quickstart:1.4
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: groupId, Value: com.mycompany.app
[INFO] Parameter: artifactId, Value: my-app
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] Parameter: package, Value: com.mycompany.app
[INFO] Parameter: packageInPathFormat, Value: com/mycompany/app
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] Parameter: package, Value: com.mycompany.app
[INFO] Parameter: groupId, Value: com.mycompany.app
[INFO] Parameter: artifactId, Value: my-app
[INFO] Project created from Archetype in dir: D:\19.2_19.7Spirng_semester\Maven\m_project\my-app
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 05:55 min
[INFO] Finished at: 2019-03-20T17:45:30+08:00
[INFO] Final Memory: 14M/52M
[INFO] ------------------------------------------------------------------------
