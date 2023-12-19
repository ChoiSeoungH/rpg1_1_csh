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
  private ArrayList<Unit> partyList = new ArrayList<>();

  public ArrayList<Unit> getGuildList() {
    return guildList;
  }

  public void guildMenu() {
    while (true) {
      System.out.println("=============== [길드관리] ================");
      System.out.println("[1.길드목록] [2.길드원추가] [3.길드원삭제]\n" + "[4.파티원교체] [5.정렬]  [0.뒤로가기]");
      int menu = InputManager.getValue("메뉴 선택 >> ", 0, 5);
      switch (menu) {
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
    System.out.println("골드 : " + Player.getMoney());
    System.out.println("======================================");
    if (!printGuildMember()) {
      return;
    }
  }//eom

  private void addGuildMember() {
    if (guildList.size() > GUILD_SIZE) {
      System.out.printf("더이상 길드원을 추가 할 수 없습니다.[최대 : %s명]%n", GUILD_SIZE);
    }
    List<String> familyName = Arrays.asList("김", "이", "박", "최", "성", "권", "유");
    List<String> lastName = Arrays.asList("승", "현", "우", "권", "철", "의", "진", "성", "병", "호", "한", "솔");
    String name = familyName.get(InputManager.getRdNum(0, familyName.size())) + lastName.get(InputManager.getRdNum(0, lastName.size())) + lastName.get(InputManager.getRdNum(0, lastName.size()));
    int maxHp = InputManager.getRdNum(20, 81);//20~100
    int att = InputManager.getRdNum(1, 10);//1~10
    int def = InputManager.getRdNum(1, 5);//1~5
    guildList.add(new Unit(name, maxHp, att, def));
    System.out.println(guildList.get(guildList.size() - 1));

  }//eom

  private void deleteGuildMember() {
    if (!printGuildMember()) {
      return;
    }
    int member = InputManager.getValue("삭제할 번호를 입력하세요 ", 1, guildList.size()) - 1;
    if (guildList.get(member).isParty()) {
      System.out.println("파티중인 멤버는 삭제할 수 없습니다.");
      return;
    }
    System.out.println("======================================");
    System.out.println("[이름 : " + guildList.get(member).getName() + "] 길드원을 삭제합니다.");
    System.out.println("======================================");
    guildList.remove(member);
  }//eom

  public boolean printGuildMember() {
    if (guildList.isEmpty()) {
      System.out.println("길드원이 없습니다");
      return false;
    }
    int idx = 0;
    System.out.println("================ [길드원] ===============");
    for (Unit unit : guildList) {
      System.out.printf("[%d번]", ++idx);
      System.out.println(unit + "\n");
    }
    System.out.println("======================================");
    return true;
  }

  private void changePartyMember() {
    int party = 0;
    printPartyMember();
    System.out.println(partyList.size());
    if (partyList.size() >= PARTY_SIZE) {//파티멤버가 꽉차지않으면 추가만
      party = InputManager.getValue("교체할 번호를 입력하세요 >> ", 1, partyList.size()) - 1;
    }

    if (!printGuildMember()) {
      return;
    }
    int guild = InputManager.getValue("참가할 번호를 입력하세요 >> ", 1, guildList.size()) - 1;

    if (!partyList.isEmpty() && partyList.get(party).equals(guildList.get(guild))) {
      System.out.println("동일한 멤버입니다");
      return;
    }

    /*if (guildList.get(guild).isParty()) {
      System.out.println("이미 파티중인 멤버입니다");
      return;
    }*/

    if (partyList.size() < PARTY_SIZE) {
      System.out.println("====================================");
      System.out.print("[이름 : " + guildList.get(guild).getName() + "] 을 추가합니다%n");
      System.out.println("====================================");
      partyList.add(guildList.get(guild));
      guildList.get(guild).setParty(true);
    } else {
      System.out.println("====================================");
      System.out.print("[이름 : " + partyList.get(party).getName() + "]에서");
      System.out.print("[이름 : " + guildList.get(guild).getName() + "]으로 교체 합니다.\n");
      System.out.println("====================================");

      partyList.get(party).setParty(false);
      guildList.get(guild).setParty(true);
      partyList.set(party, guildList.get(guild));
    }

  }//eom

  private boolean printPartyMember() {
    if (partyList.isEmpty()) {
      System.out.println("설정된 파티원이 없습니다.");
      return false;
    }

    System.out.println("================ [파티원] ===============");
    int idx = 0;
    for (Unit u : partyList) {
      System.out.printf("[%d번]", ++idx);
      System.out.println(u+"\n");
    }
    System.out.println("=====================================");
    return true;
  }

  private void sortGuildMember() {
    if (!printGuildMember()) {
      return;
    }
    String sort = InputManager.getValue("정렬할 기준 >> ");

  }//eom
}//eoc
