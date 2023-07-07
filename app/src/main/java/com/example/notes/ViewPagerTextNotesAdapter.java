package com.example.notes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerTextNotesAdapter extends FragmentPagerAdapter
{

    public ViewPagerTextNotesAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TextNoteFragment();
            case 1:
                return new EBooksFragment();
            default:
                return new QuestionPapersFragment();
        }
    }

    @Override
    public int getCount() {
        return 3; // No. of Tabs
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "Text Note";
            case 1:
                return "E-Books";
            default:
                return "Question Papers";
        }
    }

}