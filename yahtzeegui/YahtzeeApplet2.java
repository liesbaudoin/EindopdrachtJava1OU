package yahtzeegui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JButton;

import yahtzee.Score;
import yahtzee.Worp;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;

public class YahtzeeApplet2 extends JApplet {

  private JPanel jContentPane = null;
  private JTextField dobbelsteen1Field = null;
  private JTextField dobbelsteen2Field = null;
  private JTextField dobbelsteen3Field = null;
  private JTextField dobbelsteen4Field = null;
  private JTextField dobbelsteen5Field = null;

  /**
   * This is the xxx default constructor
   */
  public YahtzeeApplet2() {
    super();
    init();
    // mijnInit();
  }

  Score score = new Score(); // @jve:decl-index=0:
  Worp worp = new Worp(); // @jve:decl-index=0:

  /**
   * This method initializes this
   * 
   * @return void
   */
  public void init() {
    this.setSize(441, 560);
    this.setContentPane(getJContentPane());
  }

  private JButton enenButton = null;
  private JButton tweeenButton = null;
  private JButton drieenButton = null;
  private JButton vierenButton = null;
  private JButton vijvenButton = null;
  private JTextField enenField = null;
  private JTextField tweeenField = null;
  private JTextField drieenField = null;
  private JTextField vierenField = null;
  private JTextField vijvenField = null;
  private JButton drieDezelfdeButton = null;
  private JButton CarreButton = null;
  private JButton fullHousejButton = null;
  private JButton kleineStraatButton = null;
  private JButton groteStraatButton = null;
  private JButton yahtzeeButton = null;
  private JButton ChanceButton = null;
  private JButton zessenButton = null;
  private JTextField zessenField = null;
  private JTextField drieDezelfdeField = null;
  private JTextField carreField = null;
  private JTextField fullHouseField = null;
  private JTextField kleineStraatField = null;
  private JTextField groteStraatField = null;
  private JTextField yahtzeeField = null;
  private JTextField chanceField = null;
  private JTextField totaalCijfersField = null;
  private JLabel totaal1Label = null;
  private JLabel bonusLabel = null;
  private JTextField bonusField = null;
  private JLabel totaal2Label = null;
  private JTextField totaal2Field = null;
  private JLabel totaalLabel = null;
  private JTextField totaalField = null;
  private JButton nieuwSpelButton = null;

  // Array die de dobbelstenen op true zet

  boolean[] teWerpen = { true, true, true, true, true };

  private JButton werpButtonButton = null;
  private JLabel werpLabel = null;
  private JLabel opmerkingLabel = null;

  
  /*
   * methode om de dobbelstenen vast te zetten met een muisklik
   */
  private void dobbelsteenFieldAction(JTextField veld, int dobbelsteenNummer) {
    if (teWerpen[dobbelsteenNummer - 1]) {
      if (worp.getAantaWorpen() > 0) {
        teWerpen[dobbelsteenNummer - 1] = false;
        Color rood = new Color(238, 150, 150);
        veld.setBackground(rood);
      }
    }
    else {
      if (worp.getAantaWorpen() > 0) {
        teWerpen[dobbelsteenNummer - 1] = true;
        Color wit = Color.WHITE;
        veld.setBackground(wit);
      }
    }
  }

  /*
   * helpermethode voor het ophalen van de waarden uit de Array worp
   */
  private int pakWaarde(int dobbelsteenNummer) {
    int waarde;
    waarde = worp.getWorp()[dobbelsteenNummer - 1];
    return waarde;
  }

  private void werpButtonAction() {
    System.out.println("" + teWerpen[0] + teWerpen[1] + teWerpen[2]
        + teWerpen[3] + teWerpen[4]);
    worp.werp(teWerpen);
    dobbelsteen1Field.setText("" + pakWaarde(1));
    dobbelsteen2Field.setText("" + pakWaarde(2));
    dobbelsteen3Field.setText("" + pakWaarde(3));
    dobbelsteen4Field.setText("" + pakWaarde(4));
    dobbelsteen5Field.setText("" + pakWaarde(5));
    werpLabel.setVisible(false);
  }

