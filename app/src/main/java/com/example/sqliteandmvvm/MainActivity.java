package com.example.sqliteandmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     private SqliteDBAdapter sqliteDBAdapter;
        //SqliteDB db;
       List<empdata> empdataList=new ArrayList<>();
       empdata emp;
    LinearLayoutManager layoutManager;
       private RecyclerView recyclerView;
       private EditText editname,editage,editsalary,editaddr;
    customListAdapter CA;
      private Button btn,updt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          // db=new SqliteDB(this);
        sqliteDBAdapter=SqliteDBAdapter.getSqliteAdapterInstnce(this);
        empdataList=sqliteDBAdapter.getAllData();
         recyclerView=findViewById(R.id.recycler);
            if(empdataList.size()==0)
            {
                Toast.makeText(this, "emty list", Toast.LENGTH_SHORT).show();
            }



                CA=new customListAdapter(this,empdataList);
                layoutManager=new LinearLayoutManager(this);
              recyclerView.setLayoutManager(layoutManager);
              recyclerView.setAdapter(CA);




         btn=findViewById(R.id.add);

        btn.setOnClickListener(this);
        //updt.setOnClickListener(this);
//         if(sqliteDBAdapter.TotalData()>0)
//         {
//             empdataList=sqliteDBAdapter.getAllData();
//              CA=new customListAdapter(this,empdataList)  ;
//     extra        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
//             recyclerView.setLayoutManager(layoutManager);
//             recyclerView.setAdapter(CA);
//
//         }





    }

    @Override
    public void onClick(View view) {


        switch(view.getId())
        {
            case R.id.add:
                editname=findViewById(R.id.name);
                editage=findViewById(R.id.age);
                editsalary=findViewById(R.id.salary);
                editaddr=findViewById(R.id.address);
                boolean b=sqliteDBAdapter.insertEmployee(editname.getText().toString(),editage.getText().toString(),editsalary.getText().toString(),editaddr.getText().toString());
                if(b)
                {
                    //empdata e=new empdata(editname.getText().toString(),editage.getText().toString(),editsalary.getText().toString(),editaddr.getText().toString());
                    empdataList=sqliteDBAdapter.getAllData();


                    CA=new customListAdapter(this,empdataList);
                    layoutManager=new LinearLayoutManager(this);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(CA);
                    recyclerView.scrollToPosition(empdataList.size()-1);
                  }
                break;

//            case R.id.update:
//                editname=findViewById(R.id.name);
//                editage=findViewById(R.id.age);
//                editsalary=findViewById(R.id.salary);
//                editaddr=findViewById(R.id.address);
//                empdata e=new empdata(editname.getText().toString(),editage.getText().toString(),editsalary.getText().toString(),editaddr.getText().toString());
//                sqliteDBAdapter.
            default:
                Toast.makeText(this, "invalid choice", Toast.LENGTH_SHORT).show();
                break;




//            if(empdataList.size()==1) {
//
//                CA = new customListAdapter(this, empdataList);
//                LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//                recyclerView.setLayoutManager(layoutManager);
//                recyclerView.setAdapter(CA);
//
//            }
//            else
//            {
//                CA.notifyDataSetChanged();
//                // recyclerView.setAdapter(CA);
//
//                recyclerView.scrollToPosition(empdataList.size()-1);
//            }

        }






        }

    public boolean removeFromDatabase(int pos) {

       boolean c= sqliteDBAdapter.removeData(pos);
       return c;
    }


    private void refreshList() {
        //empdataList=sqliteDBAdapter.getAllData();
        //CA=new customListAdapter(this,empdataList);




    }




//    public StringBuffer refreshdataList()
//    {
//        empdataList=new ArrayList<>();
//        empdataList=sqliteDBAdapter.getAllData();
//
//        StringBuffer sb=new StringBuffer();
//        for(empdata emp:empdataList)
//        {
//            sb.append(emp.emp_name+"  "+emp.getEnp_age()+"\n\n");
//        }
//
//    }
}