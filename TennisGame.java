
public class TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;
    private String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame(String player1Name, String player2Name)
    {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";

        score = determineTiedScores();
        score = determineDeuce();
        score = p1Love();
        score = p2Love();

        if (P1point > P2point && P1point < 4) {
            P2res = scores[P2point];
            P1res = scores[P1point];
            score = P1res + "-" + P2res;
        }
        if (P2point > P1point && P2point < 4) {
            P2res = scores[P2point];
            P1res = scores[P1point];

            score = P1res + "-" + P2res;
        }
        if (!win().isEmpty()){
            return win();
        }
        if (!advantage().isEmpty())
        {
            return advantage();
        }


        return score;
    }


    public String advantage (){
        if (P1point > P2point && P2point >= 3) {
            return "Advantage player1";
        }
        if (P2point > P1point && P1point >= 3) {
            return "Advantage player2";
        }
        System.out.println(P2point + " " + P1point);
        return "";
    }


    public String win (){
        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            return "Win for player1";
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            return "Win for player2";
        }
        return "";
    }


    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            P1Score();
        }

    }

    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            P2Score();
        }

    }

    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}
