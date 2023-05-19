package gametheory.snowball.students2022;

import gametheory.snowball.Player;

class AlwaysAttack implements gametheory.snowball.Player {
    /**
     * This class implements always attack explained in details in the report.
     */
    private boolean p2Cheated = false;
    private int timer = 60;
    private boolean shotDone = false;
    private final int whenToShoot;

    /**
     * Constructor
     *
     * @param whenToShootV
     */
    public AlwaysAttack(int whenToShootV) {
        whenToShoot = whenToShootV;
    }

    /**
     * Reset the agent variables before the match
     */
    @Override
    public void reset() {
        p2Cheated = false;
        timer = 60;
    }

    /**
     * returning the number of snowballs the agent will shoot
     * to the opponent’s field given the last opponent’s shot to the agent's field
     * and the number of minutes passed after the agent's previous shot
     *
     * @param opponentLastShotToYourField
     * @param snowballNumber
     * @param minutesPassedAfterYourShot
     * @return
     */
    @Override
    public int shootToOpponentField(int opponentLastShotToYourField, int snowballNumber, int minutesPassedAfterYourShot) {
        shotDone = false;
        int maxBalls = maxSnowballsPerMinute(minutesPassedAfterYourShot);
        if (minutesPassedAfterYourShot >= whenToShoot) // cheating on the last step
        {
            shotDone = true;
            return Math.min(maxBalls, snowballNumber);
        }
        return 0;
    }

    /**
     * This agent will always attack so it will not send any balls to hot field
     *
     * @param opponentLastShotToYourField
     * @param snowballNumber
     * @param minutesPassedAfterYourShot
     * @return
     */
    @Override
    public int shootToHotField(int opponentLastShotToYourField, int snowballNumber, int minutesPassedAfterYourShot) {
        return 0;
    }

    /**
     * Returns my email
     *
     * @return
     */
    @Override
    public String getEmail() {
        return "m.abdelhamid@innopolis.university";
    }

    /**
     * Returns the maximum number of snowballs which can be shot
     * by a player per minute based on the number of minutes passed
     * after the previous shot
     *
     * @param minutesPassedAfterYourShot
     * @return
     */
    @Override
    public int maxSnowballsPerMinute(int minutesPassedAfterYourShot) {
        return Player.super.maxSnowballsPerMinute(minutesPassedAfterYourShot);
    }
}

class RandomAgent implements gametheory.snowball.Player {
    /**
     * This class implements Random strategy explained in details in the report.
     */
    private boolean p2Cheated = false;
    private int timer = 60;
    private boolean shotDone = false;
    private int whenToShoot;

    /**
     * Reset the agent variables before the match
     */
    @Override
    public void reset() {
        p2Cheated = false;
        timer = 60;
    }

    /**
     * Shoots at random times to opponent
     *
     * @param opponentLastShotToYourField
     * @param snowballNumber
     * @param minutesPassedAfterYourShot
     * @return
     */
    @Override
    public int shootToOpponentField(int opponentLastShotToYourField, int snowballNumber, int minutesPassedAfterYourShot) {
        shotDone = false;
        int maxBalls = maxSnowballsPerMinute(minutesPassedAfterYourShot);
        int random_int = (int) Math.floor(Math.random() * (10 - 1 + 1) + 1);
        if (random_int >= 5) {
            shotDone = true;
            return Math.min(maxBalls, snowballNumber);
        }
        return 0;
    }

    /**
     * Randomly shot to the hot field
     *
     * @param opponentLastShotToYourField
     * @param snowballNumber
     * @param minutesPassedAfterYourShot
     * @return
     */
    @Override
    public int shootToHotField(int opponentLastShotToYourField, int snowballNumber, int minutesPassedAfterYourShot) {
        if (!shotDone) {
            int maxBalls = maxSnowballsPerMinute(minutesPassedAfterYourShot);
            int random_int = (int) Math.floor(Math.random() * (10 - 1 + 1) + 1);
            if (random_int >= 5) {
                shotDone = true;
                return Math.min(maxBalls, snowballNumber);
            }
        }
        return 0;
    }

    /**
     * Returns my email
     *
     * @return
     */
    @Override
    public String getEmail() {
        return "m.abdelhamid@innopolis.university";
    }

    /**
     * Returns the maximum number of snowballs which can be shot
     * by a player per minute based on the number of minutes passed
     * after the previous shot
     *
     * @param minutesPassedAfterYourShot
     * @return
     */
    @Override
    public int maxSnowballsPerMinute(int minutesPassedAfterYourShot) {
        return Player.super.maxSnowballsPerMinute(minutesPassedAfterYourShot);
    }
}

class CooperativeAgent implements gametheory.snowball.Player {
    /**
     * This class implements the always cooperate strategy explained in details in the report.
     */
    private boolean p2Cheated = false;
    private int timer = 60;
    private final boolean shotDone = false;
    private int whenToShoot;

