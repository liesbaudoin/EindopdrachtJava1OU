package yahtzee;

import java.util.ArrayList;
import java.util.Arrays;

public class Score {
  int[] rijCijferCategorie = { -1, -1, -1, -1, -1, -1 };
  int scoreCijfersTotaal = 0;
  int bonusCijfers = 0;
  int scoreDrieDezelfde = -1;
  int scoreCarre = -1;
  int scoreFullHouse = -1;
  int scoreKleineStraat = -1;
  int scoreGroteStraat = -1;
  int scoreYahtzee = -1;
  int scoreChance = -1;
  int scoreDeel2 = 0;
  int scoreTotaal = 0;

  /*
   * get methodes
   */

  public int getScoreCijfer(int getal) {
    return rijCijferCategorie[getal - 1];
  }

  public int getScoreDrieDezelfde() {
    return scoreDrieDezelfde;
  }

  public int getScoreCarre() {
    return scoreCarre;
  }

  public int getScoreFullHouse() {
    return scoreFullHouse;
  }

  public int getScoreKleineStraat() {
    return scoreKleineStraat;
  }

  public int getScoreGroteStraat() {
    return scoreGroteStraat;
  }

  public int getScoreYahtzee() {
    return scoreYahtzee;
  }

  public int getScoreChance() {
    return scoreChance;
  }

  public int[] getRijCijferCategorie() {
    return rijCijferCategorie;
  }

  public int getScoreCijfersTotaal() {
    return scoreCijfersTotaal;
  }

  public int getScoreDeel2() {
    return scoreDeel2;
  }

  public int getScoreTotaal() {
    return scoreTotaal;
  }

  public int getBonusCijfers() {
    return bonusCijfers;
  }

  /*
   * methode die de score berekent in de cijfercategorie, @param getal het getal
   * dat gescoord moet worden @param worp de Array van cijfers die de worp
   * vertegenwoordigt
   */
  public void scoorCijfercategorie(int getal, int[] worp) {
    if (rijCijferCategorie[getal - 1] != -1) {
      return;
    }
    int score = 0;
    for (int i = 0; i < 5; i++) {
      if (worp[i] == getal) {
        score = score + getal;
      }
    }
    rijCijferCategorie[getal - 1] = score;
    return;
  }

  /*
   * methode die de score toekent aan scoreDrieDezelfde: als minstens drie keer
   * dezelfde waarde is gegooid de som van alle ogen, anders 0
   */
  public void scoorDrieDezelfde(int[] worp) {
    if (scoreDrieDezelfde != -1) {
      return;
    }
    scoreDrieDezelfde = 0;
    if (this.geefLangsteDezelfde(worp) >= 3) {
      for (int i = 0; i < 5; i++) {
        scoreDrieDezelfde = scoreDrieDezelfde + worp[i];
      }
    }
    return;
  }

  /*
   * methode die de score toekent aan carre: als minstens vier keer dezelfde
   * waarde is gegooid de som van alle ogen in de worp, anders 0
   */
  public void scoorCarre(int[] worp) {
    if (scoreCarre != -1) {
      return;
    }
    scoreCarre = 0;
    if (this.geefLangsteDezelfde(worp) >= 4) {
      for (int i = 0; i < 5; i++) {
        scoreCarre = scoreCarre + worp[i];
      }
    }
    return;
  }

  /*
   * methode die de score toekent aan FullHouse: als een waarde met drie
   * dobbelstenen is gegooid en de andere met twee 25, anders 0
   */
  public void scoorFullHouse(int[] worp) {
    if (scoreFullHouse != -1) {
      return;
    }
    scoreFullHouse = 0;
    Arrays.sort(worp);
    if (worp[0] == worp[2] && worp[3] == worp[4] || worp[0] == worp[1]
        && worp[2] == worp[4]) {
      scoreFullHouse = 25;
    }
    return;
  }

  /*
   * methode die de score toekent aan kleine straat: als er minstens vier
   * opeenvolgende waarden zijn gegooid 30, anders 0
   */
  public void scoorKleineStraat(int[] worp) {
    if (scoreKleineStraat != -1) {
      return;
    }
    scoreKleineStraat = 0;
    if (this.geefLangsteReeks(worp) >= 4) {
      scoreKleineStraat = 30;
    }
    return;
  }

  /*
   * methode die de score toekent aan grote straat: als er vijf opeenvolgende
   * waarden zijn gegooid 40, anders 0
   */
  public void scoorGroteStraat(int[] worp) {
    if (scoreGroteStraat != -1) {
      return;
    }
    scoreGroteStraat = 0;
    if (this.geefLangsteReeks(worp) == 5) {
      scoreGroteStraat = 40;
    }
    return;
  }

