package rpg.dao;

import rpg.Utils.FileData;
import rpg.Utils.InputManager;
import rpg.vo.Unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Guild {
  final private int GUILD_SIZE = 10;
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
  }//eom

  private void printAllGuildMember() {
    System.out.println("======================================");
    System.out.println("골드 : "+Player.money);
    System.out.println("======================================");
    if (guildList.size()==0) {
      System.out.println("길드원이 존재하지 않습니다");
      return;
    }
    for (Unit unit : guildList) {
      System.out.println(unit);
    }
  }//eom

  private void addGuildMember() {
    if (guildList.size()>GUILD_SIZE) {
      System.out.printf("더이상 길드원을 추가 할 수 없습니다.[최대 : %s명]%n",GUILD_SIZE);
    }
    List<String> familyName = Arrays.asList("김", "이", "박", "최", "성","권","유");
    List<String> lastName = Arrays.asList("승","현","우","권","철","의","진","성","병","호","한","솔");
    String name = familyName.get(InputManager.getRdNum(0,familyName.size())) + lastName.get(InputManager.getRdNum(0,lastName.size())) + lastName.get(InputManager.getRdNum(0,lastName.size()));
    int maxHp = InputManager.getRdNum(20,81);//20~100
    int att = InputManager.getRdNum(1,10);//1~10
    int def = InputManager.getRdNum(1,5);//1~5
    guildList.add(new Unit(name, maxHp, att, def));
    System.out.println(guildList.get(guildList.size()-1));

  }//eom

  private void deleteGuildMember() {
    
  }//eom

  private void changePartyMember() {
  }//eom

  private void sortGuildMember() {

  }//eom
}//eoc
