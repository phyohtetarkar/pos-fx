package com.jsoft.pos.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Platform;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

public class ProgressRequestBody extends RequestBody {
	private static final int DEFAULT_BUFFER_SIZE = 2048;

	private UploadCallback callback;
	private File file;
	private MediaType mediaType;

	public interface UploadCallback {
		void onProgressUpdate(double value);
		void onFinished();
		void onError();
	}

	public ProgressRequestBody(File file, MediaType mediaType, UploadCallback callback) {
		this.file = file;
		this.callback = callback;
		this.mediaType = mediaType;
	}

	@Override
	public MediaType contentType() {
		return mediaType;
	}

	@Override
	public long contentLength() throws IOException {
		return file.length();
	}

	@Override
	public void writeTo(BufferedSink bs) throws IOException {
		long fileLength = file.length();
		byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
		long uploaded = 0;
		int read;

		try (FileInputStream in = new FileInputStream(file)) {
			while ((read = in.read(buffer)) != -1) {
				double progress = (double) uploaded / fileLength;
		        
				Platform.runLater(() -> {
					if (callback != null) {
						callback.onProgressUpdate(progress);
					}
				});

				uploaded += read;
				bs.write(buffer, 0, read);
			}
		} catch (IOException e) {
			e.printStackTrace();
			Platform.runLater(() -> {
				if (callback != null) {
					callback.onError();
				}
			});
		} finally {
			Platform.runLater(() -> {
				if (callback != null) {
					callback.onFinished();
				}
			});
		}

	}

}
