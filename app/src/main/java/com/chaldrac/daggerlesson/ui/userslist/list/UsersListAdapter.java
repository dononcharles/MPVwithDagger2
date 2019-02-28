package com.chaldrac.daggerlesson.ui.userslist.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chaldrac.daggerlesson.R;
import com.chaldrac.daggerlesson.models.disk.User;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class UsersListAdapter extends RecyclerView.Adapter<UsersListViewHolder> {

    private final PublishSubject<Integer> itemClicks = PublishSubject.create();

    private ArrayList<User> listHeroes = new ArrayList<>();


    public void swapAdapter(ArrayList<User> heroes) {
        this.listHeroes.clear();
        this.listHeroes.addAll(heroes);
        notifyDataSetChanged();
    }

    public void notifAdapterS(ArrayList<User> newData) {
        listHeroes = newData;
        this.notifyDataSetChanged();
    }

    public Observable<Integer> observeClicks() {
        return itemClicks;
    }


    @NotNull
    @Override
    public UsersListViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new UsersListViewHolder(view, itemClicks);
    }

    @Override
    public void onBindViewHolder(@NotNull UsersListViewHolder holder, int position) {
        User hero = listHeroes.get(position);
        holder.bind(hero);

    }


    @Override
    public int getItemCount() {
        if (listHeroes != null && listHeroes.size() > 0) {
            return listHeroes.size();
        } else {
            return 0;
        }
    }
}
