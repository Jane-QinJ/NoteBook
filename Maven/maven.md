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
