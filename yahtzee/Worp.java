package yahtzee;


import java.util.Random;

public class Worp {
  int aantalWorpen = 0;
  int[] worp = new int[5];
  Random random = new Random();

  /*
   * @param: lijst met booleans of de dobbelsteen opnieuw gegooid moet worden
   */
  public void werp(boolean[] teWerpen) {
    if (aantalWorpen < 3) {
      for (int i = 0; i < 5; i++) {
        if (teWerpen[i]) {
          worp[i] = random.nextInt(6) + 1;
        }
      }
      aantalWorpen++;
    }
  }
  public int[] getWorp(){
    return worp;
  }
  public int getAantaWorpen(){
    return aantalWorpen;
  }
  public void zetAantalWorpenop0(){
    aantalWorpen = 0;
  }
}