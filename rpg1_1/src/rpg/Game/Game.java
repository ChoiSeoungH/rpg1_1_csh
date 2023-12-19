package rpg.Game;

import rpg.Utils.InputManager;
import rpg.dao.Player;
import rpg.dao.Shop;
import rpg.Utils.FileData;

public class Game {
  private Player player;
  private Shop shop;
  private FileData fileData;
  public void run() {
    init();
    printMainMenu();
  }//eom

  private void init() {
    player = new Player();
    shop = new Shop();
    fileData = new FileData();
  }//eom

  private void printMainMenu(){
    while (true) {
      System.out.println("=============== [메인메뉴] ================");
      System.out.println("[1.길드관리] [2.상점] [3.인벤토리]");
      System.out.println("[4.저장] [5.로드] [0.종료]");
      int menu = InputManager.getValue("메뉴 선택 >> ",0,5);
      switch (menu){
        case 0://종료
          System.out.println("게임을 종료 합니다.");
          return;
        case 1://길드관리
          player.guildMenu();
          break;
        case 2://상점
          shop.shopMng();
          break;
        case 3://인벤토리
          player.inventoryMenu();
          break;
        case 4://저장
          FileData.saveFile(player);
          break;
        case 5://로드
          FileData.loadFile(player);
          break;
      }//eos
    }//eow
  }//eom
}//eoc