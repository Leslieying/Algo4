package Chapter2;
import edu.princeton.cs.algs4.Date;

public class Transaction {
    private String who;
    private Date when;
    private double amount;

    public Transaction(String who, Date when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public Transaction(String transaction) {
        String[] fields = transaction.split("\\s+");//正则表达式，表示任意个空白
        who = fields[0];
        when = new Date(fields[1]);
        amount = Double.parseDouble(fields[2]);
    }


    public String getWho() {
        return who;
    }

    public Date getWhen() {
        return when;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public void setWho(String who) {
        this.who = who;
    }

    /**
     * 以下equal方法，记住自反性、非空性、类型比较；
     * 转换类型 ->值比较
     */
    public boolean equals(Object x) {
        if (this == x)
            return true;//自反性
        if (this == null)
            return false;//非空性
        if (this.getClass() != x.getClass())
            return false;//类型比较
        Transaction that = (Transaction) x;//object类型转换为Transaction类型
        if (this.who != that.who)
            return false;
        if (this.when != that.when)
            return false;
        if (this.amount != that.amount)
            return false;
        return true;
    }
}