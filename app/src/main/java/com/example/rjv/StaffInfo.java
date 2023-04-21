package com.example.rjv;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class StaffInfo extends AppCompatActivity {

    RecyclerView mRecyclerView;
    /*ArrayList <StaffDataHandler> mStaffDataHandlers=new ArrayList<>();
    StaffInfoAdapter adapter;*/
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_info);

        this.setTitle("All Faculity Info");
        /*progressDialog =new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("data fetching...");
        progressDialog.show();
        mRecyclerView=findViewById(R.id.StaffInfoAdminRecView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mStaffDataHandlers= new ArrayList<>(mStaffDataHandlers);
        adapter=new StaffInfoAdapter(StaffInfo.this,mStaffDataHandlers);
        mRecyclerView.setAdapter(adapter);

        studentInfoListener();*/
    }
    /*private void studentInfoListener() {
        mFirebaseFirestor.collection("staffs").orderBy("StaffName")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error!=null){
                            if (progressDialog.isShowing())
                                progressDialog.dismiss();
                            Log.d("error acccur",error.getMessage());
                            return;
                        }
                        for (DocumentChange documentChange:value.getDocumentChanges()){
                            if (documentChange.getType()==DocumentChange.Type.ADDED){
                                mStaffDataHandlers.add(documentChange.getDocument().toObject(StaffDataHandler.class));
                            }
                            adapter.notifyDataSetChanged();
                            if (progressDialog.isShowing())
                                progressDialog.dismiss();
                        }
                    }
                });
    }*/
}