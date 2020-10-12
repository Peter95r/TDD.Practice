public class Sum implements ExpressionM
{
     ExpressionM augend;
     ExpressionM addend;

     public Sum(ExpressionM addend, ExpressionM augend)
     {
         this.addend=addend;
         this.augend=augend;
     }
     public Money reduce(Bank bank,String to)
     {
         int amount = augend.reduce(bank,to).amount + addend.reduce(bank,to).amount;
         return new Money(amount,to);
     }
     public ExpressionM plus(ExpressionM addend)
     {
         return new Sum(this,addend);
     }
     public ExpressionM times (int multiplesr)
     {
         return  new Sum(augend.times(multiplesr),addend.times(multiplesr));
     }
}
