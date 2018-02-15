package com.silambar.alertexample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_alert_dialog.alertWithThreeButtons
import kotlinx.android.synthetic.main.fragment_alert_dialog.alertWithTwoButtons
import kotlinx.android.synthetic.main.fragment_alert_dialog.btnShowAlert


/**
 * Created by silambarasan on 14/02/18.
 */

class KotlinFragment : Fragment() {

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    return inflater?.inflate(R.layout.fragment_alert_dialog, container, false)
  }

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    btnShowAlert.setOnClickListener(object : OnClickListener {
      override fun onClick(v: View?) {

        val alertDialog = AlertDialog.Builder(activity)
        alertDialog.setTitle("Alert Dialog Demo")
        alertDialog.setMessage(resources.getString(R.string.title))
        alertDialog.setIcon(R.drawable.ic_done_black_24dp)
        alertDialog.setPositiveButton("OK") { dialog, which ->
          showToastMessage("You tapped OK")
        }
        alertDialog.show()
      }

    })

    alertWithTwoButtons.setOnClickListener(object : OnClickListener {
      override fun onClick(v: View?) {
        val alertDialog = AlertDialog.Builder(activity)

        alertDialog.setTitle("Confirm Remove...")

        alertDialog.setMessage("Are you sure you want to remove this?")

        alertDialog.setIcon(R.drawable.ic_clear_black_24dp)

        alertDialog.setPositiveButton("YES"
        ) { dialog, which ->
          showToastMessage("You tapped on YES")
        }
        alertDialog.setNegativeButton("NO"
        ) { dialog, which ->
          showToastMessage("You tapped on NO")
          dialog.cancel()
        }

        alertDialog.show()
      }

    })

    alertWithThreeButtons.setOnClickListener(object : OnClickListener {
      override fun onClick(v: View?) {
        val alertDialog = AlertDialog.Builder(activity)

        alertDialog.setTitle("Save File...")

        alertDialog.setMessage("Do you want to save this file?")

        alertDialog.setIcon(R.drawable.ic_save_black_24dp)

        alertDialog.setPositiveButton("YES"
        ) { dialog, which ->
          showToastMessage("You tapped on YES")
        }
        alertDialog.setNeutralButton("NO"
        ) { dialog, which ->
          showToastMessage("You tapped on NO")
        }
        alertDialog.setNegativeButton("Cancel"
        ) { dialog, which ->
          showToastMessage("You tapped on Cancel")
        }
        alertDialog.show()
      }

    })
  }

  private fun showToastMessage(msg: CharSequence) {
    val snackBar = activity.findViewById<View>(android.R.id.content)?.let {
      Snackbar.make(it, msg, Snackbar.LENGTH_LONG)
    }
    snackBar?.show()
  }
}
