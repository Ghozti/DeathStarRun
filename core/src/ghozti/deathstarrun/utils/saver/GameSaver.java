package ghozti.deathstarrun.utils.saver;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import ghozti.deathstarrun.utils.Constants;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GameSaver {

    public static SavedPlayerData data = new SavedPlayerData();

    public static void saveGameState(){
        Json json = new Json();
        json.setOutputType(JsonWriter.OutputType.json);
        FileHandle handle = Gdx.files.local(Constants.Paths.SAVED_PLAYER_DATA);
        handle.writeString(json.toJson(data),false);
    }

    public static void loadGameData(){
        Json json = new Json();
        data = json.fromJson(data.getClass(), Gdx.files.internal(Constants.Paths.SAVED_PLAYER_DATA));
    }
}
