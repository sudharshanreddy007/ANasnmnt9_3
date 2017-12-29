package com.example.user.anasnmnt9_3;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    //creating listview and in xml file
    String Phone;
    ListView lv;
    String name1, name2, name3, name4, name5, name6, name7,
            phone1, phone2, phone3, phone4, phone5, phone6, phone7;
    //taking arraylist to view the list items
    ArrayList<Student>mArrayList;
    Adaptor mStudentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listview);

        mArrayList = new ArrayList<>();
//creating array list object
        mArrayList.add(new Student("Ashan", "9778485689"));
        mArrayList.add(new Student("Rohan", "9956287987"));
        mArrayList.add(new Student("Dishan", "9765487987"));
        mArrayList.add(new Student("Mishan", "9778987987"));
        mArrayList.add(new Student("Trishan", "9578987997"));
        mArrayList.add(new Student("Minan", "9783876987"));
        mArrayList.add(new Student("Gunthan", "9778987987"));

        isPermissionGranted();

//fetching studentadapter to the adapter
        mStudentAdapter = new Adaptor(this, mArrayList);
        lv.setAdapter(mStudentAdapter);
        lv.setOnItemClickListener(this);
//register the context menu
        registerForContextMenu(lv);
    }
    //creating oncreatecontextmenu and menu inflator
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select the action");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
    }
    //on creating we use this method to select the specific item
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.call:
                Toast.makeText(getApplicationContext(), "CALL " , Toast.LENGTH_SHORT).show();
                Toast.makeText(this, ""+mArrayList.get(info.position).getPhone(), Toast.LENGTH_SHORT).show();
           Intent i = new Intent();
           i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+mArrayList.get(info.position).getPhone()));
             startActivity(i);
                return true;
            case R.id.sms:
                Toast.makeText(getApplicationContext(), "SMS " , Toast.LENGTH_SHORT).show();
                Intent in = new Intent();
                in.setAction(Intent.ACTION_SENDTO);
                in.setData(Uri.parse("smsto:"+mArrayList.get(info.position).getPhone()));
                in.putExtra("sms_body","sample sms");
                startActivity(in);
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
    public  boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG","Permission is granted");
            return true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {

            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


    }
}