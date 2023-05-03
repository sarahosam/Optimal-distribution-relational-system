package com.android.optimaldistributionrelationalsystem.nada;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.optimaldistributionrelationalsystem.R;
import com.android.optimaldistributionrelationalsystem.eman.MapsActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoOrderActivity extends AppCompatActivity {

    ListView lstItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demorder);

        lstItems = findViewById(R.id.lstItems);

        FillList();
    }// end oncreate

    public void FillList() {
        try {

            myItems items = new myItems();
            List<Map<String, String>> prolist = new ArrayList<Map<String, String>>();
            String[] from = {"OrderId", "StoreName", "Quantity", "SalePrice"};
            int[] views = {R.id.txtordersid, R.id.txtstorename, R.id.txtquantity, R.id.txtSalePrice,};

            List<myItems> lsr = items.GetItems();

            for (int i = 0; i < lsr.size(); i++) {
                Map<String, String> datanum = new HashMap<String, String>();
                datanum.put("OrderId", lsr.get(i).OrderId);
                datanum.put("StoreName", String.valueOf(lsr.get(i).StoreName));
                datanum.put("Quantity", String.valueOf(lsr.get(i).Quantity));
                datanum.put("SalePrice", String.valueOf(lsr.get(i).SalePrice));
                prolist.add(datanum);
            }//end for loop

            final SimpleAdapter simpleAdapter = new SimpleAdapter(DemoOrderActivity.this,
                    prolist, R.layout.mylist_items, from, views); //ربطنا مع layoutبتاع ال list
            lstItems.setAdapter(simpleAdapter);
        }// end try
        catch (Exception ex) {
            Toast.makeText(DemoOrderActivity.this, ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
        }//end catch
    }// end filllist

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Intent intent = new Intent(DemoOrderActivity.this, MapsActivity.class);
                startActivity(intent);

                break;
        }// end switch
    }// end onClick
}// end class