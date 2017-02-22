package steven.developer.appgaf.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import steven.developer.appgaf.R;
import steven.developer.appgaf.models.Goal;

/**
 * Created by Steven on 19/02/2017.
 */

public class DialogAdd extends DialogFragment {

    private ImageButton mBtnClose;
    private EditText mInputGoal;
    private DatePicker mPicker;
    private Button mBtnAddGoal;

    private View.OnClickListener mBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.btn_add_goal:
                    addAction();
                    break;
            }
            dismiss();
        }
    };

    //TODO process data
    private void addAction() {
        Toast.makeText(getActivity(), "entra", Toast.LENGTH_SHORT).show();
        String goal = mInputGoal.getText().toString();
        long now = System.currentTimeMillis();

        Goal goalModel = new Goal(goal, now, 0, false);

        // Configurando la bd
        RealmConfiguration configuration = new RealmConfiguration.Builder(getActivity()).build();
        Realm.setDefaultConfiguration(configuration);

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealm(goalModel);
        realm.commitTransaction();
        realm.close();
    }

    public DialogAdd() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_add, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBtnClose = (ImageButton) view.findViewById(R.id.btn_close);
        mInputGoal = (EditText) view.findViewById(R.id.et_goal);
        mPicker = (DatePicker) view.findViewById(R.id.bpv_date);
        mBtnAddGoal = (Button) view.findViewById(R.id.btn_add_goal);

        mBtnClose.setOnClickListener(mBtnClickListener);
        mBtnAddGoal.setOnClickListener(mBtnClickListener);
    }
}
