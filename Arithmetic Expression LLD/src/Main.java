public class Main {
    public static void main(String[] args) {
        ArithmeticExpression two = new Number(2);
        ArithmeticExpression one = new Number(1);
        ArithmeticExpression seven = new Number(7);

        ArithmeticExpression add = new Expression(one, seven, Operation.ADD);
        ArithmeticExpression multiply = new Expression(two, add, Operation.MULTIPLY);

        System.out.println(multiply.evaluate());
    }
}