package net.awpspace.nestedfragmentdemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.awpspace.nestedfragmentdemo.R;
import net.awpspace.nestedfragmentdemo.WorkerActivity;

/**
 * A simple {@link Fragment} subclass.
 */

public class LevelOneFragment extends Fragment {

    private Button mBtnTest;

    public LevelOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level_one, container, false);
        mBtnTest = (Button) view.findViewById(R.id.fragment_level_one_btn_test);

        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("haint", "fragment level one Test");
                startActivityForResult(new Intent(getActivity(), WorkerActivity.class), 111);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        Log.d("haint", "onActivityResult in fragment Level one: request code = " + requestCode);
    }
}
