public class User {
    int rank;
    int progress;

    public User() {
        this.rank = -8;
        this.progress = 0;
    }

    public int getRank() {
        return rank;
    }

    public int getProgress() {
        return progress;
    }

    private int calculateProgress(int activityRank) {
        if (activityRank < -8 || activityRank > 8 || activityRank == 0) {
            throw new IllegalArgumentException("Invalid activity rank");
        }

        if (rank == 8) {
            return 0;
        }

        int rankDiff = activityRank - rank;

        if (rank < 0 && activityRank > 0) rankDiff--;
        else if (rank > 0 && activityRank < 0) rankDiff++;

        if (rankDiff == 0) return 3;
        if (rankDiff == -1) return 1;
        if (rankDiff < -1) return 0;
        return 10 * rankDiff * rankDiff;
    }

    public void incProgress(int activityRank) {
        int progressPoints = calculateProgress(activityRank);

        progress += progressPoints;
        while (progress >= 100) {
            progress -= 100;
            if (rank < 0 && rank + 1 == 0) rank = 1;
            else if (rank < 8) rank++;
            if (rank == 8) progress = 0; 
        }
    }
}
