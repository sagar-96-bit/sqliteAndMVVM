package com.example.sqliteandmvvm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class customListAdapter extends RecyclerView.Adapter<customListAdapter.MyViewHolder> {
    SqliteDBAdapter sqliteDBAdapter;
    private Context context;
    private List<empdata> empList;

    public customListAdapter(Context context, List<empdata> empList) {
        this.context = context;
        this.empList = empList;
    }

    @NonNull
    @Override
    public customListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.customlist,parent,false);
        MyViewHolder mv=new MyViewHolder(view);
          view.setOnLongClickListener(new View.OnLongClickListener() {
              @Override
              public boolean onLongClick(View view) {
                  int pos=mv.getAdapterPosition();
                  empList.remove(pos);
                  sqliteDBAdapter=SqliteDBAdapter.getSqliteAdapterInstnce(context);
                  boolean b= sqliteDBAdapter.removeData(pos);
                    if (b)
                       notifyDataSetChanged();
                    else
                        Toast.makeText(context, "Not deleted", Toast.LENGTH_SHORT).show();
                  return true;
              }
          });
        return mv;
    }

    @Override
    public void onBindViewHolder(@NonNull customListAdapter.MyViewHolder holder, int position) {
              empdata emdata=empList.get(position);
               holder.name.setText(emdata.emp_name);
               holder.age.setText(emdata.enp_age);
               holder.salary.setText(emdata.emp_salary);
               holder.addr.setText(emdata.emp_address);
    }

    @Override
    public int getItemCount() {
        return empList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
              private TextView name;
        private TextView age;
        private TextView salary;
        private TextView addr;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.txtname);
            age=itemView.findViewById(R.id.txtage);
            salary=itemView.findViewById(R.id.txtsalary);
            addr=itemView.findViewById(R.id.txtaddr);
        }
    }
}
