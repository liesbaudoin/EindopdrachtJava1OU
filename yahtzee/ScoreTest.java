package yahtzee;

import junit.framework.TestCase;

public class ScoreTest extends TestCase {

  public void testCorrecteFullHouseHoogLaag() {
    Score score = new Score();
    int[] worp = { 2, 5, 5, 5, 2 };
    score.scoorFullHouse(worp);
    assertEquals(25, score.getScoreFullHouse());
  }

  public void testCorrecteFullHouseLaagHoog() {
    Score score = new Score();
    int[] worp = { 2, 5, 2, 5, 2 };
    score.scoorFullHouse(worp);
    assertEquals(25, score.getScoreFullHouse());
  }

  public void testIncorrecteFullHouse() {
    Score score = new Score();
    int[] worp = { 2, 5, 4, 5, 2 };
    score.scoorFullHouse(worp);
    assertEquals(0, score.getScoreFullHouse());
  }

  public void testCorrecteKleineStraat() {
    Score score = new Score();
    int[] worp = { 6, 5, 1, 4, 3 };
    score.scoorKleineStraat(worp);
    assertEquals(30, score.getScoreKleineStraat());
  }
  public void testCorrecteKleineStraat2() {
    Score score = new Score();
    int[] worp = { 6, 5, 4, 4, 3 };
    score.scoorKleineStraat(worp);
    assertEquals(30, score.getScoreKleineStraat());
  }
  
  public void testIncorrecteScoreKleineStraat() {
    Score score = new Score();
    int[] worp = { 6, 5, 1, 2, 4 };
    score.scoorKleineStraat(worp);
    assertEquals(0, score.getScoreKleineStraat());
  }

  public void testCorrecteGroteStraat() {
    Score score = new Score();
    int[] worp = { 5, 3, 1, 2, 4 };
    score.scoorGroteStraat(worp);
    assertEquals(40, score.getScoreGroteStraat());
  }
  public void testIncorrecteGroteStraat() {
    Score score = new Score();
    int[] worp = { 5, 5, 1, 2, 4 };
    score.scoorGroteStraat(worp);
    assertEquals(0, score.getScoreGroteStraat());
  }
  public void testCorrecteYahtzee(){
    Score score = new Score();
    int[] worp = { 5, 5, 5, 5, 5};
    score.scoorYahtzee(worp);
    assertEquals(50, score.getScoreYahtzee());
  }
  public void testincorrecteYahtzee(){
    Score score = new Score();
    int[] worp = { 2, 5, 5, 5, 5};
    score.scoorYahtzee(worp);
    assertEquals(0, score.getScoreYahtzee());
  }
  public void testChance(){
    Score score = new Score();
    int[] worp = { 5, 5, 5, 5, 5};
    score.scoorChance(worp);
    assertEquals(25, score.getScoreChance());
  }
  public void testScoorCijfers(){
    Score score = new Score();
    int[] worp = {1, 2, 3, 4, 5};
    score.scoorCijfercategorie(1, worp);
    score.scoorCijfercategorie(2, worp);
    score.scoorCijfercategorie(3, worp);
    score.scoorCijfers();
    assertEquals(6, score.getScoreCijfersTotaal());
  }
  
}