package nskmlylm.campusannouncement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class commRvAdapter extends RecyclerView.Adapter<commRvAdapter.ViewHolder>{
    private static final String TAG = "commRvAdapter";
    private Context mContext;
    List<Comment> aList;

    public commRvAdapter(Context mContext, List<Comment> aList){
        this.mContext = mContext;
        this.aList = aList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comm_recyclerview_row, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: called."); //This log will help us at debugging. Its simply tells us which view failed.
        // if there is an error and there is four of this log. That means fifth one caused the fail.

        holder.userName.setText(aList.get(position).user);
        holder.desc.setText(aList.get(position).comm);
        holder.date.setText(aList.get(position).date);

        holder.rLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + aList.get(position));
                Toast.makeText(mContext,aList.get(position).user , Toast.LENGTH_SHORT).show(); //When user clicks the rw it will show up the userName
            }
        });
    }

    @Override
    public int getItemCount() {
        return aList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //This hold the elements of the recycler view.
        TextView userName, desc,date;
        RelativeLayout rLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName);
            desc = itemView.findViewById(R.id.comment);
            date = itemView.findViewById(R.id.date);
            rLayout = itemView.findViewById(R.id.RlayoutComm);
        }
    }
}
