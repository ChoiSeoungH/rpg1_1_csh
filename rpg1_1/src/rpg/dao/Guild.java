package rpg.dao;

import rpg.Utils.FileData;
import rpg.Utils.InputManager;
import rpg.vo.Unit;

import java.util.ArrayList;

public class Guild {
  final private int PARTY_SIZE = 4;
  private ArrayList<Unit> guildList = new ArrayList<>();
  private Unit[] partyList;

  public void guildMenu() {
    while (true) {
      System.out.println("=============== [길드관리] ================");
      System.out.println("[1.길드목록] [2.길드원추가] [3.길드원삭제]\n" + "[4.파티원교체] [5.정렬]  [0.뒤로가기]");
      int menu = InputManager.getValue("메뉴 선택 >> ",0,5);
      switch (menu){
        case 0://종료
          return;
        case 1://길드목록
          printAllGuildMember();
          break;
        case 2://길드원추가
          addGuildMember();
          break;
        case 3://길드원 삭제
          deleteGuildMember();
          break;
        case 4://파티원교체
          changePartyMember();
          break;
        case 5://정렬
          sortGuildMember();
          break;
      }//eos
    }//eow
  }//eowm

  private void printAllGuildMember() {
    if (guildList.size()==0) {
      System.out.println("길드원이 존재하지 않습니다");
      return;
    }
    for (Unit unit : guildList) {

    }
  }

  private void addGuildMember() {

  }

  private void deleteGuildMember() {

  }

  private void changePartyMember() {
  }

  private void sortGuildMember() {

  }
}//eoc
