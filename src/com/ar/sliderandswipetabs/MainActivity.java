package com.ar.sliderandswipetabs;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class MainActivity extends FragmentActivity
{
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
 
		mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
		mDrawerList = (ListView)findViewById(R.id.left_drawer);
		//		CustomSlidingDrawer csd=new CustomSlidingDrawer(MainActivity.this, mDrawerLayout, mDrawerList);
		//		csd.createMenuDrawer();

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,  GravityCompat.START);

		mDrawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				getResources().getStringArray(R.array.menulist)));
		// Set the OnItemClickListener so something happens when a 
		 mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		// Enable ActionBar app icon to behave as action to toggle the NavigationDrawer
//		getActionBar().setDisplayHomeAsUpEnabled(true);
//		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.drawable.ic_launcher, R.string.drawer1, R.string.drawer2) 
		{
			public void onDrawerClosed(View view) {
				invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu
			}

			public void onDrawerOpened(View drawerView) {
				invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

	
		HomeScreen homeScreenFragment=new HomeScreen();
		FragmentManager manager=getSupportFragmentManager();
		FragmentTransaction transaction=manager.beginTransaction();
		transaction.add(R.id.fragmentFrames, homeScreenFragment, "HomeFrag").commit();



	}


	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}


	private class DrawerItemClickListener implements ListView.OnItemClickListener 
	{
		@SuppressLint("InlinedApi")
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
		{
			switch (position) 
			{
			case 0:
				Toast.makeText(MainActivity.this, "Item 0", Toast.LENGTH_LONG).show();
				break;
			case 1:
				Toast.makeText(MainActivity.this, "Item 1", Toast.LENGTH_LONG).show();
				break;
			case 2:
				Toast.makeText(MainActivity.this, "Item 2", Toast.LENGTH_LONG).show();
				break;
			case 3:
				Toast.makeText(MainActivity.this, "Item 3", Toast.LENGTH_LONG).show();
				break;
			case 4:
				Toast.makeText(MainActivity.this, "Item 4", Toast.LENGTH_LONG).show();
				break;
			case 5:
				Toast.makeText(MainActivity.this, "Item 5", Toast.LENGTH_LONG).show();
				break;
			case 6:
				Toast.makeText(MainActivity.this, "Item 6", Toast.LENGTH_LONG).show();
				break;
			default:
				break;
			}

			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			mDrawerLayout.closeDrawer(mDrawerList);

			mDrawerList.setItemChecked(position, true);
			mDrawerLayout.closeDrawer(mDrawerList);
			
		}
	}

}
