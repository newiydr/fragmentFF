import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ichikawayuki.fragmentff.R;

import java.lang.reflect.Array;

public class Fragment02 extends Fragment {

    private int cnt = 0;

    public static Fragment02 newInstance(int count){
        // Fragemnt02 インスタンス生成
        Fragment02 fragment02 = new Fragment02();

        // Bundleにパラメータを設定
        Bundle barg = new Bundle();
        barg.putInt("Counter", count);
        fragment02.setArguments(barg);

        return fragment02;
    }

    // FragmentのViewを生成して返す
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fragment02,
                container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        if(args != null ){
            int count = args.getInt("Counter");
            String str = "Fragment02: " + String.valueOf(count);
            cnt = count +1;

            TextView textView = view.findViewById(R.id.textview_02);
            textView.setText(str);
        }

        Button button02 = view.findViewById(R.id.button_02);
        button02.setOnClickListener(new View.OnClickListener(){
            public Array Fragment01;

            @Override
            public void onClick(View view){

                FragmentManager fragmentManager = getFragmentManager();
                if(fragmentManager != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    // BackStackを設定
                    fragmentTransaction.addToBackStack(null);

                    fragmentTransaction.replace(R.id.container, Fragment02.newInstance(cnt));
                    fragmentTransaction.commit();
                }
            }
        });

        // BackStackで１つ戻す
        Button pop02 = view.findViewById(R.id.pop_02);
        pop02.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentManager fragmentManager = getFragmentManager();
                if(fragmentManager != null) {
                    fragmentManager.popBackStack();
                }
            }
        });
    }
}
