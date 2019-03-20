### 第一个Maven项目Hello
1.
**在cmd中执行**
```
mvn compile
```
需要进入有pom.xml(project object model)的目录下执行此命令
之后它会将很多jar包下载到**C:\Users\秦佳\.m2\repository**中

编译完成后，commend命令框显示：
```
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding GBK, i.e. build is platform dependent!
[INFO] Compiling 1 source file to D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello\target\classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 02:29 min
[INFO] Finished at: 2019-03-14T20:09:40+08:00
[INFO] Final Memory: 16M/152M
```

*Compiling 1 source file to D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello\target\classes*
**结果**：
生成target文件夹，编译过的文件放在了target/classes中

2.
**执行**：
```
mvn clean
```
cmd结果：
```
D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello>mvn clean
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building Hello 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-clean-plugin/2.5/maven-clean-plugin-2.5.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-clean-plugin/2.5/maven-clean-plugin-2.5.pom (4 KB at 0.9 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/22/maven-plugins-22.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/22/maven-plugins-22.pom (13 KB at 11.6 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-clean-plugin/2.5/maven-clean-plugin-2.5.jar
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-clean-plugin/2.5/maven-clean-plugin-2.5.jar (25 KB at 10.3 KB/sec)
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ Hello ---
Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0/plexus-utils-3.0.pom
Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0/plexus-utils-3.0.pom (4 KB at 5.4 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/sonatype/spice/spice-parent/16/spice-parent-16.pom
Downloaded: https://repo.maven.apache.org/maven2/org/sonatype/spice/spice-parent/16/spice-parent-16.pom (9 KB at 7.6 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/sonatype/forge/forge-parent/5/forge-parent-5.pom
Downloaded: https://repo.maven.apache.org/maven2/org/sonatype/forge/forge-parent/5/forge-parent-5.pom (9 KB at 6.7 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0/plexus-utils-3.0.jar
Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0/plexus-utils-3.0.jar (221 KB at 17.6 KB/sec)
[INFO] Deleting D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello\target
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 31.690 s
[INFO] Finished at: 2019-03-20T14:30:45+08:00
[INFO] Final Memory: 8M/86M
[INFO] ------------------------------------------------------------------------
```

* Deleting D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello\target*
**结果**：
Hello\target被删除

3. 
**run**
```
mvn clean compile
```

