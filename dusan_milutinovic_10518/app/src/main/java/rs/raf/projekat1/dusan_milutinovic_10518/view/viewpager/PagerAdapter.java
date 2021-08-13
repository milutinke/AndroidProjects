package rs.raf.projekat1.dusan_milutinovic_10518.view.viewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import rs.raf.projekat1.dusan_milutinovic_10518.view.fragments.StatusFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    private final int ITEM_COUNT = 1;
    public static final int FRAGMENT_1 = 0;

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case FRAGMENT_1:
                fragment = new StatusFragment();
                break;
            default:
                fragment = new StatusFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return ITEM_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case FRAGMENT_1:
                return "1";
            default:
                return "1";
        }
    }
}
