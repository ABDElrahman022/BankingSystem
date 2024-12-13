
package patterns.strategy;

public class SimpleInterestStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.05; // 5% interest
    }
}