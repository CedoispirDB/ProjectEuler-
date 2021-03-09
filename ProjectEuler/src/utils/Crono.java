package utils;

public class Crono {

    private long startTime;
    private long lastLapDuration;
    private long lastLapTime;

    public Crono(){
        startTime = System.currentTimeMillis();
        lastLapDuration = 0;
        lastLapTime = 0;
    }

    public long getStartTime () {
        return  startTime;
    }

    public long elapsed(){
        return (System.currentTimeMillis() - startTime);
    }

    public long elapsedMins(){
        return Math.round(elapsed() / 60000);
    }

    public void lap() {
        lastLapTime = System.currentTimeMillis();
    }

    public long getLastLapDuration() {
        long lastLapDuration;

        if (lastLapTime == 0 ) {
            lastLapDuration = (System.currentTimeMillis() - startTime);
        } else {
            lastLapDuration = (System.currentTimeMillis() - lastLapTime);
        }

        return lastLapDuration;
    }
}
