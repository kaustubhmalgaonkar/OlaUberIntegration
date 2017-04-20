package com.fw.olauberintegration.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fw.olauberintegration.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kaustubh on 19/4/17.
 */
public class UberRideFragment extends Fragment {

    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    private List uberRideEstimateList = new ArrayList();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_uber_ride_estimate,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        uberRideEstimateList = (List) getArguments().getSerializable("uber_ride");
        Log.e("Fragment uber",uberRideEstimateList.size()+"");

        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycler_view.setLayoutManager(horizontalLayoutManagaer);

        UberRideEstimateAdapter mRideAdapter = new UberRideEstimateAdapter(uberRideEstimateList);
        recycler_view.setAdapter(mRideAdapter);
    }
}
