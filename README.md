## ✨ POPOOL
> MSA 기반 인사내역을 거래하고 관리하는 시스템입니다
> 한이음 프로젝트에서 개발한 내용을 바탕으로 혼자 힘으로 재 구현하는 레파지토리입니다.

- 프로젝트 기간: 2022.11-

## ✨ 주제 및 목적

> 스프링을 기반으로 전반적인 백엔드 개발에 대한 이해를 높인다.
> TDD와 클린코드를 바탕으로 코드를 짜본다

## ✨ 기술 스택
> 해당 프로젝트를 수행하며 사용한 기술 스택입니다.

- Java 8
- Spring boot , Spring Data Jpa , Spring Cloud
- QueryDSL
- Gradle
- Swagger
- Redis
- Github Action
- AWS codeDeploy, AWS S3
- H2, mysql
- Eureka

`User Server
유저 모듈은 해당 프로젝트 진행 중 타 프로젝트 합류로 레포지토리를 옮겨서 작업하였습니다.`
[User server 코드 저장소 바로가기](https://github.com/sienna011022/msa_auth_smilegate)

## ✨플로우 차트 & 시스템 아키텍처

### User server 기능
- JWT 기반  Access Token 발급
- JWT 기반 Refresh Token 발급
- 회원가입
- 로그인
- Password Encryption

### Career Server 기능
##### 인사
- 인사등록
- 인사조회
- 인사수정
- 인사삭제

##### 평가
- 평가등록(최초 등록)
- 평가조회

##### 등급
- 평가 평균 계산 후 등급 산출
- 인사내역과 평가 등급 매핑
- 최종 인사 내역 산출
## ✨구현 리스트

* User Server
- [X] 회원가입 기능
- [X] 비밀번호 암호화
- [X] 비밀번호 유효성 체크
- [X] 회원 정보를 찾을 수 없다면 예외 발생
- [X] 비밀번호가 일치하지 않으면 예외 발생
- [X] 아이디가 이미 존재한다면 예외 발생
- [X] 로그인 기능
- [X] Auth Server에 토큰 발급 요청

* Auth Server
- [X] JWT access token 발급
- [X] JWT refresh token 발급
- [X] 요청 온 access token 유효성 검사
- [X] 요청 온 refresh token 유효성 검사
- [X] refresh Token 저장 시 UUID를 발급하여 PK로 지정
- [X] 클라이언트에게 refresh Token이 아닌 UUID(DB의 PK)를 반환한다.
- [X] 요청 온 UUID를 통해 DB접근 후 , refresh token 유효성을 검증한다.
- [X] 유효할 시 , access token 재발급
- [X] access token은 만료, refresh token은 유효 => access token 재발급
- [X] access token은 만료, refresh token 만료 => 둘 다 삭제 후 재 로그인
- [X] access token 유효 , refresh token 만료 =>  에러
- [X] access token은 유효 , refresh token 유효  => 인증 성공 

* GateWay
- [X] 각 모듈 라우팅
- [X] 요청 Header에서 JWT 존재 여부 검사

* Front Server
- [X] 회원가입 페이지

* Career Server
## 구현 리스트
- [X] 인사 내역을 등록한다
- [X] 인사 내역을 조회한다
- [X] 인사 내역을 수정한다
- [X] 인사 내역을 삭제한다
- [X] 삭제된 인사내역인지 검증하는 예외 처리
- [X] 인사 평가를 등록한다
- [X] 자신이 등록한 인사 평가 내역을 조회한다
- [X] 상대방이 등록한 자신의 인사 평가 내역을 조회한다
- [ ] 평가 내역을 모아,등급을 산출한다
- [ ] 자신의 등급을 조회한다
- [ ] 인사 내역을 조회하면 등급도 조회할 수 있다

* ETC
- [X] 상태 code 정의
- [ ] 에외처리
- [ ] AWS S3 파일 저장
- [ ] AWS S3 파일 조회
- [ ] JPA Auditing
- [ ] swagger를 이용한 API
- [X] queryDsl

## Career 모듈 도메인 설계
- API 명세서, 기능 정의서,ERD가 포함되어 있습니다
  [도메인 설계](https://www.notion.so/CAREER-46ffed72a0f0494f8a330fb9725ef7d5)
## Career모듈 세세한 기능 목록
> Career 모듈의 세부적인 기능 목록을 나열한 것입니다


##### MSA
- gateway 연결
- member 정보 feign client로 받아오기
- Eureka 등록

##### ETC

## 프로젝트 진행 포스팅
> 프로젝트 개발 과정에서 다양한 고민과 좌충우돌을 적은 포스팅이며 링크로 연결되어 있습니다.

- [MSA란?](https://sienna1022.tistory.com/m/entry/%ED%95%9C%EC%9D%B4%EC%9D%8C-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-MSA-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-1)
- [Eureka](https://sienna1022.tistory.com/m/entry/%ED%95%9C%EC%9D%B4%EC%9D%8C-MSA%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-2-Eureka-%EC%84%9C%EB%B2%84%ED%81%B4%EB%9D%BC%EC%9D%B4%EC%96%B8%ED%8A%B8-%EC%84%A4%EC%A0%95)
- [Eureka호출 구현](https://sienna1022.tistory.com/m/entry/%ED%95%9C%EC%9D%B4%EC%9D%8CMSA%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B83-%EC%84%9C%EB%B9%84%EC%8A%A4-%ED%98%B8%EC%B6%9C-%EA%B5%AC%ED%98%84)
- [Feign 적용기](https://sienna1022.tistory.com/m/entry/%ED%95%9C%EC%9D%B4%EC%9D%8C-MSA-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B84-feign-client-%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0)
- [GateWay 적용기](https://sienna1022.tistory.com/m/entry/%ED%95%9C%EC%9D%B4%EC%9D%8C-MSA-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B85-Spring-Cloud-Gateway-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0)
- [AWS S3 파일 업로드](https://sienna1022.tistory.com/m/entry/%ED%95%9C%EC%9D%B4%EC%9D%8C-%EC%8A%A4%ED%94%84%EB%A7%81-AWS-S3-%ED%8C%8C%EC%9D%BC-%EC%97%85%EB%A1%9C%EB%93%9C-%EB%B0%8F-controller-%EC%97%90%EB%9F%AC-%ED%95%B4%EA%B2%B0)
- [AWS S3 파일 조회](https://sienna1022.tistory.com/m/entry/%ED%95%9C%EC%9D%B4%EC%9D%8C-AWS-S3-%EC%A0%80%EC%9E%A5%ED%95%9C-%EC%9D%B4%EB%AF%B8%EC%A7%80-%EA%B0%80%EC%A0%B8%EC%99%80%EC%84%9C-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-%EC%A1%B0%ED%9A%8C%ED%95%98%EA%B8%B0)
- [Controller의 SRP에 대한 고민](https://sienna1022.tistory.com/m/entry/%ED%95%9C%EC%9D%B4%EC%9D%8CController%EB%8A%94-SRP%EB%8B%A8%EC%9D%BC-%EC%B1%85%EC%9E%84-%EC%9B%90%EC%B9%99%EC%9D%84-%EC%A7%80%ED%82%A4%EB%8A%94%EA%B1%B8%EA%B9%8C)
- [CI/CD](https://sienna1022.tistory.com/m/entry/%ED%95%9C%EC%9D%B4%EC%9D%8C-CICD)
- [CI/CD와 AWS S3](https://sienna1022.tistory.com/m/entry/%ED%95%9C%EC%9D%B4%EC%9D%8C-CICD-%EC%99%80-S3)

## ✨User server 프로젝트 고민과 개선 사항

> 프로젝트 **개발** 및 **리팩토링** 과정에서 다양한 고민을 작성해보았습니다

(1) UUID 를 Custom하여 약 ***30%*** DB 성능 개선 사례 (리팩토링)

✅**고민** : MSA에서 인증 시스템을 구현할 때, 보안이 중요한 Refresh token을 어떻게 DB에 저장할지 고민이 되었습니다.

✅ **방안 1 -** Increment 형식의 PK를 사용한다.

- **문제사항**

(1) PK값이 외부에서 예측하기 쉬워 일반적인 URL 패턴으로 공격을 할 수 있습니다. refresh token과 같은 보안 요소를 저장하는 DB라면 위험하다고 생각했습니다.

(2) MSA는 각 서비스마다 다른 DB를 사용하는데 만약 로직의 변경으로 각 서비스가 합쳐진다면 중복되는 PK가 생깁니다. 이를 변경하려면 많은 비용이 듭니다.

✅ **방안 2 -** PK로 UUID를 사용한다.

- **문제사항**

PK를 UUID로 설정함으로써 보안적 측면에서 우수했으나, UUID가 PK로 지정될 시, 성능 상에서 큰 비용이 든다고 합니다.

- **원인 파악**

RDBMS는 MySQl인데 MySQL의 innoDB는 B-tree 알고리즘으로 인덱스를 탐색합니다. 이때 index의 전제 조건이 “정렬”된 데이터라는 점입니다.

pk가 UUID로 사용된다면 UUID는 랜덤 숫자들로 이루어져 있기에 정렬되지 않음이 성능 측면에 문제를 일으키지 않을까 예측해 보았습니다.

- **개선 사항**

저는 기존 UUID의 구조를 바꾸어, 최대한 순차적이고 고정적인 데이터(MAC주소)가 앞서게끔 배열하였습니다.  

- **실험**

10만 건의 데이터를 저장한 뒤, JPA에서 findAll() 쿼리를 날리고 걸리는 시간을 측정해 본 결과는 다음과 같이 얻을 수 있었습니다.

| PK 생성 방식 |  소요 시간 |
| --- | --- |
| Increment PK | 1077ms  |
| UUID.Random()함수 | 1540ms |
| custom 한 UUID | 1180ms |

✅ **평가** 

> 기존의 Increment 로직을 수행할 때와 비슷한 성능을 유지하면서, 단순한 값 증가가 아닌 고유한 값을 가진 PK를 발급할 수 있었습니다. 더불어 UUID를 Refresh token 대신 클라이언트에게 전달함으로써 보안적 요소인 refresh token을 실제 api에 노출하지 않을 수 있었습니다.
>



