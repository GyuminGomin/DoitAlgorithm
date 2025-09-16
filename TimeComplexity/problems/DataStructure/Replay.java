
public class Replay {
  
  /*
   * 문제 5
   * 나머지 합 구하기
   * N개의 수 A1, A2, ..., An이 주어졌을 때, 연속된 부분의 합이 M으로 나누어떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
   * 즉, Ai + ... + Aj(i <= j)의 합이 M으로 나누어떨어지는 (i,j) 쌍의 개수를 구하시오.
   * 
   * 입력 [
   *  1번째 줄에 N과 M(1 <= N <= 10^6, 2 <= M <= 10³), 2번째 줄에 N개의 수 A1, A2, ..., An이 주어진다.(0 <= Ai <= 10^9)
   * ]
   * 
   * 출력 [
   *  1번째 줄에 연속된 부분의 합이 M으로 나누어떨어지는 구간의 개수를 출력한다.
   * ]
   */
  public static class RemainderHap {
    private static void remainderHap(String[] array) {
      String[] NMArray = array[0].split(" ");
      int N = Integer.parseInt(NMArray[0]);
      int M = Integer.parseInt(NMArray[1]);

      
    }
  }

  /*
   * 문제 6
   * 어떠한 자연수 N은 몇 개의 연속된 자연수의 합으로 나타낼 수 있다. 당신은 어떤 자연수 N(1<= N <= 10000000)을 몇 개의 연속된 자연수의 합으로
   * 나타내는 가짓수를 알고 싶다. 이때 사용하는 자연수는 N이어야 한다. 예를 들어 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5이다.
   * 반면, 10을 나타내는 방법은 10, 1+2+3+4 이다. N을 입력받아 연속된 자연수의 합으로 나타내는 가짓수를 출력하는 프로그램을 작성하시오.
   * 
   * 입력 [
   *  1번째 줄에 정수 N이 주어진다.
   * ]
   * 
   * 출력 [
   *  입력된 자연수 N을 연속된 자연수의 합으로 나타내는 가짓수를 출력한다.
   * ]
   */
  public static class TwoPointer {
    private static void twoPointer(String N) {
      
    }
  }

    /*
   * 문제 7
   * 주몽은 철기군을 양성하기 위한 프로젝트에 나섰다. 그래서 야철대장에게 철기군이 입을 갑옷을 만들라고 명령했다.
   * 야철대장은 주몽의 명령에 따르기 위해 연구에 착수하던 중 갑옷을 만드는 재료들은 각각 고유한 번호가 있고, 갑옷은
   * 2개의 재료로 만드는 데 2가지 재료의 고유한 번호를 합쳐 M(1<=M<=10000000)이 되면 갑옷이 만들어진다는 사실을 발견했다.
   * 야철대장은 자신이 만들고 있는 재료로 갑옷을 몇 개나 만들 수 있는지 궁금해졌다. 야철대장의 궁금증을 풀어 주기 위해
   * N(1<= N <= 15000)개의 재료와 M이 주어졌을 때 몇 개의 갑옷을 만들 수 있는지를 구하는 프로그램을 작성하시오.
   * 
   * 추가 중첩 반복문 사용하지 말 것
   * 
   * 입력 [
   *  1번째 줄에 재료의 개수 N(1<= N <= 15000), 2번째 줄에 갑옷을 만드는 데 필요한 수 M(1<= M <= 10000000)이 주어진다.
   *  3번째 줄에는 N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어진다. 고유한 번호는 100000보다 작거나 같은 자연수이다.
   * ]
   * 
   * 출력 [
   *  1번째 줄에 갑옷을 만들 수 있는 개수를 출력한다.
   * ]
   */
  public static class TwoPointer2 {
    private static void twoPointer2(String[] array) {
      int N = Integer.parseInt(array[0]);
      int M = Integer.parseInt(array[1]);

      int result = 0;

      String[] NArray = array[2].split(" ");
      
      System.out.println(result);
    }
  }

  /*
   * 문제 8
   * 주어진 N개의 수에서 다른 두 수의 합으로 표현되는 수가 있다면 그 수를 '좋은 수'라고 한다.
   * N개의 수 중 좋은 수가 총 몇 개인지 출력하시오.
   * 
   * 입력 [
   *  1번째 줄에 수의 개수 N(1 <= N <= 2000), 2번째 줄에 N개의 수의 값(Ai)이 주어진다.
   * (|Ai| <= 1000000000, Ai는 정수)
   * ]
   * 
   * 출력 [
   *  좋은 수의 개수를 출력한다.
   * ]
   */
  public static class TwoPointer3 {
    private static void twoPointer3(String[] array) {

      int result = 0;

      System.out.println(result);
    }
  }

