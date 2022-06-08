package denis.beck.dutyreminder

import android.app.Application
import timber.log.Timber

class DutyReminder : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}