package edu.byui.cs246.testingtabs;

import android.app.ActionBar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

        /**
         * The {@link android.support.v4.view.PagerAdapter} that will provide
         * fragments for each of the sections. We use a
         * {@link FragmentPagerAdapter} derivative, which will keep every
         * loaded fragment in memory. If this becomes too memory intensive, it
         * may be best to switch to a
         * {@link android.support.v4.app.FragmentStatePagerAdapter}.
         */
        private SectionsPagerAdapter mSectionsPagerAdapter;


        /**
         * The {@link ViewPager} that will host the section contents.
         */
        private ViewPager mViewPager;
        Button button;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            // Create the adapter that will return a fragment for each of the three
            // primary sections of the activity.
            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

            // Set up the ViewPager with the sections adapter.
            mViewPager = (ViewPager) findViewById(R.id.container);
           // mViewPager.setAdapter(mSectionsPagerAdapter);
            if (mViewPager != null){
                setupViewPager(mViewPager);
            }

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
            // By using this method the tabs will be populated according to viewPager's count and
            // with the name from the pagerAdapter getPageTitle()



            //tabLayout.setTabsFromPagerAdapter(mSectionsPagerAdapter);

            // This method ensures that tab selection events update the ViewPager and page changes update the selected tab.

            tabLayout.setupWithViewPager(mViewPager);

            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    mViewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                }
            });
    //        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    //        fab.setOnClickListener(new View.OnClickListener() {
    //            @Override
    //            public void onClick(View view) {
    //                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //                        .setAction("Action", null).show();
    //            }
    //        });
         //   button = (Button) (mSectionsPagerAdapter.getItem());

        }

    private void setupViewPager(ViewPager viewPager){
            SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
            adapter.addFrag(MyFragment.newInstance(), "TAB 1");
            adapter.addFrag(PlaceholderFragment.newInstance(7), "Tab2");
            adapter.addFrag(MyFragment.newInstance(), "kart");
           // adapter.addFrag(new CoordinatorFragment(), "Coordinator Layout");
            viewPager.setAdapter(adapter);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }


        /**
         * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
         * one of the sections/tabs/pages.
         */
        public class SectionsPagerAdapter extends FragmentPagerAdapter {

            private final List<Fragment> mFragmentList = new ArrayList<>();
            private final List<String> mFragmentTitleList = new ArrayList<>();

            public SectionsPagerAdapter(FragmentManager fm) {
                super(fm);
            }
            @Override
            public Fragment getItem(int position) {
                // getItem is called to instantiate the fragment for the given page.
                // Return a PlaceholderFragment (defined as a static inner class below).
//                switch(position){
//                    case 0:
//                        return MyFragment.newInstance();
//                    case 1:
//                        return PlaceholderFragment.newInstance(position + 1);
//                    case 2:
                        return mFragmentList.get(position);//MyFragment.newInstance();
//                }
  //              return null;//PlaceholderFragment.newInstance(position + 1);
            }

            public void addFrag(Fragment fragment, String title){
                mFragmentList.add(fragment);
                mFragmentTitleList.add(title);
            }
            @Override
            public int getCount() {
                // Show 3 total pages.
                return mFragmentList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
//                switch (position) {
//                    case 0:
//                        return "HOME";
//                    case 1:
//                        return "MENU";
//                    case 2:
//                        return "CART";
//                }
                return mFragmentTitleList.get(position);
            }
        }


}
