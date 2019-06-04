package org.epm.math.operations;

import android.content.Context;
import android.media.MediaPlayer;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

/**
 * https://github.com/epman/mathops_android
 * GNU General Public License v3.0
 */
final class DataLoader extends AsyncTaskLoader {
    @Nullable
    MediaPlayer mpVictory = null;
    @Nullable
    MediaPlayer mpLose = null;

    DataLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if (mpVictory==null || mpLose==null)
            forceLoad();
    }

    @Override
    public Object loadInBackground() {
        mpVictory = MediaPlayer.create(getContext(), org.epm.math.R.raw.dixiehorn);
        mpLose = MediaPlayer.create(getContext(), org.epm.math.R.raw.lose);
        return mpVictory;
    }
}
