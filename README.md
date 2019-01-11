对应文章：[Java程序制作Docker Image推荐方案](https://segmentfault.com/a/1190000016449865)

## 编译image
``` bash
mvn clean package dockerfile:build
```

## run docker
``` bash
# -p 8081:8080==-p 宿主机对外端口:容器内端口
# 提供程序运行参数，在后面直接添加 --target.host=192.168.0.31
docker run -p 8081:8080 -e JAVA_OPTS='-Dabc=xyz -Ddef=uvw' chanjarster/dockerfile-java-examples-1:1.0-SNAPSHOT --debug --Daaa=aaa --target.host=192.168.0.31

# 设定JVM参数，使用JVM_OPTS环境变量：
docker run -p 8081:8080 -e JVM_OPTS='-Xmx128M -Xms128M' chanjarster/dockerfile-java-examples-1:1.0-SNAPSHOT

# 设定System Properties，使用JAVA_ARGS环境变量：
docker run -p 8081:8080 -e JAVA_ARGS='-Dabc=xyz -Ddef=uvw' chanjarster/dockerfile-java-examples-1:1.0-SNAPSHOT
```

## issues
### Dockerfile内chown权限问题：升级docker版本
### ENTRYPOINT sh 脚本权限问题：Dockerfile 内执行chmod
``` bash
RUN ls /home/java-app; \
	chmod +x /home/java-app/docker-entrypoint.sh; \
```
### sh 脚本格式问题：保存成UNIX格式（原来是DOC）