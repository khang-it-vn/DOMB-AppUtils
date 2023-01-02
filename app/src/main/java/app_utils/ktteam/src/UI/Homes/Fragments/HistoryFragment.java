package app_utils.ktteam.src.UI.Homes.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import app_utils.ktteam.src.DatabaseContext.RepairerDatabase;
import app_utils.ktteam.src.Entities.ERepaierDistance;
import app_utils.ktteam.src.R;
import app_utils.ktteam.src.UI.Homes.Adapters.HistoryAdapter;

public class HistoryFragment  extends Fragment {

    ListView listViewHistory;
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_history,container,false);
        ArrayList<ERepaierDistance> repaierDistances = (ArrayList<ERepaierDistance>) RepairerDatabase.getInstance(getActivity().getApplicationContext()).repairerDao().getAll();
        listViewHistory = view.findViewById(R.id.listViewHistory);

        HistoryAdapter adapter = new HistoryAdapter(getActivity(),R.layout.history_row_repairer,repaierDistances);
        listViewHistory.setAdapter(adapter);
        return view;
    }
}
