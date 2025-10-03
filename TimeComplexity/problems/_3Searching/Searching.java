
import java.util.ArrayList;
import java.util.List;

public class Searching {

  /*
   * 문제 1. 연결 요소의 개수 구하기
   * 방향 없는 그래프가 주어졌을 때 연결 요소(Connected component)의 개수를 구하는 프로그램을 작성하시오.
   * 
   * 입력 [
   *  1번째 줄에 노드의 개수 N(1 <= N <= 1000)과 에지의 개수 M(0 <= M <= N(N-1)/2),
   *  2번째 줄부터 M개의 줄에 에지의 양끝 점 u와 v가 주어진다.
   *  (1 <= u, v <= N, u ≠ v). 같은 에지는 한 번만 주어진다.
   * ]
   * 
   * 출력 [
   *  1번째 줄에 연결 요소의 개수를 출력한다.
   * ]
   */
  private static class DFS {
    private static void dfs(String[] args) {

    }
  }

  /*
   * 문제 2. 신기한 소수 찾기
   * 수빈이가 세상에서 가장 좋아하는 것은 소수이고, 취미는 소수를 이용해 노는 것이다.
   * 요즘 수빈이가 가장 관심 있어 하는 소수는 7331이다. 7331은 신기하게도 733도 소수,
   * 73도 소수, 7도 소수다. 즉, 왼쪽부터 1자리, 2자리, 3자리, 4자릿수 모두 소수다.
   * 수빈이는 이런 숫자를 신기한 소수라고 이름 붙였다. 수빈이는 N의 자리의 숫자 중
   * 어떤 수들이 신기한 소수인지 궁금해졌다. 숫자 N이 주어졌을 때 N의 자리 숫자 중
   * 신기한 소수를 모두 찾아보자.
   * 
   * 입력 [
   *  1번째 줄에 N(1 <= N <= 8)이 주어진다.
   * ]
   * 
   * 출력 [
   *  N의 자리 숫자 중 신기한 소수를 오름차순 정렬해 1줄에 1개씩 출력한다.
   * ]
   */
  private static class DFS2 {

    private static int len;
    private static int n;
    private static boolean[] notDecimal;

    private static void dfs(int k) {
      for (int i=2*k; i <= n; i+=k ) {
        notDecimal[i] = true;
      }
    }

    private static void dfs2(int args) {
      len = args;
      n = (int)Math.pow(10, args);
      notDecimal = new boolean[n+1];
      for (int i=0; i<= n; i++) {
        if (i == 0 || i == 1) {
          notDecimal[i] = true;
          continue;
        }
        if (notDecimal[i]) continue;
        dfs(i);
      }

      for (int i=0; i<=n; i++) {
        if (notDecimal[i]) continue;
        if (String.valueOf(i).length() != len) continue;
        String[] splitedVal = String.valueOf(i).split("");
        StringBuilder gettedVal = new StringBuilder();
        for (String val : splitedVal) {
          gettedVal.append(val);
          if (notDecimal[Integer.parseInt(gettedVal.toString())]) break;
          if (gettedVal.length() == len) {
            System.out.println(gettedVal.toString());
          }
        }
      }
    }
  }

  /*
   * 문제 3. 친구 관계 파악하기
   * BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고,
   * 일부 사람들은 친구다. 오늘은 다음과 같은 친구 관계를 가진 사람 A,B,C,D,E가 존재하는지 구해보려고 한다.
   * - A는 B와 친구다.
   * - B는 C와 친구다.
   * - C는 D와 친구다.
   * - D는 E와 친구다.
   * 위와 같은 친구 관계가 존재하는지 여부를 구하는 프로그램을 작성하시오.
   * 
   * 입력 [
   *  1번째 줄에 사람의 수 N(5 <= N <= 2000)과 친구 관계의 수 M(1 <= M <= 2000),
   *  2번째 줄부터 M개의 줄에 정수 a와 b가 주어진다. a와 b는 친구라는 뜻이다.(0 <= a, b <= N-1, a ≠ b).
   *  같은 친구 관계가 2번 이상 주어지지는 않는다.
   * ]
   * 
   * 출력 [
   *  문제의 조건에 맞는 A, B, C, D, E가 존재할 때 1이 없으면 0을 출력한다.
   * ]
   */
  private static class DFS3 {

