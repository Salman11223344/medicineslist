package com.example.medicines_listapi;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicines_listapi.Model.Medicine;

import java.util.List;

public class MyAdeptar  extends RecyclerView.Adapter<MyAdeptar.ViewHolder>  {




    private Context mcontext;
    private List<Medicine>mdata;
    public MyAdeptar(Context mcontext,List<Medicine>mdata){
        this.mcontext = mcontext;
        this.mdata =mdata;


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

     //view varible assign all
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model, parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Medicine data = mdata.get(position); //madecine = data variable
        holder.mModel.setText(data.getDrugs());
           holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {


            @Override
            public boolean onLongClick(View v) {



                Dialog dialog;
                dialog = new Dialog(mcontext);
                dialog.setContentView(R.layout.costom_dailog);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(true);
                Toast.makeText(mcontext, "Successful", Toast.LENGTH_SHORT).show();
                dialog.show();
                TextView drugs,indications ,therapeutic_class,pharmacology,dosage;
                    drugs = dialog.findViewById(R.id.drugs_show);
                    indications = dialog.findViewById(R.id.indications_show);
                    therapeutic_class  = dialog.findViewById(R.id.therapeutic_class_show);
                    pharmacology = dialog.findViewById(R.id.pharmacology_show);
                    dosage = dialog.findViewById(R.id.dosage_show);

                    drugs.setText(data.getDrugs());
                    indications.setText(data.getIndications());
                    therapeutic_class.setText(data.getTherapeuticClass());
                    pharmacology.setText(data.getPharmacology());
                    dosage.setText(data.getDosage());

                    return false;
            }
        });
        // text veie == mmodel

    }

    @Override
    public int getItemCount() {

        if(mdata == null)
            return 0;
        return mdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView mModel ;


        public ViewHolder(View itemView)
        {

            super(itemView);

            mModel = itemView.findViewById(R.id.model1);




        }



    }

    }
