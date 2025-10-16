
import java.util.ArrayList;
import java.util.Arrays;
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
      if (depth == A.length) {
        System.out.println(dfsResult);
        return;
      }

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

  /*
   * 문제 5. 미로 탐색하기
   * 4x6 크기의 배열로 표현되는 다음과 같은 미로가 있다.
   * 1 0 1 1 1 1
   * 1 0 1 0 1 0
   * 1 0 1 0 1 1
   * 1 1 1 0 1 1
   * 미로의 각 칸에 들어 있는 숫자 중 1은 이동할 수 있는 칸, 0은 이동할 수 없는 칸을 나타낸다.
   * 한 칸에서 다른 칸으로 이동할 때는 서로 인접한 칸으로 이동할 수 있다. 이동한 칸을 셀 때는 시작 위치와
   * 도착 위치를 포함한다. 즉, (1, 1)에서 (4, 6)으로 이동하려면 총 15칸을 지나가야 한다.
   * 
   * N x M 크기의 미로가 주어질 때(1, 1)에서 출발해(N, M)의 위치로 이동하기 위해 지나야 하는 칸 수의 최솟값을 구하는 프로그램을 작성하시오.
   * 
   * 입력 [
   *  1번째 줄에 두 정수 N,M(2 <= N,M <= 100), 그 다음 N개의 줄에는 미로의 내용이 M개의 정수로 주어진다.
   *  각각의 수들은 붙어서 입력된다.
   * ]
   * 
   * 출력 [
   *  1번째 줄에 지나야 하는 칸 수의 최솟값을 출력한다. 항상 도착 위치로 이동할 수 있을 때만 입력으로 주어진다.
   * ]
   */
  private static class BFS2 {
    private static void bfs2(String[] args) {
      
    }
  }

  /*
   * 문제 7. 원하는 정수 찾기
   * N개의 정수 A[1], A[2], ... , A[N]이 주어져 있을 때 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
   * 
   * 입력 [
   *  1번째 줄에 자연수 N(1 <= N <= 100000), 그다음 줄에 N개의 정수 A[1], A[2], ... , A[N]이 주어진다.
   *  그다음 줄에 M(1 <= M <= 100000), 그다음 줄에 M개의 수들이 주어지는데, 이 수들이 A 안에 존재하는지 알아내면 된다.
   *  모든 정수의 범위는 -2^31 보다 크거나 같고, 2^31보다는 작다.
   * ]
   * 
   * 출력 [
   *  M개의 줄에 답을 출력한다. 존재하면 1, 존재하지 않으면 0을 출력한다.
   * ]
   * 
   * 이 문제를 풀 때, 먼저 퀵 정렬 또는 병합 정렬 또는 기수 정렬을 사용해서 정렬을 해보자
   */
  private static class BINARYSEARCH {

    private static int[] A; 

    private static void bs(int s, int e, int g) {
      if (e - s <= 1) {
        if (A[s] == g || A[e] == g) System.out.println("1");
        else System.out.println("0");
        return;
      }
      int middleIdx = (s+e)/2;
      int m = A[middleIdx];
      if (m < g) {
        s = middleIdx+1;
        bs(s, e, g);
      } else if (m > g) {
        e = middleIdx-1;
        bs(s, e, g);
      } else {
        System.out.println("1");
        return;
      }
    }

    private static void binarySearch(String[] args) {
      int n = Integer.parseInt(args[0]); 
      A = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = Integer.parseInt(args[1].split(" ")[i]); 
      }
      Arrays.sort(A);
      int m = Integer.parseInt(args[2]);
      for (int i = 0; i < m; i++) {
        int g = Integer.parseInt(args[3].split(" ")[i]);
        bs(0, n-1, g);
      }
    }
  }

  /*
   * 문제 8. 블루레이 만들기
   * 강토는 자신의 기타 레슨 동영상을 블루레이로 만들어 판매하려고 한다. 블루레이에는 총 N개의 레슨이 들어가는데,
   * 블루레이를 녹화할 때 레슨의 순서가 바뀌면 안 된다. 순서가 뒤바뀔 때는 레슨의 흐름이 끊겨 학생들이 혼란에 빠질 수 있기 때문이다.
   * 즉, i, j번 레슨을 같은 블루레이에 녹화하려면 i와 j 사이의 모든 레슨도 같은 블루레이에 녹화해야 한다.
   * 강토는 이 블루레이가 얼마나 팔릴지 아직 알 수 없어 제작 개수를 가급적 줄이려고 한다. 강토는 고민 끝에 M개의 블루레이에 모든
   * 기타 레슨 동영상을 녹화하기로 했다. 이때 블루레이의 크기(녹화할 수 있는 길이)는 최소, M개의 블루레이는 모두 같은 크기로 만드려고 한다.
   * 강토의 각 레슨의 길이가 분 단위(자연수)로 주어질 때 가능한 블루레이의 크기 중 최솟값을 구하는 프로그램을 작성하시오.
   * 
   * 입력 [
   *  1번째 줄에 레슨의 수 N(1 <= N <= 100000)과 M(1 <= M <= N), 2번째 줄에 강토의 기타 레슨의 길이가 레슨 순서대로
   *  분 단위로(자연수)로 주어진다. 각 레슨의 길이는 10000분을 넘지 않는다.
   * ]
   * 
   * 출력 [
   *  1번째 줄에 블루레이 크기 중 최솟값을 출력한다.
   * ]
   */
  private static class BINARYSEARCH2 {
    private static void binarySearch2(String[] args) {

    }
  }

  /*
   * 문제 9. 배열에서 K번째 수 찾기
   * 세준이는 크기가 N x N인 배열 A를 만들었다. 배열에 들어 있는 수는 A[i][j] = i x j 이다. 이 수를 1차원 배열 B에 넣으면
   * B의 크기는 N x N이 된다. B를 오름차순 정렬했을 때 B[k]를 구하라(배열 A와 B의 인덱스는 1부터 시작한다.)
   * 
   * 입력 [
   *  1번째 줄에 배열의 크기 N이 주어진다. N은 10^5보다 작거나 같은 자연수다. 2번째 줄에 k가 주어진다.
   *  k는 min(10^9, N²)보다 작거나 같은 자연수다.
   * ]
   * 
   * 출력 [
   *  B[k]를 출력한다.
   * ]
   */
  private static class BINARYSEARCH3 {
    private static void binarySearch3(String[] args) {
      // x, y
      // 7 / 3 = 2
      // 7 % 3 = 1
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
      // BFS.bfs(new String[]{"4 5 1", "1 2", "1 3", "1 4", "2 4", "3 4"});
      // BFS.bfs(new String[]{"5 5 3", "5 4", "5 2", "1 2", "3 4", "3 1"});
      // BFS2.bfs2(new String[]{"4 6", "101111", "101010", "101011", "111011"});
      // BFS2.bfs2(new String[]{"4 6", "110110", "110110", "111111", "111101"});
      // BFS2.bfs2(new String[]{"2 25", "1011101110111011101110111", "1110111011101110111011101"});
      // BFS2.bfs2(new String[]{"7 7", "1011111", "1110001", "1000001", "1000001", "1000001", "1000001", "1111111"});
    // BINARYSEARCH.binarySearch(new String[]{"5", "4 1 5 2 3", "5", "1 3 7 9 5"});
    // BINARYSEARCH2.binarySearch2(new String[]{"9 3", "1 2 3 4 5 6 7 8 9"});
    BINARYSEARCH3.binarySearch3(new String[]{"3", "7"});
  }
}
