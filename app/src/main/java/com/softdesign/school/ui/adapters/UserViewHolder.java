package com.softdesign.school.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.softdesign.school.R;



/**ViewHolder для RecyclerView с данными модели User*/

public class UserViewHolder extends RecyclerView.ViewHolder {

    /* image - иконка аватара пользователя
     *  name - переменная в кот. записывается данные пользователя
     */

    protected ImageView image;
    protected TextView name;

    public UserViewHolder(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.item_contacts_avatar);
        name = (TextView) itemView.findViewById(R.id.item_contacts_full_name);
    }
}
