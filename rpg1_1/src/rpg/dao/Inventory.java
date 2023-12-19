package rpg.dao;

import rpg.Utils.InputManager;
import rpg.vo.Item;

import java.util.ArrayList;

public class Inventory {
  private ArrayList<Item> itemList = new ArrayList<>();

  public ArrayList<Item> getItemList() {
    return itemList;
  }

  public void inventoryMenu() {
    while (true) {
      System.out.println("============ [인벤메뉴] =============");
      System.out.println("[1.착용] [2.판매] [0.뒤로가기]");
      int menu = InputManager.getValue("메뉴 선택 >>", 0, 2);
      switch (menu) {
        case 0:
          return;
        case 1://착용
          equipMenu();
          break;
        case 2://판매
          sellMenu();
          break;
      }//eos
    }//eow
  }//eom

  private void equipMenu() {
    if (!hasItem()) return;
    if (!Player.getGuild().printGuildMember()) return;

    int member = InputManager.getValue("아이템을 착용할 길드원을 선택하세요 >> ", 0, Player.getGuild().getGuildList().size())-1;
    while (true) {
      if (!hasItem()) return;
      System.out.println(Player.getGuild().getGuildList().get(member));
      printItemList();
      int num = Integer.parseInt(InputManager.getValue("착용할 아이템 번호를 입력하세요 [0.뒤로가기]"))-1;
      if (num==-1) return;
      if (Player.getGuild().getGuildList().get(member).getItem(itemList.get(num).getKind())!=null){
        itemList.add(Player.getGuild().getGuildList().get(member).getItem(itemList.get(num).getKind()));
      }
      Player.getGuild().getGuildList().get(member).setItem(itemList.get(num));
      itemList.remove(num);
    }//eow
  }//eom

  private void printItemList() {
    System.out.println("============ [아이템리스트] ==============");
    int idx = 0;
    for (Item i : itemList) {
      System.out.printf("[%d번]",++idx);
      System.out.println(i);
    }
  }

  private boolean hasItem() {
    if (itemList.isEmpty()){
      System.out.println("아이템이 없습니다.");
      return false;
    }
    return true;
  }

  private void sellMenu() {
    while (true) {
      if (!hasItem()) {
        return;
      }
      printItemList();
      System.out.println("[골드 : " + Player.getMoney() + "]");
      int item = InputManager.getValue("판매할 아이템 번호를 입력하세요. (50 % 세금) [0.뒤로가기] >> ",0,itemList.size())-1;
      if (item == -1) {
        return;
      }
      System.out.println(itemList.get(item).getName()+"을 판매합니다.");
      Player.setMoney(itemList.get(item).getPrice() / 2);
      itemList.remove(item);
    }//eow
  }//eom
}//eoc
