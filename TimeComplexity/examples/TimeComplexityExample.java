/*
 * 시간복잡도 예제 코드
 * 
 * 빅-오메가 : 1
 * 빅-세타 : 2/N
 * 빅-오 : N
 */
public class TimeComplexityExample {
  public static void main(String[] args) {
    // 1 ~ 100 사이 값 랜덤 선택
    int findNubmer = (int)(Math.random() * 100);
    for (int i = 0; i < 100; i++) {
      if (i == findNubmer) {
        System.out.println(i);
        break;
      }
    }
  }
}