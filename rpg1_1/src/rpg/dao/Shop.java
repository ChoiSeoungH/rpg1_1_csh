package rpg.dao;

import rpg.Utils.InputManager;
import rpg.vo.Item;

import java.util.ArrayList;

public class Shop {
  private ArrayList<Item> itemList = new ArrayList<>();

  public Shop() {
    itemList.add(new Item(Item.WEAPON, "노송나무막대", 7, 1000));
    itemList.add(new Item(Item.WEAPON, "구리검", 13, 2000));
    itemList.add(new Item(Item.WEAPON, "철검", 20, 4000));
    itemList.add(new Item(Item.ARMOR, "가죽 갑옷", 11, 800));
    itemList.add(new Item(Item.ARMOR, "체인 메일", 20, 1600));
    itemList.add(new Item(Item.ARMOR, "청동 갑옷", 24, 3200));
    itemList.add(new Item(Item.RING, "청동반지", 20, 2000));
    itemList.add(new Item(Item.RING, "은반지", 30, 3500));
    itemList.add(new Item(Item.RING, "금반지", 40, 5000));
  }

  public void shopMng() {
    while (true) {
      if (!printShopMenu()) {
        return;
      }
    }
  }

  private boolean printShopMenu() {
    System.out.println("=============== [상점] ===============");
    int menu = InputManager.getValue("[1.무기] [2.갑옷] [3.반지] [0.뒤로가기] : ", 0, 3);
    if (menu==0) {
      return false;
    }
    Item i = new Item();
    BuyItem(menu, i);
    return true;
  }

  private void BuyItem(int menu, Item i) {
    while (true) {
      switch (menu) {
        case 0 :
          return;
        case 1 :
          System.out.println("=========== [무기] ============");
          i = SelectItem(1);
          break;
        case 2 :
          System.out.println("=========== [방어구] ============");
          i = SelectItem(2);
          break;
        case 3 :
          System.out.println("=========== [반지] ============");
          i = SelectItem(3);
          break;
      }
      if (i==null) {
        return;
      }
      if (Player.getMoney()<i.getPrice()) {
        System.out.println("골드가 부족합니다");
        continue;
      }

      if (itemList.contains(i)) {
        System.out.printf("[%s] 을 구입했습니다.%n", i.getName());
        InputManager.setDelay(800);
        Player.getInven().getItemList().add(i);
        Player.setMoney(-i.getPrice());
      }
    }
  }

  private Item SelectItem(int kind) {
    int idx = 0;
    for (Item item : itemList) {
      if (item.getKind()==kind) {
        System.out.printf("[%d번]",++idx);
        System.out.printf("[이름 : %s] [능력 : %d] [가격 : %d]%n",item.getName(),item.getPower(),item.getPrice());
      }
    }
    System.out.printf("[골드 : %d]%n",Player.getMoney());
    int sel = InputManager.getValue("구입할 아이템 번호를 입력하세요 [0.뒤로가기] : ", 0, idx)-1;
    if (sel==-1) {
      return null;
    }

    return findItem(sel,kind);
  }//eom

  private Item findItem(int sel,int kind) {
    int idx;
    idx=0;
    for (Item item : itemList) {
      if (item.getKind()==kind ) {
        if (idx== sel) {
          return item;
        }
        idx += 1;
      }
    }
    return null;
  }


}
