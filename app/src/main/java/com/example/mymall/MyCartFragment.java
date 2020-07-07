package com.example.mymall;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyCartFragment extends Fragment {

    public MyCartFragment() {
        // Required empty public constructor
    }

    private RecyclerView cartItemsRecyclerView;
    private Button continueBtn;
    private Dialog loadingDialog;
    public static CartAdapter cartAdapter;
    private TextView totalAmount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);

        requestPermission(getActivity());
        ////loading dialog
        loadingDialog = new Dialog(getContext());
        loadingDialog.setContentView(R.layout.loading_progress_dialog);
        loadingDialog.setCancelable(false);
        loadingDialog.getWindow().setBackgroundDrawable(getContext().getDrawable(R.drawable.slider_background));
        loadingDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        loadingDialog.show();
        ////loading dialog

        cartItemsRecyclerView = view.findViewById(R.id.cart_items_recyclerview);
        continueBtn = view.findViewById(R.id.cart_continue_btn);
        totalAmount=view.findViewById(R.id.total_cart_amount);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        cartItemsRecyclerView.setLayoutManager(layoutManager);

        if (DBqueries.cartItemModelList.size() == 0) {
            DBqueries.cartList.clear();
            DBqueries.loadCartList(getContext(), loadingDialog, true,new TextView(getContext()),totalAmount);
        } else {
            if(DBqueries.cartItemModelList.get(DBqueries.cartItemModelList.size() - 1).getType() == CartItemModel.TOTAL_AMOUNT){
                LinearLayout parent = (LinearLayout) totalAmount.getParent().getParent();
                parent.setVisibility(View.VISIBLE);
            }
            loadingDialog.dismiss();
        }

        cartAdapter = new CartAdapter(DBqueries.cartItemModelList,totalAmount,true);
        cartItemsRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!isPermissionGranted(getContext()))
                {

                    requestPermission(getActivity());
                }

                DeliveryActivity.cartItemModelList = new ArrayList<>();


                float price = 0;
                long productQuantite = 0;
                for(int x= 0 ; x < DBqueries.cartItemModelList.size(); x++){
                    CartItemModel cartItemModel = DBqueries.cartItemModelList.get(x);
                    if(cartItemModel.isInStock()){
                        DeliveryActivity.cartItemModelList.add(cartItemModel);
                        price = Float.parseFloat(cartItemModel.getProductPrice());
                        productQuantite = cartItemModel.getProductQuantite();
                    }
                }
                DeliveryActivity.cartItemModelList.add(new CartItemModel(CartItemModel.TOTAL_AMOUNT));

                //Toast.makeText(getContext(), "price " +  price + "\nproductQuantite = " + productQuantite, Toast.LENGTH_LONG).show();

                loadingDialog.show();
                if (DBqueries.addressesModelList.size() == 0) {
                    DBqueries.loadAddresses(getContext(), loadingDialog);


                }else{
                    loadingDialog.dismiss();
                    Intent deliveryIntent = new Intent(getContext(), DeliveryActivity.class);
                    startActivity(deliveryIntent);

                }
            }
        });
        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 101:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Log.i("MYCartFragment", "Permissions granted ");
                }
                else {

                    Log.i("MYCartFragment", "Permissions not granted ");
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    //check if permessiongranted
    public static  boolean isPermissionGranted(Context context)
    {
        boolean l_bRet = true;
        int SmsPermission = ContextCompat.checkSelfPermission(context, Manifest.permission.SEND_SMS);
        if(SmsPermission == PackageManager.PERMISSION_DENIED)
        {
            l_bRet =  false;
        }
        return l_bRet;
    }

    //request permissions
    public static void requestPermission(Activity activity)
    {
        ActivityCompat.requestPermissions(activity, new String[] {
                Manifest.permission.SEND_SMS},101);
    }
}
