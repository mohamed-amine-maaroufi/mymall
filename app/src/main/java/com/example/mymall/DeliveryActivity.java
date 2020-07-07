package com.example.mymall;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DeliveryActivity extends AppCompatActivity {

    public static List<CartItemModel> cartItemModelList;
    private RecyclerView deliveryRecyclerView;
    private Button changeORaddNewAddressBtn;
    public static final int SELECT_ADDRESS=0;
    private TextView totalAmount;
    private TextView fullname;
    private TextView fullAddress;
    private TextView pincode;
    private Button continueBtn;
    private Dialog loadingDialog;
    private Dialog paymentMethodDialog;
    private ImageView paypal;

    //// order confirmed
    private ConstraintLayout orderConfirmationLayout;
    private ImageButton continueShoppingBtn;
    private TextView orderId;
    //// order confirmed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Delivery");

        deliveryRecyclerView=findViewById(R.id.delivery_recyclerview);
        changeORaddNewAddressBtn=findViewById(R.id.change_or_add_address_btn);
        totalAmount = findViewById(R.id.total_cart_amount);
        fullname = findViewById(R.id.fullname);
        fullAddress = findViewById(R.id.address);
        pincode = findViewById(R.id.pincode);
        continueBtn = findViewById(R.id.cart_continue_btn);
        orderConfirmationLayout = findViewById(R.id.order_confirmation_layout);
        continueShoppingBtn = findViewById(R.id.continue_shopping_btn);
         orderId = findViewById(R.id.order_id);



        /*Toast.makeText(DeliveryActivity.this, "fullAddress" + fullAddress + "\n totalAmount = "+ totalAmount
                + "\norderId = " + orderId
                , Toast.LENGTH_SHORT).show();*/

        ////loading dialog
        loadingDialog = new Dialog(DeliveryActivity.this);
        loadingDialog.setContentView(R.layout.loading_progress_dialog);
        loadingDialog.setCancelable(false);
        loadingDialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.slider_background));
        loadingDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ////loading dialog

        ////loading payment method dialog
        paymentMethodDialog = new Dialog(DeliveryActivity.this);
        paymentMethodDialog.setContentView(R.layout.payment_method);
        paymentMethodDialog.setCancelable(true);
        paymentMethodDialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.slider_background));
        paymentMethodDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paypal = paymentMethodDialog.findViewById(R.id.paypal);
        ////loading payment method dialog


        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        deliveryRecyclerView.setLayoutManager(layoutManager);

        CartAdapter cartAdapter=new CartAdapter(cartItemModelList,totalAmount,false);
        deliveryRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        changeORaddNewAddressBtn.setVisibility(View.VISIBLE);
        changeORaddNewAddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myAddressesIntent=new Intent(DeliveryActivity.this,MyAddressesActivity.class);
                myAddressesIntent.putExtra("MODE",SELECT_ADDRESS);
                startActivity(myAddressesIntent);
            }
        });

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                paymentMethodDialog.show();


            }
        });


        continueShoppingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity=new Intent(DeliveryActivity.this,MainActivity.class);
                startActivity(mainActivity);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        String fullName = DBqueries.addressesModelList.get(DBqueries.selectedAddress).getFullName() ;
        String address = DBqueries.addressesModelList.get(DBqueries.selectedAddress).getAddress();
        String pincod = DBqueries.addressesModelList.get(DBqueries.selectedAddress).getPincode();
        fullname.setText(fullName);
        fullAddress.setText(address);
        pincode.setText(pincod);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();

        if (!TextUtils.isEmpty(fullName)){
            if (!TextUtils.isEmpty(address)){
                if (!TextUtils.isEmpty(pincod)){

                    editor.putString("name", fullName.substring( 0, fullName.indexOf(" -")));
                    editor.putString("mobile", fullName.substring(fullName.lastIndexOf("- ") + 2));
                    editor.putString("fullAddress", address);
                    editor.putString("pincode", pincod);
                    editor.commit();

                    String name =  pref.getString("name", null);
                    String mobile =  pref.getString("mobile", null);
                    String fullAddress = pref.getString("fullAddress", null);
                    String pincode =  pref.getString("pincode", null);

                    String msg = "Hello " + name.toUpperCase() + ", Your Order has been confirmed. \n Expected delivery within 4-6 days on the address : "
                            + fullAddress + "\n Pincode : " + pincode + ", mobile : " + mobile;

                    //Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

                    SendMessage(this, mobile, msg);

                }
            }
        }

        else{

            String name =  pref.getString("name", null);
            String mobile =  pref.getString("mobile", null);
            String fullAddress = pref.getString("fullAddress", null);
            String pincode =  pref.getString("pincode", null);

            String msg = "Hello " + name.toUpperCase() + ", Your Order has been confirmed. \n Expected delivery within 4-6 days on the address : "
                    + fullAddress + "\n Pincode : " + pincode;

            SendMessage(this, mobile, msg);
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
       if(id==android.R.id.home){
           finish();
           return true;
       }
        return super.onOptionsItemSelected(item);
    }

    //send message
    public static void SendMessage(final Context context, String phoneNumber, String message) {
        String l_sNumber = phoneNumber;
        String l_sMsg = message.trim();
        if (l_sNumber.equals("") || l_sMsg.equals("")){

            Log.d("DeliveryActivity", "sms Fields (l_sNumber + l_sMsg) cannot be empty");
        } else {
            if (TextUtils.isDigitsOnly(l_sNumber)){
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(l_sNumber, null, l_sMsg, null, null);
                Log.d("DeliveryActivity", "message is sended with success");
                Log.d("DeliveryActivity", "number of phone = " +phoneNumber);

            } else {
                Log.d("DeliveryActivity", "Incorrect phone number, failed to send message !!!");
            }
        }
    }

}
