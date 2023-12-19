package rpg.dao;

import rpg.vo.Item;
import rpg.vo.Unit;

import java.util.ArrayList;
import java.util.Arrays;

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

  public static void addData(String gameData) {
    String[] temp = gameData.split("\n");
    money = Integer.parseInt(temp[0]);
    int start = 2;
    int end = 2 + 2 * Integer.parseInt(temp[1]);
    for (int i = start; i < end; i+=2) { //길드원
      String[] info = temp[i].split("/");
      guild.getGuildList().add(new Unit(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]), Integer.parseInt(info[3]),
          Integer.parseInt(info[4]), Integer.parseInt(info[5]), Boolean.parseBoolean(info[6])));
      info = temp[i + 1].split("/");
      for (int j = 0; j < info.length; j++) {
        String[] info2 = info[j].split(",");
        if (info2.length == 1) continue;
        guild.getGuildList().get(i / 2 - 1).setItem(new Item(Integer.parseInt(info2[0]), info2[1]
            , Integer.parseInt(info2[2]), Integer.parseInt(info2[3])));
      }
    }
    start = end + 1;
    end = start + Integer.parseInt(temp[end]);
    for (int i = start; i < end; i++) {//아이템
      String[] info = temp[i].split("/");
      inven.getItemList().add(new Item(Integer.parseInt(info[0]), info[1]
          , Integer.parseInt(info[2]), Integer.parseInt(info[3])));
    }
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
