package com.example.freebieticket.Admin.Admin.AdminFragments.AddEventFragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.freebieticket.Model.Organizer;
import com.example.freebieticket.Model.Performer;
import com.example.freebieticket.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddOrganizersFragment extends Fragment {
    View view;
    ImageView BackBtn,add_ImgOfOrganizer;
    CardView AddOrganizerToRecycleView;
    Uri image_file;
    FirebaseAuth Mauth;
    DatabaseReference Ref_user,Ref_event;
    StorageReference PerformerImgref;
    String ImageURL,EventID;
    EditText add_NameOfOrganizer,add_typeOfEventOrganizer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_organizers, container, false);

        AddEventAdminFragment2 activity = (AddEventAdminFragment2) getActivity();
        EventID = activity.getMyData();

        InisializationOfFealds();
        openGalleryResult();
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                        .replace(R.id.AddEventFragment2, new PreOrgFragment())
                        .addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        AddOrganizerToRecycleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNotEmpty()){
                    String idd = GenerateID();
                    PerformerImgref.child(idd+".jpeg").putFile(image_file)
                            .addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                                    if (task.isSuccessful()){
                                        PerformerImgref.child(idd+".jpeg").getDownloadUrl()
                                                .addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                    @Override
                                                    public void onSuccess(Uri uri) {
                                                        ImageURL = uri.toString();
                                                        Ref_event = FirebaseDatabase.getInstance(getString(R.string.DBURL))
                                                                .getReference().child("Organizers");
                                                        Ref_event = Ref_event.push();
                                                        String idd = Ref_event.getKey();
                                                        Organizer organizer = new Organizer(add_NameOfOrganizer.getText().toString()
                                                                ,add_typeOfEventOrganizer.getText().toString()
                                                                ,ImageURL,idd);
                                                        saveUserInDB(organizer);
                                                    }
                                                });
                                    }else {
                                        Toast.makeText(getActivity(), "ERROR", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
        return view;
    }
    private void InisializationOfFealds(){
        BackBtn = view.findViewById(R.id.BackBtn);
        add_NameOfOrganizer = view.findViewById(R.id.add_NameOfOrganizer);
        add_typeOfEventOrganizer = view.findViewById(R.id.add_typeOfEventOrganizer);
        add_ImgOfOrganizer = view.findViewById(R.id.add_ImgOfOrganizer);
        AddOrganizerToRecycleView = view.findViewById(R.id.AddOrganizerToRecycleView);
        Mauth = FirebaseAuth.getInstance();
        Ref_user = FirebaseDatabase.getInstance(getString(R.string.DBURL)).getReference()
                .child("Events")
                .child(EventID)
                .child("Organizers");
        Ref_event = FirebaseDatabase.getInstance(getString(R.string.DBURL))
                .getReference().child("Events");
        PerformerImgref = FirebaseStorage.getInstance().getReference()
                .child("OrganizerImage");
    }
    private void openGalleryResult(){
        ActivityResultLauncher<Intent> openGalleryResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();
                            image_file = data.getData();
                            add_ImgOfOrganizer.setImageURI(image_file);
                        }
                    }
                });
        add_ImgOfOrganizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGalleryResult.launch(OpenGalery());
            }
        });
    }
    private Intent OpenGalery(){
        Intent i = new Intent();
        i.setAction(Intent.ACTION_GET_CONTENT);
        i.setType("image/*");
        return i;
    }
    private String GenerateID(){
        Calendar calForDate = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("yyyyMMdd");
        String saveCurrentDate = currentDate.format(calForDate.getTime());
        SimpleDateFormat currentTime = new SimpleDateFormat("HH : MM : ss a");
        String SaveCurrentTime = currentTime.format(calForDate.getTime());
        return saveCurrentDate+SaveCurrentTime;
    }
    protected boolean isNotEmpty(){
        if (add_NameOfOrganizer.getText().toString().isEmpty()){
            Toast.makeText(getActivity(), "Enter The Name Of Organizer", Toast.LENGTH_SHORT).show();
            return false;
        }else if (add_typeOfEventOrganizer.getText().toString().isEmpty()){
            Toast.makeText(getActivity(), "Enter The type Of Event Organizer", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }
    protected void saveUserInDB(Organizer Organizer){
        Ref_user.push().setValue(Organizer).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getActivity(), "Product added", Toast.LENGTH_SHORT).show();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                            .replace(R.id.AddEventFragment2, new PreOrgFragment())
                            .addToBackStack(null);
                    fragmentTransaction.commit();
                }else {
                    Toast.makeText(getActivity(),task.getException().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}