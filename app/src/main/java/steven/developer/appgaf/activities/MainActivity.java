package steven.developer.appgaf.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import steven.developer.appgaf.R;
import steven.developer.appgaf.adapters.AdapterGoals;
import steven.developer.appgaf.fragments.DialogAdd;
import steven.developer.appgaf.models.Goal;
import steven.developer.appgaf.widgets.BucketRecyclerView;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private Button mBtnAdd;
    private View.OnClickListener mBtnAddListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showDialogAdd();
        }
    };

    private View mEmptyView;

    private Toolbar mToolbar;
    private BucketRecyclerView mRecycler;
    private AdapterGoals mAdapter;

    RealmResults<Goal> mResults;

    private Realm mRealm;
    private RealmChangeListener mChangeListener = new RealmChangeListener() {
        @Override
        public void onChange() {
            mAdapter.setUpList(mResults);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        initComponents();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mRealm.addChangeListener(mChangeListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mRealm.removeChangeListener(mChangeListener);
    }

    private void initComponents() {
        ImageView background = (ImageView) findViewById(R.id.iv_background);
        Glide.with(mContext)
                .load(R.drawable.background)
                .centerCrop()
                .into(background);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mEmptyView = findViewById(R.id.empty_drops);

        mRealm = Realm.getDefaultInstance();
        mResults = mRealm.where(Goal.class).findAllAsync();

        mRecycler = (BucketRecyclerView) findViewById(R.id.rv_goals);

        mRecycler.hideIfEmpty(mToolbar);
        mRecycler.showIfEmpty(mEmptyView);

        mAdapter = new AdapterGoals(mContext);
        mAdapter.setUpList(mResults);
        mRecycler.setAdapter(mAdapter);

        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mBtnAdd.setOnClickListener(mBtnAddListener);
    }

    private void showDialogAdd() {
        DialogAdd dialogAdd = new DialogAdd();
        dialogAdd.show(getSupportFragmentManager(), "Add");
    }
}
