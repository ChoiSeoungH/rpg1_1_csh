package rpg.dao;

import rpg.vo.Unit;

import java.util.ArrayList;

public class Guild {
  final private int PARTY_SIZE = 4;
  ArrayList<Unit> guildList = new ArrayList<>();
  Unit[] partyList;

  public void guildMenu() {
    while (true) {
      System.out.println("=============== [길드관리] ================");
      System.out.println("[1.길드목록] [2.길드원추가] [3.길드원삭제]\n" + "[4.파티원교체] [5.정렬]  [0.뒤로가기]");

    }
  }
}
