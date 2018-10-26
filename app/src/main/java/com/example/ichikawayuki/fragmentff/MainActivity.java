import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ichikawayuki.fragmentff.Fragment01;
import com.example.ichikawayuki.fragmentff.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // BackStackを設定
            fragmentTransaction.addToBackStack(null);

            // counterをパラメータとして設定
            int count = 0;
            fragmentTransaction.replace(R.id.container, Fragment01.newInstance(count));

            fragmentTransaction.commit();
        }
    }
}