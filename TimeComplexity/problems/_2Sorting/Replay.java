
public class Replay {

   /*
   * 문제 2 - 버블 소트 프로그램 1
   * 영식이는 다음과 같은 버블 소트 프로그램을 C++로 작성했다.
   * ```
   * bool change = false;
   * for (int i = 1; i <= n + 1; i++)
   * {
   *  change = false;
   *  for (int j = 1; j <= n - i; j++)
   *  {
   *    if(a[j] > a[j+1]) {
   *      change = true;
   *      swap(a[j], a[j+1]);
   *    }
   *  }
   *  if (change == false) {
   *    cout << i << '\n';
   *    break;
   *  }
   * }
   * ```
   * 위 코드에서 n은 배열의 크기, a는 수가 들어있는 배열이다. 수는 배열의 1번 방부터 채운다.
   * 위와 같은 코드를 실행시켰을 때 어떤 값이 출력되는지를 구하는 프로그램을 작성하시오.(시간복잡도 따져야 함)
   * 
   * 입력 [
   *  1번째 줄에 N이 주어진다. N은 500000보다 작거나 같은 자연수다. 2번째 줄부터 N개의 줄에 A[1]부터 A[N]까지
   *  1개씩 주어진다. A에 들어 있는 수는 1000000보다 작거나 같은 자연수 또는 0이다.
   * ]
   * 
   * 출력 [
   *  정답을 출력한다.
   * ]
   */
  public static class BubbleSorting2 {
    private static void bubbleSorting2(String[] args) {
      
    }
  }

  public static void main(String[] args) {
    
    BubbleSorting2.bubbleSorting2(new String[]{"5", "10", "1", "5", "2", "3"});
  }
}
