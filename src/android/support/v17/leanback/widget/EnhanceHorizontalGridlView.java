/**
 * Copyright (C) 2015 Togic Corporation. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.support.v17.leanback.widget;

import android.content.Context;
import android.support.v17.leanback.widget.HorizontalGridView;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;

/**
 * @author jar @date 2015年12月18日
 */
public class EnhanceHorizontalGridlView extends HorizontalGridView {

    private OnSelectedItemViewChangedListener mSelectedItemViewChangedListener = null;

    public EnhanceHorizontalGridlView(Context context) {
        super(context);
    }

    public EnhanceHorizontalGridlView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EnhanceHorizontalGridlView(Context context, AttributeSet attrs,
            int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setSelectedItemViewChangedListener(
            OnSelectedItemViewChangedListener selectedItemViewChangedListener) {
        mSelectedItemViewChangedListener = selectedItemViewChangedListener;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            int itemCount = getAdapter().getItemCount();
            int oldPosition = getSelectedPosition();
            View oldView = findViewHolderForAdapterPosition(oldPosition).itemView;
            int newPosition = oldPosition;
            View newView = oldView;
            switch (event.getKeyCode()) {
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (oldPosition < itemCount - 1) {
                    newPosition++;
                    newView = findViewHolderForAdapterPosition(newPosition).itemView;
                    if (mSelectedItemViewChangedListener != null) {
                        mSelectedItemViewChangedListener
                                .onSelectedItemViewChanged(oldView, newView,
                                        oldPosition, newPosition);
                    }
                }
                break;

            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (oldPosition > 0) {
                    newPosition--;
                    newView = findViewHolderForAdapterPosition(newPosition).itemView;
                    if (mSelectedItemViewChangedListener != null) {
                        mSelectedItemViewChangedListener
                                .onSelectedItemViewChanged(oldView, newView,
                                        oldPosition, newPosition);
                    }
                }
                break;
            }
        }
        return super.dispatchKeyEvent(event);
    }


}
