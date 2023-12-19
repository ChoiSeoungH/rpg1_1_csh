package rpg.vo;

public class Item {
  public static final int WEAPON = 1;
  public static final int ARMOR = 2;
  public static final int RING = 3;
  private int kind;
  private String name;
  private int power;
  private int price;

  public int getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public int getPower() {
    return power;
  }

  public int getPrice() {
    return price;
  }

  public Item(int kind, String name, int power, int price) {
    this.kind = kind;
    this.name = name;
    this.power = power;
    this.price = price;
  }

  public Item() {
  }

  @Override
  public String toString() {
    return String.format("[이름 : %s] [능력 : %s] [가격 : %s]%n",name,power,price);
  }
}