    private static boolean[] visited;
    private static List<Integer>[] A;
    private static boolean isResult = false;

    private static void dfs(int s, int depth) {
      if (depth == 5) {
        isResult = true;
        return;
      }
      List<Integer> l = A[s];
      for (int i=0; i < A[s].size(); i++) {
        if (isResult) break;
        int e = l.get(i);
        if (visited[e]) continue;
        visited[e] = true;
        dfs(e, depth+1);
      }
    }

    private static void dfs3(String[] args) {
      isResult = false;
      int n = Integer.parseInt(args[0].split(" ")[0]);
      int m = Integer.parseInt(args[0].split(" ")[1]);
      visited = new boolean[n];
      A = new ArrayList[n];
      for (int i=0; i< n; i++) {
        A[i] = new ArrayList<Integer>();
      }
      for (int i=0; i<m; i++) {
        int s = Integer.parseInt(args[i+1].split(" ")[0]);
        int e = Integer.parseInt(args[i+1].split(" ")[1]);
        A[s].add(e);
        A[e].add(s);
      }

      dfs(1, 1);
      if (isResult) System.out.println("1");
      else System.out.println("0");
    }
  }

  /*
   * 문제 4. DFS와 BFS 프로그램
   * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 노드가
   * 여러 개일 경우에는 노드 번호가 작은 것을 먼저 방문하고 더 이상 방문할 수 있는 노드가 없을 때 종료한다.
   * 노드 번호는 1에서 N까지다.
   * 
   * 입력 [
   *  1번째 줄에 노드의 개수 N(1 <= N <= 1000), 에지의 개수 M(1 <= M <= 10000), 탐색을 시작할 노드의 번호 V가 주어진다.
   *  그 다음 M개의 줄에는 에지가 연결하는 두 노드의 번호가 주어진다. 어떤 두 노드 사이에 여러 개의 에지가 있을 수 있다.
   *  입력으로 주어지는 에지는 양방향이다.
   * ]
   * 
   * 출력 [
   *  1번째 줄에 DFS를 수행한 결과, 그다음 줄에 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
   * ]
   */
  private static class BFS {

    private static List[] A;
    private static boolean[] visited;
    private static StringBuilder dfsResult;
    private static StringBuilder bfsResult;

    private static void dfs(int f, int depth) {
      if (depth == A.length) System.out.println(dfsResult);
    }

    private static void bfs(int f, int breadth) {

    }

    private static void bfs(String[] args) {
      dfsResult = new StringBuilder();
      bfsResult = new StringBuilder();
      int n = Integer.parseInt(args[0].split(" ")[0]);
      int e = Integer.parseInt(args[0].split(" ")[1]);
      int s = Integer.parseInt(args[0].split(" ")[2]);

      A = new ArrayList[n];
      visited = new boolean[n];
      for (int i=0; i<n; i++) {
        A[i] = new ArrayList<Integer>();
      }
      for (int i=0; i<e; i++) {
        int f = Integer.parseInt(args[i+1].split(" ")[0]);
        int l = Integer.parseInt(args[i+1].split(" ")[1]);

        A[f].add(l);
        A[l].add(f);
      }

    }
  }

  public static void main(String[] args) {
      // DFS.dfs(new String[]{"6 5", "1 2", "2 5", "5 1", "3 4", "4 6"});
      // DFS.dfs(new String[]{"6 8", "1 2", "2 5", "5 1", "3 4", "4 6", "5 4", "2 4", "2 3"});
      // DFS2.dfs2(4);
      // DFS3.dfs3(new String[]{"8 8", "1 7", "3 7", "4 7", "3 4", "4 6", "3 5", "0 4", "2 7"});
      // DFS3.dfs3(new String[]{"5 5", "0 1", "1 2", "2 3", "3 0", "1 4"});
      // DFS3.dfs3(new String[]{"6 5", "0 1", "0 2", "0 3", "0 4", "0 5"});
      // DFS3.dfs3(new String[]{"5 4", "0 1", "1 2", "2 3", "3 4"});
      BFS.bfs(new String[]{"4 5 1", "1 2", "1 3", "1 4", "2 4", "3 4"});
      BFS.bfs(new String[]{"5 5 3", "5 4", "5 2", "1 2", "3 4", "3 1"});
  }
}
