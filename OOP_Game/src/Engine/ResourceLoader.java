/* Kevin Stubblefield
 * Last Updated: March 11, 2015
 * Known Bugs: None
 * Created class
 */

package Engine;

import Music.SoundEffects;
import Sprite.SpriteCache;

public class ResourceLoader {
    
    private static final String SITH_SOLDIER = "res\\sprites\\enemies\\sith soldier";
    private static final String SITH_HEAVY_SOLDIER = "res\\sprites\\enemies\\sith heavy soldier";
    private static final String SITH_ASSASSIN = "res\\sprites\\enemies\\sith assassin";
    private static final String SITH_ADVANCED_ASSASSIN = "res\\sprites\\enemies\\sith advanced assassin";
    private static final String SITH_APPRENTICE_1 = "res\\sprites\\enemies\\sith apprentice 1";
    private static final String SITH_APPRENTICE_2 = "res\\sprites\\enemies\\sith apprentice 2";
    private static final String DOWN = "\\down";
    private static final String UP = "\\up";
    private static final String RIGHT = "\\right";
    private static final String LEFT = "\\left";
    
    public static void loadImages() {
        SpriteCache.getSpriteCache().getSprite("res\\sprites/start_game_selected.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites/continue_selected.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites/options_selected.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites/exit_selected.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites/ResumeSelected.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites/OptionsSelected.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites/ResumeSelected.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites/door-close-h.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites/wall.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites/text_box_0.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites/Mission1-bg.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites/check64x64.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites/rock2.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites/sith_soldier_left_0.png");
        
        // hud folder
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/player_health_0.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/player_health_1.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/player_health_2.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/player_health_3.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/player_health_4.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/player_health_5.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/player_health_6.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/player_health_7.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/player_health_8.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/player_health_9.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\hud/player_health_10.png");
        
        // items folder
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\items/heart_item_0.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\items/heart_item_1.png");
        
        // player images
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\back/player_back_0.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\back/player_back_1.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\back/player_back_2.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\back/player_back_3.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\front/player_front_0.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\front/player_front_1.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\front/player_front_2.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\front/player_front_3.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\right/player_right_0.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\right/player_right_1.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\left/player_left_0.png");
        SpriteCache.getSpriteCache().getSprite("res\\sprites\\player\\left/player_left_1.png");
        
        // Sith Solider
        SpriteCache.getSpriteCache().getSprite(SITH_SOLDIER + DOWN + "/sith_soldier_down_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_SOLDIER + DOWN + "/sith_soldier_down_1.png");
        SpriteCache.getSpriteCache().getSprite(SITH_SOLDIER + DOWN + "/sith_soldier_down_2.png");
        SpriteCache.getSpriteCache().getSprite(SITH_SOLDIER + DOWN + "/sith_soldier_down_3.png");
        SpriteCache.getSpriteCache().getSprite(SITH_SOLDIER + UP + "/sith_soldier_up_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_SOLDIER + UP + "/sith_soldier_up_1.png");
        SpriteCache.getSpriteCache().getSprite(SITH_SOLDIER + UP + "/sith_soldier_up_2.png");
        SpriteCache.getSpriteCache().getSprite(SITH_SOLDIER + UP + "/sith_soldier_up_3.png");
        SpriteCache.getSpriteCache().getSprite(SITH_SOLDIER + RIGHT + "/sith_soldier_right_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_SOLDIER + RIGHT + "/sith_soldier_right_1.png");
        SpriteCache.getSpriteCache().getSprite(SITH_SOLDIER + LEFT + "/sith_soldier_left_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_SOLDIER + LEFT + "/sith_soldier_left_1.png");
        
        // Sith Heavy Soldier
        SpriteCache.getSpriteCache().getSprite(SITH_HEAVY_SOLDIER + DOWN + "/sith_heavy_soldier_down_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_HEAVY_SOLDIER + DOWN + "/sith_heavy_soldier_down_1.png");
        SpriteCache.getSpriteCache().getSprite(SITH_HEAVY_SOLDIER + DOWN + "/sith_heavy_soldier_down_2.png");
        SpriteCache.getSpriteCache().getSprite(SITH_HEAVY_SOLDIER + DOWN + "/sith_heavy_soldier_down_3.png");
        SpriteCache.getSpriteCache().getSprite(SITH_HEAVY_SOLDIER + UP + "/sith_heavy_soldier_up_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_HEAVY_SOLDIER + UP + "/sith_heavy_soldier_up_1.png");
        SpriteCache.getSpriteCache().getSprite(SITH_HEAVY_SOLDIER + UP + "/sith_heavy_soldier_up_2.png");
        SpriteCache.getSpriteCache().getSprite(SITH_HEAVY_SOLDIER + UP + "/sith_heavy_soldier_up_3.png");
        SpriteCache.getSpriteCache().getSprite(SITH_HEAVY_SOLDIER + RIGHT + "/sith_heavy_soldier_right_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_HEAVY_SOLDIER + RIGHT + "/sith_heavy_soldier_right_1.png");
        SpriteCache.getSpriteCache().getSprite(SITH_HEAVY_SOLDIER + LEFT + "/sith_heavy_soldier_left_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_HEAVY_SOLDIER + LEFT + "/sith_heavy_soldier_left_1.png");
        
        // Sith Assassin
        SpriteCache.getSpriteCache().getSprite(SITH_ASSASSIN + DOWN + "/sith_assassin_down_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ASSASSIN + DOWN + "/sith_assassin_down_1.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ASSASSIN + DOWN + "/sith_assassin_down_2.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ASSASSIN + DOWN + "/sith_assassin_down_3.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ASSASSIN + UP + "/sith_assassin_up_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ASSASSIN + UP + "/sith_assassin_up_1.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ASSASSIN + UP + "/sith_assassin_up_2.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ASSASSIN + UP + "/sith_assassin_up_3.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ASSASSIN + RIGHT + "/sith_assassin_right_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ASSASSIN + RIGHT + "/sith_assassin_right_1.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ASSASSIN + LEFT + "/sith_assassin_left_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ASSASSIN + LEFT + "/sith_assassin_left_1.png");
        
        // Sith Advanced Assassin
        SpriteCache.getSpriteCache().getSprite(SITH_ADVANCED_ASSASSIN + DOWN + "/sith_advanced_assassin_down_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ADVANCED_ASSASSIN + DOWN + "/sith_advanced_assassin_down_1.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ADVANCED_ASSASSIN + DOWN + "/sith_advanced_assassin_down_2.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ADVANCED_ASSASSIN + DOWN + "/sith_advanced_assassin_down_3.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ADVANCED_ASSASSIN + UP + "/sith_advanced_assassin_up_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ADVANCED_ASSASSIN + UP + "/sith_advanced_assassin_up_1.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ADVANCED_ASSASSIN + UP + "/sith_advanced_assassin_up_2.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ADVANCED_ASSASSIN + UP + "/sith_advanced_assassin_up_3.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ADVANCED_ASSASSIN + RIGHT + "/sith_advanced_assassin_right_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ADVANCED_ASSASSIN + RIGHT + "/sith_advanced_assassin_right_1.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ADVANCED_ASSASSIN + LEFT + "/sith_advanced_assassin_left_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_ADVANCED_ASSASSIN + LEFT + "/sith_advanced_assassin_left_1.png");
        
        // Sith Apprentice 1
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_1 + DOWN + "/sith_apprentice_1_down_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_1 + DOWN + "/sith_apprentice_1_down_1.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_1 + DOWN + "/sith_apprentice_1_down_2.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_1 + DOWN + "/sith_apprentice_1_down_3.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_1 + UP + "/sith_apprentice_1_up_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_1 + UP + "/sith_apprentice_1_up_1.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_1 + UP + "/sith_apprentice_1_up_2.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_1 + UP + "/sith_apprentice_1_up_3.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_1 + RIGHT + "/sith_apprentice_1_right_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_1 + RIGHT + "/sith_apprentice_1_right_1.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_1 + LEFT + "/sith_apprentice_1_left_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_1 + LEFT + "/sith_apprentice_1_left_1.png");
        
        // Sith Apprentice 2
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_2 + DOWN + "/sith_apprentice_2_down_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_2 + DOWN + "/sith_apprentice_2_down_1.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_2 + DOWN + "/sith_apprentice_2_down_2.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_2 + DOWN + "/sith_apprentice_2_down_3.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_2 + UP + "/sith_apprentice_2_up_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_2 + UP + "/sith_apprentice_2_up_1.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_2 + UP + "/sith_apprentice_2_up_2.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_2 + UP + "/sith_apprentice_2_up_3.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_2 + RIGHT + "/sith_apprentice_2_right_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_2 + RIGHT + "/sith_apprentice_2_right_1.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_2 + LEFT + "/sith_apprentice_2_left_0.png");
        SpriteCache.getSpriteCache().getSprite(SITH_APPRENTICE_2 + LEFT + "/sith_apprentice_2_left_1.png");
    }
    
    public static void loadMusic() {
        
    }
    
    public static void loadSoundEffects() {
        SoundEffects.init();
    }
    
}
