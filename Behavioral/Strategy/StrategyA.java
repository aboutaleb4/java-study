package Behavioral.Strategy;

public class StrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println(this.getClass().getName() + " has been executed");
    }
}
