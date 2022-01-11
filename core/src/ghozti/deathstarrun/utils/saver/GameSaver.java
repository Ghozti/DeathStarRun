package ghozti.deathstarrun.utils.saver;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GameSaver {

    public static SavedPlayerData data = new SavedPlayerData();

    public static void saveGameState(){
        Json json = new Json();
        json.setOutputType(JsonWriter.OutputType.json);
        FileHandle handle = Gdx.files.local("core/assets/save.json");
        handle.writeString(json.toJson(data),false);
    }

    public static void loadGameData(){
        Json json = new Json();
        data = json.fromJson(data.getClass(), Gdx.files.internal("core/assets/save.json"));
    }
}
