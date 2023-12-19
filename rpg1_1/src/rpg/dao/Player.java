package rpg.dao;

public class Player {
  private static int money;
  private static Guild guild = new Guild();
  private static Inventory inven = new Inventory();

  public Player() {
    money = 100000;
  }

  public static int getMoney() {
    return money;
  }

  public static void setMoney(int money) {
    Player.money += money;
  }

  public static Guild getGuild() {
    return guild;
  }

  public static Inventory getInven() {
    return inven;
  }

  public void guildMenu() {
    guild.guildMenu();
  }

  public void inventoryMenu() {
    inven.inventoryMenu();
  }

}