    /**
     * Reset the agent variables before the match
     */
    @Override
    public void reset() {
        p2Cheated = false;
        timer = 60;
    }

    /**
     * It will never shoot the opponent
     *
     * @param opponentLastShotToYourField
     * @param snowballNumber
     * @param minutesPassedAfterYourShot
     * @return
     */
    @Override
    public int shootToOpponentField(int opponentLastShotToYourField, int snowballNumber, int minutesPassedAfterYourShot) {
        return 0;
    }

    /**
     * Shoot to the hot field every 4 minutes
     *
     * @param opponentLastShotToYourField
     * @param snowballNumber
     * @param minutesPassedAfterYourShot
     * @return
     */
    @Override
    public int shootToHotField(int opponentLastShotToYourField, int snowballNumber, int minutesPassedAfterYourShot) {
        if (minutesPassedAfterYourShot >= 4) {
            int maxBalls = maxSnowballsPerMinute(minutesPassedAfterYourShot);
            return Math.min(maxBalls, snowballNumber);
        }
        return 0;
    }

    /**
     * Returns my email
     *
     * @return
     */
    @Override
    public String getEmail() {
        return "m.abdelhamid@innopolis.university";
    }

    /**
     * Returns the maximum number of snowballs which can be shot
     * by a player per minute based on the number of minutes passed
     * after the previous shot
     *
     * @param minutesPassedAfterYourShot
     * @return
     */
    @Override
    public int maxSnowballsPerMinute(int minutesPassedAfterYourShot) {
        return Player.super.maxSnowballsPerMinute(minutesPassedAfterYourShot);
    }
}

class Copycat implements gametheory.snowball.Player {
    /**
     * This class implements the copycat strategy explained in details in the report.
     */
    private boolean p2Cheated = false;
    private int timer = 60;
    private boolean shotDone = false;

    /**
     * Reset the agent variables before the match
     */
    @Override
    public void reset() {
        p2Cheated = false;
        timer = 60;
    }

    /**
     * Returns the number of snowballs the agent will shoot
     * to the opponent’s field given the last opponent’s shot to the agent's field
     * and the number of minutes passed after the agent's previous shot
     *
     * @param opponentLastShotToYourField
     * @param snowballNumber
     * @param minutesPassedAfterYourShot
     * @return
     */
    @Override
    public int shootToOpponentField(int opponentLastShotToYourField, int snowballNumber, int minutesPassedAfterYourShot) {
        shotDone = false;
        int maxBalls = maxSnowballsPerMinute(minutesPassedAfterYourShot);
        if (opponentLastShotToYourField > 0) // opponent cheated
        {
            p2Cheated = true;
        }

        if (p2Cheated && minutesPassedAfterYourShot >= 4) {
            p2Cheated = false; // forgiving him for the next episode
            shotDone = true;
            timer -= 4;
            return Math.min(maxBalls, snowballNumber);
        }
        return 0;
    }

    /**
     * Returning the number of snowballs the agent will shoot to the
     * hot field given the last opponent's shot to his field, and the
     * number of minutes passed after the agent's previous shot
     *
     * @param opponentLastShotToYourField
     * @param snowballNumber
     * @param minutesPassedAfterYourShot
     * @return
     */
    @Override
    public int shootToHotField(int opponentLastShotToYourField, int snowballNumber, int minutesPassedAfterYourShot) {
        if (!p2Cheated && minutesPassedAfterYourShot >= 4 && !shotDone) {
            timer -= 4;
            shotDone = true;
            int maxBalls = maxSnowballsPerMinute(minutesPassedAfterYourShot);
            return Math.min(maxBalls, snowballNumber);
        }
        return 0;
    }

    /**
     * Returns my email
     *
     * @return
     */
    @Override
    public String getEmail() {
        return "m.abdelhamid@innopolis.university";
    }

    /**
     * Returns the maximum number of snowballs which can be shot
     * by a player per minute based on the number of minutes passed
     * after the previous shot
     *
     * @param minutesPassedAfterYourShot
     * @return
     */
    @Override
    public int maxSnowballsPerMinute(int minutesPassedAfterYourShot) {
        return Player.super.maxSnowballsPerMinute(minutesPassedAfterYourShot);
    }
}

class Grouch implements gametheory.snowball.Player {
    /**
     * This class implements the grouch strategy explained in details in the report.
     */
    private boolean p2Cheated = false;
    private int timer = 60;
    private boolean shotDone = false;

    /**
     * Reset the agent variables before the match
     */
    @Override
    public void reset() {
        p2Cheated = false;
        timer = 60;
    }

