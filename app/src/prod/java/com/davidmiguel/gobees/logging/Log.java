@@ -18,6 +18,7 @@
  
  package com.davidmiguel.gobees.logging;
  
 +import com.crashlytics.android.Crashlytics;
  import com.davidmiguel.gobees.BuildConfig;
  
  import timber.log.Timber;
 @@ -40,6 +41,25 @@ public static void initLogger() {
          if (BuildConfig.DEBUG) {
              Timber.plant(new DebugTree());
          }
 +        // Log to Crashlytics
 +        Timber.plant(new CrashlyticsTree());
 +        // Attach build info
 +        setCommitHash(BuildConfig.COMMIT_HASH);
 +        setBuildDate(BuildConfig.BUILD_DATE);
 +    }
 +
 +    /**
 +     * Attaches commit hash in crash reports.
 +     */
 +    public static void setCommitHash(String hash) {
 +        Crashlytics.setString("commit_hash", hash);
 +    }
 +
 +    /**
 +     * Attaches build date in crash reports.
 +     */
 +    public static void setBuildDate(String date) {
 +        Crashlytics.setString("build_date", date);
      }
  
      /**