import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class TreeQueries {

    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String args[]) {
        FastIO f = new FastIO();
        int n = f.nextInt();
        int q = f.nextInt();
        long arr[] = new long[(int) (n + 1)];
        ArrayList<Long> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        long c = 0;
        int level = 1;
        long total = 0;
        for(int i=1; i<=n; i++) {
            long data = f.nextLong();
            arr[i] = data;
            c++;
            if((long) Math.pow(2, level) == c) {
                list.add(total);
                level++;
                total = 0;
            }
            total += data;
        }
        list.add(total);
        for(int i=0; i<q; i++) {
            int queryNum = f.nextInt();
            if(queryNum == 1) {
                int x = f.nextInt();
                int l = f.nextInt();
                l--;
                int numOfNodes = (int) Math.pow(2, l);
                //System.out.println(arr[numOfNodes+x-1]);
                sb.append(arr[numOfNodes+x-1]+"\n");
            } else if(queryNum == 2) {
                int l1 = f.nextInt();
                int l2 = f.nextInt();
                long sum = 0;
                l1--;
                for(int j=l1; j<l2; j++) {
                    sum += list.get(j);
                }
                //System.out.println(sum);
                sb.append(sum+"\n");
            } else {
                int x = f.nextInt();
                int l = f.nextInt();
                long val = f.nextInt();
                l--;
                int start = (int) Math.pow(2, l);
                long oldVal = arr[start+x-1];
                arr[start+x-1] = val;
                list.set(l, list.get(l)+(val-oldVal));
            }
        }
        System.out.println(sb.toString());
    }

    static class FastIO {

        private final InputStream is;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
    
        public FastIO() {
            this(System.in);
        }
    
        public FastIO(final InputStream is) {
            this.is = is;
        }
    
        public int read() {
            if(numChars == -1) {
                throw new RuntimeException();
            }
            if(curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = is.read(buf);
                } catch (final IOException e) {
                    throw new RuntimeException();
                }
                if(numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
    
        public String readLine() {
            int c = read();
            while(isSpaceChar(c)) {
                c = read();
            }
            final StringBuilder sb = new StringBuilder();
            do {
                sb.append((char) c);
                c = read();
            } while(!isEndOfLine(c));
            return sb.toString();
        }
    
        public String nextLine() {
            return readLine();
        }
    
        public String next() {
            int c = read();
            while(isSpaceChar(c)) {
                c = read();
            }
            final StringBuilder sb = new StringBuilder();
            do {
                sb.append((char) c);
                c = read();
            } while(!isSpaceChar(c));
            return sb.toString();
        }
        
        public long nextLong() {
            int c = read();
            while(isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if(c == '-') {
                sign = -1;
                c = read();
            }
            long res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while(!isSpaceChar(c));
            return res * sign;
        }
    
        public int nextInt() {
            int c = read();
            while(isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if(c == '-') {
                sign = -1;
                c = read();
            }
            int res = 0;
            while (!isSpaceChar(c) && c >= '0' && c <= '9') {
                res *= 10;
                res += c - '0';
                c = read();
            } 
            return res * sign;
        }
    
        public boolean isSpaceChar(final int c) {
            return (c == ' ') || (c == '\n') || (c == '\t') || (c == '\r') || (c == -1);
        }
    
        public boolean isEndOfLine(final int c) {
            return (c == '\n') || (c == '\r') || (c == -1);
        }
    }
}