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

### Running Apache Maven
The syntax for running Maven is as follows:
```
mvn [options] [<goal(s)>] [<phase(s)>]
```

All available options are documented in the built in help that you can access with
```
mvn -h
```

The typical invocation for building a Maven project uses a Maven life cycle phase. E.g.
```
mvn package
```

The built in life cycles and their phases are in order are:

- clean - pre-clean, clean, post-clean(清理项目的)

- default - validate, initialize, generate-sources, process-sources, generate-resources, process-resources, compile, process-classes, generate-test-sources, process-test-sources, generate-test-resources, process-test-resources, test-compile, process-test-classes, test, prepare-package, package, pre-integration-test, integration-test, post-integration-test, verify, install, deploy(构建项目的)

- site - pre-site, site, post-site, site-deploy(生成项目站点的)

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
