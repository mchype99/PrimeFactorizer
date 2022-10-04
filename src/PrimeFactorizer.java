package q5;
import java.util.ArrayList;

public class PrimeFactorizer {
    int target;
    ArrayList<Integer> primes = new ArrayList<Integer>();
    ArrayList<Integer> exponents = new ArrayList<Integer>();
    Boolean computed = false;

    /**
     * Initialize the object with target number n.
     */
    public PrimeFactorizer(int n) {
        target = n;
    }
    /**
     * Return n, the target number.
     */

    public int getN() {
        int n = this.target;
        return n;
    }

    /**
     * Compute factorization. Do not repeat operation if it was called
     before.
     */
    public void compute() {
        if (computed == true)
            return;
        else{
            int n = target;
            if (n <= 0)
                throw new IllegalArgumentException("N must be a positive non-zero integer");
            else if (n == 1)
                throw new ArithmeticException("1 is neither prime nor composite");
            else {
                for (int i = 2; i * i <= n; i++) {
                    while (n % i == 0) {
                        n = n / i;
                        if (!primes.contains(i)) {
                            primes.add(i);
                            exponents.add(1);
                        } else {
                            exponents.set(primes.indexOf(i), exponents.get(primes.indexOf(i)) + 1);
                        }
                    }
                }
                if (n > 1) {
                    if (!primes.contains(n)) {
                        primes.add(n);
                        exponents.add(1);
                    } else {
                        exponents.set(primes.indexOf(n), exponents.get(primes.indexOf(n)) + 1);
                    }
                }
            }
        }
    }

    /**
     * Return the factors and exponents in two arraylists. Call compute()
     first, if necessary.
     * For instance, if n=60, primes=[2,3,5], and exponents=[2,1,1].
     * This function overwrites the 'n' parameter passed to the
     constructor.
     */
    public void getFactorsAndExponents(int n, ArrayList<Integer> primes, ArrayList<Integer> exponents) {
        if (computed == false || target != n){
            target = n;
            computed = false;
            compute();
        }
        primes = this.primes;
        exponents = this.exponents;
    }

    /**
     * Return a string with the "pretty" representation of the prime
     factorization.
     * For instance, if n is 60, then toString() for the
     PrimeFactorizer(60) object
     * should be "60 = 2^2*3*5". Call compute() if not done before.
     */
    public String toString() {
        if (computed == false){
            computed = false;
            compute();
        }
        String factorization = "";
        for (int i = 0; i < primes.size(); i++) {
            if (i >= 1) {
                factorization = factorization.concat("*");
            }
            int exp = exponents.get(i);
            if (exp == 1)
                factorization = factorization.concat(""+primes.get(i));
            else
                factorization = factorization.concat(primes.get(i) + "^" + exponents.get(i));
        }
        return factorization;
    }
}
