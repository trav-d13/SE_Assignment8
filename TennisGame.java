/**
 * Identify 3 code smells in this code
 *      - Long method
 *         --> extract method
 *              * We grouped code fragments together and moved them to separate methods
 *              * win() and advantage() and tie() and scoring(int points)
 *         --> decompose conditional
 *              * We replaced complex conditionals statements by less complicated ones
 *                and replaced the if part by method calls.
 *              * We used this approach in the case of win() and advantage() and tie()
 *      - Duplicate code
 *          --> extract method
 *              * We grouped together the code duplication that occurred in the original if statements
 *                of the getScore() method into scoring(int points) and replaced this inside the method.
 *
 */
public class TennisGame {
    private int P1point = 0;        //TODO make these private ?
    private int P2point = 0;        //TODO make these private ?

    public String P1res = "";       //TODO DELETE
    public String P2res = "";       //TODO DELETE
    private String player1Name;
    private String player2Name;
    final private String[] SCORES = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = scoring(P1point) + "-" + scoring(P2point);       //duplicate code

        if (P1point == P2point) {    // decompose conditional
            score = tie(P1point);
        }

        if (!win().isEmpty()){          // decompose conditional
            return win();
        }
        if (!advantage().isEmpty()) {    // decompose conditional
            return advantage();
        }
        return score;
    }

    // extract method
    public String scoring(int points){
        if (points > 3){
            return "";
        }else{
            return SCORES[points];
        }
    }

    // extract method
    public String advantage(){
        if (P1point > P2point && P2point >= 3) {
            return "Advantage player1";
        }
        if (P2point > P1point && P1point >= 3) {
            return "Advantage player2";
        }
        return "";
    }

    // extract method
    public String tie(int points){
        if(points < 3){
            return scoring(P1point) + "-All";
        }else{
            return "Deuce";
        }
    }

    // extract method
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
