package app_utils.ktteam.src.UI.Homes;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import app_utils.ktteam.src.UI.Homes.Fragments.HistoryFragment;
import app_utils.ktteam.src.UI.Homes.Fragments.HomeFragment;
import app_utils.ktteam.src.UI.Homes.Fragments.ProfileFragment;

public class ViewPaperAdapter extends FragmentStatePagerAdapter {

    public ViewPaperAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new HomeFragment();
            case 1:
                return  new HistoryFragment();
            case 2:
                return new ProfileFragment();
            default:
                return new HomeFragment();
        }

    }

    @Override
    public int getCount() {
        return 4; // số lượng fragment
    }
}
