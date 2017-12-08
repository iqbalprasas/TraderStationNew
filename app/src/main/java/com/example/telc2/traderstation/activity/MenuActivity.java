package com.example.telc2.traderstation.activity;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.adapter.PagerAdapter;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    Toolbar toolbar;
    ViewPager viewPager;
    ImageButton searchTt;
    boolean clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //handleIntent(getIntent());

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar_menu);

        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        searchTt = (ImageButton) toolbar.findViewById(R.id.btn_search_tt);
//        searchTt.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
//            @Override
//            public void onClick(View v) {
//                int icon;
//                if (clicked) {
//                    clicked = false;
//                    icon = R.drawable.ic_close_tt;
//                }else {
//                        clicked = true;
//                        icon = R.drawable.search10;
//                }
//                searchTt.setImageDrawable(
//                        ContextCompat.getDrawable(getApplicationContext(), icon));                }
//        });
        searchTt.setVisibility(View.GONE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.leftarrow);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout_menu);
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.friends14);
        tabLayout.getTabAt(1).setIcon(R.drawable.chat13);
        tabLayout.getTabAt(2).setIcon(R.drawable.timeline4);
        tabLayout.getTabAt(3).setIcon(R.drawable.more2);

        LinearLayout linearLayout = (LinearLayout)tabLayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.LTGRAY);
        drawable.setSize(1, 1);
        linearLayout.setDividerPadding(10);
        linearLayout.setDividerDrawable(drawable);

        //handling navigation view item event
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        ImageButton settingView = (ImageButton)headerView.findViewById(R.id.btn_edit_profile);
        settingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(MenuActivity.this, ProfileActivity.class);
                intent.putExtra("string", "Go to other Activity by NavigationView item cliked!");
                startActivity(intent);
            }
        });
//        headerView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                drawer.closeDrawer(GravityCompat.START);
//                Intent intent = new Intent(MenuActivity.this, ProfileActivity.class);
//                intent.putExtra("string", "Go to other Activity by NavigationView item cliked!");
//                startActivity(intent);
//            }
//        }

        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);

        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setCurrentItem(1);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //FragmentManager fm = getSupportFragmentManager();
                //Fragment f = adapter.getItem(1);
//                if(viewPager.getCurrentItem()==1) {
//                    if (f != null) {
//                        Toast.makeText(MenuActivity.this, "tab clicked  ",
//                                Toast.LENGTH_LONG).show();
//                        cf.loadDataDummy();
//                        //cf.getRecyclerView().smoothScrollToPosition(0);
//                    }
//                }
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.fr1) {
            viewPager.setCurrentItem(0);
        } else if (id == R.id.fr2) {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        } else if (id == R.id.fr3) {
            viewPager.setCurrentItem(2);
        } else if (id == R.id.fr4){
            viewPager.setCurrentItem(3);
        /*} else if (id == R.id.fr1) {
            Intent intent = new Intent(this, DesActivity.class);
            intent.putExtra("string", "Go to other Activity by NavigationView item cliked!");
            startActivity(intent);
        } else if (id == R.id.close) {
            finish();*/
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        assert drawer != null;
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        ImageView searchIcon = (ImageView)searchView.findViewById(android.support.v7.appcompat.R.id.search_button);
        searchIcon.setImageResource(R.drawable.search10);

        SearchManager searchManager = (SearchManager) MenuActivity.this.getSystemService(Context.SEARCH_SERVICE);

        searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(this, SearchResultActivity.class)));
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void startActivity(Intent intent) {
        // check if search intent
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            if(viewPager.getCurrentItem()==0){
                intent.putExtra("key", "From contact");
            }else{
                intent.putExtra("key", "From chat");
            }
        }
        super.startActivity(intent);
    }

//    @Override
//    protected void onNewIntent(Intent intent) {
//        handleIntent(intent);
//    }
//
//
//    private void handleIntent(Intent intent) {
//
//        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
//            String query = intent.getStringExtra(SearchManager.QUERY);
//            Toast.makeText(MenuActivity.this, query,
//                    Toast.LENGTH_LONG).show();
//        }
//    }

}
