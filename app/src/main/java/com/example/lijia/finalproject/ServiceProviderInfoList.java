package com.example.lijia.finalproject;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ServiceProviderInfoList extends ArrayAdapter<ServiceProviderProfile> {

    private Activity context;
    private List<ServiceProviderProfile> serviceProviderInfoList;

    public ServiceProviderInfoList(Activity context, List<ServiceProviderProfile> serviceProviderInfoList){
        super(context, R.layout.activity_service_provider_profile_info_page, serviceProviderInfoList);
        this.context = context;
        this.serviceProviderInfoList = serviceProviderInfoList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.activity_service_provider_profile_info_page, null, true);


        TextView textViewServiceProviderAddress = (TextView) listViewItem.findViewById(R.id.address2);
        TextView textViewServiceProviderPhone = (TextView) listViewItem.findViewById(R.id.phone2);
        TextView textViewServiceProviderGeneralDescription = (TextView) listViewItem.findViewById(R.id.generalDescription2);
        TextView textViewServiceProviderCompanyName = (TextView) listViewItem.findViewById(R.id.companyName2);

        ServiceProviderProfile serviceProviderProfileList = serviceProviderInfoList.get(position);

        textViewServiceProviderAddress.setText(serviceProviderProfileList.getServiceProviderAddress());
        textViewServiceProviderPhone.setText(serviceProviderProfileList.getServiceProviderPhone());
        textViewServiceProviderGeneralDescription.setText(serviceProviderProfileList.getServiceProviderGeneralDescription());
        textViewServiceProviderCompanyName.setText(serviceProviderProfileList.getServiceProviderCompanyName());

        return listViewItem;
    }
}
