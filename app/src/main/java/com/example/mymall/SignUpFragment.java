package com.example.mymall;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {


    public SignUpFragment() {
        // Required empty public constructor
    }

    private TextView alreadyHaveAnAccount;;
    private FrameLayout parentFrameLayout;

    private EditText email;
    private  EditText fullName;
    private EditText password;
    private  EditText confirmPassword;

    private ImageButton closeBtn;
    private Button signUpButton;
    private ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;

    private String emailPattern="[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";

    public static boolean disableCloseBtn=false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sign_up, container, false);
        parentFrameLayout=getActivity().findViewById(R.id.register_framelayout);

        alreadyHaveAnAccount=view.findViewById(R.id.tv_already_have_an_account);

        email=view.findViewById(R.id.sign_up_email);
        fullName=view.findViewById(R.id.sign_up_fullname);
        password=view.findViewById(R.id.sign_up_pasword);
        confirmPassword=view.findViewById(R.id.sign_up_confirm_password);
        closeBtn=view.findViewById(R.id.sign_in_close_btn);
        signUpButton=view.findViewById(R.id.sign_up_btn);
        progressBar=view.findViewById(R.id.sign_up_progress_bar);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();

        if(disableCloseBtn){
            closeBtn.setVisibility(View.GONE);
        }else{
            closeBtn.setVisibility(View.VISIBLE);
        }

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        alreadyHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignInFragment());
            }
        });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maiIntent();
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                checkInputs();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        fullName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        confirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailAndPassword();
            }
        });
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left,R.anim.slideout_from_right);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();


    }

    private  void checkInputs(){
        if(!TextUtils.isEmpty(email.getText())){
            if(!TextUtils.isEmpty(fullName.getText())){
                if(!TextUtils.isEmpty(password.getText())&& password.length() >=8){
                    if(!TextUtils.isEmpty(confirmPassword.getText())){
                        signUpButton.setEnabled(true);
                        signUpButton.setTextColor(Color.rgb(255,255,255));
                    }else{
                        signUpButton.setEnabled(false);
                        signUpButton.setTextColor(Color.argb(50,255,255,255));


                    }
                }else{
                    signUpButton.setEnabled(false);
                    signUpButton.setTextColor(Color.argb(50,255,255,255));


                }
            }else{
                signUpButton.setEnabled(false);
                signUpButton.setTextColor(Color.argb(50,255,255,255));


            }
        }else{
            signUpButton.setEnabled(false);
            signUpButton.setTextColor(Color.argb(50,255,255,255));

        }
    }

    private  void checkEmailAndPassword(){

        Drawable customErrorIcon =getResources().getDrawable(R.mipmap.custom_erreur_icon);
        customErrorIcon.setBounds(0,0,customErrorIcon.getIntrinsicWidth(),customErrorIcon.getIntrinsicHeight());

        if(email.getText().toString().matches(emailPattern)){
            if(password.getText().toString().equals(confirmPassword.getText().toString())){

                progressBar.setVisibility(View.VISIBLE);
                signUpButton.setEnabled(false);
                signUpButton.setTextColor(Color.argb(50,255,255,255));
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Map<String,Object> userdata=new HashMap<>();
                                    userdata.put("fullname",fullName.getText().toString());
                                    userdata.put("email",email.getText().toString());
                                    userdata.put("profile","");

                                    firebaseFirestore.collection("USERS").document(firebaseAuth.getUid())
                                            .set(userdata)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if(task.isSuccessful()){

                                                        CollectionReference userDataReference = firebaseFirestore.collection("USERS").document(firebaseAuth.getUid()).collection("USER_DATA");
                                                        //// Maps
                                                        Map<String,Object> wishlistMap =new HashMap<>();
                                                        wishlistMap.put("list_size", (long) 0);

                                                        Map<String,Object> ratingsMap =new HashMap<>();
                                                        ratingsMap.put("list_size", (long) 0);

                                                        Map<String,Object> cartMap =new HashMap<>();
                                                        cartMap.put("list_size", (long) 0);

                                                        Map<String,Object> myAddressesMap =new HashMap<>();
                                                        myAddressesMap.put("list_size", (long) 0);
                                                        //// Maps

                                                        final List<String> documentNames= new ArrayList<>();
                                                        documentNames.add("MY_WISHLIST");
                                                        documentNames.add("MY_RATINGS");
                                                        documentNames.add("MY_CART");
                                                        documentNames.add("MY_ADDRESSES");

                                                        List<Map<String,Object>> documentFields = new ArrayList<>();
                                                        documentFields.add(wishlistMap);
                                                        documentFields.add(ratingsMap);
                                                        documentFields.add(cartMap);
                                                        documentFields.add(myAddressesMap);


                                                        for (int x = 0 ; x < documentNames.size() ; x++){
                                                            final int finalX = x;
                                                            userDataReference.document(documentNames.get(x))
                                                                    .set(documentFields.get(x)).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                @Override
                                                                public void onComplete(@NonNull Task<Void> task) {
                                                                    if(task.isSuccessful()){
                                                                        if(finalX ==documentNames.size() -1){
                                                                            maiIntent();
                                                                        }
                                                                    }else{
                                                                        progressBar.setVisibility(View.INVISIBLE);
                                                                        signUpButton.setEnabled(true);
                                                                        signUpButton.setTextColor(Color.rgb(255,255,255));
                                                                        String error=task.getException().getMessage();
                                                                        Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
                                                                    }
                                                                }
                                                            });
                                                        }
                                                    }else{
                                                        String error=task.getException().getMessage();
                                                        Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });

                                }else{
                                    progressBar.setVisibility(View.INVISIBLE);
                                    signUpButton.setEnabled(true);
                                    signUpButton.setTextColor(Color.rgb(255,255,255));
                                    String error=task.getException().getMessage();
                                    Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }else{
                confirmPassword.setError("Password doesn't matched !",customErrorIcon);
            }
        }else{email.setError("Invalide email !",customErrorIcon);
        }
    }

    private void maiIntent(){
        if(disableCloseBtn){
            disableCloseBtn=false;
        }else {
            Intent mainIntent = new Intent(getActivity(), MainActivity.class);
            startActivity(mainIntent);
        }
        getActivity().finish();
    }
}
