/* Kevin Stubblefield
 * Last Updated: March 11, 2015
 * Known Bugs: None
 * Created class
 */

package Engine;

import Music.SoundEffects;
import Sprite.SpriteCache;

public class ResourceLoader {
    
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
    }
    
    public static void loadMusic() {
        
    }
    
    public static void loadSoundEffects() {
        SoundEffects.init();
    }
    
}