**cmd show**
D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello>mvn clean compile
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building Hello 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ Hello ---
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ Hello ---
[WARNING] Using platform encoding (GBK actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ Hello ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding GBK, i.e. build is platform dependent!
[INFO] Compiling 1 source file to D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello\target\classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.890 s
[INFO] Finished at: 2019-03-20T14:38:19+08:00
[INFO] Final Memory: 13M/137M
[INFO] ------------------------------------------------------------------------
**result**
 *Compiling 1 source file to D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello\target\classes*
 编译成功，target文件再次被创建

**尝试在compile文件存在的情况下，执行mvn clean compile**
D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello>mvn clean compile
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building Hello 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ Hello ---
[INFO] Deleting D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello\target
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ Hello ---
[WARNING] Using platform encoding (GBK actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ Hello ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding GBK, i.e. build is platform dependent!
[INFO] Compiling 1 source file to D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello\target\classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.047 s
[INFO] Finished at: 2019-03-20T14:41:45+08:00
[INFO] Final Memory: 13M/136M
[INFO] ------------------------------------------------------------------------
 *[INFO] Deleting D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello\target *
*[INFO] Compiling 1 source file to D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello\target\classes*

可以看出， 编译文件先被delete后再次compile

 4.
 **run**
 ```
 mvn clean test
 ```
 **result**
 ```
 -------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running cn.rjxy.maven.HelloTest
Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 0.16 sec <<< FAILURE!
testHello(cn.rjxy.maven.HelloTest)  Time elapsed: 0.013 sec  <<< FAILURE!
junit.framework.ComparisonFailure: **expected:<Hello Jane Qin[]> but was:<Hello Jane Qin[!]>**
        at junit.framework.Assert.assertEquals(Assert.java:85)
        at junit.framework.Assert.assertEquals(Assert.java:91)
        at cn.rjxy.maven.HelloTest.testHello(HelloTest.java:11)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:44)
        at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:15)
        at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:41)
        at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:20)
        at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:263)
        at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:69)
        at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:48)
        at org.junit.runners.ParentRunner$3.run(ParentRunner.java:231)
        at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:60)
        at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:229)
        at org.junit.runners.ParentRunner.access$000(ParentRunner.java:50)
        at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:222)
        at org.junit.runners.ParentRunner.run(ParentRunner.java:292)
        at org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:252)
        at org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:141)
        at org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:112)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at org.apache.maven.surefire.util.ReflectionUtils.invokeMethodWithArray(ReflectionUtils.java:189)
        at org.apache.maven.surefire.booter.ProviderFactory$ProviderProxy.invoke(ProviderFactory.java:165)
        at org.apache.maven.surefire.booter.ProviderFactory.invokeProvider(ProviderFactory.java:85)
        at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:115)
        at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:75)


Results:

Failed tests:   testHello(cn.rjxy.maven.HelloTest): expected:<Hello Jane Qin[]> but was:<Hello Jane Qin[!]>

Tests run: 1, Failures: 1, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 01:08 min
[INFO] Finished at: 2019-03-20T14:45:57+08:00
[INFO] Final Memory: 17M/138M
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.12.4:test (default-test) on project Hello: There are test failures.
[ERROR]
[ERROR] Please refer to D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello\target\surefire-reports for the individual test results.
[ERROR] -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
```

=-=
Failed tests:   testHello(cn.rjxy.maven.HelloTest): expected:<Hello Jane Qin[]> but was:<Hello Jane Qin[!]>
失败了，初步断定是测试文件或者java类写错了，少了一个！

修改之后，尝试重新编译
**Q： 需要先清理clean么？**
A： 不需要 
*[INFO] Changes detected - recompiling the module!*
每次改动，都可以自动检测到

```
D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello>mvn test
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building Hello 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ Hello ---
[WARNING] Using platform encoding (GBK actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ Hello ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding GBK, i.e. build is platform dependent!
[INFO] Compiling 1 source file to D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello\target\classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ Hello ---
[WARNING] Using platform encoding (GBK actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ Hello ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ Hello ---
[INFO] Surefire report directory: D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running cn.rjxy.maven.HelloTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.088 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3.238 s
[INFO] Finished at: 2019-03-20T14:52:48+08:00
[INFO] Final Memory: 15M/137M
[INFO] ------------------------------------------------------------------------
```
![](https://raw.githubusercontent.com/Jane-QinJ/NoteBook/master/Maven/images/mvn_test.png)
新增加两个文件夹
(1)surefire-reprots
(2)test-classes

5.
**run**
 ```
 mvn clean package
 ```
 **result**
 ```

D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello>mvn clean package
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building Hello 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ Hello ---
[INFO] Deleting D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello\target
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ Hello ---
[WARNING] Using platform encoding (GBK actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ Hello ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding GBK, i.e. build is platform dependent!
[INFO] Compiling 1 source file to D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello\target\classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ Hello ---
[WARNING] Using platform encoding (GBK actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ Hello ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding GBK, i.e. build is platform dependent!
[INFO] Compiling 1 source file to D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello\target\test-classes
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ Hello ---
[INFO] Surefire report directory: D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running cn.rjxy.maven.HelloTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.078 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ Hello ---
[INFO] Building jar: D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello\target\Hello-0.0.1-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 27.173 s
[INFO] Finished at: 2019-03-20T15:41:25+08:00
[INFO] Final Memory: 15M/72M
[INFO] ------------------------------------------------------------------------
```
将上述

**清理->编译->测试->报告->打包->部署**
都完成了，并生成了jar包。

**Q：部署还未出现**
**A： to be continue**

### 第二个Maven项目 HelloFriend
```
D:\19.2_19.7Spirng_semester\Maven\chapter3\HelloFriend>mvn package
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building HelloFriend 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[WARNING] The POM for cn.rjxy.maven:Hello:jar:0.0.1-SNAPSHOT is missing, no dependency information available
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 0.477 s
[INFO] Finished at: 2019-03-20T16:18:04+08:00
[INFO] Final Memory: 7M/77M
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal on project HelloFriend: Could not resolve dependencies for project cn.rjxy.maven:HelloFriend:jar:0.0.1-SNAPSHOT: Could not find artifact cn.rjxy.maven:Hello:jar:0.0.1-SNAPSHOT -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/DependencyResolutionException
```

*[WARNING] The POM for cn.rjxy.maven:Hello:jar:0.0.1-SNAPSHOT is missing, no dependency information available*

**Error**:找不到依赖的Hello项目

**solution**:
将Hello项目的JAR包放入仓库中，执行
```
mvn install
```

```
[INFO] Installing D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello\target\Hello-0.0.1-SNAPSHOT.jar to C:\Users\秦佳\.m2\repository\cn\rjxy\maven\Hello\0.0.1-SNAPSHOT\Hello-0.0.1-SNAPSHOT.jar
[INFO] Installing D:\19.2_19.7Spirng_semester\Maven\chapter3\Hello\pom.xml to C:\Users\秦佳\.m2\repository\cn\rjxy\maven\Hello\0.0.1-SNAPSHOT\Hello-0.0.1-SNAPSHOT.pom
```

**issues**
```
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:testCompile (default-testCompile) on project HelloFriend: Compilation failure
[ERROR] /D:/19.2_19.7Spirng_semester/Maven/chapter3/HelloFriend/src/test/java/cn/rjxy/maven/HelloFriendTest.java:[7,6] 找不到符号
```
**reason**
没有导包 junit无法识别@Test
**solution**
```
import org.junit.Test;
```