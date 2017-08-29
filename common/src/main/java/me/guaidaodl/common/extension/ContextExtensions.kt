package me.guaidaodl.common.extension

import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.OpenableColumns
import me.guaidaodl.common.logger.Logger
import me.guaidaodl.common.uri.UriInfo
import org.apache.commons.io.IOUtils
import java.lang.Exception

private const val TAG = "ContextExtension"

fun Context.queryUriInfo(uri: Uri): UriInfo? {
	if (ContentResolver.SCHEME_CONTENT != uri.scheme) return null

	val projection = arrayOf(OpenableColumns.SIZE, OpenableColumns.DISPLAY_NAME)
	var c: Cursor? = null
	try {
		c = contentResolver.query(uri, projection, null, null, null)
		if (c == null || !c.moveToFirst()) return null

		val size = c.getLong(c.getColumnIndexOrThrow(OpenableColumns.SIZE))
		val name = c.getString(c.getColumnIndexOrThrow(OpenableColumns.DISPLAY_NAME))
		val type = contentResolver.getType(uri)

		return UriInfo(name, type, size)
	} catch (e: Exception) {
		Logger.e(TAG, message = "query failed $uri", tr = e)
		return null
	} finally {
		IOUtils.closeQuietly(c)
	}
}