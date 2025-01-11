package design_patterns.behavioral.strategy;

public class StrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println(this.getClass().getName() + " has been executed");
    }
}