  /*
   * methode die de score toekent aan Yahtzee: als vijf keer dezelfde waarde is
   * gegooid 50, anders 0
   */
  public void scoorYahtzee(int[] worp) {
    if (scoreYahtzee != -1) {
      return;
    }
    scoreYahtzee = 0;
    if (this.geefLangsteDezelfde(worp) == 5) {
      scoreYahtzee = 50;
    }
    return;
  }

  /*
   * methode die de score toekent aan chance: de som van alle ogen in de worp
   */
  public void scoorChance(int[] worp) {
    if (scoreChance != -1) {
      return;
    }
    scoreChance = 0;
    for (int i = 0; i < 5; i++) {
      scoreChance = scoreChance + worp[i];
    }
    return;
  }

  /*
   * methode die de score van de categorie cijfers toekent aan scoreCijfers
   */
  public void scoorCijfers() {
    scoreCijfersTotaal = 0;
    for (int i = 0; i < 6; i++) {
      if (rijCijferCategorie[i] != -1) {
        scoreCijfersTotaal = scoreCijfersTotaal + rijCijferCategorie[i];
      }
    }
  }

  /*
   * methode die de score toekent aan scoreDeel2
   */
  public void scoorDeel2() {
    scoreDeel2 = 0;
    ArrayList<Integer> lijst = new ArrayList<Integer>();
    
    lijst.add(scoreDrieDezelfde);
    lijst.add(scoreCarre);
    lijst.add(scoreFullHouse);
    lijst.add(scoreKleineStraat);
    lijst.add(scoreGroteStraat);
    lijst.add(scoreYahtzee);
    lijst.add(scoreChance);
    for (int i = 0; i < lijst.size(); i++) {
      if (lijst.get(i) != -1) {
        scoreDeel2 = scoreDeel2 + lijst.get(i);
      }
    }
  }

  /*
   * methode die de totaalscore toekent aan scoreTotaal
   */
  public void scoorTotaal() {
    scoreTotaal = scoreDeel2 + scoreCijfersTotaal + bonusCijfers;
    return;
  }

  /*
   * methode die berekent of de bonus moet worden toegekend. Dit gebeurt wanneer
   * de scoreCijfers 63 is of hoger. de bonus wordt slechts 1 maal toegekend. Na
   * het toekennen wordt de boolean bonusCijfers op true gezet
   */
  public void bonusRegelDezelfde() {
    if (bonusCijfers == 0) {
      if (scoreCijfersTotaal >= 63) {
        bonusCijfers = 35;
      }
    }
  }

  // methode die de atributen op hun beginwaarde zet
  public void maakLeeg() {
    for (int i = 0; i < rijCijferCategorie.length;  i++) {
      rijCijferCategorie[i] = -1;
    }
    scoreCijfersTotaal = 0;
    bonusCijfers = 0;
    scoreDrieDezelfde = -1;
    scoreCarre = -1;
    scoreFullHouse = -1;
    scoreKleineStraat = -1;
    scoreGroteStraat = -1;
    scoreYahtzee = -1;
    scoreChance = -1;
    scoreTotaal = 0;

  }

  /*
   * helpermethode die het het aantal van de meest voorkomende waarde uit de
   * Array worp geeft
   */

  private int geefLangsteDezelfde(int[] worp) {
    int vorige = -1;
    int dezelfde = 1;
    int langsteDezelfde = 1;
    Arrays.sort(worp);
    for (int i = 0; i < 5; i++) {
      if (worp[i] == vorige) {
        dezelfde++;
        if (dezelfde > langsteDezelfde) {
          langsteDezelfde = dezelfde;
        }
      }
      else {
        dezelfde = 1;
      }
      vorige = worp[i];
    }
    return langsteDezelfde;
  }

  /*
   * helper methode die de lengte teruggeeft van de langste reeks van
   * opeenvolgende waarden in de Array worp
   */
  private int geefLangsteReeks(int[] worp) {
    int vorige = -1;
    int reeks = 1;
    int langsteReeks = 1;
    Arrays.sort(worp);
    for (int i = 0; i < 5; i++) {
      if (worp[i] == vorige + 1) {
        reeks++;
      }
      if (reeks > langsteReeks) {
        langsteReeks = reeks;
      }
      if (worp[i] > vorige + 1) {
        reeks = 1;
      }
      vorige = worp[i];
    }
    return langsteReeks;
  }

}