  /*
   * 문제 10 최솟값 찾기
   * N개의 수 Ａ1, Ａ2, ..., Ａn과 L이 주어진다. Ａi-L+1 ~ Ａi 중 최솟값을 Ｄi라고 할 때 Ｄ에 저장된 수를 출력하는 프로그램을 작성하시오.
   * 이때 i <= 0 인 Ａi는 무시하고 Ｄ를 구해야 한다.
   * 
   * 입력 [
   *  1번째 줄에 N과 L(1 <= L <= N <= 5000000), 2번째 줄에 N개의 수 Ａi가 주어진다. (-10^9 <= Ａi <= 10^9)
   * ]
   * 
   * 출력 [
   *  1번째 줄에 Ｄi를 공백으로 구분해 순서대로 출력한다.
   * ]
   */
  public static class SlidingWindow2 {
    private static void slidingWindow2(String[] args) {
      
    }
  }

  /*
   * 문제 12 - 오큰수 구하기
   * 크기가 N인 수열 A = A1,A2,...,An이 있다. 수열의 각 원소 Ai에 관련된 오큰수 NGE(i)를 구하려고 한다. Ai의 오큰수는
   * 오른쪽에 있으면서 Ai보다 큰 수 중 가장 왼쪽에 있는 수를 의미한다. 이렇나 수가 없을 때 오큰수는 -1이다. 예를 들어 A = [3, 5, 2, 7]일 때
   * NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다. A[9,5,4,8]일 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.
   * 
   * 입력 [
   *  1번째 줄에 수열 A의 크기 N(1 <= N <= 1000000), 2번째 줄에 수열 A의 원소 A1, A2, ..., An(1 <= Ai <= 1000000)이 주어진다.
   * ]
   * 
   * 출력 [
   *  총 N개의 수 NGE(1), NGE(2), ..., NGE(N)을 공백으로 구분해 출력한다.
   * ]
   */
  public static class Stack2 {
    private static void stack2(String[] args) {
      
    }
  }

   /*
   * 문제 14 - 절댓값 힙 구현하기
   * 절댓값 힙은 다음과 같은 연산을 지원하는 자료구조다.
   * 1. 배열에 정수 x(x ≠ 0)을 넣는다.
   * 2. 배열에서 절댓값이 가장 작은 값을 출력한 후 그 값을 배열에서 제거한다. 절댓값이 가장 작은 값이 여러개일 경우에는
   * 그중 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
   * 
   * 프로그램은 처음에 비어 있는 배열에서 시작한다. 절댓값 힙을 구현하시오.
   * 
   * 입력 [
   *  1번째 줄에 연산의 개수 N(1 <= N <= 100000)이 주어진다. 다음 N개의 줄에는 연산과 관련된 정보를 나타내는 정수 x가 주어진다.
   *  만약 x가 0이 아니라면 배열에 x라는 값을 추가하고, x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
   *  입력되는 정수는 -2^31 보다 크고, 2^31 보다 작다.
   * ]
   * 
   * 출력 [
   *  입력에서 0이 주어진 횟수만큼 답을 출력한다. 만약 배열이 비어 있는데 절댓값이 가장 작은 값을 출력하라고 할 때는 0을 출력하면 된다.
   * ]
   */
  public static class Queue2 { // TODO -> 참신하다. PriorityQueue 방식으로도 한번 풀어보자
    private static void queue2(String[] args) {
    }
  }

  public static void main(String[] args) {
   
    // RemainderHap.remainderHap(new String[]{"5 3", "1 2 3 1 2"});

    // TwoPointer.twoPointer("15");
    
    // TwoPointer2.twoPointer2(new String[]{"6", "9", "2 7 4 1 5 3"});

    // TwoPointer3.twoPointer3(new String[]{"10", "1 2 3 4 5 6 7 9 8 10"});

    // SlidingWindow2.slidingWindow2(new String[]{"12 3", "1 5 2 3 6 2 3 7 3 5 2 6"});

    // Stack2.stack2(new String[]{"4", "3 5 2 7"});
    // Stack2.stack2(new String[]{"4", "9 5 4 8"});
  }
}
