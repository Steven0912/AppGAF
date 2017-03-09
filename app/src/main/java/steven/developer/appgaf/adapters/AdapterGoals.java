package steven.developer.appgaf.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.RealmResults;
import steven.developer.appgaf.R;
import steven.developer.appgaf.models.Goal;

/**
 * Created by DESARROLLO HAPPY INC on 22/02/2017.
 */

public class AdapterGoals extends RecyclerView.Adapter<AdapterGoals.GoalHolder> {

    private LayoutInflater mInflater;
    private RealmResults<Goal> mListGoals;

    public AdapterGoals(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public void setUpList(RealmResults<Goal> listGoals) {
        mListGoals = listGoals;
        notifyDataSetChanged();
    }

    @Override
    public GoalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_goal, parent, false);
        return new GoalHolder(view);
    }

    @Override
    public void onBindViewHolder(GoalHolder holder, int position) {
        Goal current = mListGoals.get(position);
        holder.mLbls[0].setText(current.getGoal());
    }

    @Override
    public int getItemCount() {
        return mListGoals.size();
    }

    public class GoalHolder extends RecyclerView.ViewHolder {

        private TextView[] mLbls = new TextView[2];

        public GoalHolder(View itemView) {
            super(itemView);
            mLbls[0] = (TextView) itemView.findViewById(R.id.tv_goal);
            mLbls[1] = (TextView) itemView.findViewById(R.id.tv_when);
        }
    }
}
