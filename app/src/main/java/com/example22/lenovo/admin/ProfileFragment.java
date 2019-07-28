package com.example22.lenovo.admin;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    @BindView(R.id.profilName)
    TextView profilName;
    @BindView(R.id.profilEmail)
    TextView profilEmail;
    @BindView(R.id.profilHp)
    TextView profilHp;
    @BindView(R.id.profilBtn)
    Button profilBtn;
    Unbinder unbinder;

    private SessionManager sesi ;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sesi = new SessionManager(getActivity());
        profilEmail.setText("Email :" +sesi.getEmail());
        profilHp.setText("Handphone : " + sesi.getPhone());

        profilName.setText("Nama : " +sesi.getNama());



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.profilBtn)
    public void onViewClicked() {
        sesi.logout();
        startActivity(new Intent(getContext(),LoginActivity.class));
        getActivity().finish();
    }
}