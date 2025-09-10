
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class DataStructure {
  
  /*
   * 1번 문제
   * N개의 숫자가 공백없이 써 있다. 이 숫자를 모두 합해 출력하는 프로그램을 작성하시오.
   * 
   * 입력 [
   *  1번째 줄에 숫자의 개수 N(1 <= N <= 100), 2번째 줄에 숫자 N개가 공백 없이 주어진다.
   * ]
   * 
   * 출력 [
   *  입력으로 주어진 숫자 N개의 합을 구한다.
   * ]
   */
  public static class AddNubmer {
    private static void addNumber(String[] array) {

      String size = array[0];
      String list = array[1];

      String[] list2 = list.split("");


      int result = 0;
      for (String val : list2) {
        int tmpVal = Integer.parseInt(val);

        result += tmpVal;
      }

      System.out.println(result);
    }
  }

  /**
   * 2번 문제
   * 세준이는 기말고사를 망쳤다. 그래서 점수를 조작해 집에 가져가기로 결심했다.
   * 일단 세준이는 자기 점수 중 최댓값을 골랐다. 그런 다음 최댓값을 M이라 할 때 모든 점수를 점수/M * 100으로 고쳤다. 예를 들어
   * 세준이의 최고점이 70점, 수학 점수가 50점이라면 수학 점수는 50/70 * 100 이므로 71.43점이다. 세준이의 성적을 이 방법으로
   * 계산했을 때 새로운 평균을 구하는 프로그램을 작성하시오.
   * 
   * 입력 [
   *  1번째 줄에 시험을 본 과목의 개수 N이 주어진다. 해당 값은 1000보다 작거나 같다. 2번째 줄에 세준이의 현재 성적이 주어진다.(스페이스로 분리되어있음)
   *  해당 값은 100보다 작거나 같은, 음이 아닌 정수이고, 적어도 1개의 값은 0보다 크다.
   * ]
   * 
   * 츨력 [
   *  1번째 줄에 새로운 평균을 출력한다. 실제 정답과 출력값의 절대 오차 또는 상대 오차가 10-²이하이면 정답이다.
   * ]
   */
  public static class CalcMean {
    private static void calcMean(String[] array) {

      // 먼저 최댓값을 구하기
      String testCnt = array[0];

      String list = array[1];

      String[] arrays = list.split(" ");

      int max = 0;
      double res = 0;

      for (String val : arrays) {
        int tmpVal = Integer.parseInt(val);
        if (max <= tmpVal) max = tmpVal;

        res += tmpVal;
      }

      int cnt = Integer.parseInt(testCnt);
      res = ((res / max) * 100) / cnt;

      System.out.println(res);
    }
  }

  /*
   * 문제 3
   * 수 N개가 주어졌을 때 i번째 수에서 j번째 수까지의 합을 구하는 프로그램을 작성하시오.
   * 
   * 입력 [
   *  1번째 줄에 수의 개수 N(1 <= N <= 100000), 합을 구해야 하는 횟수 M(1 <= M <= 100000),
   *  2번째 줄에 N개의 수가 주어진다. 각 수는 1000보다 작거나 같은 자연수다.
   *  3번째 줄부터는 M개의 줄에 합을 구해야 하는 구간 i와 j가 주어진다.
   * ]
   * 
   * 출력 [
   *  총 M개의 줄에 입력으로 주어진 i 번째 수에서 j 번째 수까지의 합을 출력한다.
   * ]
   */
  public static class RangeHap {
    private static void rangeHap(String[] array) {
      String NM = array[0];
      String[] NMArray = NM.split(" ");
      int N = Integer.parseInt(NMArray[0]);
      int M = Integer.parseInt(NMArray[1]);

      String numbers = array[1];
      String[] numbersArray = numbers.split(" ");

      int[] hapArray = new int[N];

      for (int i=0; i< N; i++) {
        int num = Integer.parseInt(numbersArray[i]);
        if (i == 0) {
          hapArray[i] = num;
          continue;
        }
        hapArray[i] = hapArray[i-1] + num;
      }

      for (int j=0; j< M; j++) {
        String rangeHap = array[2 + j]; // 2부터 시작
        String[] rangeHapArray = rangeHap.split(" ");
        int start = Integer.parseInt(rangeHapArray[0]) - 1; // 0
        int end = Integer.parseInt(rangeHapArray[1]) - 1; // 2

        if (start == 0 || end == N-1) {
          if (start == 0 && end == N-1) {
            System.out.println(hapArray[N-1]);
          } else if (start == 0) {
            System.out.println(hapArray[end]);
          } else if (end == N-1) {
            System.out.println(hapArray[N-1] - hapArray[start-1]);
          }
        } else {
          System.out.println(hapArray[end] - hapArray[start-1]);
        }
      }
    }
  }

  /*
   * 문제 4
   * N x N개의 수가 N x N 크기의 표에 채워져 있다. 표 안의 수 중 (X1, Y1)에서 (X2, Y2)까지의 합을 구하려 한다.
   * X는 행, Y는 열을 의미한다. 예를 들어 N = 4이고, 표가 다음과 같이 채워져 있을 때를 살펴보자.
   * 1 2 3 4
   * 2 3 4 5
   * 3 4 5 6
   * 4 5 6 7
   * (2,2) 에서 (3,4)까지의 합을 구하면 3 + 4 + 5 + 4 + 5 + 6 = 27이고,
   * (4,4) 에서 (4,4)까지의 합을 구하면 7이다.
   * 표에 채워져 있는 수와 합을 구하는 연산이 주어졌을 때 이를 처리하는 프로그램을 작성하시오.
   * 
   * 입력 [
   *  1번째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다.(1 <= N <= 1024, 1 <= M <= 100000)
   *  2번째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다. 다음 M개의 줄에는 4개의 정수 X1, Y1, X2, Y2가 주어지며,
   *  (X1, Y1)에서 (X2, Y2)의 합을 구해 출력해야 한다. 표에 채워져 있는 수는 1000보다 작거나 같은 자연수다(X1 <= X2, Y1 <= Y2)
   * ]
   * 
   * 출력 [
   *  총 M줄에 걸쳐 (X1, Y1)에서 (X2, Y2)까지 합을 구해 출력한다.
   * ]
   */
  public static class RangeHap2 {
    private static void rangeHap2(String[] array) {
      // N : 행, 열의 수
      // M : 문제의 개수
      String[] NMArray = array[0].split(" ");

      int N = Integer.parseInt(NMArray[0]);
      int M = Integer.parseInt(NMArray[1]);

      int[][] hapArray2Dimension = new int[N][N];

      for (int i=0; i < N; i++) {
        String NthList = array[1+i];
        String[] NthArray = NthList.split(" ");
        for (int j=0; j < N; j++) {
          if (j==0) {
            hapArray2Dimension[i][j] = Integer.parseInt(NthArray[j]);
            continue;
          }
          hapArray2Dimension[i][j] = hapArray2Dimension[i][j-1] + Integer.parseInt(NthArray[j]);
        }
      }

      for (int j=0; j < M; j++) {
        int result = 0;
        String problem = array[1+N+j];
        int x1 = Integer.parseInt(problem.split(" ")[0])-1; // 1
        int y1 = Integer.parseInt(problem.split(" ")[1])-1; // 1
        int x2 = Integer.parseInt(problem.split(" ")[2])-1; // 2
        int y2 = Integer.parseInt(problem.split(" ")[3])-1; // 3

        for (int k=y1;  k <= y2; k++) {
          if (x1 == 0 || x2 == N-1) {
            if (x1 == 0 && x2 == N-1) {
              result += hapArray2Dimension[k][N-1];
            } else if (x1 == 0) {
              result += hapArray2Dimension[k][x2];
            } else if (x2 == N-1) {
              result += hapArray2Dimension[k][N-1] - hapArray2Dimension[k][x1-1];
            }
          } else {
            result += hapArray2Dimension[k][x2] - hapArray2Dimension[k][x1-1];
          }
        }

        System.out.println(result);
      }
    }
  }

  // TODO 5번 문제 다시 풀기
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

    private static int probability(int n) {
      return (n*(n-1)) / 2;
    }

    private static void remainderHap(String[] array) {
      String[] NMArray = array[0].split(" ");
      int N = Integer.parseInt(NMArray[0]);
      int M = Integer.parseInt(NMArray[1]);

      String[] strNumbers = array[1].split(" ");

      int result = 0;

      // 합배열 생성
      int[] hapNumbers = new int[N];
      for (int i=0; i<N; i++) {
        if (i == 0) {
          hapNumbers[i] = Integer.parseInt(strNumbers[i]) % M;

          if (hapNumbers[i] % M == 0) result += 1;
          continue;
        }
        hapNumbers[i] = (hapNumbers[i-1] + (Integer.parseInt(strNumbers[i]) % M)) % M;

        if (hapNumbers[i] % M == 0) result += 1;
      }
      
      Map<Integer,Integer> hapMap = new HashMap<>();
      for (int i=0; i<N; i++) {
        hapMap.put(hapNumbers[i], hapMap.getOrDefault(hapNumbers[i], 0)+1) ;
      }

      for (int key : hapMap.keySet()) {
        result += probability(hapMap.get(key));
      }

      System.out.println(result);
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
      int n = Integer.parseInt(N);

      int[] sumArray = new int[n];
      for (int i=0; i<n; i++) {
        if (i == 0) {
          sumArray[i] = i;
          continue;
        }
        sumArray[i] = sumArray[i-1] + i;
      }
      
      int start= 0;
      int end= 0;

      int sum;
      int result = 1;

      while(end != n) {
        if (start == 0) {
          sum = sumArray[end];
        } else {
          sum = sumArray[end] - sumArray[start-1];
        }
        
        if (sum < n) {
          end += 1;
        } else if (sum == n) {
          end += 1;
          result += 1;
        } else {
          start += 1;
        }
      }

      System.out.println(result);
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
      for (int i=0; i<N; i++) {
        for (int j=i+1; j<N; j++) {
          if (M == Integer.parseInt(NArray[i]) + Integer.parseInt(NArray[j])) {
            result += 1;
          } 
        }
      }

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

      int N = Integer.parseInt(array[0]);
      String[] NArray = array[1].split(" ");

      if (N <= 2) {
        System.out.println(result);
        return;
      }
      int s_idx = 0;
      int e_idx = 1;
      int goal_idx = 2;
      
      int[] iNArray = new int[N];
      for (int i=0; i<N; i++) {
        iNArray[i] = Integer.parseInt(NArray[i]);
      }

      Arrays.sort(iNArray);

      while(goal_idx <= N-1) {
        int s = iNArray[s_idx];
        int e = iNArray[e_idx];
        int g = iNArray[goal_idx];

        if (s_idx == e_idx) {
          e_idx += 1;
        }

        if (s + e == g) {
          result += 1;
        } else if (s + e < g) {
          if (e_idx - s_idx != 1) {
            s_idx += 1;
            continue;
          } else if (goal_idx - e_idx != 1) {
            e_idx += 1;
            continue;
          }
          e_idx += 1;
        }
        goal_idx += 1;
      }

      System.out.println(result);
    }
  }

  public static void main(String[] args) {
    
    // AddNubmer.addNumber(new String[]{"5", "12345"});

    // CalcMean.calcMean(new String[]{"3", "40 80 60"});

    // RangeHap.rangeHap(new String[]{"5 3", "5 4 3 2 1", "1 3", "2 4", "5 5"});

    // RangeHap2.rangeHap2(new String[]{"4 3", "1 2 3 4", "2 3 4 5", "3 4 5 6", "4 5 6 7", "2 2 3 4", "3 4 3 4", "1 1 4 4"});

    // RemainderHap.remainderHap(new String[]{"5 3", "1 2 3 1 2"});

    // TwoPointer.twoPointer("15");
    
    // TwoPointer2.twoPointer2(new String[]{"6", "9", "2 7 4 1 5 3"});

    TwoPointer3.twoPointer3(new String[]{"10", "1 2 3 4 5 6 7 9 8 10"});
  }
}


