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
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.freebieticket.Model.Event;
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

public class AddEventAdminActivity extends AppCompatActivity {
    View view;
    CardView event_add_NextBtn;
    Uri image_file;
    FirebaseAuth Mauth;
    StorageReference EventImgref;
    DatabaseReference Ref_event;
    String ImageURL;
    ImageView event_add_img,BackBtn1;
    EditText event_add_Title,event_add_Location,event_add_DayOfEvent,event_add_planingOfEvent,event_add_TypeOfEvent,event_add_Prices,event_add_Details;
    String idd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event_admin);

        InisializationOfFealds();
        openGalleryResult();
        BackBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



        event_add_NextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNotEmpty()){
                    String id = GenerateID();
                    EventImgref.child(id+".jpeg").putFile(image_file)
                            .addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                                    if (task.isSuccessful()){
                                        EventImgref.child(id+".jpeg").getDownloadUrl()
                                                .addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                    @Override
                                                    public void onSuccess(Uri uri) {
                                                        ImageURL = uri.toString();
                                                        Ref_event = FirebaseDatabase.getInstance(getString(R.string.DBURL))
                                                                .getReference().child("Events");
                                                        Ref_event = Ref_event.push();
                                                        idd = Ref_event.getKey();
                                                        Event event = new Event(event_add_Title.getText().toString()
                                                                ,event_add_DayOfEvent.getText().toString(),event_add_DayOfEvent.getText().toString()
                                                                ,event_add_Location.getText().toString()
                                                                ,event_add_TypeOfEvent.getText().toString()
                                                                ,event_add_Prices.getText().toString()
                                                                ,event_add_Details.getText().toString()
                                                                ,ImageURL,idd);
                                                        saveEventIntoDB(event);

                                                    }
                                                });
                                    }else {
                                        Toast.makeText(AddEventAdminActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                    }
            }
        });
    }

    private void InisializationOfFealds() {
        BackBtn1 = findViewById(R.id.BackBtn1);
        event_add_NextBtn= findViewById(R.id.event_add_NextBtn);
        event_add_img = findViewById(R.id.event_add_img);
        event_add_Title = findViewById(R.id.event_add_Title);
        event_add_Location = findViewById(R.id.event_add_Location);
        event_add_DayOfEvent = findViewById(R.id.event_add_DayOfEvent);
        event_add_planingOfEvent = findViewById(R.id.event_add_planingOfEvent);
        event_add_TypeOfEvent = findViewById(R.id.event_add_TypeOfEvent);
        event_add_Prices = findViewById(R.id.event_add_Prices);
        event_add_Details = findViewById(R.id.event_add_Details);
        Mauth = FirebaseAuth.getInstance();
        Ref_event = FirebaseDatabase.getInstance(getString(R.string.DBURL))
                .getReference().child("Events");
        EventImgref = FirebaseStorage.getInstance().getReference()
                .child("EventImage");
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
                            event_add_img.setImageURI(image_file);
                        }
                    }
                });
        event_add_img.setOnClickListener(new View.OnClickListener() {
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
    private boolean isNotEmpty(){
        if (event_add_Title.getText().toString().isEmpty()){
            Toast.makeText(AddEventAdminActivity.this, "Enter Event Title", Toast.LENGTH_SHORT).show();
            return false;
        }else if (event_add_Location.getText().toString().isEmpty()){
            Toast.makeText(AddEventAdminActivity.this, "Enter Event Location", Toast.LENGTH_SHORT).show();
            return false;
        }else if (event_add_DayOfEvent.getText().toString().isEmpty()){
            Toast.makeText(AddEventAdminActivity.this, "Enter Event DayOfEvent", Toast.LENGTH_SHORT).show();
            return false;
        }else if (event_add_TypeOfEvent.getText().toString().isEmpty()){
            Toast.makeText(AddEventAdminActivity.this, "Enter Event TypeOfEvent", Toast.LENGTH_SHORT).show();
            return false;
        }else if (event_add_Prices.getText().toString().isEmpty()){
            Toast.makeText(AddEventAdminActivity.this, "Enter Event Prices", Toast.LENGTH_SHORT).show();
            return false;
        }else if (event_add_Details.getText().toString().isEmpty()){
            Toast.makeText(AddEventAdminActivity.this, "Enter Event Details", Toast.LENGTH_SHORT).show();
            return false;
        }else if (event_add_img.getResources().toString().isEmpty()){
            Toast.makeText(AddEventAdminActivity.this, "Enter Event image", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }
    private String GenerateID(){
        Calendar calForDate = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("yyyyMMdd");
        String saveCurrentDate = currentDate.format(calForDate.getTime());
        SimpleDateFormat currentTime = new SimpleDateFormat("HH : MM : ss a");
        String SaveCurrentTime = currentTime.format(calForDate.getTime());
        return saveCurrentDate+SaveCurrentTime;
    }
    protected void saveEventIntoDB(Event event ){
        Ref_event.setValue(event)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(AddEventAdminActivity.this, "Event added", Toast.LENGTH_SHORT).show();
                            sendData(idd);
                        }else {
                            Toast.makeText(AddEventAdminActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public void sendData(String idd) {
        Intent i = new Intent(this, AddEventAdminFragment2.class);
        Intent g = new Intent(this,PreOrgFragment.class);
        i.putExtra("EventID",idd);
        g.putExtra("EventID",idd);
        startActivity(i);
    }
    public String getMyData() {
        return idd;
    }
}