    /**
     * Returns the number of snowballs the agent will shoot
     * to the opponent’s field given the last opponent’s shot to the agent's field
     * and the number of minutes passed after the agent's previous shot
     *
     * @param opponentLastShotToYourField
     * @param snowballNumber
     * @param minutesPassedAfterYourShot
     * @return
     */
    @Override
    public int shootToOpponentField(int opponentLastShotToYourField, int snowballNumber, int minutesPassedAfterYourShot) {
        shotDone = false;
        int maxBalls = maxSnowballsPerMinute(minutesPassedAfterYourShot);
        if (opponentLastShotToYourField > 0) // opponent cheated
        {
            p2Cheated = true;
        }

        if (p2Cheated && minutesPassedAfterYourShot >= 4) {
            shotDone = true;
            timer -= 4;
            return Math.min(maxBalls, snowballNumber);
        }
        return 0;
    }

    /**
     * Returning the number of snowballs the agent will shoot to the
     * hot field given the last opponent's shot to his field, and the
     * number of minutes passed after the agent's previous shot
     *
     * @param opponentLastShotToYourField
     * @param snowballNumber
     * @param minutesPassedAfterYourShot
     * @return
     */
    @Override
    public int shootToHotField(int opponentLastShotToYourField, int snowballNumber, int minutesPassedAfterYourShot) {
        if (!p2Cheated && minutesPassedAfterYourShot >= 4 && !shotDone) {
            timer -= 4;
            shotDone = true;
            int maxBalls = maxSnowballsPerMinute(minutesPassedAfterYourShot);
            return Math.min(maxBalls, snowballNumber);
        }
        return 0;
    }

    /**
     * Returns my email
     *
     * @return
     */
    @Override
    public String getEmail() {
        return "m.abdelhamid@innopolis.university";
    }

    /**
     * Returns the maximum number of snowballs which can be shot
     * by a player per minute based on the number of minutes passed
     * after the previous shot
     *
     * @param minutesPassedAfterYourShot
     * @return
     */
    @Override
    public int maxSnowballsPerMinute(int minutesPassedAfterYourShot) {
        return Player.super.maxSnowballsPerMinute(minutesPassedAfterYourShot);
    }
}

public class MohamedAbdelhamidTesting {
    public static void main(String[] args) {
        MohamedAbdelhamidCode player1 = new MohamedAbdelhamidCode();
        MohamedAbdelhamidCode player2 = new MohamedAbdelhamidCode();
        playTournament(player1, player2);
    }

    /**
     * Let player 1 and player 2 play for 10 matches and take the average
     * of the results
     *
     * @param player1
     * @param player2
     */
    public static void playTournament(Player player1, Player player2) {
        int player1Score = 0;
        int player2Score = 0;

        for (int j = 0; j < 10; j++) {
            int opponentLastShotToYourFieldP1ToP2 = 0;
            int opponentLastShotToYourFieldP2ToP1 = 0;
            int minutesPassedAfterYourShotP1 = 0;
            int minutesPassedAfterYourShotP2 = 0;
            int snowballNumberP1 = 100;
            int snowballNumberP2 = 100;
            player1.reset(); // resetting the players before each match
            player2.reset();
            for (int i = 1; i <= 60; i++) {
                int p1_shoot_p2 = player1.shootToOpponentField(opponentLastShotToYourFieldP2ToP1, snowballNumberP1, minutesPassedAfterYourShotP1);
                int p2_shoot_p1 = player2.shootToOpponentField(opponentLastShotToYourFieldP1ToP2, snowballNumberP2, minutesPassedAfterYourShotP2);

                int p1_shoot_hotfield = player1.shootToHotField(opponentLastShotToYourFieldP2ToP1, snowballNumberP1, minutesPassedAfterYourShotP1);
                int p2_shoot_hotfield = player2.shootToHotField(opponentLastShotToYourFieldP1ToP2, snowballNumberP2, minutesPassedAfterYourShotP2);

                opponentLastShotToYourFieldP2ToP1 = p2_shoot_p1;
                opponentLastShotToYourFieldP1ToP2 = p1_shoot_p2;

                if (p1_shoot_hotfield + p1_shoot_p2 == 0) {
                    minutesPassedAfterYourShotP1 += 1;
                } else {
                    minutesPassedAfterYourShotP1 = 1;
                }

                if (p2_shoot_hotfield + p2_shoot_p1 == 0) {
                    minutesPassedAfterYourShotP2 += 1;
                } else {
                    minutesPassedAfterYourShotP2 = 1;
                }

                snowballNumberP1 += p2_shoot_p1;
                snowballNumberP1 -= (p1_shoot_hotfield + p1_shoot_p2);

                snowballNumberP2 += p1_shoot_p2;
                snowballNumberP2 -= (p2_shoot_hotfield + p2_shoot_p1);

                snowballNumberP1 += 1;
                snowballNumberP2 += 1;

            }
            player1Score += snowballNumberP1;
            player2Score += snowballNumberP2;
        }
        player1Score = player1Score / 10;
        player2Score = player2Score / 10;
        System.out.println("Player 1 achieved score of " + player1Score + " against Player 2");
        System.out.println("Player 1 achieved score of " + player2Score + " against Player 2");
        System.out.println();
    }
}
