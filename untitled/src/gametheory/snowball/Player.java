package gametheory.snowball;

public interface Player {
    void reset();
    int shootToOpponentField(int opponentLastShotToYourField, int
            snowballNumber, int minutesPassedAfterYourShot);
    int shootToHotField(int opponentLastShotToYourField, int snowballNumber,
                        int minutesPassedAfterYourShot);
    String getEmail();
    default int maxSnowballsPerMinute(int minutesPassedAfterYourShot) {
        double exp = Math.exp(minutesPassedAfterYourShot);
        return (int) (15 * exp / (15 + exp));
    }
}
