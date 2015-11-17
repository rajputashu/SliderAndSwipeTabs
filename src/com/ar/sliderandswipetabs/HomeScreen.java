package com.ar.sliderandswipetabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ar.sliderandswipetabs.fragments.Fragment1;
import com.ar.sliderandswipetabs.fragments.Fragment2;
import com.ar.sliderandswipetabs.fragments.Fragment3;

public class HomeScreen extends Fragment {

	DemoCollectionPagerAdapter mDemoCollectionPagerAdapter;
	ViewPager mViewPager;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.home_screen, container, false);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		
		mDemoCollectionPagerAdapter =new DemoCollectionPagerAdapter(getActivity().getSupportFragmentManager());
		mViewPager = (ViewPager)getActivity().findViewById(R.id.pager);
		mViewPager.setAdapter(mDemoCollectionPagerAdapter);
		

		mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			// This method will be invoked when a new page becomes selected.
			@Override
			public void onPageSelected(int position) {
				
				mViewPager.setCurrentItem(position);
				
			}
			
			// This method will be invoked when the current page is scrolled
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				// Code goes here
			}
			
			// Called when the scroll state changes: 
			// SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
			@Override
			public void onPageScrollStateChanged(int state) {
				// Code goes here
			}
		});
		
	}

	public class DemoCollectionPagerAdapter extends FragmentStatePagerAdapter {
		public DemoCollectionPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int i) 
		{
			Fragment fragment =null;

			if(i==0)
				fragment=new Fragment1();
			else if(i==1)
				fragment=new Fragment2();
			else if(i==2)
				fragment=new Fragment3();
			else if(i==3)
				fragment=new Fragment1();
			
			/*Fragment fragment = new DemoObjectFragment();
	        Bundle args = new Bundle();
	        // Our object is just an integer :-P
	        args.putInt(DemoObjectFragment.ARG_OBJECT, i + 1);
	        fragment.setArguments(args);*/
			return fragment;
		}

		@Override
		public int getCount() {
			return 4;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			String title="";
			
			if(position==0)
				title="Fruits";
			else if(position==1)
				title="Vegetable";
			else if(position==2)
				title="Breakfast";
			else if(position==3)
				title="Bath & Daily";
			
			return title;
//			return "Tab " + (position + 1);
		}
	}


}
