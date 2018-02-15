package com.silambar.alertexample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by silambarasan on 14/02/18.
 */

public class JavaFragment extends Fragment {

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_alert_dialog, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    Button btnShowAlert = (Button) view.findViewById(R.id.btnShowAlert);
    Button alertWithTwoButtons = (Button) view.findViewById(R.id.alertWithTwoButtons);
    Button alertWithThreeButtons = (Button) view.findViewById(R.id.alertWithThreeButtons);

    btnShowAlert.setOnClickListener(new OnClickListener() {
      @Override public void onClick(View v) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Alert Dialog Demo");
        alertDialog.setMessage(getResources().getString(R.string.title));
        alertDialog.setIcon(R.drawable.ic_done_black_24dp);
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
          @Override public void onClick(DialogInterface dialog, int which) {
            showToastMessage("You tapped OK");
          }
        });
        alertDialog.show();
      }
    });

    alertWithTwoButtons.setOnClickListener(new OnClickListener() {
      @Override public void onClick(View v) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());

        alertDialog.setTitle("Confirm Remove...");

        alertDialog.setMessage("Are you sure you want to remove this?");

        alertDialog.setIcon(R.drawable.ic_clear_black_24dp);

        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
            showToastMessage("You tapped on YES");
          }
        });
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
            showToastMessage("You tapped on NO");
            dialog.cancel();
          }
        });

        alertDialog.show();
      }
    });

    alertWithThreeButtons.setOnClickListener(new OnClickListener() {
      @Override public void onClick(View v) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Save File...");
        alertDialog.setMessage("Do you want to save this file?");
        alertDialog.setIcon(R.drawable.ic_save_black_24dp);
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {

          public void onClick(DialogInterface dialog, int which) {
            showToastMessage("You tapped on YES");
          }
        });
        alertDialog.setNeutralButton("NO", new DialogInterface.OnClickListener() {

          public void onClick(DialogInterface dialog, int which) {
            showToastMessage("You tapped on NO");
          }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

          public void onClick(DialogInterface dialog, int which) {
            showToastMessage("You tapped on Cancel");
          }
        });

        alertDialog.show();
      }
    });
  }

  private void showToastMessage(CharSequence msg) {
    Snackbar snackBar =
        Snackbar.make(getActivity().findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG);
    snackBar.show();
  }
}
