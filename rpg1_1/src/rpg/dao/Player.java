package rpg.dao;

import rpg.vo.Item;
import rpg.vo.Unit;

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

  public String getData() {
    String data = "";
    data += String.format("%s%n%s%n", money, guild.getGuildList().size());
    for (Unit u : guild.getGuildList()) {
      data += String.format("%s/%d/%d/%d/%d/%d/%b%n", u.getName(), u.getLevel(), u.getMaxHp(), u.getAtt(), u.getDef(), u.getExp(), u.isParty());
      data += getItemData(Item.WEAPON, u) + "/";
      data += getItemData(Item.ARMOR, u) + "/";
      data += getItemData(Item.RING, u) + "\n";
    }
    data += inven.getItemList().size() + "\n";
    for (Item i : inven.getItemList()) {
      data += getItemData(i);
    }
    System.out.println(data);
    return data;
  }

  private String getItemData(int kind, Unit u) {
    if (u.getItem(kind) == null) {
      return null;
    } else {
      return String.format("%d,%s,%d,%s", kind, u.getItem(kind).getName(), u.getItem(kind).getPower(), u.getItem(kind).getPrice());
    }
  }

  private String getItemData(Item i) {
    return String.format("%d/%s/%d/%s%n", i.getKind(), i.getName(), i.getPower(), i.getPrice());
  }
}
