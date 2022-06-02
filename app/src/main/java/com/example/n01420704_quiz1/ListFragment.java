package com.example.n01420704_quiz1;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.n01420704_quiz1.databinding.FragmentSecondBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ListFragment extends Fragment {
    private RecyclerView recyclerView;
    private ListAdapter mListadapter;
    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 2));


        ArrayList data = new ArrayList<Notes>();
        for (int i = 0; i < NotesInfo.names.length; i++)
        {
            data.add(
                    new Notes
                            (
                                    NotesInfo.names[i],
                                    NotesInfo.descs[i],
                                    NotesInfo.dates[i],
                                    NotesInfo.priorities[i]
                            ));

        }

        mListadapter = new ListAdapter(data);
        recyclerView.setAdapter(mListadapter);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ListFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>
    {
        private ArrayList<Notes> dataList;

        public ListAdapter(ArrayList<Notes> data)
        {
            this.dataList = data;
        }

        public class ViewHolder extends RecyclerView.ViewHolder
        {
            TextView textViewName;
            TextView textViewDesc;
            TextView textViewDate;
            CheckBox chkBox;


            public ViewHolder(View itemView)
            {
                super(itemView);
                this.textViewName = (TextView) itemView.findViewById(R.id.idTV1);
                this.textViewDesc = (TextView) itemView.findViewById(R.id.idTV2);
                this.textViewDate = (TextView) itemView.findViewById(R.id.idTV3);
                this.chkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
            }

        }

        @Override
        public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);

            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ListAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position)
        {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy ");
            String dateString = format.format( dataList.get(position).getDate() );

            holder.textViewName.setText(dataList.get(position).getName());
            holder.textViewDesc.setText(dataList.get(position).getDescription());
            holder.textViewDate.setText(dateString);


            holder.chkBox.setChecked(dataList.get(position).getPriority());

            holder.chkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    // update your model (or other business logic) based on isChecked
                    if(buttonView.isChecked())
                    {
                        Toast.makeText(getActivity(), holder.textViewName.getText()+" has high priority", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getActivity(), holder.textViewName.getText()+" has low priority", Toast.LENGTH_LONG).show();
                    }


                }
            });



            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Toast.makeText(getActivity(), "Item " + position + " is clicked.", Toast.LENGTH_LONG).show();
                    v.setBackgroundColor(0xff00ff00);
                }
            });
        }

        @Override
        public int getItemCount()
        {
            return dataList.size();
        }
    }
}

