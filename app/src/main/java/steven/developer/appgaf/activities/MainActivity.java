package steven.developer.appgaf.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import steven.developer.appgaf.R;

public class MainActivity extends AppCompatActivity {

    public Context mContext;

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
    }
}
