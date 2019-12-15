package frc.robot.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * I hate this class so god damn much but I can't be bothered to make it in a less 4head like way
 * 
 * OMFG I just finished this and I'm disgusted... but idc
 * 
 * TODO: For now don't you even dare use this digusting piece of garbade. Just do it old fashion
 */
public class ConstantsManager {

  public static boolean hasInit = false;

  public static SavedData mData;

  private static final String JSON_DIRECTORY = "~/constants/";
  private static File mDatFile1;
  private static FileWriter mDatFile1W;
  private static FileReader mDatFile1R;

  private static GsonBuilder mBuilder;
  private static Gson mDatGson;

  public static void Init() throws IOException {

    mBuilder = new GsonBuilder();
    mBuilder.setPrettyPrinting();
    mDatGson = mBuilder.create();

    mData = new SavedData();

    mDatFile1 = new File(JSON_DIRECTORY + "mDatFile.json");
    if (!mDatFile1.exists()) {
      mDatFile1.createNewFile();
      mDatFile1R = new FileReader(mDatFile1);
      mDatFile1W = new FileWriter(mDatFile1);
      SaveData();
    } else {
      mDatFile1R = new FileReader(mDatFile1);
      mDatFile1W = new FileWriter(mDatFile1);
      LoadData();
    }

    hasInit = true;
  }

  public static void SaveData() {
    Write(mDatFile1W, mDatGson.toJson(mData));
  }

  public static void LoadData() {
    String r = Read(mDatFile1R);
    if (!r.equals("")) {
      mData = mDatGson.fromJson(r, SavedData.class);
    } else {
      System.out.println("RREEEEEEEEEEEEEEEEEEEEEEEE");
    }
  }

  public static void Write(FileWriter fw, String dat) {
    try {
      fw.write(dat);
      fw.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static String Read(FileReader fr) {
    try {
      CharBuffer cbuf = null;
      fr.read(cbuf);
      return cbuf != null ? cbuf.toString() : "";
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "";
  }

  public static class SavedData {

    public double
  
      ARM_UP = 0.0;

  }

}