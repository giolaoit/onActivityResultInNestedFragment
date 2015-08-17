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
import net.awpspace.nestedfragmentdemo.eventbus.ActivityResultEvent;

import de.greenrobot.event.EventBus;

/**
 * A simple {@link Fragment} subclass.
 */
public class LevelTwoFragment extends Fragment {

    private Button mBtnTest;

    public LevelTwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_level_two, container, false);
        mBtnTest = (Button) view.findViewById(R.id.fragment_level_two_btn_test);

        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("haint", "fragment level two Test");
                getActivity().startActivityForResult(new Intent(getActivity(), WorkerActivity.class), 222);
            }
        });

        EventBus.getDefault().register(this);

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("haint", "onActivityResult in fragment Level two: request code = " + requestCode);
    }

    public void onEvent(ActivityResultEvent event) {
        Log.d("haint", "Message from MainActivity via EvenBus: request code = " + event.getRequestCode());
    }

    ;
}
