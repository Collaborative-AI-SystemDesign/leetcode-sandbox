## 개요
1. 직접 LeetCode 같은 코딩 플랫폼을 직접 설계하고,
2. 작은 MVP부터 시작해 성능 병목을 찾아내고,
3. 문제를 구조적으로 해결하는 일련의 과정을 실습해보기로 했습니다.
   
이 글은 단순히 동작하는 서비스를 만들기 위한 기록이 아닙니다.  
시스템 디자인 인터뷰에서 자주 등장하는 주제들을 실무, 인터뷰에서 자신 있게 설명할 수 있도록 만들기 위한 일종의 자체 시뮬레이션 기반 학습입니다.

## Contents
1. 초기 프로젝트 구현
   - 요구사항
   - API 엔드포인트
   - DB 스키마, Infra Diagram
2. 애플리케이션 내부 성능 측정 및 최적화
   - GET Problem List: 커서 방식의 페이징처리
   - GET Problem Detail: Redis 캐싱
   - Post Submit Problem: 캐싱 & 멱등키 도입 시도
   - Get Leaderboard: Redis의 Sorted Set 캐싱
3. 프로젝트 부하 테스트 및 회적화
   - GET APIs: 고부하 상황에서 API 병목 진단 및 대응 전략
   - POST API: 비기능 요구사항의 고확장성(10,000 동시 호출)을 만족하기
4. 트로젝트 트러블 슈팅
   - JPA: Osiv
   - RabbitMq: ackMode = None
   - vCPU 능력 이상의 처리량
