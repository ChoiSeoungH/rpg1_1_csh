package rpg.dao;

import rpg.Utils.InputManager;
import rpg.vo.Item;
import rpg.vo.Unit;

import java.util.*;

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
    InputManager.setDelay(800);
    System.out.println("추가완료");
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
    InputManager.setDelay(800);
    System.out.println("삭제완료");
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
      InputManager.setDelay(800);
    }
    System.out.println("======================================");
    return true;
  }

  private void changePartyMember() {
    int party = 0;
    printPartyMember();
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
      System.out.print("[이름 : " + guildList.get(guild).getName() + "] 을 추가합니다\n");
      System.out.println("====================================");
      partyList.add(guildList.get(guild));
      guildList.get(guild).setParty(true);
      InputManager.setDelay(800);
    } else {
      System.out.println("====================================");
      System.out.print("[이름 : " + partyList.get(party).getName() + "]에서");
      System.out.print("[이름 : " + guildList.get(guild).getName() + "]으로 교체 합니다.\n");
      System.out.println("====================================");
      InputManager.setDelay(800);
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
      InputManager.setDelay(800);
    }
    System.out.println("=====================================");
    return true;
  }

  private void sortGuildMember() {
    if (!printGuildMember()) {
      return;
    }
    int sort = InputManager.getValue("[1.이름] [2.레벨] [3.체력] [4.공격력] [5.방어력] [6.경험치] [7.파티중] [0.뒤로가기] 정렬할 기준 >> ",0,7);
    switch (sort) {
      case 0:
        return;
      case 1:
        sortByName();
        break;
      case 2:
        sortByLevel();
        break;
      case 3:
        sortByMaxHp();
        break;
      case 4:
        sortByAtt();
        break;
      case 5:
        sortByDef();
        break;
      case 6:
        sortByExp();
        break;
      case 7:
        sortByIsParty();
        break;
    }
    printGuildMember();
  }//eom

  private void sortByName() {
    for (int i = 0; i < guildList.size()-1; i++) {
      for (int j = i+1; j < guildList.size(); j++) {
        if (guildList.get(i).getName().compareTo(guildList.get(j).getName())>0) {
          Unit temp = guildList.get(i);
          guildList.set(i, guildList.get(j));
          guildList.set(j, temp);
        }
      }
    }
  }

  private void sortByLevel() {
    for (int i = 0; i < guildList.size()-1; i++) {
      for (int j = i+1; j < guildList.size(); j++) {
        if (guildList.get(i).getLevel()>guildList.get(j).getLevel()) {
          Unit temp = guildList.get(i);
          guildList.set(i, guildList.get(j));
          guildList.set(j, temp);
        }
      }
    }
  }

  private void sortByMaxHp() {
    for (int i = 0; i < guildList.size()-1; i++) {
      for (int j = i+1; j < guildList.size(); j++) {
        int MaxHp1 = guildList.get(i).getItem(Item.RING) == null ? guildList.get(i).getMaxHp() 
            : guildList.get(i).getItem(Item.RING).getPower() + guildList.get(i).getMaxHp();
        int MaxHp2 = guildList.get(j).getItem(Item.RING) == null ? guildList.get(j).getMaxHp()
            : guildList.get(j).getItem(Item.RING).getPower() + guildList.get(j).getMaxHp();
        if (MaxHp1>MaxHp2) {
          Unit temp = guildList.get(i);
          guildList.set(i, guildList.get(j));
          guildList.set(j, temp);
        }
      }
    }

  }

  private void sortByAtt() {
    for (int i = 0; i < guildList.size()-1; i++) {
      for (int j = i+1; j < guildList.size(); j++) {
        int Att1 = guildList.get(i).getItem(Item.WEAPON) == null ? guildList.get(i).getAtt()
            : guildList.get(i).getItem(Item.WEAPON).getPower() + guildList.get(i).getAtt();
        int Att2 = guildList.get(j).getItem(Item.WEAPON) == null ? guildList.get(j).getAtt()
            : guildList.get(j).getItem(Item.WEAPON).getPower() + guildList.get(j).getAtt();
        if (Att1>Att2) {
          Unit temp = guildList.get(i);
          guildList.set(i, guildList.get(j));
          guildList.set(j, temp);
        }
      }
    }

  }

  private void sortByDef() {
    for (int i = 0; i < guildList.size()-1; i++) {
      for (int j = i+1; j < guildList.size(); j++) {
        int Def1 = guildList.get(i).getItem(Item.ARMOR) == null ? guildList.get(i).getDef()
            : guildList.get(i).getItem(Item.ARMOR).getPower() + guildList.get(i).getDef();
        int Def2 = guildList.get(j).getItem(Item.ARMOR) == null ? guildList.get(j).getDef()
            : guildList.get(j).getItem(Item.ARMOR).getPower() + guildList.get(j).getDef();
        if (Def1>Def2) {
          Unit temp = guildList.get(i);
          guildList.set(i, guildList.get(j));
          guildList.set(j, temp);
        }
      }
    }
  }

  private void sortByExp() {
    for (int i = 0; i < guildList.size()-1; i++) {
      for (int j = i+1; j < guildList.size(); j++) {
        if (guildList.get(i).getExp()>guildList.get(j).getExp()) {
          Unit temp = guildList.get(i);
          guildList.set(i, guildList.get(j));
          guildList.set(j, temp);
        }
      }
    }
  }

  private void sortByIsParty() {
    for (int i = 0; i < guildList.size()-1; i++) {
      for (int j = i+1; j < guildList.size(); j++) {
        if (!guildList.get(i).isParty()&& guildList.get(j).isParty()) {
          Unit temp = guildList.get(i);
          guildList.set(i, guildList.get(j));
          guildList.set(j, temp);
        }
      }
    }
  }
}//eoc
