
import java.util.Arrays;

/* 15부터 시작인데, 1로 지정 */
public class Sorting {

  /*
   * 문제 1 - 수 정렬하기 1
   * N개의 수가 주어졌을 때 이를 오름차순 정렬하는 프로그램을 작성하시오.
   * 
   * 입력 [
   *  1번째 줄에 수의 개수 N(1 <= N <= 1000), 2번째 줄부터 N개의 줄에 숫자가 주어진다.
   *  이 수는 절댓값이 1000보다 작거나 같은 정수다. 수는 중복되지 않는다.
   * ]
   *
   * 출력 [
   *  1번째 줄부터 N개의 줄에 오름차순 정렬한 결과를 1줄에 1개씩 출력한다.
   * ]
   */
  public static class BubbleSorting {
    private static void bubbleSorting(String[] args) {
      int N = Integer.parseInt(args[0]);

      int[] qArray = new int[N];
      for (int i=0; i<N; i++) {
        qArray[i] =  Integer.parseInt(args[i+1]);
      }

      StringBuilder result = new StringBuilder();

      for (int i=0; i<N; i++) {
        for (int j=i+1; j<N; j++) {
          int f = qArray[i];
          int s = qArray[j];
          if (f > s) {
            qArray[i] = s;
            qArray[j] = f;
          }
        }
        result.append(qArray[i]+ "\n");
      }

      System.out.println(result.toString());
    }
  }

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
   * 위와 같은 코드를 실행시켰을 때 어떤 값이 출력되는지를 구하는 프로그램을 작성하시오.(시간복잡도 따져야 함 - 따라서 버블정렬은 사용 x)
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
      
      int N = Integer.parseInt(args[0]);
      mData[] A = new mData[N];
      for (int i=0; i<N; i++) {
        A[i] = new mData(Integer.parseInt(args[i+1]), i);
      }

