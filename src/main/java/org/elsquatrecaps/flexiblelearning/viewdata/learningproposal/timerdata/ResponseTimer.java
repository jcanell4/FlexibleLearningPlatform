package org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.timerdata;

/**
 *
 * @author josep
 */
public class ResponseTimer {
    private CallableJavascript onReciveCallable=null;
    private Timer nextTimer=null;

    public ResponseTimer() {
    }

    public ResponseTimer(CallableJavascript onReciveCallable) {
        this.onReciveCallable = onReciveCallable;
    }
    
    public ResponseTimer(Timer nextTimer) {
        this.nextTimer = nextTimer;
    }
    
    public ResponseTimer(CallableJavascript onReciveCallable, Timer nextTimer) {
        this.onReciveCallable = onReciveCallable;
        this.nextTimer = nextTimer;
    }
    
    /**
     * @return the onReciveCallable
     */
    public CallableJavascript getOnReciveCallable() {
        return onReciveCallable;
    }

    /**
     * @param onReciveCallable the onReciveCallable to set
     */
    public void setOnReciveCallable(CallableJavascript onReciveCallable) {
        this.onReciveCallable = onReciveCallable;
    }

    /**
     * @return the nextTimer
     */
    public Timer getNextTimer() {
        return nextTimer;
    }

    /**
     * @param nextTimer the nextTimer to set
     */
    public void setNextTimer(Timer nextTimer) {
        this.nextTimer = nextTimer;
    }
}
