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
import android.widget.Button;
import android.widget.EditText;

import org.pursuit.fragmentinterfacecallbacksappfromscratch.R;

public class InputFragment extends Fragment {

    private FragmentInterface fragmentInterface;

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;

    private Button button;


    public InputFragment() {
        // Required empty public constructor
    }

    public static InputFragment newInstance() {
        InputFragment fragment = new InputFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

//    public void onButtonPressed(Uri uri) {
//        if (fragmentInterface != null) {
//            fragmentInterface.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText1 = view.findViewById(R.id.input_edit_text1);
        editText2 = view.findViewById(R.id.input_edit_text2);
        editText3 = view.findViewById(R.id.input_edit_text3);

        button = view.findViewById(R.id.input_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();
                String text3 = editText3.getText().toString();

                fragmentInterface.onFragmentInteraction(text1, text2, text3);
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            fragmentInterface = (FragmentInterface) context;
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

    public interface FragmentInterface {
        void onFragmentInteraction(String first, String second, String third);
    }
}
