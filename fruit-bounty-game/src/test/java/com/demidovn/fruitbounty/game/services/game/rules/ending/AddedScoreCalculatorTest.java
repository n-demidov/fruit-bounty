package com.demidovn.fruitbounty.game.services.game.rules.ending;

import static org.assertj.core.api.Assertions.assertThat;

import com.demidovn.fruitbounty.gameapi.model.Player;
import org.junit.Test;

public class AddedScoreCalculatorTest {

  private static final int MIN_MODIFIER = 5;

  private final AddedScoreCalculator addedScoreCalculator = new AddedScoreCalculator();

  @Test
  public void whenScoreEquals() {
    Player winner = createPlayer(1000);
    Player looser = createPlayer(1000);

    int actual = addedScoreCalculator.findWinnerAddedScore(winner, looser);

    assertThat(actual).isEqualTo(MIN_MODIFIER);
  }

  @Test
  public void whenWinnerAlmostLessAtOneLevel() {
    Player winner = createPlayer(1000);
    Player looser = createPlayer(1074);

    int actual = addedScoreCalculator.findWinnerAddedScore(winner, looser);

    assertThat(actual).isEqualTo(MIN_MODIFIER);
  }

  @Test
  public void whenWinnerLessAtOneLevel() {
    Player winner = createPlayer(1000);
    Player looser = createPlayer(1075);

    int actual = addedScoreCalculator.findWinnerAddedScore(winner, looser);

    assertThat(actual).isEqualTo(MIN_MODIFIER + 1);
  }

  @Test
  public void whenWinnerLessAtSomeDiff() {
    Player winner = createPlayer(1000);
    Player looser = createPlayer(1920);

    int actual = addedScoreCalculator.findWinnerAddedScore(winner, looser);

    assertThat(actual).isEqualTo(MIN_MODIFIER + 12);
  }

  @Test
  public void whenWinnerAlmostBiggerAtOneLevel() {
    Player winner = createPlayer(1099);
    Player looser = createPlayer(1000);

    int actual = addedScoreCalculator.findWinnerAddedScore(winner, looser);

    assertThat(actual).isEqualTo(MIN_MODIFIER);
  }

  @Test
  public void whenWinnerBiggerAtOneLevel() {
    Player winner = createPlayer(1100);
    Player looser = createPlayer(1000);

    int actual = addedScoreCalculator.findWinnerAddedScore(winner, looser);

    assertThat(actual).isEqualTo(MIN_MODIFIER - 1);
  }

  @Test
  public void whenWinnerBiggerAtSomeDiff() {
    Player winner = createPlayer(1799);
    Player looser = createPlayer(1000);

    int actual = addedScoreCalculator.findWinnerAddedScore(winner, looser);

    assertThat(actual).isEqualTo(0);
  }

  private Player createPlayer(int score) {
    Player player = new Player();
    player.setScore(score);
    return player;
  }

}