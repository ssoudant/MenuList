package com.dahuette.menulist.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.Spinner;

import com.dahuette.menulist.MainActivity;
import com.dahuette.menulist.R;

public class MainActivityTest extends
		ActivityInstrumentationTestCase2<MainActivity> {
	private String TAG = "MainActivityTest";
	private MainActivity mainActivity;
	private Spinner spinners[];
	private EditText editTexts[];

	public MainActivityTest() {
		super("com.dahuette.menuList.MainActivity", MainActivity.class);
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		int spinnerIds[] = { R.id.day1_spinner, R.id.day2_spinner,
				R.id.day3_spinner, R.id.day4_spinner, R.id.day5_spinner,
				R.id.day6_spinner, R.id.day7_spinner };
		int editTextIds[] = { R.id.dishOfTheDay1, R.id.dishOfTheDay2,
				R.id.dishOfTheDay3, R.id.dishOfTheDay4, R.id.dishOfTheDay5,
				R.id.dishOfTheDay6, R.id.dishOfTheDay7 };
		super.setUp();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(true, true);
	}

	@Test
	public void testFail() {
		fail();
	}

}
