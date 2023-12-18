package rpg.dao;

public class Player {
  static int money;
  static Guild guild = new Guild();
  static Inventory inven = new Inventory();

  public void guildMenu() {
    guild.guildMenu();
  }

  public void inventoryMenu() {
    inven.inventoryMenu();
  }

}
