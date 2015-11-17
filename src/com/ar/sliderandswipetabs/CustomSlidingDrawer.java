package com.ar.sliderandswipetabs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@SuppressWarnings("deprecation")
public class CustomSlidingDrawer 
{
	private Activity activityContext;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ArrayAdapter<String> adapter;
	private ActionBarDrawerToggle mDrawerToggle;

	public CustomSlidingDrawer(Activity activityContext,DrawerLayout mDrawerLayout,ListView mDrawerList)
	{
		this.activityContext=activityContext;
		this.mDrawerLayout=mDrawerLayout;
		this.mDrawerList=mDrawerList;
	}

	public void createMenuDrawer()
	{
		// TODO Auto-generated method stub

		Drawable shadow=activityContext.getResources().getDrawable(R.drawable.drawer_shadow);

		//		HeaderMenuAdapter adapter=new HeaderMenuAdapter(activityContext);

		adapter=new ArrayAdapter<String>(activityContext, android.R.layout.simple_list_item_1,
				activityContext.getResources().getStringArray(R.array.menulist));

		mDrawerLayout.setDrawerShadow(shadow, GravityCompat.START);
		mDrawerList.setAdapter(adapter);

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		mDrawerToggle = new ActionBarDrawerToggle(activityContext,   
				mDrawerLayout,R.drawable.ic_launcher,R.string.drawer1,R.string.drawer2) 
		{
			public void onDrawerClosed(View view) 
			{
				mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
			}
			public void onDrawerOpened(View drawerView) 
			{
				mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);
		mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

		/*headerMenuImage.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View arg0) 
			{

			}
		});*/

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
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
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
