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

package uk.co.hassie.library.textcolouriser;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

/**
 * Created by Hassie on 07/04/2017.
 */

public class TextColouriser {

    private Spannable colourisedText;

    public static class Builder extends TextColouriser {

        private Context mContext;
        private int mColour;
        private CharSequence mText;

        public Builder(@NonNull Context context) {
            mContext = context;
        }

        public Builder setColour(int colourInt) {
            mColour = colourInt;
            return this;
        }

        public Builder setColour(@NonNull String colourHex) {
            mColour = Color.parseColor(colourHex);
            return this;
        }

        public Builder setText(@NonNull CharSequence text) {
            mText = text;
            return this;
        }

        public Builder setText(@StringRes int stringResId) {
            if (stringResId == 0)
                return this;
            mText = mContext.getResources().getString(stringResId);
            return this;
        }

        public Builder setText(@NonNull TextView textView) {
            mText = textView.getText().toString();
            return this;
        }

        public Builder colourise() {
            Spannable spannable = new SpannableString(mText);
            spannable.setSpan(new ForegroundColorSpan(mColour), 0, spannable.length(), 0);
            super.colourisedText = spannable;
            return this;
        }

    }

    public Spannable getColourisedText() {
        return colourisedText;
    }

}