package com.example.freebieticket.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.freebieticket.Admin.Admin.AdminMainActivity;
import com.example.freebieticket.MainActivity;
import com.example.freebieticket.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LogInFragment extends Fragment {
    View view;
    TextView CreateAnAccount,LoginBtn,Forget;
    EditText Email,Password;
    FirebaseAuth Mauth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_log_in, container, false);
        InisializationOfFields();



        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNotEmpty()){
                    isSaveInDB();
                }
            }
        });
        CreateAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                        .replace(R.id.LogInOutfragment_container, new SignUpFragment())
                        .addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
    private void InisializationOfFields(){
        Forget = view.findViewById(R.id.ForgetPassword);
        Email = view.findViewById(R.id.EmailInPut);
        Password = view.findViewById(R.id.PasswordInPut);
        Mauth = FirebaseAuth.getInstance();
        CreateAnAccount = view.findViewById(R.id.CreateAnAccount);
        LoginBtn = view.findViewById(R.id.LoginBtn);

    }
    private boolean isNotEmpty(){
        if (Email.getText().toString().isEmpty()){
            Toast.makeText(getActivity(), "Enter your email", Toast.LENGTH_SHORT).show();
            return false;
        }else if (Password.getText().toString().isEmpty()){
            Toast.makeText(getActivity(), "Enter your password", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }
    private void isSaveInDB(){
        String my_email = Email.getText().toString();
        String pwd = Password.getText().toString();
        Mauth.signInWithEmailAndPassword(my_email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    if (my_email.equals("freebieTicket@admin.com")){
                        Intent i = new Intent(getActivity(), AdminMainActivity.class);
                        startActivity(i);
                        getActivity().finish();
                    }else {
                        Intent i = new Intent(getActivity(), MainActivity.class);
                        startActivity(i);
                        getActivity().finish();
                    }

                }else {
                    Toast.makeText(getActivity(), task.getException().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}