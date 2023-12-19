package rpg.Utils;

import rpg.dao.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileData {
  final static private String CUR_PATH = System.getProperty("user.dir")+"\\rpg1_1\\src\\";

  public static void saveFile(Player player) {
    String gameData = player.getData();

    saveData("gameData.txt", gameData);
  }//eom

  private static void saveData(String fileName, String data) {
    try (FileWriter fw = new FileWriter(CUR_PATH + fileName)) {
      fw.write(data);
      System.out.println(fileName + "저장완료");
    } catch (IOException e) {
      System.out.print("입출력 에러");
    }
  }//eom

  public static void loadFile(Player player) {
    String gameData = loadData("gameData.txt");
  }//eom

  private static String loadData(String fileName) {
    String data = "";
    try(BufferedReader br = new BufferedReader(new FileReader(CUR_PATH+fileName))) {
      while (true) {
        String line = br.readLine();
        if (line == null) break;
        data += line;
        data += "\n";
      }
    } catch (Exception e) {
      System.out.println(fileName+"로드 실패");
    }
    return data;
  }
}
