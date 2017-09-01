package me.guaidaodl.common.logger

import android.util.Log

/**
 * @author Guaidaodl
 */
class GLogger {
	companion object {
		fun v(tag: String, message: String) {
			Log.i(tag, message)
		}

		fun d(tag: String, message: String) {
			Log.d(tag, message)
		}

		fun i(tag: String, message: String) {
			Log.i(tag, message)
		}

		fun w(tag: String, message: String) {
			Log.i(tag, message)
		}

		fun e(tag: String, message: String, tr: Throwable? = null) {
			if (tr != null) {
				Log.e(tag, message, tr)
			} else {
				Log.e(tag, message)
			}
		}

		fun wtf(tag: String, message: String, tr: Throwable? = null) {
			if (tr != null) {
				Log.wtf(tag, message, tr)
			} else {
				Log.wtf(tag, message)
			}
		}
	}
}