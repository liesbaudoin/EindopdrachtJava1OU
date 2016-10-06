package yahtzee;
//
import java.util.ArrayList;
//
public class ScoreTestMain {
//
//  /**
//   * @param args
//   */
 public static void main(String[] args) {
Worp worp = new Worp();
Score score = new Score();

 int[] worp1 = {3, 4, 3, 3, 3};
score.scoorDrieDezelfde(worp1);
System.out.println(score.getScoreDrieDezelfde());
  score.scoorCarre(worp1);
  System.out.println(score.getScoreCarre());
 }
}