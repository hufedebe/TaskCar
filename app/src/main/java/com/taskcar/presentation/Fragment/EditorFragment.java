package com.taskcar.presentation.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.taskcar.R;

/**
 * Created by Hudeya on 28/09/2017.
 */

public class EditorFragment extends Fragment {
    private static final String KEY_POSITION="position";

    public static EditorFragment newInstance(int position) {
        EditorFragment frag=new EditorFragment();
        Bundle args=new Bundle();

        args.putInt(KEY_POSITION, position);
        frag.setArguments(args);

        return(frag);
    }

    public static String getTitle(Context ctxt, int position) {
        return(String.format(ctxt.getString(R.string.hint), position + 1));
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.activity_custom_swip_talleres, container, false);
        EditText editor=(EditText)result.findViewById(R.id.taller_id);
        int position=getArguments().getInt(KEY_POSITION, -1);

        editor.setHint(getTitle(getActivity(), position));

        return(result);
    }
}
