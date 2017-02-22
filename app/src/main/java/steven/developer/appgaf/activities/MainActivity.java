package steven.developer.appgaf.activities;

import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import steven.developer.appgaf.R;
import steven.developer.appgaf.fragments.DialogAdd;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private Button mBtnAdd;
    private View.OnClickListener mBtnAddListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showDialogAdd();
        }
    };

    private void showDialogAdd() {
        DialogAdd dialogAdd = new DialogAdd();
        dialogAdd.show(getSupportFragmentManager(), "Add");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        initComponents();
    }

    private void initComponents() {
        ImageView background = (ImageView) findViewById(R.id.iv_background);
        Glide.with(mContext)
                .load(R.drawable.background)
                .centerCrop()
                .into(background);

        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mBtnAdd.setOnClickListener(mBtnAddListener);
    }
}
