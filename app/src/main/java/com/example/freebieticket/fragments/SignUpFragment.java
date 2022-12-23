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
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.freebieticket.MainActivity;
import com.example.freebieticket.Model.User;
import com.example.freebieticket.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpFragment extends Fragment {
    View view;
    ImageView SignUpBackBtn;
    EditText Name,SecondName,Email,Password;
    TextView Signup_btn;
    FirebaseAuth Mauth;
    DatabaseReference Ref_user;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        InisializationOfFields();
        SignUpBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();

            }
        });
        Signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNotEmpty()){
                    createAnAccount();
                }
            }
        });
        return view;
    }
    private void InisializationOfFields(){
        Name = view.findViewById(R.id.NameInPut);
        SecondName = view.findViewById(R.id.SecondNameInPut);
        Signup_btn = view.findViewById(R.id.SignInBtn);
        Email = view.findViewById(R.id.EmailInPut);
        Password = view.findViewById(R.id.PasswordInPut);
        SignUpBackBtn = view.findViewById(R.id.SignUpBackBtn);
        Mauth = FirebaseAuth.getInstance();
        Ref_user = FirebaseDatabase.getInstance(getString(R.string.DBURL)).getReference().child("Users");
    }
    private boolean isNotEmpty(){
        if (Email.getText().toString().isEmpty()){
            Toast.makeText(getActivity(), "Enter your email", Toast.LENGTH_SHORT).show();
            return false;
        }else if (Password.getText().toString().isEmpty()){
            Toast.makeText(getActivity(), "Enter your password", Toast.LENGTH_SHORT).show();
            return false;
        }else if (Name.getText().toString().isEmpty()){
            Toast.makeText(getActivity(), "Enter your Name", Toast.LENGTH_SHORT).show();
            return false;
        }else if (SecondName.getText().toString().isEmpty()){
            Toast.makeText(getActivity(), "Enter your SecondName", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }
    private void createAnAccount(){
        String my_email = Email.getText().toString();
        String pwd = Password.getText().toString();

        Mauth.createUserWithEmailAndPassword(my_email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    User user = new User(Email.getText().toString(),Name.getText().toString(),SecondName.getText().toString());
                    saveUserInDB(user);
                }else {
                    Toast.makeText(getActivity(),task.getException().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void saveUserInDB(User user){
        Ref_user.child(Mauth.getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Intent i = new Intent(getActivity(), MainActivity.class);
                    startActivity(i);
                    getActivity().finish();
                }else {
                    Toast.makeText(getActivity(),task.getException().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}