  /*
   * helpermethode om all scorevelden te updaten
   */
  private void updateScoreVelden() {
    if (score.getScoreCijfer(1) != -1) {
      enenField.setText("" + score.getScoreCijfer(1));
    }
    if (score.getScoreCijfer(2) != -1) {
      tweeenField.setText("" + score.getScoreCijfer(2));
    }
    if (score.getScoreCijfer(3) != -1) {
      drieenField.setText("" + score.getScoreCijfer(3));
    }
    if (score.getScoreCijfer(4) != -1) {
      vierenField.setText("" + score.getScoreCijfer(4));
    }
    if (score.getScoreCijfer(5) != -1) {
      vijvenField.setText("" + score.getScoreCijfer(5));
    }
    if (score.getScoreCijfer(6) != -1) {
      zessenField.setText("" + score.getScoreCijfer(6));
    }
    if (score.getScoreDrieDezelfde() != -1) {
      drieDezelfdeField.setText("" + score.getScoreDrieDezelfde());
    }
    if (score.getScoreCarre() != -1) {
      carreField.setText("" + score.getScoreCarre());
    }
    if (score.getScoreFullHouse() != -1) {
      fullHouseField.setText("" + score.getScoreFullHouse());
    }
    if (score.getScoreKleineStraat() != -1) {
      kleineStraatField.setText("" + score.getScoreKleineStraat());
    }
    if (score.getScoreGroteStraat() != -1) {
      groteStraatField.setText("" + score.getScoreGroteStraat());
    }
    if (score.getScoreYahtzee() != -1) {
      yahtzeeField.setText("" + score.getScoreYahtzee());
    }
    if (score.getScoreChance() != -1) {
      chanceField.setText("" + score.getScoreChance());
    }
    score.scoorCijfers();
    score.bonusRegelDezelfde();
    score.scoorDeel2();
    score.scoorTotaal();
    totaalCijfersField.setText("" + score.getScoreCijfersTotaal());
    bonusField.setText("" + score.getBonusCijfers());
    totaal2Field.setText("" + score.getScoreDeel2());
    totaalField.setText("" + score.getScoreTotaal());
  }

  /*
   * methode om dobbelsteenvelden leeg te maken, en de dobbelstenen klaar te
   * zetten voor de nieuwe worp
   */
  private void klaarVoorNieuweWorp() {
    worp.zetAantalWorpenop0();
    for (int i = 0; i < 5; i++) {
      teWerpen[i] = true;
    }
    Color wit = Color.WHITE;
    dobbelsteen1Field.setBackground(wit);
    dobbelsteen2Field.setBackground(wit);
    dobbelsteen3Field.setBackground(wit);
    dobbelsteen4Field.setBackground(wit);
    dobbelsteen5Field.setBackground(wit);
    werpLabel.setVisible(true);
  }

  /*
   * eventhandlers voor de scoreknoppen
   */
  private void cijfercategorieKnopAction(int getal, JTextField veld) {
    if (worp.getAantaWorpen() == 0) {
      return;
    }
    score.scoorCijfercategorie(getal, worp.getWorp());
    klaarVoorNieuweWorp();
    updateScoreVelden();
    return;
  }

  private void drieDezelfdeButtonAction() {
    if (worp.getAantaWorpen() == 0) {
      return;
    }
    score.scoorDrieDezelfde(worp.getWorp());
    klaarVoorNieuweWorp();
    updateScoreVelden();
    System.out.println("" + score.getScoreDrieDezelfde());
    return;
  }

  private void carreButtonAction() {
    if (worp.getAantaWorpen() == 0) {
      return;
    }
    score.scoorCarre(worp.getWorp());
    klaarVoorNieuweWorp();
    updateScoreVelden();
    return;
  }
  
  private void fullHouseButtonAction(){
    if (worp.getAantaWorpen() == 0) {
      return;
    }
    score.scoorFullHouse(worp.getWorp());
    klaarVoorNieuweWorp();
    updateScoreVelden();
    return;
  }
  
  private void kleineStraatButtonAction(){
    if (worp.getAantaWorpen() == 0) {
      return;
    }
    score.scoorKleineStraat(worp.getWorp());
    klaarVoorNieuweWorp();
    updateScoreVelden();
    return;
  }
  
