package io.github.charly1811.bookexampledemo;

/**
 * Created by rohanrodrigues on 4/28/17.
 */

import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class HomeDashboardAdapter extends RecyclerView.Adapter<HomeDashboardAdapter.MyViewHolder> {

    private Context mContext;
    private List<Option> mOptionList;
    private Button beginButton;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        private Button beginButton;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            beginButton = (Button) view.findViewById(R.id.begin_button);
            title = (TextView) view.findViewById(R.id.option_title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }

        public Button getBeginButton() {
            return this.beginButton;
        }
    }


    public HomeDashboardAdapter(Context mContext, List<Option> optionList) {
        this.mContext = mContext;
        this.mOptionList = optionList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_page_dashboard, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Option option = mOptionList.get(position);
        holder.title.setText(option.getName());
        holder.beginButton.setText(option.getDescription());

        // loading option cover using Glide library
        Glide.with(mContext).load(option.getThumbnail()).into(holder.thumbnail);
        beginButton = holder.getBeginButton();
        beginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (option.getDescription()) {
                    case ("Enter Text Now"):
                        ((FragmentActivity)mContext).getFragmentManager().beginTransaction().replace(R.id.maincontent, new TextToBookFrag()).commit();

                        return;
                    case ("Try Scanning Now"):
                        ((FragmentActivity)mContext).getFragmentManager().beginTransaction().replace(R.id.maincontent, new OcrFrag()).commit();
                        return;
                    case ("See Your Progress"):
                        ((FragmentActivity)mContext).getFragmentManager().beginTransaction().replace(R.id.maincontent, new AchievementsFragment()).commit();
                        return;
                }
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_dashboard, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favorite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return mOptionList.size();
    }

    public Button getBeginButton() {
        return beginButton;
    }
}