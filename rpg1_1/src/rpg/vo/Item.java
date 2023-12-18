package rpg.vo;

public class Item {
  static final int WEAPON = 1;
  static final int ARMOR = 2;
  static final int RING = 3;
  int kind;
  String name;
  int power;
  int price;

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
}
