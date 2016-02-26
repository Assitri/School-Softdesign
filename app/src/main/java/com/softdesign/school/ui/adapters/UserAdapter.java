package com.softdesign.school.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.User;

import java.util.ArrayList;

/*Адаптер вставляющий данные пользователей во View элементы списка RecyclerView*/
public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    /* mUsers - массив с данными о пользователях (объекты User)

     */

    private ArrayList<User> mUsers;
    private Context mContext;

    public UserAdapter(ArrayList<User> mUsers, Context mContext) {
        this.mUsers = mUsers;
        this.mContext = mContext;
    }

    /* создается элимент списка в котороый будет вставлено View с данными из объекта User
    (данные пользователя, имя фамилия)
     */

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(mContext).inflate(R.layout.item_contacts, parent, false);
        return new UserViewHolder(convertView);
    }

    /* сама вставка  данных из  User  во View  из ViewHolder
     * Изменение фона View
     */
    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = mUsers.get(position);
        holder.image.setImageDrawable(user.getImage());
        holder.name.setText(user.getLastName()+" "+user.getFirstName());
        if (position%2==1) holder.itemView.setBackgroundColor(mContext.getResources().getColor(R.color.item_purple));
        if (position%2==0) holder.itemView.setBackgroundColor(mContext.getResources().getColor(R.color.item_white));
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }
}
