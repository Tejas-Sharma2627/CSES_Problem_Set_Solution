        /*
            Somewhere, something incredible is waiting to be known

            Don’t worry about failure; you only have to be right once.

            Don’t worry about WA; you only have to be ACCEPTED once ><
                                                                     
        */
        /*
            Collections.binarySearch(items, item_name): Returns the index of item_name
            
        */
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
public class Increasing_Array{
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader s = new FastReader();
    final static int MOD = 1000000007;
    public static long[] readArray(int n){
        long[] ret = new long[n];
        for(int i = 0;i<n;i++){
            ret[i]=s.nextLong();
        }
        return ret;
    }
    public static int[] readIntArray(int n){
        int[] ret = new int[n];
        for(int i = 0;i<n;i++){
            ret[i]=s.nextInt();
        }
        return ret;
    }
    public static int[][] readMatrix(int row, int col, Scanner s){
        int[][] ans = new int[row][col];
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                ans[i][j]=s.nextInt();
            }
        }
        return ans;
    }
    public static int digitsCount(int N)
    {
        return (int)Math.floor(Math.log10(N)) + 1;
    }
     public static void sort(int[] arr)
    {
        //because Arrays.sort() uses quicksort which is dumb
        //Collections.sort() uses merge sort
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for(int x: arr)
            ls.add(x);
        Collections.sort(ls);
        for(int i=0; i < arr.length; i++)
            arr[i] = ls.get(i);
    }
    public static void longSort(long[] arr)
    {
        //because Arrays.sort() uses quicksort which is dumb
        //Collections.sort() uses merge sort
        ArrayList<Long> ls = new ArrayList<>();
        for(long x: arr)
            ls.add(x);
        Collections.sort(ls);
        for(int i=0; i < arr.length; i++)
            arr[i] = ls.get(i);
    }
    public static long power(long x, long y, long p)
    {
        //0^0 = 1
        long res = 1L;
        x = x%p;
        while(y > 0)
        {
            if((y&1)==1)
                res = (res*x)%p;
            y >>= 1;
            x = (x*x)%p;
        }
        return res;
    }
    public static boolean isPrime(long n)
    {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }
    public static List<Long> primeFactors(long n){
        //O(root N) Time Learnt from CP handbook
        //n = a*b where a<=root n or b<=root n
        List<Long> ans = new ArrayList<>();
        for(long i = 2;i*i<=n;i++){
            while(n%i==0){
                ans.add(i);
                n/=i;
            }
        }
        if(n>1)ans.add(n);
        return ans;
    }
    public static long gcd(long a, long b)
    {
        if(a > b)
            a = (a+b)-(b=a);
        if(a == 0L)
            return b;
        return gcd(b%a, a);
    }
    public static void solve(){
        int n = s.nextInt();
        long[] a = readArray(n); 
        long ans = 0;
        for(int i = 1;i<n;i++){
            long diff = a[i-1]-a[i];
            if(diff>0){
                a[i] = a[i-1];
                ans+=diff;
            }
        }
        out.println(ans);
    }
    public static void main(String[] args) {
        int t = 1;
        //t = s.nextInt();
        while(t-->0){
            solve();
        }
        out.close();
    }
}
class DSU{
    int[] array;
    int[] rank;
    public DSU(int n){
        array = new int[n+1];
        for(int i = 0;i<=n;i++){
            array[i] = i;
        }
        rank = new int[n];
        Arrays.fill(rank, 1);
    }
    public int find(int a){
        if(array[a]==a)return a;
        return array[a]=find(array[a]);
    }
    public void union(int a, int b){
        int s1 = find(a);
        int s2 = find(b);
        if(s1!=s2){
            array[s2] = s1;
        }
    }
    public void unionByRank(int a, int b){
        int s1 = find(a);
        int s2 = find(b);
        if(s1!=s2){
            if(rank[s1]<rank[s2]){
                array[s1] = s2;
                rank[s2]+=rank[s1];
            }
            else{
                array[s2] = s1;
                rank[s1]+=rank[s2];
            }
        }
    }
}
class Pair{
    int first;
    int second;
    public Pair(int f, int s){
        first = f;
        second = s;
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;
  
    public FastReader()
    {
        br = new BufferedReader(
            new InputStreamReader(System.in));
    }
  
    String next()
    {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
  
    int nextInt() { return Integer.parseInt(next()); }
  
    long nextLong() { return Long.parseLong(next()); }
  
    double nextDouble()
    {
        return Double.parseDouble(next());
    }
  
    String nextLine()
    {
        String str = "";
        try {
            if(st.hasMoreTokens()){
                str = st.nextToken("\n");
            }
            else{
                str = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}