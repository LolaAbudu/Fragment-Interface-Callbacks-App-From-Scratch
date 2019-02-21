package org.pursuit.fragmentinterfacecallbacksappfromscratch.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.pursuit.fragmentinterfacecallbacksappfromscratch.R;

public class DisplayFragment extends Fragment {

    private static final String TEXT1_KEY = "text1";
    private static final String TEXT2_KEY = "text2";
    private static final String TEXT3_KEY = "text3";

    // TODO: Rename and change types of parameters
    private String text1;
    private String text2;
    private String text3;

    private InputFragment.FragmentInterface fragmentInterface;

    private TextView displayTextView;

    public DisplayFragment() {
        // Required empty public constructor
    }

    public static DisplayFragment newInstance(String text1, String text2, String text3) {
        DisplayFragment fragment = new DisplayFragment();
        Bundle args = new Bundle();
        args.putString(TEXT1_KEY, text1);
        args.putString(TEXT2_KEY, text2);
        args.putString(TEXT3_KEY, text3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            text1 = getArguments().getString(TEXT1_KEY);
            text2 = getArguments().getString(TEXT2_KEY);
            text3 = getArguments().getString(TEXT3_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        displayTextView = view.findViewById(R.id.display_textView);
        displayTextView.setText(getString(R.string.display_string, text1, text2, text3));

        //OR do below with concatenating the strings
        //String conctenatedTexts = text1 + text2 + text3;
        //displayTextView.setText(conctenatedTexts);


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof InputFragment.FragmentInterface) {
            fragmentInterface = (InputFragment.FragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentInterface = null;
    }

}
