package rpg.dao;

import rpg.vo.Item;

import java.util.ArrayList;

public class Inventory {
  ArrayList<Item> itemList = new ArrayList<>();
  public void inventoryMenu() {
    while (true) {
      System.out.println("============ [인벤메뉴] =============");
      System.out.println("[1.착용] [2.판매] [0.뒤로가기]");
    }
  }

  public void equipMenu() {
    System.out.println("아이템 착용할 길드원을 선택하세요 ");
    while (true) {
      System.out.println("착용할 아이템 번호를 입력하세요 [0.뒤로가기]");
    }
  }

  public void sellMenu() {
    while (true) {
      System.out.println("[골드 : " + Player.money + "]");
      System.out.println("판매할 아이템 번호를 입력하세요. (50 % 세금) [0.뒤로가기]");
    }
  }
}
