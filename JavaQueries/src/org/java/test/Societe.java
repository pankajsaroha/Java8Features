package org.java.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Societe {

	public static void main(String[] args) {
		
		FastIO f = new FastIO(System.in);
		
		int test = f.nextInt();
		
		for(int t=0; t<test; t++) {
			Map<String, Integer> map = new TreeMap<String, Integer>(new Order());
			int lines = f.nextInt();
			int highest = 0;
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<lines; i++) {
				String line = f.readLine();
				if("top".equals(line)) {
					Set<Map.Entry<String, Integer>> set = map.entrySet();
					for(Map.Entry<String, Integer> entry: set) {
						if(entry.getValue() == highest) {
							sb.append(entry.getKey()+ " ");
						}
					}
					sb.append("\n");
				} else {
					String arr[] = line.split(" ");
					String prod = arr[0];
					int quant = Integer.parseInt(arr[1]);
					if(map.containsKey(prod)) {
						int quantity = map.get(prod);
						if((quant + quantity) > highest) {
							highest = quant + quantity;
						}
						map.put(prod, (quant + quantity));
					} else {
						map.put(prod, quant);
						if(quant > highest) {
							highest = quant;
						}
					}
				}
			}
			System.out.print(sb.toString());
		}
		
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

class Order implements Comparator<String> {

	@Override
	public int compare(String str1, String st2) {
		return str1.compareTo(st2);
	}
	
}
