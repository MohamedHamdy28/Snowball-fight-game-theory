package gametheory.snowball.students2022;

import gametheory.snowball.Player;

public class MohamedAbdelhamidCode implements gametheory.snowball.Player {
    /**
     * This class implements my strategy explained in details in the report.
     */
    private boolean p2Cheated = false; // to know if the other player cheated or attacked
    private int timer = 60; // Timer for the 60 rounds
    private boolean shotDone = false; // To know if it shot in this round or not yet

    /**
     * reset the agent variables before the match
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
        if (timer == 4 && minutesPassedAfterYourShot >= 3) // cheating on the last step
        {
            shotDone = true;
            return Math.min(maxBalls, snowballNumber);
        }

        if (opponentLastShotToYourField > 0) // opponent cheated
        {
            p2Cheated = true;
        }

        if (p2Cheated && minutesPassedAfterYourShot >= 4) // always attacking the other player if he cheated once
        {
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
