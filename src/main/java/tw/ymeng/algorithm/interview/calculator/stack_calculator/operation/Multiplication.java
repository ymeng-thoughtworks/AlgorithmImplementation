package tw.ymeng.algorithm.interview.calculator.stack_calculator.operation;

class Multiplication implements BinaryOperator {

    @Override
    public int execute(int a, int b) {
        return a * b;
    }
}
