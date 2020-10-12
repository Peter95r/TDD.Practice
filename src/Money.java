public class Money implements ExpressionM
{
    protected int amount;
    protected String currency;
    public ExpressionM times (int multipler)
    {
        return new Money(amount*multipler,currency);
    }

    public Money (int amount, String currency)
    {
        this.amount=amount;
        this.currency=currency;
    }

    public String currency()
    {
        return currency;
    }

    @Override
    public boolean equals(Object obj)
    {
        Money money = (Money) obj;
        return amount==money.amount
                && currency.equals(money.currency);
    }
    public static Money dollar(int amout)
    {
        return new Money(amout,"USD");
    }
    public static Money franc(int amount)
    {
        return new Money(amount,"CHF");
    }
    public ExpressionM plus (ExpressionM addend)
    {
      return new Sum(this,addend);
    }

    public Money reduce(Bank bank, String to)
    {
        int rate = bank.rate(currency,to);
        return new Money(amount/rate,to);
    }
    @Override
    public String toString()
    {
        return amount + " " + currency;
    }

    public int getAmount() {
        return amount;
    }
}
