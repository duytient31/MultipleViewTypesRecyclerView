package com.example.teamas.multipleviewtypesrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CallSmsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_CALL = 1;
    private static final int TYPE_SMS = 2;

    private Context mContext;
    private List<Object> callSmsFeed;


    public CallSmsAdapter(Context context, List<Object> objects) {
        mContext = context;
        callSmsFeed = objects;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_CALL) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.call_card_layout, parent, false);
            return new callViewHolder(v);
        } else if (viewType == TYPE_SMS) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.sms_card_layout, parent, false);
            return new smsViewHolder(v);
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder.getItemViewType() == TYPE_CALL) {
            Call call = (Call) callSmsFeed.get(position);
            ((callViewHolder) holder).tvCallTime.setText(call.getCallTime());
            ((callViewHolder) holder).tvCallerName.setText(call.getCallerName());

        } else if (holder.getItemViewType() == TYPE_SMS) {
            Sms sms = (Sms) callSmsFeed.get(position);
            ((smsViewHolder) holder).tvSenderName.setText(sms.getSenderName());
            ((smsViewHolder) holder).tvSmsContent.setText(sms.getSmsContent());
            ((smsViewHolder) holder).tvSmsTime.setText(sms.getSmsTime());

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return callSmsFeed.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (callSmsFeed.get(position) instanceof Call) {
            return TYPE_CALL;
        } else if (callSmsFeed.get(position) instanceof Sms) {
            return TYPE_SMS;
        } else {
            return -1;
        }

    }


    class callViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCallerName;
        private TextView tvCallTime;


        public callViewHolder(View itemView) {
            super(itemView);
            tvCallerName = itemView.findViewById(R.id.callerName);
            tvCallTime = itemView.findViewById(R.id.callTime);
        }
    }

    class smsViewHolder extends RecyclerView.ViewHolder {

        private TextView tvSenderName;
        private TextView tvSmsContent;
        private TextView tvSmsTime;

        public smsViewHolder(View itemView) {
            super(itemView);
            tvSenderName = itemView.findViewById(R.id.senderName);
            tvSmsContent = itemView.findViewById(R.id.smsContent);
            tvSmsTime = itemView.findViewById(R.id.smsTime);
        }
    }
}
