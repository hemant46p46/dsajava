package dsajava.hp.dp.easy;

public class EasyProb {
	public static void main(String[] args) {
		/*	Fibonacci
		 * 		int n = 6;
		System.out.println(fibonacci(n));
		System.out.println(fibonacciTopDownMemo(n));
		System.out.println(fibonacciBottomUpTab(n));
		System.out.println(fibonacciBottomUpUlti(n));
		 */
		
		int n = 6;
		System.out.println(tribonacci(n));
		System.out.println(tribonacciTopDownMemo(n));
		System.out.println(tribonacciBottomUpTab(n));
		System.out.println(tribonacciBottomUpUlti(n));
		 
		
		
		/*	Fibonacci
		 * 		int n = 6;
		System.out.println(fibonacci(n));
		System.out.println(fibonacciTopDownMemo(n));
		System.out.println(fibonacciBottomUpTab(n));
		System.out.println(fibonacciBottomUpUlti(n));
		 */

		
		/* climbStairs
		 * 		int noStairs = 8;
		System.out.println(climbStairs(noStairs));
		System.out.println(climbStairsTopDownMemo(noStairs));
		System.out.println(climbStairsBottomUpTab(noStairs));
		System.out.println(climbStairsUltimate(noStairs));
		 */
	}
	protected static int climbStairs(int n) {
		if(n==1 || n==2) {
			return n;
		}
		return climbStairs(n-1) + climbStairs(n-2);
	}
	protected static int climbStairsTopDownMemo(int n) {
		int[] memo = new int[n+1];
		return csDpHelper(n, memo);
		
	}
	private static int csDpHelper(int n, int[] memo) {
		if(n==1 || n==2) {return n;}
		if(memo[n]!=0) {
			return memo[n];
		}
		memo[n] = csDpHelper(n-1, memo) + csDpHelper(n-2, memo);
		return memo[n];
	}
	protected static int climbStairsBottomUpTab(int n) {
		if(n==1 || n==2) {return n;}
		int[] tab = new int[n+1];
		tab[1] = 1; tab[2] = 2;
		
		for(int i=3;i<=n;i++) {
			tab[i] = tab[i-1] + tab[i-2];
		}
		return tab[n];
	}
    protected static int climbStairsUltimate(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int prev2 = 1;
        int prev1 = 2;
        int current = 0;
        
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return current;
    }
    
    protected static int fibonacci(int n) {
    	if(n==0 || n==1) {
    		return n;
    	}
    	return fibonacci(n-1) + fibonacci(n-2);
    }
    protected static int fibonacciTopDownMemo(int n) {
    	int[] memo = new int[n+1];
    	return fibMemoHelper(n, memo);
    }
    private static int fibMemoHelper(int n, int[] memo) {
    	if(n==0 || n==1) {return n;}
    	if(memo[n]!=0) {
    		return memo[n];
    	}
    	memo[n] = fibMemoHelper(n-1, memo) + fibMemoHelper(n-2, memo);
    	return memo[n];
    }
    protected static int fibonacciBottomUpTab(int n) {
    	int[] tab = new int[n+1];
    	tab[0] = 0;
    	tab[1] = 1;
    	for(int i=2;i<=n;i++) {
    		tab[i] = tab[i-1] + tab[i-2];
    	}
    	return tab[n];
    }
    protected static int fibonacciBottomUpUlti(int n) {
    	if(n==0 || n==1) {return n;}
    	int p1 = 0, p2 = 1, curr=0;
    	for(int i=2;i<=n;i++) {
    		curr = p1 + p2;
    		p1 = p2;
    		p2 = curr;
    	}
    	return curr;
    }
    
    protected static int tribonacci (int n) {
    	if(n==0) {
    		return 0;
    	}
    	if(n==1 || n==2) {
    		return 1;
    	}
    	return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
    }
    protected static int tribonacciTopDownMemo(int n) {
    	int[] memo = new int[n+1];
    	return tibMemoHelper(n, memo);
    }
    private static int tibMemoHelper(int n, int[] memo) {
    	if(n==0) {return 0;}
    	if(n==1 || n==2) {return 1;}
    	if(memo[n]!=0) {
    		return memo[n];
    	}
    	memo[n] = tibMemoHelper(n-1, memo) + tibMemoHelper(n-2, memo) + tibMemoHelper(n-3, memo);
    	return memo[n];
    }
    protected static int tribonacciBottomUpTab(int n) {
    	int[] tab = new int[n+1];
    	tab[0] = 0;
    	tab[1] = 1;
    	tab[2] = 1;
    	for(int i=3;i<=n;i++) {
    		tab[i] = tab[i-1] + tab[i-2] + tab[i-3];
    	}
    	return tab[n];
    }
    protected static int tribonacciBottomUpUlti(int n) {
    	if(n==0 || n==1) {return n;}
    	int p1 = 0, p2 = 1, p3=1, curr=0;
    	for(int i=3;i<=n;i++) {
    		curr = p1 + p2 + p3;
    		p1 = p2;
    		p2 = p3;
    		p3 = curr;
    	}
    	return curr;
    }
}
