# 요구사항
- 이번 스프린트(첫 번째 이터레이션)에서는 계산기 펌웨어에 기본 산술 연산을 구현하게 됩니다. QA 팀이 계산기를
테스트할 수 있도록 하기 위해 입력을 명령행 자바 프로그램으로 인수로 받도록 해야 합니다. 아래는 자세한
내용입니다:
### Operations
- [x] Addition
- [x] Subtraction
- [x] Multiplication
- [x] Division
- [x] Operation ::= + , - , *, / 
### Operands
- [x] Operand ::= [0-9]+[.]?[0-9]*
- [x] No thousand separators (i.e., ,)
- ### Inputs
- [x] Input ::= Operand Operation Operand 
- # Outputs
- [x] No thousand separators required (i.e., ,)
- [x] Print the result to the console.

### 주의사항
- [x]  가능하다면 모든 작업은 TDD 방식을 사용하여 수행되어야 합니다. 만약 불가능하다면 Unit Test 코드만 이라도 같이
작성해 주세요. 
- [x] 그리고 다음 스프린트에서 삼각함수인 사인과 코사인 함수 지원이 예정되어 있습니다.
 - 예상 시나리오
   - CalculateValue에서 cos, sin 및 operatinType에 값 추가
   - CalculateValue에서 cos 나 sin이 들어갈 경우 num1 하나만 받게 변경 및 length 체크 1개만 하게 변경