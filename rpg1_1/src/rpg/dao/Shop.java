package rpg.dao;

import rpg.vo.Item;

import java.util.ArrayList;

public class Shop {
  ArrayList<Item> itemList = new ArrayList<>();
  public void shopMng() {
    System.out.println("=============== [상점] ===============");
    System.out.println("[1.무기] [2.갑옷] [3.반지] [0.뒤로가기]");
  }

}
