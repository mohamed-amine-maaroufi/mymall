package com.example.mymall;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mymall.manageproducts.Product;
import com.example.mymall.manageproducts.RecyclerViewAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemListener {
    private RecyclerView categoryRecyclerView;
    private List<HomePageModel> homePageModelFakeList = new ArrayList<>();
    RecyclerView recyclerView;
    List<Product> products;
    FirebaseFirestore firebaseFirestore;
private HomePageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String title=getIntent().getStringExtra("CategoryName");
        String index=getIntent().getStringExtra("CategoryIndex");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.category_recyclerview);

        //list to store products
        products = new ArrayList<>();
        firebaseFirestore = FirebaseFirestore.getInstance();

        int indexint = 0;
        if(index != null)
            indexint = Integer.parseInt(index);


        firebaseFirestore.collection("PRODUCTS")
                .whereEqualTo("index_category", indexint)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            try {
                                //clear the old list
                                products.clear();

                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Log.d("CategryActivity", document.getId() + " => " + document.getData());

                                    //getting product
                                    Product product = new Product();

                                    product.setId(document.getId());

                                    product.setProduct_title(String.valueOf(  document.get("product_title")));
                                    product.setProduct_price(String.valueOf(document.get("product_price")));
                                    if(document.get("1_star") != null)
                                        product.setStar_1(String.valueOf( document.get("1_star")));

                                    if(document.get("2_star") != null)
                                        product.setStar_2(String.valueOf( document.get("2_star")));

                                    if(document.get("3_star") != null)
                                        product.setStar_3(String.valueOf( document.get("3_star")));

                                    if(document.get("4_star") != null)
                                        product.setStar_4(String.valueOf( document.get("4_star")));

                                    if(document.get("5_star") != null)
                                        product.setStar_5(String.valueOf( document.get("5_star")));

                                    if(document.get("COD") != null)
                                        product.setCod(String.valueOf( document.get("COD")));

                                    if(document.get("in_stock") != null)
                                        product.setIn_stock(String.valueOf(  document.get("in_stock")));

                                    if(document.get("no_of_product_images") != null)
                                        product.setNo_of_product_images(String.valueOf(  document.get("no_of_product_images")));


                                    if(document.get("average_rating") != null)
                                        product.setAverage_rating(String.valueOf( document.get("average_rating")));


                                    product.setCutted_price(String.valueOf( document.get("cutted_price")));
                                    product.setFree_coupen_body(String.valueOf(document.get("free_coupen_body")));
                                    product.setFree_coupen_title(String.valueOf( document.get("free_coupen_title")));

                                    if(document.get("free_coupens") != null)
                                        product.setFree_coupens(String.valueOf(document.get("free_coupens")));

                                    product.setProduct_description(String.valueOf(  document.get("product_description")));
                                    product.setProduct_image_1(String.valueOf(  document.get("no_of_product_images")));
                                    product.setProduct_image_1(String.valueOf(  document.get("product_image_1")));
                                    product.setProduct_image_2(String.valueOf(  document.get("product_image_2")));
                                    product.setProduct_image_3(String.valueOf(  document.get("product_image_3")));
                                    product.setProduct_other_details(String.valueOf(  document.get("product_other_details")));
                                    product.setProduct_price(String.valueOf(  document.get("product_price")));
                                    product.setProduct_title(String.valueOf(  document.get("product_title")));
                                    product.setSpec_title_1(String.valueOf(  document.get("spec_title_1")));
                                    product.setSpec_title_1_field_1_name(String.valueOf(  document.get("spec_title_1_field_1_name")));
                                    product.setSpec_title_1_field_1_value(String.valueOf(  document.get("spec_title_1_field_1_value")));
                                    product.setSpec_title_1_field_2_name(String.valueOf(  document.get("spec_title_1_field_2_name")));
                                    product.setSpec_title_1_field_2_value(String.valueOf(  document.get("spec_title_1_field_2_value")));

                                    if(document.get("spec_title_1_total_fields") != null)
                                        product.setSpec_title_1_totals_fields(String.valueOf(  document.get("spec_title_1_total_fields")));

                                    product.setSpec_title_2(String.valueOf(  document.get("spec_title_2")));
                                    product.setSpec_title_2_field_1_name(String.valueOf(  document.get("spec_title_2_field_1_name")));
                                    product.setSpec_title_2_field_1_value(String.valueOf(  document.get("spec_title_2_field_1_value")));
                                    product.setSpec_title_2_field_2_name(String.valueOf(  document.get("spec_title_2_field_2_name")));
                                    product.setSpec_title_2_field_2_value(String.valueOf(  document.get("spec_title_2_field_2_value")));

                                    if(document.get("spec_title_2_total_fields") != null)
                                        product.setSpec_title_2_totals_fields(String.valueOf(  document.get("spec_title_2_total_fields")));

                                    product.setSpec_title_3(String.valueOf(  document.get("spec_title_3")));
                                    product.setSpec_title_3_field_1_name(String.valueOf(  document.get("spec_title_3_field_1_name")));
                                    product.setSpec_title_3_field_1_value(String.valueOf(  document.get("spec_title_3_field_1_value")));
                                    product.setSpec_title_3_field_2_name(String.valueOf(  document.get("spec_title_3_field_2_name")));
                                    product.setSpec_title_3_field_2_value(String.valueOf(  document.get("spec_title_3_field_2_value")));

                                    if(document.get("spec_title_3_total_fields") != null)
                                        product.setSpec_title_3_totals_fields(String.valueOf(  document.get("spec_title_3_total_fields")));

                                    product.setSpec_title_4(String.valueOf(  document.get("spec_title_4")));
                                    product.setSpec_title_4_field_1_name(String.valueOf(  document.get("spec_title_4_field_1_name")));
                                    product.setSpec_title_4_field_1_value(String.valueOf(  document.get("spec_title_4_field_1_value")));
                                    product.setSpec_title_4_field_2_name(String.valueOf(  document.get("spec_title_4_field_2_name")));
                                    product.setSpec_title_4_field_2_value(String.valueOf(  document.get("spec_title_4_field_2_value")));
                                    product.setSpec_title_4_field_3_name(String.valueOf(  document.get("spec_title_4_field_3_name")));
                                    product.setSpec_title_4_field_3_value(String.valueOf(  document.get("spec_title_4_field_3_value")));

                                    if(document.get("spec_title_4_total_fields") != null)
                                        product.setSpec_title_4_totals_fields(String.valueOf(  document.get("spec_title_4_total_fields")));

                                    if(document.get("total_ratings") != null)
                                        product.setTotal_rating(String.valueOf(  document.get("total_ratings")));

                                    if(document.get("total_spec_titles") != null)
                                        product.setTotal_spec_titles(String.valueOf(  document.get("total_spec_titles")));

                                    //adding product to the list
                                    products.add(product);
                                }


                            } catch (Exception e) {
                                e.printStackTrace();
                                Toast.makeText(CategoryActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }


                            RecyclerViewAdapter adapter = new RecyclerViewAdapter(CategoryActivity.this, products, CategoryActivity.this);
                            recyclerView.setAdapter(adapter);


                        } else {
                            Log.w("ActivityProducts", "Error getting documents.", task.getException());


                            Toast.makeText(CategoryActivity.this, "Error getting documents. : " +  task.getException().toString() , Toast.LENGTH_LONG).show();

                        }
                    }
                });




        /*if(!productListbyCategorie.isEmpty()) {
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, productListbyCategorie, this);
            recyclerView.setAdapter(adapter);
        }
        else {
            Toast.makeText(this, "List of product is empty !", Toast.LENGTH_SHORT).show();
        }*/



        /**
         AutoFitGridLayoutManager that auto fits the cells by the column width defined.
         **/

        /*AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(this, 500);
        recyclerView.setLayoutManager(layoutManager);*/


        /**
         Simple GridLayoutManager that spans two columns
         **/
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);


    }

    @Override
    public void onItemClick(Product item) {


        Intent intent = new Intent(CategoryActivity.this, ProductDetailsActivity.class);
        intent.putExtra("PRODUCT_ID", item.getId());
        startActivity(intent);
        //Toast.makeText(getApplicationContext(), item.getId() + " is clicked", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.main_search_icon){
            //todo:search
            return  true;
        }else if(id==android.R.id.home){
                finish();
                return true;
        }
        return  super.onOptionsItemSelected(item);
    }
}