      Arrays.sort(A);
      int max = 0;
      for (int i=0; i<N; i++) {
        if (max < A[i].index - i) {
          max = A[i].index-i;
        }
      }
      System.out.println(max+1);
    }
  }

  public static class mData implements Comparable<mData> {
    int value;
    int index;

    public mData(int value, int index) {
      super();
      this.value = value;
      this.index = index;
    }

    @Override
    public int compareTo(mData o) {
      return this.value - o.value;
    }
  }

  /*
   * 문제 3 - 내림차순으로 자릿수 정렬하기
   * 배열을 정렬하는 것은 쉽다. 수가 주어지면 그 수의 각 자릿수를 내림차순으로 정렬하시오.
   * 
   * 입력 [
   *  1번째 줄에 정렬할 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
   * ]
   * 
   * 출력 [
   *  1번째 줄에 자릿수를 내림차순 정렬한 수를 출력한다.
   * ]
   */
  public static class SelectSorting {
    private static void selectSoring(String N) {

      String[] Q = N.split("");
      int[] iQ = new int[Q.length];
      for (int i=0; i<Q.length; i++) {
        iQ[i] = Integer.parseInt(Q[i]);
      }

      for (int i=0; i<Q.length; i++) {
        for (int j=i+1; j<Q.length; j++) {
          int f = iQ[i];
          int s = iQ[j];
          if (f < s) {
            iQ[i] = s;
            iQ[j] = f;
          }
        }
      }
      StringBuilder sb = new StringBuilder();
      long result = 0;

      for (int i=0; i<Q.length; i++) {
        sb.append(iQ[i]);
      }

      result = Long.parseLong(sb.toString());

      System.out.println(result);
    }
  }
  
  /*
   * 문제 4 - ATM 인출 시간 계산하기
   * 인하은행에는 ATM이 1대밖에 없다. 지금 이 ATM 앞에 N명의 사람들이 줄을 서 있다. 사람은 1번에서 N번까지 번호가 매겨져 있으며, i번 사람이 돈을 인출하는 데 걸리는 시간은 Pi분이다.
   * 사람들이 줄을 서는 순서에 따라서 돈을 인출하는 데 필요한 시간의 합이 달라진다. 예를 들어 총 5명이 있고, P1=3, P2=1, P3=4, P4=3, P5=2일 때를 생각해보자.
   * [1,2,3,4,5] 순서로 줄을 선다면 1번 사람은 3분 만에 돈을 뽑을 수 있다. 2번 사람은 1번 사람이 돈을 뽑을 때까지 기달야 하므로 3+1 = 4분이 걸린다.
   * 3번 사람은 3+1+4=8분, 4번 사람은 11분, 5번사람은 13분이 걸린다. 즉, 각 사람이 돈을 인출하는 데 필요한 시간의 합은 3+4+8+11+13 = 39분이다.
   * [2,5,1,4,3] 순서로 줄을 선다면 2번은 1분, 5번은 1+2=3분, 1번은 6분, 4번은 9분, 3번은 13분이 걸리므로 각 사람이 인출하는 데 필요한 시간의 합은 1+3+6+9+13 = 32분이다.
   * 이 순서보다 모든 사람이 돈을 인출하는 데 필요한 시간이 짧을 수는 없다.
   * 줄을 서 있는 사람의 수 N과 각 사람이 돈을 인출하는 데 걸리는 시간 Pi가 주어졌을 때 각 사람이 돈을 인출하는 데 필요한 시간의 합의 최솟값을 구하는 프로그램을 작성하시오.
   * 
   * 입력 [
   *  1번째 줄에 사람의 수 N(1 <= N <= 1000), 2번째 줄에 각 사람이 돈을 인출하는 데 걸리는 시간 Pi(1 <= Pi <= 1000)가 주어진다.
   * ]
   * 
   * 출력 [
   *  1번째 줄에 각 사람이 돈을 인출하는 데 필요한 시간의 합의 최솟값을 출력한다.
   * ]
   */
  public static class InsertSorting {

    private static void change(int[] A, int i, int j) {
      int tmp = A[i];
      A[i] = A[j];
      A[j] = tmp;
    }

    private static void insertSorting(String[] args) {
      int N = Integer.parseInt(args[0]);
      
      int[] A1 = new int[N];
      for (int i=0; i < N; i++) {
        A1[i] = Integer.parseInt(args[1].split(" ")[i]);
      }

      for (int i=1; i < N; i++) {
        for (int j=i; j>0; j--) {
          if (A1[j] > A1[j-1]) {
            break;
          } else {
            change(A1, j, j-1);
          }
        }
      }

      int result = 0;
      for (int i=0; i < N; i++) {
        if (i == 0) { result += A1[i]; }
        else {
          A1[i] = A1[i] + A1[i-1];
          result += A1[i];
        }
      }
      System.out.println(result);
    }
  }

  /*
   * 문제5 - K번째 수 구하기
   * 수 N개(A1, A2, ..., An)가 주어진다. A를 오름차순 정렬했을 때 앞에서부터 K번째에 있는 수를 구하는 프로그램을 작성하시오.
   * 
   * 입력 [
   *  1번째 줄에 N(1 <= N <= 5000000)과 K(1 <= K <= N), 2번째 줄에 A1, A2, ..., An이 주어진다. (-10^9 <= Ai <= 10^9)
   * ]
   * 
   * 출력 [
   *  A를 정렬했을 때 앞에서부터 K번째에 있는 수를 출력한다.
   * ]
   */
  public static class QuickSorting {
    private static void quickSorting(String[] args) {
      
    }
  }

  /*
   * 문제6 - 수 정렬하기 2
   * N개의 수가 주어졌을 때 이를 오름차순 정렬하는 프로그램을 작성하시오.
   * 
   * 입력 [
   *  1번째 줄에 수의 개수 N(1 <= N <= 1000000), 2번째 줄부터 N개의 줄에 숫자가 주어진다. 이 수는 절댓값이 1000000보다 작거나 같은 정수다.
   *  수는 중복되지 않는다.
   * ]
   * 
   * 출력 [
   *  1번째 줄부터 N개의 줄에 오름차순 정렬한 결과를 1줄에 1개씩 출력한다.
   * ]
   */
  public static class MergeSorting {
    private static void mergeSorting(String[] args) {

    }
  }

  public static void main(String[] args) {
    
    // BubbleSorting.bubbleSorting(new String[]{"5", "5", "2", "3", "4", "1"});

    // BubbleSorting2.bubbleSorting2(new String[]{"5", "10", "1", "5", "2", "3"});

    // SelectSorting.selectSoring("2143");

    // InsertSorting.insertSorting(new String[]{"5", "3 1 4 3 2"});

    QuickSorting.quickSorting(new String[]{"5 2", "4 1 2 3 5"});

    // MergeSorting.mergeSorting(new String[]{"5", "5", "4", "3", "2", "1"});
  }
}
