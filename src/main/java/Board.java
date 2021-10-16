

public class Board{
        public String [] boardMatrix;
        public String [] myChoices;
        public int currentTurn;
        public Board () {
            this.boardMatrix  = new String [9];
            this.myChoices    = new String [] {"O", "X"};
            this.currentTurn  = 0;
        }
        public void getNextTurn (){}


    public String[] CheckIfAnybodyWon(String[] pParameter) {

        //  Check first all board for any strike of player X
        //  and then all board again for any strike of player O

        for (String player : new String [] {"X","O"}) {

            /* Verticals possible strikes: n,0->2: Cn,Cn+3,Cn+6  (columns)
            { 0,   1,   2,
              3,   4,   5,           cols =  [0,3,6],[1,4,7],[2,5,8]
              6,   7,   8 }
             */

            for (int i = 0; i < 3; i++) { // i for each vertical (verticals 0,1 and 2)
                if ((pParameter[i]).equals(player) &&
                        (pParameter[i + 3]).equals(player) &&
                        (pParameter[i + 6]).equals(player)) {

                    return new String[]{ "Winner player: "+player+ " - Strike: Vertical " + i };

                }
            }

            /* Horizontals possible strikes: n,0->2: Rn,Rn+1,Rn+2  (rows)
            { 0,   1,   2,
              3,   4,   5,           rows =  [0,1,2],[3,4,5],[6,7,8]
              6,   7,   8 }
             */

            for (int i = 0; i < 9; i=i+3) { //horizontals jumps by 3
                if ((pParameter[i]).equals(player) &&
                        (pParameter[i + 1]).equals(player) &&
                        (pParameter[i + 2]).equals(player)) {

                    return new String[]{ "Winner player: "+player+ " - Strike: Horizontal " + i/3 };

                }
            }

            /* Diagonals possible strikes:
            Diagonal 0   possible strike: Do,Do+4,Do+8
            Diagonal 1   possible strike: D1,D1+2,D1+4
            { 0,   1,   2,
              3,   4,   5,           diagonals =  [0,4,8],[2,4,6]
              6,   7,   8 }
             */

            if     ((pParameter[0]).equals(player) &&
                    (pParameter[4]).equals(player) &&
                    (pParameter[8]).equals(player)) {

                return new String[]{"Winner player: "+player+ " - Strike: Diagonal 0"};

            }else if ((pParameter[2]).equals(player) &&
                    (pParameter[4]).equals(player) &&
                    (pParameter[6]).equals(player)) {

                return new String[]{"Winner player: "+player+ " - Strike: Diagonal 1"};
            }
        }
        return new String[]{"OHHHHHH....NOBODY WON"}; //Nobody won !
    }

}
