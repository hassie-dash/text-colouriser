/*
 * Copyright ©2017 Hassie.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.co.hassie.sample.library.textcolouriser;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import uk.co.hassie.library.textcolouriser.TextColouriser;
import uk.co.hassie.library.versioninfomdialog.VersionInfoMDialog;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupButtonListeners();

    }

    private void setupButtonListeners() {

        Button colourBlack = (Button) findViewById(R.id.buttonBlack);
        Button colourBlue = (Button) findViewById(R.id.buttonBlue);
        Button colourGreen = (Button) findViewById(R.id.buttonGreen);
        Button colourRed = (Button) findViewById(R.id.buttonRed);

        final TextView textView = (TextView) findViewById(R.id.textView);

        colourBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextColouriser textColouriser = new TextColouriser.Builder(HomeActivity.this)
                        .setColour("#000000")
                        .setText(textView)
                        .colourise();
                textView.setText(textColouriser.getColourisedText());
            }
        });

        colourBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextColouriser textColouriser = new TextColouriser.Builder(HomeActivity.this)
                        .setColour(Color.BLUE)
                        .setText(textView)
                        .colourise();
                textView.setText(textColouriser.getColourisedText());
            }
        });

        colourGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextColouriser textColouriser = new TextColouriser.Builder(HomeActivity.this)
                        .setColour("#00FF00")
                        .setText(textView)
                        .colourise();
                textView.setText(textColouriser.getColourisedText());
            }
        });

        colourRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextColouriser textColouriser = new TextColouriser.Builder(HomeActivity.this)
                        .setColour(Color.RED)
                        .setText(textView)
                        .colourise();
                textView.setText(textColouriser.getColourisedText());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            new VersionInfoMDialog.Builder(this)
                    .setCopyrightText(R.string.app_copyright)
                    .setVersionPrefix(R.string.version_prefix)
                    .show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
