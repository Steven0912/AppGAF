package steven.developer.appgaf.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by DESARROLLO HAPPY INC on 22/02/2017.
 */

public class Goal extends RealmObject {
    private String goal;
    @PrimaryKey
    private long added;
    private long when;
    private boolean completed;

    public Goal(String goal, long added, long when, boolean completed) {
        this.goal = goal;
        this.added = added;
        this.when = when;
        this.completed = completed;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public long getAdded() {
        return added;
    }

    public void setAdded(long added) {
        this.added = added;
    }

    public long getWhen() {
        return when;
    }

    public void setWhen(long when) {
        this.when = when;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
