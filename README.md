webapp-quickstart:web项目开发脚手架
========================

Version-0.0.1
--------------------------
[Feature]
* SpringMVC+Spring+Mybatis

[Bugfix]
* NA

[Configuration]
* 使用脚手架如下：
```
mvn archetype:create-from-project
cd target\generated-sources\archetype
mvn install -Dmaven.skip.test=true

mvn archetype:generate -B -DarchetypeCatalog=local -DarchetypeRepository=local -DarchetypeGroupId=com.eboji -DarchetypeArtifactId=quick-start-archetype -DarchetypeVersion=0.0.1 -DgroupId=com.clzps -DartifactId=Monitor -Dpackage=com.clzps.monitor
```

