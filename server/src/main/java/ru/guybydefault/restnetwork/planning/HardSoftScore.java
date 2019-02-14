package ru.guybydefault.restnetwork.planning;

public class HardSoftScore implements Comparable<HardSoftScore>, Cloneable {

    private final int hardScore;
    private final int softScore;

    public HardSoftScore(int hardScore, int softScore) {
        this.hardScore = hardScore;
        this.softScore = softScore;
    }

    public HardSoftScore addHard(int s) {
        return new HardSoftScore(hardScore + s, softScore);
    }


    public HardSoftScore addSoft(int s) {
        return new HardSoftScore(hardScore, softScore + s);
    }

    public int getHardScore() {
        return hardScore;
    }

    public int getSoftScore() {
        return softScore;
    }

    @Override
    public Object clone() {
        HardSoftScore copy = null;
        try {
            copy = (HardSoftScore) super.clone();
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError(e);
        }
        return copy;
    }

    @Override
    public int compareTo(HardSoftScore o) {
        if (this.getHardScore() - o.getHardScore() != 0) {
            return this.getHardScore() - o.getHardScore();
        }
        return this.getSoftScore() - o.getSoftScore();
    }

    @Override
    public String toString() {
        return "HardSoftScore{" +
                "hardScore=" + hardScore +
                ", softScore=" + softScore +
                '}';
    }
}
