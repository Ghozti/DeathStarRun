package ghozti.deathstarrun.utils.saver;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GameSaver {

    public void main() {
        SavedPlayerData playerData = new SavedPlayerData();
        playerData.savedShipsIDs.add("123");
        playerData.savedShipsIDs.add("456");
        playerData.highestScore = 10;
        Json json = new Json();
        json.setOutputType(JsonWriter.OutputType.json);
        FileHandle handle = Gdx.files.local("core/assets/test.json");
        handle.writeString(json.toJson(playerData),false);
    }
}
