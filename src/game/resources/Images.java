package game.resources;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Images {

	public static BufferedImage TITLEBG, PLAY_BUTTON, HELP_BUTTON, ABOUT_BUTTON, EXIT_BUTTON, MAY_0, PAC_0, GAMEGUIDE, ABOUTIMG, BACK, HELP_BG;
	public static BufferedImage PLAY_BUTTON2, HELP_BUTTON2, ABOUT_BUTTON2, EXIT_BUTTON2;
	
	public static BufferedImage TOP_1, LEFT_1, RIGHT_1, BOTTOM_1, TOPLEFT_1, TOPRIGHT_1, BOTTOMLEFT_1, BOTTOMRIGHT_1, GROUND_1, POST_1, WALL_1;
	public static BufferedImage TOP_2, LEFT_2, RIGHT_2, BOTTOM_2, TOPLEFT_2, TOPRIGHT_2, BOTTOMLEFT_2, BOTTOMRIGHT_2, GROUND_2, POST_2, WALL_2;
	public static BufferedImage TOP_3, LEFT_3, RIGHT_3, BOTTOM_3, TOPLEFT_3, TOPRIGHT_3, BOTTOMLEFT_3, BOTTOMRIGHT_3, GROUND_3, POST_3, WALL_3;
	
	public static BufferedImage DIGIT_0, DIGIT_1, DIGIT_2, DIGIT_3, DIGIT_4, DIGIT_5, DIGIT_6, DIGIT_7, DIGIT_8, DIGIT_9, COLON;
	
	public static BufferedImage LR_EXPLODE, UD_EXPLODE, MID_EXPLODE;
	
	public static BufferedImage BOMB_1, BOMB_2;
	
	public static BufferedImage PACUP_0, PACUP_1, PACDOWN_0, PACDOWN_1, PACLEFT_0, PACLEFT_1, PACRIGHT_0, PACRIGHT_1;
	public static BufferedImage MAYUP_0, MAYUP_1, MAYDOWN_0, MAYDOWN_1, MAYLEFT_0, MAYLEFT_1, MAYRIGHT_0, MAYRIGHT_1;
	
	public static BufferedImage WINNER_P1, WINNER_P2;
	
	public static BufferedImage RANDOM, LIFEUP_1, ADDBOMB, RANGEUP, RANGEDOWN;
	
	public static BufferedImage AUDIENCE1_1, AUDIENCE1_2, AUDIENCE2_1, AUDIENCE2_2, AUDIENCE3_1, AUDIENCE3_2, BOTTOMBORDER_1, BOTTOMBORDER_2, BOTTOMBORDER_3, TOP_MODE1, TOP_MODE2, TOP_MODE3; 
	public static BufferedImage MODE1, MODE2, MODE3, STARTGAME, STARTGAME2, RANDMODE, SETUPBG, RANDMODE2, MODE1_2, MODE2_2, MODE3_2, BACK2;
	public static BufferedImage LIFE_MODE1, LIFE_MODE2, LIFE_MODE3;
	public static void load() {
		try {
			TITLEBG = ImageIO.read(new File("res/titlebg.png"));
			PLAY_BUTTON = ImageIO.read(new File("res/play.png"));
			HELP_BUTTON = ImageIO.read(new File("res/help.png"));
			ABOUT_BUTTON = ImageIO.read(new File("res/about.png"));
			EXIT_BUTTON = ImageIO.read(new File("res/exit.png"));
			PLAY_BUTTON2 = ImageIO.read(new File("res/play2.png"));
			HELP_BUTTON2 = ImageIO.read(new File("res/help2.png"));
			ABOUT_BUTTON2 = ImageIO.read(new File("res/about2.png"));
			EXIT_BUTTON2 = ImageIO.read(new File("res/exit2.png"));
			MAY_0 = ImageIO.read(new File("res/may_0.png"));
			PAC_0 = ImageIO.read(new File("res/pac_0.png"));
			MAY_0 = ImageIO.read(new File("res/may_0.png"));
			PAC_0 = ImageIO.read(new File("res/pac_0.png"));
			GAMEGUIDE = ImageIO.read(new File("res/gameGuide.png"));
			ABOUTIMG = ImageIO.read(new File("res/aboutPanel.png"));
			BACK = ImageIO.read(new File("res/back.png"));
			HELP_BG = ImageIO.read(new File("res/help_bg.png"));
			GROUND_1 = ImageIO.read(new File("res/ground_1.png"));
			POST_1 = ImageIO.read(new File("res/post_1.png"));
			WALL_1 = ImageIO.read(new File("res/wall_1.png"));
			TOP_1 = ImageIO.read(new File("res/top_1.png"));
			LEFT_1 = ImageIO.read(new File("res/left_1.png"));
			RIGHT_1 = ImageIO.read(new File("res/right_1.png"));
			BOTTOM_1 = ImageIO.read(new File("res/bottom_1.png"));
			TOPLEFT_1 = ImageIO.read(new File("res/topleft_1.png"));
			TOPRIGHT_1 = ImageIO.read(new File("res/topright_1.png"));
			BOTTOMLEFT_1 = ImageIO.read(new File("res/bottomleft_1.png"));
			BOTTOMRIGHT_1 = ImageIO.read(new File("res/bottomright_1.png"));
			GROUND_2 = ImageIO.read(new File("res/ground_2.png"));
			POST_2 = ImageIO.read(new File("res/post_2.png"));
			WALL_2 = ImageIO.read(new File("res/wall_2.png"));
			TOP_2 = ImageIO.read(new File("res/top_2.png"));
			LEFT_2 = ImageIO.read(new File("res/left_2.png"));
			RIGHT_2 = ImageIO.read(new File("res/right_2.png"));
			BOTTOM_2 = ImageIO.read(new File("res/bottom_2.png"));
			TOPLEFT_2 = ImageIO.read(new File("res/topleft_2.png"));
			TOPRIGHT_2 = ImageIO.read(new File("res/topright_2.png"));
			BOTTOMLEFT_2 = ImageIO.read(new File("res/bottomleft_2.png"));
			BOTTOMRIGHT_2 = ImageIO.read(new File("res/bottomright_2.png"));
			GROUND_3 = ImageIO.read(new File("res/ground_3.png"));
			POST_3 = ImageIO.read(new File("res/post_3.png"));
			WALL_3 = ImageIO.read(new File("res/wall_3.png"));
			TOP_3 = ImageIO.read(new File("res/top_3.png"));
			LEFT_3 = ImageIO.read(new File("res/left_3.png"));
			RIGHT_3 = ImageIO.read(new File("res/right_3.png"));
			BOTTOM_3 = ImageIO.read(new File("res/bottom_3.png"));
			TOPLEFT_3 = ImageIO.read(new File("res/topleft_3.png"));
			TOPRIGHT_3 = ImageIO.read(new File("res/topright_3.png"));
			BOTTOMLEFT_3 = ImageIO.read(new File("res/bottomleft_3.png"));
			BOTTOMRIGHT_3 = ImageIO.read(new File("res/bottomright_3.png"));
			DIGIT_0 = ImageIO.read(new File("res/digit_0.png"));
			DIGIT_1 = ImageIO.read(new File("res/digit_1.png"));
			DIGIT_2 = ImageIO.read(new File("res/digit_2.png"));
			DIGIT_3 = ImageIO.read(new File("res/digit_3.png"));
			DIGIT_4 = ImageIO.read(new File("res/digit_4.png"));
			DIGIT_5 = ImageIO.read(new File("res/digit_5.png"));
			DIGIT_6 = ImageIO.read(new File("res/digit_6.png"));
			DIGIT_7 = ImageIO.read(new File("res/digit_7.png"));
			DIGIT_8 = ImageIO.read(new File("res/digit_8.png"));
			DIGIT_9 = ImageIO.read(new File("res/digit_9.png"));
			COLON = ImageIO.read(new File("res/colon.png"));
			LR_EXPLODE = ImageIO.read(new File("res/lr_explode.png"));
			UD_EXPLODE = ImageIO.read(new File("res/ud_explode.png"));
			MID_EXPLODE = ImageIO.read(new File("res/mid_explode.png"));
			BOMB_1 = ImageIO.read(new File("res/bomb_1.png"));
			BOMB_2 = ImageIO.read(new File("res/bomb_2.png"));
			PACUP_0 = ImageIO.read(new File("res/pacup_0.png"));
			PACUP_1 = ImageIO.read(new File("res/pacup_1.png"));
			PACDOWN_0 = ImageIO.read(new File("res/pacdown_0.png"));
			PACDOWN_1 = ImageIO.read(new File("res/pacdown_1.png"));
			PACLEFT_0 = ImageIO.read(new File("res/pacleft_0.png"));
			PACLEFT_1 = ImageIO.read(new File("res/pacleft_1.png"));
			PACRIGHT_0 = ImageIO.read(new File("res/pacright_0.png"));
			PACRIGHT_1 = ImageIO.read(new File("res/pacright_1.png"));
			MAYUP_0 = ImageIO.read(new File("res/mayup_0.png"));
			MAYUP_1 = ImageIO.read(new File("res/mayup_1.png"));
			MAYDOWN_0 = ImageIO.read(new File("res/maydown_0.png"));
			MAYDOWN_1 = ImageIO.read(new File("res/maydown_1.png"));
			MAYLEFT_0 = ImageIO.read(new File("res/mayleft_0.png"));
			MAYLEFT_1 = ImageIO.read(new File("res/mayleft_1.png"));
			MAYRIGHT_0 = ImageIO.read(new File("res/mayright_0.png"));
			MAYRIGHT_1 = ImageIO.read(new File("res/mayright_1.png"));
			WINNER_P1 = ImageIO.read(new File("res/winner_p1.png"));
			WINNER_P2 = ImageIO.read(new File("res/winner_p2.png"));
			RANDOM = ImageIO.read(new File("res/rand.png"));
			ADDBOMB = ImageIO.read(new File("res/addbomb.png"));
			RANGEUP = ImageIO.read(new File("res/rangeUp.png"));
			RANGEDOWN = ImageIO.read(new File("res/rangeDown.png"));
			LIFEUP_1 = ImageIO.read(new File("res/lifeup_1.png"));
			MODE1 = ImageIO.read(new File("res/mode1.png"));
			MODE2 = ImageIO.read(new File("res/mode2.png"));
			MODE3 = ImageIO.read(new File("res/mode3.png"));
			RANDMODE = ImageIO.read(new File("res/random.png"));
			STARTGAME = ImageIO.read(new File("res/start.png"));
			STARTGAME2 = ImageIO.read(new File("res/start2.png"));
			SETUPBG = ImageIO.read(new File("res/setupbg.png"));
			MODE1_2 = ImageIO.read(new File("res/mode1_2.png"));
			MODE2_2 = ImageIO.read(new File("res/mode2_2.png"));
			MODE3_2 = ImageIO.read(new File("res/mode3_2.png"));
			RANDMODE2 = ImageIO.read(new File("res/random2.png"));
			BACK2 = ImageIO.read(new File("res/back2.png"));
			AUDIENCE1_1 = ImageIO.read(new File("res/audience1-left.png"));
			AUDIENCE1_2 = ImageIO.read(new File("res/audience1-right.png"));
			AUDIENCE2_1 = ImageIO.read(new File("res/audience2-left.png"));
			AUDIENCE2_2 = ImageIO.read(new File("res/audience2-right.png"));
			AUDIENCE3_1 = ImageIO.read(new File("res/audience3-left.png"));
			AUDIENCE3_2 = ImageIO.read(new File("res/audience3-right.png"));
			BOTTOMBORDER_1 = ImageIO.read(new File("res/bottom_mode1.png"));
			BOTTOMBORDER_2 = ImageIO.read(new File("res/bottom_mode2.png"));
			BOTTOMBORDER_3 = ImageIO.read(new File("res/bottom_mode3.png"));
			TOP_MODE1 = ImageIO.read(new File("res/top_mode1.png"));
			TOP_MODE2 = ImageIO.read(new File("res/top_mode2.png"));
			TOP_MODE3 = ImageIO.read(new File("res/top_mode3.png"));
			LIFE_MODE1 = ImageIO.read(new File("res/life_mode1.png"));
			LIFE_MODE2 = ImageIO.read(new File("res/life_mode2.png"));
			LIFE_MODE3 = ImageIO.read(new File("res/life_mode3.png"));
		} catch (Exception e) {
			System.out.println("WARNING! One or more of the images in the game is missing. Please obtain a copy with complete resources.");
		}
	}
	
}
