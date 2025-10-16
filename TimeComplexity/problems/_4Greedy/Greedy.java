
import java.util.PriorityQueue;

public class Greedy {

  /*
   * 문제 1. 동전 개수의 최솟값 구하기
   * 준규가 소유하고 있는 동전은 총 N종류이고, 각 동전의 개수가 많다. 동전을 적절히 사용해 그 가격의 합을 K로 만들려고 한다.
   * 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
   * 
   * 입력 [
   *  1번째 줄에 N과 K(1 <= N <= 10, 1 <= K <= 100000000), 2번째 줄부터 N개의 줄에 동전의 가격 Ai가 오름차순으로 주어진다.
   *  (1 <= Ai <= 1000000, A1 = 1, i >= 2 일 때 Ai는 Ai-1의 배수)
   * ]
   * 
   * 출력 [
   *  1번째 줄에 K원을 만드는 데 필요한 동전 개수의 최솟값을 출력한다.
   * ]
   */
  private static class Greedy1 {
    private static void greedy1(String[] args) {

    }
  }

  /*
   * 문제 2. 카드 정렬하기
   * 정렬된 두 묶음의 숫자 카드가 있다. 각 묶음의 카드의 개수가 A, B일 때 보통 두 묶음을 합쳐 1개로 만들려면 A + B번 비교해야 한다.
   * 예를 들어 20장의 숫자 카드 묶음과 30장의 숫자 카드 묶음을 합치려면 50번의 비교가 필요하다.
   * 
   * 매우 많은 숫자 카드 묶음이 책상 위에 놓여 있다고 가정해 보자. 이들을 두 묶음씩 골라 서로 합쳐 나가면 고르는 순서에 따라 비교 횟수가 달라진다.
   * 예를 들어 10장, 20장, 40장의 묶음이 있다면 10장과 20장을 합친 후 30장 묶믕과 40장 묶음을 합치면 (10 + 20) + (30 + 40) = 100번의
   * 비교가 필요하므로 덜 효율적이다.
   * 
   * N개의 숫자 카드 묶음의 각각의 크기가 주어질 때 최소한 몇 번의 비교가 필요한지를 구하는 프로그램을 작성하시오.
   * 
   * 입력 [
   *  1번째 줄에 N이 주어진다. (1 <= N <= 100000). 그 다음 N개의 줄에 걸쳐 숫자 카드 묶음의 각각의 크기가 주어진다.
   *  숫자 카드 묶음의 크기는 1000보다 작거나 같은 양의 정수다.
   * ]
   * 
   * 출력 [
   *  1번째 줄에 최소 비교 횟수를 출력한다.
   * ]
   */
  private static class Greedy2 {

    private static void greedy2(String[] args) {

    }
  }

  /*
   * 문제 3. 수를 묶어서 최댓값 만들기
   * 길이가 N인 수열이 주어질 때 수열의 합을 구하려고 한다. 그런데 수열의 합을 구하기 전에 먼저 수열 안에 있는
   * 임의의 두 수를 묶으려 한다. 위치에 상관없이 두 수를 묶을 수 있다. 단, 같은 위치에 있는 수(자기 자신)를 묶을 수는 없다.
   * 묶인 두 수는 수열의 합을 구할 때 서로 곱한 후 계산한다. 수열의 모든 수는 각각 한 번씩만 묶을 수 있다. 예를 들어 어떤 수열이
   * {0, 1, 2, 4, 3, 5}일 때 그냥 이 수열의 합을 구하면 0 + 1 + 2 + 4 + 5 = 15이다. 하지만 2와 3을 묶고, 4와 5를 묶으면 
   * 0 + 1 + (2 * 3) + (4 * 5) = 27이 돼 최댓값이 나온다.
   * 주어진 수열의 각 수를 적절히 묶어 그 합을 최대로 만드는 프로그램을 작성하시오.
   * 
   * 입력 [
   *  1번째 줄에 수열의 크기 N이 주어진다. N은 10000보다 작은 자연수다. 2번째 줄부터 N개의 줄에 수열의 각 수가 주어진다.
   *  수열의 수는 -10000보다 크거나 같고, 10000보다 작거나 같은 정수다.
   * ]
   * 
   * 출력 [
   *  합이 최대가 나오게 수를 묶었을 때 그 합을 출력한다. 정답은 항상 2^31보다 작다.
   * ]
   */
  private static class Greedy3 {

