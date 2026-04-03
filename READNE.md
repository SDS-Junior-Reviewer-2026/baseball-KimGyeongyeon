- 모든 커밋은 단위테스트가 돌아가야한다.
- master <- feature/game PR을 올려야한다.
- [feature/refactoring] page 양식을 지켜야한다

---

•
Commit 규칙
1. 8단계까지리팩토링하는동안수차례Commit을한다. (feature/game)
2. Green / Refactor 단계마다Unit Test 후Pass시Commit한다.
3. Red 단계는Commit 하지않는다. (동작하는코드만Commit해야하기때문)

Commit Message Format


Green 단계: [feature] page 번호(예시: [feature] 31p)

Refactor 단계: [refactoring] page 번호(예시: [refactoring] 33p)

최종제출하기

1. 모든실습을완료한이후, Push 1회진행
2. PR을던진후Merge를수행한다.
3. Merge 이후, 기존Branch를삭제한다.