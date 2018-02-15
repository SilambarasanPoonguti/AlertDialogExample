package com.silambar.alertexample

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  private val jFragment: JavaFragment = JavaFragment()
  private val kFragment: KotlinFragment = KotlinFragment()

  private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
    when (item.itemId) {
      R.id.navigation_java -> {
        container.setBackgroundColor(ContextCompat.getColor(this, R.color.javaFragmentBackgroundColor))
        showJFragment()
        return@OnNavigationItemSelectedListener true
      }
      R.id.navigation_kotlin -> {
        container.setBackgroundColor(ContextCompat.getColor(this, R.color.kotlinFragmentBackgroundColor))
        showKFragment()
        return@OnNavigationItemSelectedListener true
      }
    }
    false
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    container.setBackgroundColor(ContextCompat.getColor(this, R.color.javaFragmentBackgroundColor))
    showJFragment()
  }

  private fun showJFragment() {

    val tr = supportFragmentManager.beginTransaction()
    if (jFragment.isAdded) {
      tr.show(jFragment)
    } else {
      tr.add(R.id.fragment_container, jFragment, "JavaFragment")
    }

    if (kFragment.isAdded) {
      tr.hide(kFragment)
    }

    tr.commit()

  }

  private fun showKFragment() {

    val tr = supportFragmentManager.beginTransaction()
    if (kFragment.isAdded) {
      tr.show(kFragment)
    } else {
      tr.add(R.id.fragment_container, kFragment, "kotlinFragment")
    }

    if (jFragment.isAdded) {
      tr.hide(jFragment)
    }

    tr.commit()

  }
}
