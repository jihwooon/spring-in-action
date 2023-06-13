## Toby-Spring
토비의 스프링 예제를 위해 SpringBoot 프로젝트를 생성했습니다.

## 환경 셋팅 및 필수 조건
SpringBoot 환경설정에는 다음과 같습니다.

- Language: Java 11
- SpringBoot:2.3.x
- Packaging: Jar

> 주의: SpringBoot: 3.0.x 이상이면 Java 17 이상 사용해야 합니다.

Docker 환경 설정에는 다음과 같습니다.
- Mysql: Mysql:8

## SpringBoot 생성하기
1. https://start.spring.io 으로 접속합니다. 

2. **프로젝트 선택**을 다음과 같습니다. 
   1. Projects: Gradle-Groovy
   2. Spring: 2.3.x 이상
   3. Language: Java
   4. Packaging: Jar
   5. Java: 11
3. 프로젝트를 생성합니다.

## IntelliJ Gradle 대신 자바로 실행하기
새로운 프로젝트를 설치하고 실행하면 Gradle로 기본 실행이 됩니다. 이 경우 속도가 느립니다.
1. 실행 속도를 높이기 위해서 다음과 같은 설정을 변경해줍니다.
- Preferences Build, Execution, Deployment  Build Tools  Gradle
  - **Build and run using:** Gradle -> IntelliJ IDEA
  - **Run tests using:** Gradle -> IntelliJ IDEA

## Docker 환경에 MySQL 설정하기
로컬 환경에서 데이터베이스(`DB`)환경 설정이 아닌 Docker 환경에서 MySQL를 이용해서 데이터 베이스 환경을 구축합니다.
Docker가 설치가 되어 있지 않다면 Docker를 설치합니다.

1. docker 생성시 명령어는 다음과 같습니다.
```shell
docker run --name {docker-name} \
-e MYSQL_ROOT_PASSWORD={mysql-password} \
-e MYSQL_DATABASE={database-name} \
-d -p {outport-number}:{inport-number} mysql:8 \
--character-set-server=utf8mb4 \
--collation-server=utf8mb4_unicode_ci
```

2. Docker 컨터이너가 생성이 되었다면 워크벤치(`DBeaver`)에 설정합니다.