    private static void greedy3(String[] args) {
      int n = Integer.parseInt(args[0]);
      PriorityQueue<Integer> minusQs = new PriorityQueue<>();
      PriorityQueue<Integer> plusQs = new PriorityQueue<>();
      boolean isExistZero = false; 
      for (int i=0; i<n; i++) {
        int v = Integer.parseInt(args[i+1]);
        if (v < 0) {
          minusQs.add(v);
        } else if (v > 0) {
          plusQs.add(-v);
        } else {
          isExistZero = true;
        }
      }

      int result = 0;
      while(minusQs.size() > 1) {
        int v1 = minusQs.remove();
        int v2 = minusQs.remove();
        result += v1 * v2;
      }

      while(plusQs.size() > 1) {
        int v1 = -plusQs.remove();
        int v2 = -plusQs.remove();
        if (v1 == 1) {
          result += 2;
        } else if (v2 == 1) {
          result += v1 + 1;
        } else {
          result += v1 * v2;
        }
      }
      if (!minusQs.isEmpty()) {
        if (!isExistZero) {
          result += minusQs.remove();
        }
      }
      if (!plusQs.isEmpty()) result += -plusQs.remove();

      System.out.println(result);
    }
  }

  /*
   * 문제 4. 회의실 배정하기
   * 1개의 회의실에서 N개의 회의를 진행하기 위해 회의실 사용표를 만들려고 한다. 각 회의마다 시작 시간과 끝나는 시간이 주어질 때
   * 회의 시간이 겹치지 않으면서 회의를 가장 많이 진행하려면 최대 몇 번까지 할 수 있는지 알아보자. 단, 회의를 시작하면 중간에 중단할 수 없고,
   * 한 회의를 끝내는 것과 동시에 다음 회의를 시작할 수 있다. 회의의 시작 시간과 끝나는 시간이 같을 수도 있는데, 이때는 시작하자마자 끝나는
   * 것으로 생각하면 된다.
   * 
   * 입력 [
   *  1번째 줄에 회의의 수 N(1 <= N <= 100000), 2번째 줄부터 N + 1줄까지는 각 회의의 시작 시간과 끝나는 시간이 공백을 사이에 두고
   *  주어진다. 시작 시간과 끝나는 시간은 2^31 -1 보다 작거나 같은 자연수 또는 0이다.
   * ]
   * 
   * 출력 [
   *  1번째 줄에 진행할 수 있는 회의의 최대 개수를 출력한다.
   * ]
   */
  private static class Greedy4 {

    private static void greedy4(String[] args) {
      
    }
  }

  /*
   * 문제 5. 최솟값을 만드는 괄호 배치 찾기
   * 세준이는 양수와 +, - 그리고 괄호를 이용해 어떤 수식을 만들었다. 그리고 괄호를 모두 지우고, 다시 괄호를 적절히 넣어
   * 이 수식의 값을 최소로 만들려고 한다. 이렇게 수식의 괄호를 다시 적절하게 배치해 수식의 값을 최소로 만드는 프로그램을 작성하시오.
   * 
   * 입력 [
   *  1번째 줄에 식이 주어진다. 식은 '0'~'9', '+' 그리고 '-'만으로 이뤄져 있고, 가장 처음과 마지막 문자는 숫자다.
   *  그리고 연속해서 2개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다.
   *  입력으로 주어지는 식의 길이는 50보다 작거나 같다.
   * ]
   * 
   * 출력 [
   *  1번째 줄에 정답을 입력한다.
   * ]
   */
  private static class Greedy5 {

    private static void greedy5(String[] args) {
      String arg = args[0];
      String[] jiphap = arg.split("-");
      int result = 0;

      String val = jiphap[0];
      if (val.contains("+")) {
        String[] vals = val.split("\\+");
        for (int i=0; i<vals.length; i++) {
          result += Integer.parseInt(vals[i]);
        }
      } else {
        result += Integer.parseInt(val);
      }
      if (arg.startsWith("-")) {
        result *= -1;
        System.out.println("작동중??");
      }
      for (int i=1; i<jiphap.length; i++) {
        val = jiphap[i];
        if (val.contains("+")) {
          String[] vals = val.split("\\+");
          for (int j=0; j<vals.length; j++) {
            result += -Integer.parseInt(vals[j]);
          }
        }
      }
      
      System.out.println(result);

    }
  }
  

  public static void main(String[] args) {
    // Greedy1.greedy1(new String[]{"10 4200", "1", "5", "10", "50", "100", "500", "1000", "5000", "10000", "50000"});
    // Greedy1.greedy1(new String[]{"10 4790", "1", "5", "10", "50", "100", "500", "1000", "5000", "10000", "50000"});
    // Greedy2.greedy2(new String[]{"3", "10", "20", "40"});
    // Greedy3.greedy3(new String[]{"9", "-1", "-8", "2", "1", "3", "6", "-5", "0", "1"});
    // Greedy4.greedy4(new String[]{"11", "1 4", "3 5", "0 6", "5 7", "3 8", "5 9", "6 10", "8 11", "8 12", "2 13", "12 14"});
    Greedy5.greedy5(new String[]{"-100-40+50+74-30+29-45+43+11"});
  }
}
