/* Kevin Stubblefield
 * Last Updated: April 8, 2015
 * Known Bugs: None
 * Created classs
 */

package Engine;

import Object.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFileHandler {
    
    private final String FILENAME = "saveFile";
    private final String DIRECTORY = System.getProperty("user.dir");
    private GameData gameData;
    
    public SaveFileHandler(GameData gameData) {
        this.gameData = gameData;
    }
    
    public void saveGame() {
        String filePath = DIRECTORY + File.separator + FILENAME;
        File saveFile = new File(filePath);
        try {
            if(saveFile.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("Overwriting file");
                saveHelper(saveFile);
            }
        } catch(IOException e) {
            System.err.println("File could not be created.");
        }
    }
    
    public void loadGame() {
        BufferedReader br = null;
        try {
            int lineNum = 0;
            String currentLine;
            br = new BufferedReader(new FileReader(DIRECTORY + File.separator + FILENAME));
            while((currentLine = br.readLine()) != null) {
                if(lineNum == 0) { // Get X Value
                    gameData.getPlayer().setX(Float.parseFloat(currentLine));
                }
                if(lineNum == 1) { // Get Y Value
                    gameData.getPlayer().setY(Float.parseFloat(currentLine));
                }
                if(lineNum == 2) { // Get Health Value
                    gameData.getPlayer().setHealth(Integer.parseInt(currentLine));
                }
                if(lineNum == 3) { // Start inventory
                    while(lineNum < 3 + gameData.getPlayer().getInventory().getItems().size()) {
                        String[] itemString = currentLine.split(":");
                        Item item;
                        if(itemString[0].equals("Half-Heart")) {
                            item = new HalfHeart(0, 0, true);
                            for(int i = 0; i < Integer.parseInt(itemString[1]); i++) {
                                gameData.getPlayer().getInventory().add(item);
                            }
                        }
                        if(itemString[0].equals("Heart")) {
                            item = new Heart(0, 0, true);
                            item.setQuantity(Integer.parseInt(itemString[1]));
                            for(int i = 0; i < Integer.parseInt(itemString[1]); i++) {
                                gameData.getPlayer().getInventory().add(item);
                            }
                        }
                        currentLine = br.readLine();
                        lineNum++;
                    }
                }
                System.out.println(currentLine);
                lineNum++;
            }
        } catch(IOException e) {
            System.err.println("Unable to read file");
        }
    }
    
    private void saveHelper(File saveFile) {
        try {
            if(!saveFile.exists()) {
                saveFile.createNewFile();
            }
            FileWriter fw = new FileWriter(saveFile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(String.valueOf(gameData.getPlayer().getX()) + "\n" + String.valueOf(gameData.getPlayer().getY())
                        + "\n" + String.valueOf(gameData.getPlayer().getHealth()) + "\n" + gameData.getPlayer().getInventory().toString()
                        + "\n" + String.valueOf(gameData.getPlayer().getMission()));
            bw.close();
        } catch(IOException e) {
            System.err.println("Unable to write to file");
        }
    }
    
}