  private void groteStraatButtonAction(){
    if (worp.getAantaWorpen() == 0) {
      return;
    }
    score.scoorGroteStraat(worp.getWorp());
    klaarVoorNieuweWorp();
    updateScoreVelden();
    return;
  }

  private void YahtzeeButtonAction(){
    if (worp.getAantaWorpen() == 0) {
      return;
    }
    score.scoorYahtzee(worp.getWorp());
    klaarVoorNieuweWorp();
    updateScoreVelden();
    return;
  }
  
  private void chanceButtonAction(){
    if (worp.getAantaWorpen() == 0) {
      return;
    }
    score.scoorChance(worp.getWorp());
    klaarVoorNieuweWorp();
    updateScoreVelden();
    return;
  }
  
  private void nieuwSpelButtonAction(){
    score.maakLeeg();
    klaarVoorNieuweWorp();
    updateScoreVelden();
    dobbelsteen1Field.setText("");
    dobbelsteen2Field.setText("");
    dobbelsteen3Field.setText("");
    dobbelsteen4Field.setText("");
    dobbelsteen5Field.setText("");
    enenField.setText("");
    tweeenField.setText("");
    drieenField.setText("");
    vierenField.setText("");
    vijvenField.setText("");
    zessenField.setText("");
    drieDezelfdeField.setText("");
    carreField.setText("");
    fullHouseField.setText("");
    kleineStraatField.setText("");
    groteStraatField.setText("");
    yahtzeeField.setText("");
    chanceField.setText("");
    totaalCijfersField.setText("");
    bonusField.setText("");
    totaal2Field.setText("");
    totaalField.setText("");    
      }
  
  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      opmerkingLabel = new JLabel();
      opmerkingLabel.setBounds(new Rectangle(50, 57, 321, 15));
      opmerkingLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
      opmerkingLabel.setText("Door op het vakje te klikken, zet je de dobbelsteen vast");
      werpLabel = new JLabel();
      werpLabel.setBounds(new Rectangle(28, 84, 186, 33));
      werpLabel.setText("Werp de dobbelsteen!  --->");
      totaalLabel = new JLabel();
      totaalLabel.setBounds(new Rectangle(87, 477, 96, 30));
      totaalLabel.setText("TOTAAL:");
      totaal2Label = new JLabel();
      totaal2Label.setBounds(new Rectangle(247, 429, 110, 32));
      totaal2Label.setText("Totaal deel 2:");
      bonusLabel = new JLabel();
      bonusLabel.setBounds(new Rectangle(13, 428, 91, 25));
      bonusLabel.setText("Bonus:");
      totaal1Label = new JLabel();
      totaal1Label.setBounds(new Rectangle(11, 393, 110, 32));
      totaal1Label.setText("Totaal deel 1:");
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.setFont(new Font("Dialog", Font.PLAIN, 14));
      jContentPane.add(getDobbelsteen1Field(), null);
      jContentPane.add(getDobbelsteen2Field(), null);
      jContentPane.add(getDobbelsteen3Field(), null);
      jContentPane.add(getDobbelsteen4Field(), null);
      jContentPane.add(getDobbelsteen5Field(), null);
      jContentPane.add(getEnenButton(), null);
      jContentPane.add(getTweeenButton(), null);
      jContentPane.add(getDrieenButton(), null);
      jContentPane.add(getVierenButton(), null);
      jContentPane.add(getVijvenButton(), null);
      jContentPane.add(getEnenField(), null);
      jContentPane.add(getTweeenField(), null);
      jContentPane.add(getDrieenField(), null);
      jContentPane.add(getVierenField(), null);
      jContentPane.add(getVijvenField(), null);
      jContentPane.add(getDrieDezelfdeButton(), null);
      jContentPane.add(getCarreButton(), null);
      jContentPane.add(getFullHousejButton(), null);
      jContentPane.add(getKleineStraatButton(), null);
      jContentPane.add(getGroteStraatButton(), null);
      jContentPane.add(getYahtzeeButton(), null);
      jContentPane.add(getChanceButton(), null);
      jContentPane.add(getZessenButton(), null);
      jContentPane.add(getZessenField(), null);
      jContentPane.add(getDrieDezelfdeField(), null);
      jContentPane.add(getCarreField(), null);
      jContentPane.add(getFullHouseField(), null);
      jContentPane.add(getKleineStraatField(), null);
      jContentPane.add(getGroteStraatField(), null);
      jContentPane.add(getYahtzeeField(), null);
      jContentPane.add(getChanceField(), null);
      jContentPane.add(getTotaalCijfersField(), null);
      jContentPane.add(totaal1Label, null);
      jContentPane.add(bonusLabel, null);
      jContentPane.add(getBonusField(), null);
      jContentPane.add(totaal2Label, null);
      jContentPane.add(getTotaal2Field(), null);
      jContentPane.add(totaalLabel, null);
      jContentPane.add(getTotaalField(), null);
      jContentPane.add(getNieuwSpelButton(), null);
      jContentPane.add(getWerpButtonButton(), null);
      jContentPane.add(werpLabel, null);
      jContentPane.add(opmerkingLabel, null);
    }
    return jContentPane;
  }

  /**
   * This method initializes dobbelsteen1Field
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getDobbelsteen1Field() {
    if (dobbelsteen1Field == null) {
      dobbelsteen1Field = new JTextField();
      dobbelsteen1Field.setBounds(new Rectangle(22, 14, 62, 43));
      dobbelsteen1Field.setBackground(Color.white);
      dobbelsteen1Field.setEditable(false);
      dobbelsteen1Field.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent e) {
          dobbelsteenFieldAction(dobbelsteen1Field, 1);
          System.out.println("mousePressed()"); // TODO Auto-generated Event
          // stub mousePressed()
        }
      });
    }

    return dobbelsteen1Field;
  }

  /**
   * This method initializes dobbelsteen2Field
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getDobbelsteen2Field() {
    if (dobbelsteen2Field == null) {
      dobbelsteen2Field = new JTextField();
      dobbelsteen2Field.setBounds(new Rectangle(98, 14, 62, 43));
      dobbelsteen2Field.setBackground(Color.white);
      dobbelsteen2Field.setEditable(false);
      dobbelsteen2Field.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent e) {
          System.out.println("mousePressed2()"); // TODO Auto-generated Event
          // stub mousePressed()
          dobbelsteenFieldAction(dobbelsteen2Field, 2);
        }
      });

    }

    return dobbelsteen2Field;
  }

  /**
   * This method initializes dobbelsteen3Field
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getDobbelsteen3Field() {
    if (dobbelsteen3Field == null) {
      dobbelsteen3Field = new JTextField();
      dobbelsteen3Field.setBounds(new Rectangle(174, 14, 62, 43));
      dobbelsteen3Field.setBackground(Color.white);
      dobbelsteen3Field.setEditable(false);
      dobbelsteen3Field.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent e) {
          System.out.println("mousePressed()"); // TODO Auto-generated Event
          // stub mousePressed()
          dobbelsteenFieldAction(dobbelsteen3Field, 3);
        }
      });
    }
    return dobbelsteen3Field;
  }

  /**
   * This method initializes dobbelsteen4Field
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getDobbelsteen4Field() {
    if (dobbelsteen4Field == null) {
      dobbelsteen4Field = new JTextField();
      dobbelsteen4Field.setBounds(new Rectangle(250, 14, 62, 43));
      dobbelsteen4Field.setBackground(Color.white);
      dobbelsteen4Field.setEditable(false);
      dobbelsteen4Field.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent e) {
          System.out.println("mousePressed()"); // TODO Auto-generated Event
          dobbelsteenFieldAction(dobbelsteen4Field, 4);
        }
      });
    }
    return dobbelsteen4Field;
  }

  /**
   * This method initializes dobbelsteen5Field
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getDobbelsteen5Field() {
    if (dobbelsteen5Field == null) {
      dobbelsteen5Field = new JTextField();
      dobbelsteen5Field.setBounds(new Rectangle(326, 14, 62, 43));
      dobbelsteen5Field.setBackground(Color.white);
      dobbelsteen5Field.setEditable(false);
      dobbelsteen5Field.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent e) {
          System.out.println("mousePressed()"); // TODO Auto-generated Event
          dobbelsteenFieldAction(dobbelsteen5Field, 5);

        }
      });
    }
    return dobbelsteen5Field;
  }

  /**
   * This method initializes enenButton
   * 
   * @return javax.swing.JButton
   */
  private JButton getEnenButton() {
    if (enenButton == null) {
      enenButton = new JButton();
      enenButton.setBounds(new Rectangle(20, 120, 117, 33));
      enenButton.setText("Enen");
      enenButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          cijfercategorieKnopAction(1, enenField);
        }
      });
    }
    return enenButton;
  }

  /**
   * This method initializes tweeenButton
   * 
   * @return javax.swing.JButton
   */
  private JButton getTweeenButton() {
    if (tweeenButton == null) {
      tweeenButton = new JButton();
      tweeenButton.setBounds(new Rectangle(20, 166, 117, 33));
      tweeenButton.setText("Tweeën");
      tweeenButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          cijfercategorieKnopAction(2, tweeenField);
        }
      });
    }
    return tweeenButton;
  }

  /**
   * This method initializes drieenButton
   * 
   * @return javax.swing.JButton
   */
  private JButton getDrieenButton() {
    if (drieenButton == null) {
      drieenButton = new JButton();
      drieenButton.setBounds(new Rectangle(20, 207, 117, 33));
      drieenButton.setText("Drieën");
      drieenButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          cijfercategorieKnopAction(3, drieenField);
        }
      });
    }
    return drieenButton;
  }

  /**
   * This method initializes vierenButton
   * 
   * @return javax.swing.JButton
   */
  private JButton getVierenButton() {
    if (vierenButton == null) {
      vierenButton = new JButton();
      vierenButton.setBounds(new Rectangle(20, 249, 117, 33));
      vierenButton.setText("Vieren");
      vierenButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          cijfercategorieKnopAction(4, vierenField);
        }
      });
    }
    return vierenButton;
  }

  /**
   * This method initializes vijvenButton
   * 
   * @return javax.swing.JButton
   */
  private JButton getVijvenButton() {
    if (vijvenButton == null) {
      vijvenButton = new JButton();
      vijvenButton.setBounds(new Rectangle(20, 290, 117, 33));
      vijvenButton.setText("Vijven");
      vijvenButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          cijfercategorieKnopAction(5, vijvenField);
        }
      });
    }
    return vijvenButton;
  }

  /**
   * This method initializes enenField
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getEnenField() {
    if (enenField == null) {
      enenField = new JTextField();
      enenField.setBounds(new Rectangle(154, 120, 42, 31));
      enenField.setEditable(false);
    }
    return enenField;
  }

  /**
   * This method initializes tweeenField
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getTweeenField() {
    if (tweeenField == null) {
      tweeenField = new JTextField();
      tweeenField.setBounds(new Rectangle(154, 168, 42, 31));
      tweeenField.setEditable(false);
    }
    return tweeenField;
  }

  /**
   * This method initializes drieenField
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getDrieenField() {
    if (drieenField == null) {
      drieenField = new JTextField();
      drieenField.setBounds(new Rectangle(154, 209, 42, 31));
      drieenField.setEditable(false);
    }
    return drieenField;
  }

  /**
   * This method initializes vierenField
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getVierenField() {
    if (vierenField == null) {
      vierenField = new JTextField();
      vierenField.setBounds(new Rectangle(154, 249, 42, 31));
      vierenField.setEditable(false);
    }
    return vierenField;
  }

  /**
   * This method initializes vijvenField
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getVijvenField() {
    if (vijvenField == null) {
      vijvenField = new JTextField();
      vijvenField.setBounds(new Rectangle(154, 292, 42, 31));
      vijvenField.setEditable(false);
    }
    return vijvenField;
  }

  /**
   * This method initializes drieDezelfdeButton
   * 
   * @return javax.swing.JButton
   */
  private JButton getDrieDezelfdeButton() {
    if (drieDezelfdeButton == null) {
      drieDezelfdeButton = new JButton();
      drieDezelfdeButton.setBounds(new Rectangle(239, 120, 117, 33));
      drieDezelfdeButton.setText("Drie dezelfde");
      drieDezelfdeButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          drieDezelfdeButtonAction();
        }
      });
    }
    return drieDezelfdeButton;
  }

  /**
   * This method initializes CarreButton
   * 
   * @return javax.swing.JButton
   */
  private JButton getCarreButton() {
    if (CarreButton == null) {
      CarreButton = new JButton();
      CarreButton.setBounds(new Rectangle(239, 166, 117, 33));
      CarreButton.setText("Carré");
      CarreButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          carreButtonAction();
        }
      });
    }
    return CarreButton;
  }

  /**
   * This method initializes fullHousejButton
   * 
   * @return javax.swing.JButton
   */
  private JButton getFullHousejButton() {
    if (fullHousejButton == null) {
      fullHousejButton = new JButton();
      fullHousejButton.setBounds(new Rectangle(239, 207, 117, 33));
      fullHousejButton.setText("Full House");
      fullHousejButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          fullHouseButtonAction();
        }
      });
    }
    return fullHousejButton;
  }

  /**
   * This method initializes kleineStraatButton
   * 
   * @return javax.swing.JButton
   */
  private JButton getKleineStraatButton() {
    if (kleineStraatButton == null) {
      kleineStraatButton = new JButton();
      kleineStraatButton.setBounds(new Rectangle(239, 247, 117, 33));
      kleineStraatButton.setText("Kleine Straat");
      kleineStraatButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          kleineStraatButtonAction();
        }
      });
    }
    return kleineStraatButton;
  }

  /**
   * This method initializes groteStraatButton
   * 
   * @return javax.swing.JButton
   */
  private JButton getGroteStraatButton() {
    if (groteStraatButton == null) {
      groteStraatButton = new JButton();
      groteStraatButton.setBounds(new Rectangle(239, 290, 117, 33));
      groteStraatButton.setText("Grote Straat");
      groteStraatButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          groteStraatButtonAction();
        }
      });
    }
    return groteStraatButton;
  }

  /**
   * This method initializes yahtzeeButton
   * 
   * @return javax.swing.JButton
   */
  private JButton getYahtzeeButton() {
    if (yahtzeeButton == null) {
      yahtzeeButton = new JButton();
      yahtzeeButton.setBounds(new Rectangle(239, 335, 117, 33));
      yahtzeeButton.setText("Yahtzee!");
      yahtzeeButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          YahtzeeButtonAction();
        }
      });
    }
    return yahtzeeButton;
  }

  /**
   * This method initializes ChanceButton
   * 
   * @return javax.swing.JButton
   */
  private JButton getChanceButton() {
    if (ChanceButton == null) {
      ChanceButton = new JButton();
      ChanceButton.setBounds(new Rectangle(239, 381, 117, 33));
      ChanceButton.setText("Chance");
      ChanceButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          chanceButtonAction();
        }
      });
    }
    return ChanceButton;
  }

  /**
   * This method initializes zessenButton
   * 
   * @return javax.swing.JButton
   */
  private JButton getZessenButton() {
    if (zessenButton == null) {
      zessenButton = new JButton();
      zessenButton.setBounds(new Rectangle(20, 337, 115, 31));
      zessenButton.setText("Zessen");
      zessenButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          cijfercategorieKnopAction(6, zessenField);
        }
      });
    }
    return zessenButton;
  }

  /**
   * This method initializes zessenField
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getZessenField() {
    if (zessenField == null) {
      zessenField = new JTextField();
      zessenField.setBounds(new Rectangle(154, 337, 42, 31));
      zessenField.setEditable(false);
    }
    return zessenField;
  }

  /**
   * This method initializes drieDezelfdeField
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getDrieDezelfdeField() {
    if (drieDezelfdeField == null) {
      drieDezelfdeField = new JTextField();
      drieDezelfdeField.setBounds(new Rectangle(371, 120, 42, 31));
      drieDezelfdeField.setEditable(false);
    }
    return drieDezelfdeField;
  }

  /**
   * This method initializes carreField
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getCarreField() {
    if (carreField == null) {
      carreField = new JTextField();
      carreField.setBounds(new Rectangle(371, 168, 42, 31));
      carreField.setEditable(false);
    }
    return carreField;
  }

  /**
   * This method initializes fullHouseField
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getFullHouseField() {
    if (fullHouseField == null) {
      fullHouseField = new JTextField();
      fullHouseField.setBounds(new Rectangle(371, 209, 42, 31));
      fullHouseField.setEditable(false);
    }
    return fullHouseField;
  }

  /**
   * This method initializes kleineStraatField
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getKleineStraatField() {
    if (kleineStraatField == null) {
      kleineStraatField = new JTextField();
      kleineStraatField.setBounds(new Rectangle(371, 249, 42, 31));
      kleineStraatField.setEditable(false);
    }
    return kleineStraatField;
  }

  /**
   * This method initializes groteStraatField
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getGroteStraatField() {
    if (groteStraatField == null) {
      groteStraatField = new JTextField();
      groteStraatField.setBounds(new Rectangle(371, 292, 42, 31));
      groteStraatField.setEditable(false);
    }
    return groteStraatField;
  }

  /**
   * This method initializes yahtzeeField
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getYahtzeeField() {
    if (yahtzeeField == null) {
      yahtzeeField = new JTextField();
      yahtzeeField.setBounds(new Rectangle(371, 337, 42, 31));
      yahtzeeField.setEditable(false);
    }
    return yahtzeeField;
  }

  /**
   * This method initializes chanceField
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getChanceField() {
    if (chanceField == null) {
      chanceField = new JTextField();
      chanceField.setBounds(new Rectangle(371, 381, 42, 31));
      chanceField.setEditable(false);
    }
    return chanceField;
  }

  /**
   * This method initializes totaalCijfersField
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getTotaalCijfersField() {
    if (totaalCijfersField == null) {
      totaalCijfersField = new JTextField();
      totaalCijfersField.setBounds(new Rectangle(152, 393, 53, 32));
      totaalCijfersField.setEditable(false);
    }
    return totaalCijfersField;
  }

  /**
   * This method initializes bonusField
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getBonusField() {
    if (bonusField == null) {
      bonusField = new JTextField();
      bonusField.setBounds(new Rectangle(158, 435, 42, 21));
      bonusField.setEditable(false);
    }
    return bonusField;
  }

  /**
   * This method initializes totaal2Field
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getTotaal2Field() {
    if (totaal2Field == null) {
      totaal2Field = new JTextField();
      totaal2Field.setBounds(new Rectangle(371, 429, 53, 32));
      totaal2Field.setEditable(false);
    }
    return totaal2Field;
  }

  /**
   * This method initializes totaalField
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getTotaalField() {
    if (totaalField == null) {
      totaalField = new JTextField();
      totaalField.setBounds(new Rectangle(220, 477, 61, 32));
      totaalField.setEditable(false);
      totaalField.setFont(new Font("Dialog", Font.PLAIN, 18));
    }
    return totaalField;
  }

  /**
   * This method initializes nieuwSpelButton
   * 
   * @return javax.swing.JButton
   */
  private JButton getNieuwSpelButton() {
    if (nieuwSpelButton == null) {
      nieuwSpelButton = new JButton();
      nieuwSpelButton.setBounds(new Rectangle(98, 528, 203, 40));
      nieuwSpelButton.setText("Nieuw spel");
      nieuwSpelButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          nieuwSpelButtonAction();
        }
      });
    }
    return nieuwSpelButton;
  }

  /**
   * This method initializes werpButtonButton
   * 
   * @return javax.swing.JButton
   */
  private JButton getWerpButtonButton() {
    if (werpButtonButton == null) {
      werpButtonButton = new JButton();
      werpButtonButton.setBounds(new Rectangle(208, 83, 147, 27));
      werpButtonButton.setText("Werp");
      werpButtonButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          werpButtonAction();
        }
      });
    }
    return werpButtonButton;
  }

} // @jve:decl-index=0:visual-constraint="25,36"
