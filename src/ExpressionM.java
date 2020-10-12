public interface ExpressionM
{
Money reduce(Bank bank,String to);
ExpressionM plus(ExpressionM addend);
ExpressionM times(int multipler);
}
