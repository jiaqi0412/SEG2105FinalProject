package com.example.lijia.finalproject;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.List;

public class ServiceList extends ArrayAdapter<Service> {

    private Activity context;
    private List<Service> serviceList;

    public ServiceList(Activity context, List<Service> serviceList){
        super(context, R.layout.activity_admin_edit_or_remove_service, serviceList);
        this.context = context;
        this.serviceList = serviceList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.activity_admin_edit_or_remove_service, null, true);


        TextView textViewServiceName = (TextView) listViewItem.findViewById(R.id.textViewServiceName);
        TextView textViewServiceHourlyRate = (TextView) listViewItem.findViewById(R.id.textViewServiceHourlyRate);

        Service service = serviceList.get(position);

        textViewServiceName.setText(service.getServiceName());
        textViewServiceHourlyRate.setText(service.getServiceHourlyRate());

        return listViewItem;
    }
}
