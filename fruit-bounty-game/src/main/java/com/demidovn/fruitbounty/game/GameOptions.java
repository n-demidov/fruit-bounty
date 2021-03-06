package com.demidovn.fruitbounty.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameOptions {

  public static final String CONFIG_PROPERTIES = "config.properties";
  public static final int BOARD_WIDTH = 12;
  public static final int BOARD_HEIGHT = BOARD_WIDTH;

  public static final int CELL_TYPES_COUNT = 9;
  public static final int CELL_TYPES_MIN = 1;

  public static final String GAME_LOOP_SCHEDULE_DELAY = "30";
  public static final int TIME_PER_MOVE = 20000;
  public static final int MOVE_TIME_DELAY_CORRECTION = 800;
  public static final int MAX_GAME_MISSED_MOVES = 3;

  public static final List<Integer> ALL_CELL_TYPES;

  static {
    List<Integer> possibleCellTypes = new ArrayList<>();

    for (int i = GameOptions.CELL_TYPES_MIN; i <= GameOptions.CELL_TYPES_COUNT; i++) {
      possibleCellTypes.add(i);
    }

    ALL_CELL_TYPES = Collections.unmodifiableList(possibleCellTypes);
  }

}
