package com.example.project7_2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CustomDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CustomDialogFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CustomDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CustomDialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CustomDialogFragment newInstance(String param1, String param2) {
        CustomDialogFragment fragment = new CustomDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    TextView tvName, tvEmail, toastText;
    Button btnDialog;
    EditText dlgName, dlgEmail;
    View dialogView, toastView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_custom_dialog, container, false);

        tvName = rootview.findViewById(R.id.tvName);
        tvEmail = rootview.findViewById(R.id.tvEmail);

        btnDialog = rootview.findViewById(R.id.btn_custom_Dialog);

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                dialogView = View.inflate(getActivity(), R.layout.dialog1, null);
                dlgName = (EditText) dialogView.findViewById(R.id.dlgName);
                dlgEmail = (EditText) dialogView.findViewById(R.id.dlgEmail);

                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle("사용자 정보입력");
                dialog.setIcon(R.drawable.icon_custom_dialog);
                dialog.setView(dialogView);
                dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvName.setText(dlgName.getText().toString());
                        tvEmail.setText(dlgEmail.getText().toString());
                    }
                });
                dialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(getActivity());
                        toastView = View.inflate(getActivity(),R.layout.toast1,null);
                        toastText = (TextView) toastView.findViewById(R.id.toastText);
                        toastText.setText("취소했습니다.");
                        toast.setView(toastView);
                        toast.show();
                    }
                });
                dialog.show();
            }
        });

        return rootview;
    }
}